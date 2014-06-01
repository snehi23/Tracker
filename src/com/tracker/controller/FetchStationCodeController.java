package com.tracker.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import com.tracker.model.Details;
import com.tracker.model.StationLocation;
import com.tracker.model.StationLocationPlot;
import com.tracker.util.DBConnectionManager;

public class FetchStationCodeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
		String Train_Route=null;
		Map<String, String> temp2 = new HashMap<String, String>();
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		
		String Train = request.getParameter("Train_Name");
		
		String Train_Number = Train.replaceAll("[^0-9]","");
		
		String  Train_Name = Train.replaceAll("[^A-Z a-z]", "");
		
		
        System.out.println(Train_Number);
        
        System.out.println(Train_Name);
        
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
        	
        	ResultSet rs2=null;
        	for(String t : temp1.keySet()) {
        		
        		System.out.println(t+" : "+temp1.get(t));
        		
        		rs2 = stmt.executeQuery("select station_name from station_lat_long where station_code="+"'"+t+"'");
    	     	
            	while(rs2.next()) {

            		temp2.put(rs2.getString("station_name")+"("+t+")", temp1.get(t));
            	}
            	
            	conn.commit();
    		
        	}
	
        	request.setAttribute("station_code", temp2);
        	request.setAttribute("Train_Name", Train);
        	
        	rs2.close();
         	conn.close();
	
  	
        	rd = request.getRequestDispatcher("/success.jsp");
        	
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