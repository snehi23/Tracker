package com.tracker.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tracker.model.Details;
import com.tracker.model.StationLocation;
import com.tracker.model.StationLocationPlot;
import com.tracker.util.DBConnectionManager;

public class DisplayLocationController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
		List<StationLocation> station_loc_list = new ArrayList<StationLocation>();
		
		List<StationLocationPlot> station_loc_plot = new ArrayList<StationLocationPlot>();
		
		
        
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
        	
        	
        	ResultSet rs1 = stmt.executeQuery("select station_lat_long.station_lat_long_id,tracker.From_Station,station_lat_long.station_name,station_lat_long.latitude,station_lat_long.longitude from tracker inner join station_lat_long where tracker.From_Station=station_lat_long.station_code union select station_lat_long.station_lat_long_id,tracker.To_Station,station_lat_long.station_name,station_lat_long.latitude,station_lat_long.longitude from tracker inner join station_lat_long where tracker.To_Station=station_lat_long.station_code");
        	     	
        	while(rs1.next()) {

        		StationLocation d = new StationLocation();
        		d.setStation_lat_long_id(rs1.getInt("station_lat_long_id"));
        		d.setStation_code(rs1.getString("From_Station"));
        		d.setStation_name(rs1.getString("station_name"));
        		d.setLatitude(rs1.getDouble("latitude"));
        		d.setLongitude(rs1.getDouble("longitude"));
        		station_loc_list.add(d);        		
        	}
        	
        	   
            request.setAttribute("station_loc_list", station_loc_list);
            
        	rs1.close();
        	conn.commit();
        	
        	ResultSet rs2 = stmt.executeQuery("select distinct s1.latitude,s1.longitude,s2.latitude,s2.longitude from tracker t inner join station_lat_long s1 on t.From_Station=s1.station_code inner join station_lat_long s2 on t.To_Station=s2.station_code");
        	
        	while(rs2.next()) {
        		
        		StationLocationPlot d = new StationLocationPlot();
        		d.setFrom_latitude(rs2.getDouble(1));
        		d.setFrom_longitude(rs2.getDouble(2));
        		d.setTo_latitude(rs2.getDouble(3));
        		d.setTo_longitude(rs2.getDouble(4));
        		station_loc_plot.add(d);		
        	}
        	
        	request.setAttribute("station_loc_plot",station_loc_plot);
        	
        	      	
        	rs2.close();
        	conn.commit();
        	conn.close();
        	        	
        	
        } 
        catch(Exception E1)
        {
        	System.out.println(E1.getMessage());
        } 
                
        RequestDispatcher rd = null;
 
            rd = request.getRequestDispatcher("/displaylocation.jsp");
            
        rd.forward(request, response);
    }
}
