package com.tracker.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.tracker.util.DBConnectionManager;


public class DisplayStatisticsController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,Integer> group_by_train = new HashMap<String,Integer>();
		Map<String,Integer> group_by_from_station = new HashMap<String,Integer>();
		Map<String,Integer> group_by_to_station = new HashMap<String,Integer>();
		Map<String,Integer> group_by_class = new HashMap<String,Integer>();
		Map<String,Integer> group_by_year = new HashMap<String,Integer>();
		Map<String,Integer> group_by_month = new LinkedHashMap<String,Integer>();
		Map<String,Integer> group_by_day = new LinkedHashMap<String,Integer>();
        
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
        	 ResultSet rs1 = stmt.executeQuery("select Train, count(*) as all_train from tracker group by Train order by all_train desc");
        	 while(rs1.next()) {

         		group_by_train.put(rs1.getString(1),rs1.getInt(2));
         		       		
         	}
        	 
        	 request.setAttribute("group_by_train_list", group_by_train);
        	 
        	rs1.close(); 
        	conn.commit(); 
         	
         	
         	ResultSet rs2 = stmt.executeQuery("select From_Station, count(*) as all_from from tracker group by From_Station order by all_from desc");
         	while(rs2.next()) {

       		group_by_from_station.put(rs2.getString(1),rs2.getInt(2));
        		       		
        	}
        	
        	request.setAttribute("group_by_from_station_list", group_by_from_station);
        	
        	rs2.close();
        	conn.commit();
        	
        	ResultSet rs3 = stmt.executeQuery("select To_Station, count(*) as all_to from tracker group by To_Station order by all_to desc");
         	while(rs3.next()) {

         	group_by_to_station.put(rs3.getString(1),rs3.getInt(2));
        		       		
        	}
        	
        	request.setAttribute("group_by_to_station_list", group_by_to_station);
        	
        	
        	rs3.close();
        	conn.commit();
        	
        	ResultSet rs4 = stmt.executeQuery("select To_Station, count(*) as all_to from tracker group by To_Station order by all_to desc");
         	while(rs4.next()) {

         		group_by_class.put(rs4.getString(1),rs4.getInt(2));
        		       		
        	}
        	
        	request.setAttribute("group_by_class_list", group_by_class);
        	
        	
        	rs4.close();
        	conn.commit();
        	
        	ResultSet rs5 = stmt.executeQuery("select (select year(DOJ)), count(*) from tracker group by (select year(DOJ))");
         	while(rs5.next()) {

         		group_by_year.put(rs5.getString(1),rs5.getInt(2));
        		       		
        	}
        	
        	request.setAttribute("group_by_year_list", group_by_year);
        	
        	
        	rs5.close();
        	conn.commit();
        	
        	ResultSet rs6 = stmt.executeQuery("select (select monthname(DOJ)), count(*) from tracker group by (select monthname(DOJ)) order by month(DOJ)");
         	while(rs6.next()) {

         		group_by_month.put(rs6.getString(1),rs6.getInt(2));		
        		       		
        	}
         	
         	/*for(Map.Entry<String,Integer> a : group_by_month.entrySet()) {
         		System.out.println(a.getKey());
         		System.out.println(a.getValue());   	      		
         	}*/
        	
        	request.setAttribute("group_by_month_list", group_by_month);
        	
        	
        	rs6.close();
        	conn.commit();
        	
        	
        	ResultSet rs7 = stmt.executeQuery("select (select dayname(DOJ)), count(*) from tracker group by (select dayname(DOJ)) order by dayofweek(DOJ)");
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
        	
        	conn.close();
        	
        } 
        catch(Exception E1)
        {
        	System.out.println(E1.getMessage());
        } 
                
        RequestDispatcher rd = null;
 
            rd = request.getRequestDispatcher("/displaystatistics.jsp");
            
        rd.forward(request, response);
    }


}
