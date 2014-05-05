package com.tracker.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.tracker.util.DBConnectionManager;

public class DisplayLocationController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
		List<StationLocation> station_loc_list = new ArrayList<StationLocation>();
        
        ServletContext ctx=getServletContext();
        PreparedStatement ps = null;
        ResultSet rs= null;
        
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
        	ps = conn.prepareStatement("select station_lat_long.station_lat_long_id,tracker.From_Station,station_lat_long.station_name,station_lat_long.latitude,station_lat_long.longitude from tracker inner join station_lat_long where tracker.From_Station=station_lat_long.station_code union select station_lat_long.station_lat_long_id,tracker.To_Station,station_lat_long.station_name,station_lat_long.latitude,station_lat_long.longitude from tracker inner join station_lat_long where tracker.To_Station=station_lat_long.station_code");
        	rs = ps.executeQuery();       	
        	while(rs.next()) {

        		StationLocation d = new StationLocation();
        		d.setStation_lat_long_id(rs.getInt("station_lat_long_id"));
        		d.setStation_code(rs.getString("From_Station"));
        		d.setStation_name(rs.getString("station_name"));
        		d.setLatitude(rs.getDouble("latitude"));
        		d.setLongitude(rs.getDouble("longitude"));
        		station_loc_list.add(d);        		
        	}
        	
        	   
            request.setAttribute("station_loc_list", station_loc_list);
            
        	rs.close();
        	ps.close();
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
