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
		
		Map<String, Integer> temp = new HashMap<String, Integer>();
		List<StationLocation> station_loc_list = new ArrayList<StationLocation>();
		
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		
		String Train = request.getParameter("Train");
		String To_Station = request.getParameter("To_Station");
		String From_Station = request.getParameter("From_Station");
		
		System.out.println(Train+To_Station+From_Station);
        
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
        	
        		
            
        	Connection conn = (Connection) ctx.getAttribute("DBConnection");
        	
        	conn.setAutoCommit(false);
        	
        	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        	
        	String sql1 = "select Train_Route from train_number_name_type_route where Train_Name="+"'"+Train+"'";
        	
        	ResultSet rs1 = stmt.executeQuery(sql1);
        	     	
        	while(rs1.next()) {

        		Train_Route = rs1.getString("Train_Route");
        		        		
        	}
        	

        	rs1.close();
        	conn.commit();
        	
        	
        	boolean flag=false;
        	
        	
        	Map<String, String> temp1 = Splitter.on('$').withKeyValueSeparator(":").split(Train_Route);
        	
        	Map<String, String> temp2 = new LinkedHashMap<String, String>();
        	
        	
        	for(Map.Entry<String,String> a : temp1.entrySet()) {
         		//System.out.println("STATION : "+a.getKey()+" DISTANCE : "+a.getValue());
         		if(From_Station.equals(a.getKey()) || (flag==true) ) {
         			temp2.put(a.getKey(), a.getValue());
         			flag=true;
         			if(To_Station.equals(a.getKey())) flag=false;
         			
         		} 
         		   	      		
         	}
        	
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
        	
        	rs2.close();
        	conn.close();
        	
        	request.setAttribute("station_loc_list", station_loc_list);

        	
        	rd = request.getRequestDispatcher("/displaylocation.jsp");
        } 
        catch(Exception E1)
        {
        	System.out.println(E1.getMessage());
        } 
      
        rd.forward(request, response);
	
	
	
	}
    
}