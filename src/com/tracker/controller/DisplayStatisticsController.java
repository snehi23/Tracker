package com.tracker.controller;

import java.io.IOException;
import java.lang.reflect.Array;
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

import com.tracker.model.StationLocation;
import com.tracker.model.StationLocationPlot;
import com.tracker.util.DBConnectionManager;


public class DisplayStatisticsController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,Integer> group_by_train = new HashMap<String,Integer>();
		Map<String,Integer> group_by_from_station = new HashMap<String,Integer>();
		Map<String,Integer> group_by_to_station = new HashMap<String,Integer>();
		Map<String,Integer> group_by_class = new HashMap<String,Integer>();
		Map<String,Integer> group_by_type = new HashMap<String,Integer>();
		Map<String,Integer> group_by_berth = new HashMap<String,Integer>();
		Map<String,Integer> group_by_year = new LinkedHashMap<String,Integer>();
		Map<String,Integer> group_by_month = new LinkedHashMap<String,Integer>();
		Map<String,Integer> group_by_day = new LinkedHashMap<String,Integer>();
		
		List<StationLocation> station_loc_list = new ArrayList<StationLocation>();
		List<StationLocationPlot> station_loc_plot = new ArrayList<StationLocationPlot>();
		
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		Double dist = 0.0;
        
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
        		
            String userid = (String) session.getAttribute("userid");
        	
        	Connection conn = (Connection) ctx.getAttribute("DBConnection");
        	
        	conn.setAutoCommit(false);
        	
        	 Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        	 
        	 String sql1 = "select Train, count(*) as all_train from tracker where user_id ="+"'"+userid+"'"+"group by Train order by all_train desc";
        	 ResultSet rs1 = stmt.executeQuery(sql1);
        	 while(rs1.next()) {

         		group_by_train.put(rs1.getString(1),rs1.getInt(2));
         		       		
         	}
        	 
        	 request.setAttribute("group_by_train_list", group_by_train);
        	 
        	rs1.close(); 
        	conn.commit(); 
         	
        	String sql2 = "select From_Station, count(*) as all_from from tracker where user_id ="+"'"+userid+"'"+"group by From_Station order by all_from desc";
       	 	ResultSet rs2 = stmt.executeQuery(sql2);
        	
       	 	while(rs2.next()) {

       		group_by_from_station.put(rs2.getString(1),rs2.getInt(2));
        		       		
        	}
        	
        	request.setAttribute("group_by_from_station_list", group_by_from_station);
        	
        	rs2.close();
        	conn.commit();
        	
        	String sql3 = "select To_Station, count(*) as all_from from tracker where user_id ="+"'"+userid+"'"+"group by To_Station order by all_from desc";
       	 	ResultSet rs3 = stmt.executeQuery(sql3);
        	
       	 	while(rs3.next()) {

         	group_by_to_station.put(rs3.getString(1),rs3.getInt(2));
        		       		
        	}
        	
        	request.setAttribute("group_by_to_station_list", group_by_to_station);
        	
        	
        	rs3.close();
        	conn.commit();
        	
        	String sql4 = "select Classes, count(*) as all_from from tracker where user_id ="+"'"+userid+"'"+"group by Classes order by all_from desc";
       	 	ResultSet rs4 = stmt.executeQuery(sql4);
        	
       	 	while(rs4.next()) {

         		group_by_class.put(rs4.getString(1),rs4.getInt(2));
        		       		
        	}
        	
        	request.setAttribute("group_by_class_list", group_by_class);
        	
        	
        	rs4.close();
        	conn.commit();
        	
        	String sql5 = "select (select year(DOJ)), count(*) as all_from from tracker where user_id ="+"'"+userid+"'"+"group by (select year(DOJ)) order by (select year(DOJ))";
       	 	ResultSet rs5 = stmt.executeQuery(sql5);
        	
       	 	while(rs5.next()) {

         		group_by_year.put(rs5.getString(1),rs5.getInt(2));
        		       		
        	}
        	
        	request.setAttribute("group_by_year_list", group_by_year);
        	
        	
        	rs5.close();
        	conn.commit();
        	
        	String sql6 = "select (select monthname(DOJ)), count(*) as all_from from tracker where user_id ="+"'"+userid+"'"+"group by (select monthname(DOJ)) order by (select month(DOJ))";
       	 	ResultSet rs6 = stmt.executeQuery(sql6);
        	
       	 	while(rs6.next()) {

         		group_by_month.put(rs6.getString(1),rs6.getInt(2));		
        		       		
        	}
         	
       	 	
        	request.setAttribute("group_by_month_list", group_by_month);
        	
        	rs6.close();
        	conn.commit();
        	
        	String sql7 = "select (select dayname(DOJ)), count(*) as all_from from tracker where user_id ="+"'"+userid+"'"+"group by (select dayname(DOJ)) order by (select dayofweek(DOJ))";
       	 	ResultSet rs7= stmt.executeQuery(sql7);
        	
       	 	while(rs7.next()) {

         		group_by_day.put(rs7.getString(1),rs7.getInt(2));		
        		       		
        	}
         	
         	/*for(Map.Entry<String,Integer> a : group_by_day.entrySet()) {
         		System.out.println(a.getKey());
         		System.out.println(a.getValue());   	      		
         	}*/
        	
        	request.setAttribute("group_by_day_list", group_by_day);
        	
        	
        	rs7.close();
        	conn.commit();
        	
        	
        	String sql8 = "select station_lat_long.station_lat_long_id,tracker.From_Station,station_lat_long.station_name,station_lat_long.latitude,station_lat_long.longitude from tracker inner join station_lat_long where tracker.From_Station=station_lat_long.station_code and tracker.user_id ="+"'"+userid+"'"+"union select station_lat_long.station_lat_long_id,tracker.To_Station,station_lat_long.station_name,station_lat_long.latitude,station_lat_long.longitude from tracker inner join station_lat_long where tracker.To_Station=station_lat_long.station_code and tracker.user_id ="+"'"+userid+"'";
        	
        	ResultSet rs8 = stmt.executeQuery(sql8);
        	     	
        	while(rs8.next()) {

        		StationLocation d = new StationLocation();
        		d.setStation_lat_long_id(rs8.getInt("station_lat_long_id"));
        		d.setStation_code(rs8.getString("From_Station"));
        		d.setStation_name(rs8.getString("station_name"));
        		d.setLatitude(rs8.getDouble("latitude"));
        		d.setLongitude(rs8.getDouble("longitude"));
        		station_loc_list.add(d);        		
        	}
        	
        	   
            request.setAttribute("station_loc_list", station_loc_list);
            
        	rs8.close();
        	conn.commit();
        	
        	String sql9 = "select distinct s1.latitude,s1.longitude,s2.latitude,s2.longitude from tracker t inner join station_lat_long s1 on t.From_Station=s1.station_code and t.user_id= "+"'"+userid+"'"+" inner join station_lat_long s2 on t.To_Station=s2.station_code and t.user_id= "+"'"+userid+"'";
        	
        	ResultSet rs9 = stmt.executeQuery(sql9);
        	
        	while(rs9.next()) {
        		
        		StationLocationPlot d = new StationLocationPlot();
        		d.setFrom_latitude(rs9.getDouble(1));
        		d.setFrom_longitude(rs9.getDouble(2));
        		d.setTo_latitude(rs9.getDouble(3));
        		d.setTo_longitude(rs9.getDouble(4));
        		station_loc_plot.add(d);		
        	}
        	
        	request.setAttribute("station_loc_plot",station_loc_plot);
        	
        	      	
        	rs9.close();
        	conn.commit();
        	
        	String sql10 = "select s1.latitude,s1.longitude,s2.latitude,s2.longitude from tracker t inner join station_lat_long s1 on t.From_Station=s1.station_code and t.user_id= "+"'"+userid+"'"+" inner join station_lat_long s2 on t.To_Station=s2.station_code and t.user_id= "+"'"+userid+"'";
        	
        	ResultSet rs10 = stmt.executeQuery(sql10);
        	
        	while(rs10.next()) {
        		
        		dist = dist + distance(rs10.getDouble(1), rs10.getDouble(2), rs10.getDouble(3), rs10.getDouble(4));
        		
        	}
        	
        	System.out.println(Math.floor(dist));
        	
        	request.setAttribute("total_distance",Math.floor(dist));
        	
        	      	
        	rs10.close();
        	conn.commit();
        	
        	String sql11 = "select  T_type.Train_Type,count(*) from tracker inner join (select distinct Train_Name,Train_Type from train_number_name_type_route) as T_type where tracker.Train = T_type.Train_Name and tracker.user_id=  "+"'"+userid+"'"+" group by T_type.Train_Type;";
        	
        	ResultSet rs11 = stmt.executeQuery(sql11);
        	
        	while(rs11.next()) {
        		
        		group_by_type.put(rs11.getString(1), rs11.getInt(2));
        		
        	}
        	   	
        	request.setAttribute("group_by_type_list",group_by_type);
        	
        	      	
        	rs11.close();
        	conn.commit();
        	
        	String sql12 = "select berth, count(*) as all_berth from tracker where user_id ="+"'"+userid+"'"+"group by berth order by all_berth desc";
       	 	ResultSet rs12 = stmt.executeQuery(sql12);
        	
       	 	while(rs12.next()) {

         		group_by_berth.put(rs12.getString(1),rs12.getInt(2));
        		       		
        	}
        	
        	request.setAttribute("group_by_berth_list", group_by_berth);
        	
        	
        	rs12.close();
        	conn.commit();
 	
        	conn.close();
        	
        	rd = request.getRequestDispatcher("/displaystatistics.jsp");
        	
        		} else {
        			
        			rd = request.getRequestDispatcher("/error.jsp");
        			
        		}
        	
        } 
        catch(Exception E1)
        {
        	System.out.println(E1.getMessage());
        } 
        
        rd.forward(request, response);
    }
	
	public double distance(double lat1, double lon1, double lat2, double lon2) {
		  double theta = lon1 - lon2;
	
		  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	
		  dist = Math.acos(dist);
	
		  dist = rad2deg(dist);
	
		  dist = dist * 60 * 1.1515;
	
		  dist = dist * 1.609344;
	
		  return (dist);
		
		}
	
	public double rad2deg(double rad) {
	
		  return (rad * 180 / Math.PI);
	
		}

	public double deg2rad(double deg) {
			
			  return (deg * Math.PI / 180.0);
		
		}


}
