package com.tracker.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.tracker.model.FetchLatLong;
import com.tracker.model.StationLocation;
import com.tracker.util.DBConnectionManager;

public class RefreshLocationController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
	
	List<StationLocation> stationlocation = new ArrayList<StationLocation>();
    
    
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
    	ps = conn.prepareStatement("select station_name from station_lat_long where station_lat_long_id<10");
    	rs = ps.executeQuery();
    	while(rs.next()) {
    		StationLocation loc = new StationLocation();
    		loc.setStation_name(rs.getString("station_name"));
    		stationlocation.add(loc);		
    	}
    	
    	for(StationLocation st : stationlocation) {
    		
    		System.out.println(st.getStation_name());
    	}
    	
    	request.setAttribute("station_location", stationlocation);
    	
    	JAXBContext jc = JAXBContext.newInstance(FetchLatLong.class);
        
        
        String mapurl1 = "https://maps.googleapis.com/maps/api/geocode/xml?address=";
        String mapurl2 = "&sensor=false&key=AIzaSyAGd0G-I1ZepBC2X5oR1DmAJRMS9aPF4G0";
        
        for(StationLocation sl : stationlocation) {
         Unmarshaller unmarshaller = jc.createUnmarshaller();
         String temp =mapurl1+sl.getStation_name()+mapurl2;
         temp = temp.replaceAll(" ","%20").trim();
         URL url = new URL(temp);
         System.out.println(temp);
         //URL url = new URL("https://maps.googleapis.com/maps/api/geocode/xml?address=Nagpur&sensor=false&key=AIzaSyAGd0G-I1ZepBC2X5oR1DmAJRMS9aPF4G0");
         InputStream xmlStream = url.openStream();
         FetchLatLong latlong = (FetchLatLong) unmarshaller.unmarshal(xmlStream);
         	System.out.println(sl.getStation_name());
             System.out.println("Latitude : "+latlong.getResult().getGeo().getLocation().getLat());
             System.out.println("Longitude : "+latlong.getResult().getGeo().getLocation().getLng());
             
        }
    	
    	rs.close();
    	ps.close();
    	conn.close();
    		 	
    }catch(Exception E2) {
        		
    }
	
	RequestDispatcher rd = null;
	 
    rd = request.getRequestDispatcher("/displayinfo.jsp");
    
    rd.forward(request, response);
	
    
	}

}
