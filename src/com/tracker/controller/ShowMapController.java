package com.tracker.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.common.base.Splitter;
import com.tracker.model.StationLocation;
import com.tracker.model.StationLocationPlot;
import com.tracker.util.DBConnectionManager;

public class ShowMapController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
		String Train_Route=null;
		boolean flag=false;
		
		Map<String, Integer> temp = new HashMap<String, Integer>();
		List<StationLocation> station_loc_list = new ArrayList<StationLocation>();
		List<StationLocation> station_loc_plot = new ArrayList<StationLocation>();
		
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		
		String Train_Number = request.getParameter("Train_Number");
		String To_Station = request.getParameter("To_Station");
		String From_Station = request.getParameter("From_Station");
		
		System.out.println(Train_Number+To_Station+From_Station);
        
        ServletContext ctx=getServletContext();
        
        String connectionURL= ctx.getInitParameter("dbURL");
        String uname= ctx.getInitParameter("dbUser");
        String pwd= ctx.getInitParameter("dbPassword");
        
        try {
			DBConnectionManager dbconnmng = new DBConnectionManager(connectionURL, uname, pwd);
			
			ctx.setAttribute("DBConnection", dbconnmng.getConnection());
			
		} catch (ClassNotFoundException e1) {
			
		} catch (SQLException e1) {
			
		}
        
        try {
        	
        	if(session.getAttribute("userid")!=null) {	
            
        	Connection conn = (Connection) ctx.getAttribute("DBConnection");
        	
        	conn.setAutoCommit(false);
        	
        	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        	
        	String sql1 = "select Train_Route from train_number_name_type_route where Train_Number="+"'"+Train_Number+"'";
        	
        	ResultSet rs1 = stmt.executeQuery(sql1);
        	     	
        	while(rs1.next()) {

        		Train_Route = rs1.getString("Train_Route");
        		        		
        	}
        	

        	rs1.close();
        	conn.commit();
        	
  	
        	Map<String, String> temp1 = Splitter.on('$').withKeyValueSeparator(":").split(Train_Route);
        	
        	Map<String, String> temp2 = new LinkedHashMap<String, String>();
        	
        	String from_distance=null;
        	String to_distance=null;
        	
        	
        	for(Map.Entry<String,String> a : temp1.entrySet()) {
         		//System.out.println("STATION : "+a.getKey()+" DISTANCE : "+a.getValue());
         		if(From_Station.equals(a.getKey()) || (flag==true) ) {
         			
         			if(From_Station.equals(a.getKey()))
         			from_distance = a.getValue();
         			
         			temp2.put(a.getKey(), a.getValue());
         			flag=true;
         			if(To_Station.equals(a.getKey())) {
         				to_distance = a.getValue();
         				flag=false;
         			}
         			
         		} 
         		   	      		
         	}
        	
        	Integer Total_Distance = (Integer.parseInt(to_distance) - Integer.parseInt(from_distance));
        	System.out.println(Total_Distance);
        	
        	request.setAttribute("total_distance", Total_Distance);
        	
        	ResultSet rs2=null;
        	for(Map.Entry<String,String> a : temp2.entrySet()) {
        		System.out.println("STATION : "+a.getKey()+" DISTANCE : "+a.getValue());
        		
        		rs2 = stmt.executeQuery("select latitude,longitude from station_lat_long where station_code="+"'"+a.getKey()+"'");
    	     	
            	while(rs2.next()) {

            		StationLocation l = new StationLocation();
            			l.setLatitude(rs2.getDouble("latitude"));
            			l.setLongitude(rs2.getDouble("longitude"));
            			station_loc_list.add(l);
 		        		
            	}
            	
            	conn.commit();	
  		
        	}
        	
        	request.setAttribute("station_loc_list", station_loc_list);
        	
        	rs2.close();
   	
        	String sql3 = "select * from station_lat_long where station_code="+"'"+From_Station+"' OR station_code="+"'"+To_Station+"'";
        	
        	ResultSet rs3 = stmt.executeQuery(sql3);
        	     	
        	while(rs3.next()) {

        		StationLocation d = new StationLocation();
        		d.setStation_lat_long_id(rs3.getInt("station_lat_long_id2"));
        		d.setStation_code(rs3.getString("station_code"));
        		d.setStation_name(rs3.getString("station_name"));
        		d.setLatitude(rs3.getDouble("latitude"));
        		d.setLongitude(rs3.getDouble("longitude"));
        		station_loc_plot.add(d);        		
        	}
        	
        	   
            request.setAttribute("station_loc_plot", station_loc_plot);
            
        	rs3.close();
        	conn.commit();	
        	conn.close();
        	
        		rd = request.getRequestDispatcher("/displaylocation.jsp");
    	
        	} else {
    	
        		rd = request.getRequestDispatcher("/invalid-session.html");
    	
        	}
    	
        } 
        catch(Exception E1)
        {
        	System.out.println(E1.getMessage());
        } 
      
        rd.forward(request, response);
	
	
	
	}
    
}