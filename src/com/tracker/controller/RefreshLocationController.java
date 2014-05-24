package com.tracker.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.tracker.model.FetchLatLong;
import com.tracker.model.StationLocation;
import com.tracker.util.DBConnectionManager;

public class RefreshLocationController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
	
	Connection conn=null;
	PreparedStatement prep= null;
	Boolean flag1=true,flag2=true;
	
	List<StationLocation> stationLocation = new ArrayList<StationLocation>();
    
    
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
    	
		
		conn = (Connection) ctx.getAttribute("DBConnection");
    	
    	conn.setAutoCommit(false);
    	
    	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    	
    	ResultSet rs1 = stmt.executeQuery("select t.From_Station from tracker t where not exists (select * from station_lat_long s where s.Station_Code=t.From_Station) union select t.To_Station from tracker t where not exists (select * from station_lat_long s where s.Station_Code=t.To_Station)");
    	
    	
    	if(rs1!=null && rs1.next()) {
    	
    		rs1.close();
        	conn.commit();
    		
    		JAXBContext jc = JAXBContext.newInstance(FetchLatLong.class);
            
            
            String mapurl1 = "https://maps.googleapis.com/maps/api/geocode/xml?address=";
            String mapurl2 = "&sensor=false&key=AIzaSyAGd0G-I1ZepBC2X5oR1DmAJRMS9aPF4G0";
    		
    		ResultSet rs2 = stmt.executeQuery("select distinct Station_Name,Station_Code from station_code  where Station_Code in (select t.From_Station from tracker t where not exists (select * from station_lat_long s where s.Station_Code=t.From_Station))");

    		while(rs2.next()) {

    			StationLocation t = new StationLocation();
    			t.setStation_name(rs2.getString(1));
    			t.setStation_code(rs2.getString(2));
    			
    			Unmarshaller unmarshaller = jc.createUnmarshaller();
    	         String temp =mapurl1+t.getStation_name()+mapurl2;
    	         temp = temp.replaceAll(" ","%20").trim();
    	         URL url = new URL(temp);
    	         System.out.println(temp);
    	         
    	         InputStream xmlStream = url.openStream();
    	         FetchLatLong latlong = (FetchLatLong) unmarshaller.unmarshal(xmlStream);
    	         
    			t.setLatitude(latlong.getResult().getGeo().getLocation().getLat());
    			t.setLongitude(latlong.getResult().getGeo().getLocation().getLng());
    			
    			stationLocation.add(t);	
    			
    			
        	}
    		
    		for(StationLocation s1 : stationLocation) {
    			
    			System.out.println(s1.getStation_code()+" "+s1.getStation_name()+" "+s1.getLatitude()+" "+s1.getLongitude());
    		}
    		
    		rs2.close();
        	conn.commit();
    		
    	} else {
    		flag1=false;
    		rs1.close();
        	conn.commit();
    		
    	}
    	
    	ResultSet rs3 = stmt.executeQuery("select t.From_Station from tracker t where not exists (select * from station_lat_long s where s.Station_Code=t.From_Station) union select t.To_Station from tracker t where not exists (select * from station_lat_long s where s.Station_Code=t.To_Station)");
    	
    	
    	if(rs3!=null && rs3.next()) {
    	
    		rs3.close();
        	conn.commit();
    		
    		JAXBContext jc = JAXBContext.newInstance(FetchLatLong.class);
            
            
            String mapurl1 = "https://maps.googleapis.com/maps/api/geocode/xml?address=";
            String mapurl2 = "&sensor=false&key=AIzaSyAGd0G-I1ZepBC2X5oR1DmAJRMS9aPF4G0";
    		
    		ResultSet rs4 = stmt.executeQuery("select distinct Station_Name,Station_Code from station_code  where Station_Code in (select t.To_Station from tracker t where not exists (select * from station_lat_long s where s.Station_Code=t.To_Station))");

    		while(rs4.next()) {

    			StationLocation t = new StationLocation();
    			t.setStation_name(rs4.getString(1));
    			t.setStation_code(rs4.getString(2));
    			
    			Unmarshaller unmarshaller = jc.createUnmarshaller();
    	         String temp =mapurl1+t.getStation_name()+mapurl2;
    	         temp = temp.replaceAll(" ","%20").trim();
    	         URL url = new URL(temp);
    	         System.out.println(temp);
    	         
    	         InputStream xmlStream = url.openStream();
    	         FetchLatLong latlong = (FetchLatLong) unmarshaller.unmarshal(xmlStream);
    	         
    			t.setLatitude(latlong.getResult().getGeo().getLocation().getLat());
    			t.setLongitude(latlong.getResult().getGeo().getLocation().getLng());
    			
    			stationLocation.add(t);	
    			
    			
        	}
    		
    		for(StationLocation s1 : stationLocation) {
    			
    			System.out.println(s1.getStation_code()+" "+s1.getStation_name()+" "+s1.getLatitude()+" "+s1.getLongitude());
    		}
    		
    		rs4.close();
        	conn.commit();
    		
    	} else {
    		flag2=false;
    		rs3.close();
        	conn.commit();
    		
    	}
    	
    	

		}catch(Exception E2) {
    	
			E2.printStackTrace();
        		
		}
	
    	try {
    		
    		

    	if(flag1 || flag2 ) {
    	
    	for(StationLocation s1 : stationLocation) {
    	String sql= "insert into station_lat_long(station_lat_long_id2,station_code,station_name,latitude,longitude) values (?,?,?,?,?)";
    	prep = conn.prepareStatement(sql);
    	prep.setInt(1, 0);
    	prep.setString(2, s1.getStation_code()); 	
    	prep.setString(3, s1.getStation_name());
    	prep.setDouble(4, s1.getLatitude());
    	prep.setDouble(5, s1.getLongitude());
    	prep.executeUpdate();
    	}
    	
    	prep.close();	
    	conn.commit();
    		
    	}
    	
    	conn.close();
    	
    	}catch(Exception E3) {
        	
        	E3.printStackTrace();
            		
        }

	RequestDispatcher rd = null;
	 
    rd = request.getRequestDispatcher("/success.jsp");
    
    rd.forward(request, response);
	
    
	}

}
