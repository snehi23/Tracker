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
import javax.servlet.http.HttpSession;

import com.tracker.model.Details;
import com.tracker.util.DBConnectionManager;

public class UserInputEditController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        
        HttpSession session = request.getSession(true);
        RequestDispatcher rd = null;
      
    	String temp = request.getParameter("recordid");
       	Integer train_journey_id = Integer.parseInt(temp);
   
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
        	
        	
        	if(session.getAttribute("userid")!=null) {
        		
        	
        	Connection conn = (Connection) ctx.getAttribute("DBConnection");
        	
        	String sql = "select * from tracker where train_journey_id ="+"'"+train_journey_id+"'";
        	ps = conn.prepareStatement(sql);
        	rs = ps.executeQuery();
        	
        	Details d = new Details();
        	while(rs.next()) {

        		d.setTrain_journey_id(rs.getInt("train_journey_id"));
        		d.setDOJ(rs.getString("DOJ"));
        		d.setTrain(rs.getString("Train"));
        		d.setFrom_Station(rs.getString("From_Station"));
        		d.setTo_Station(rs.getString("To_Station"));
        		d.setClasses(rs.getString("Classes"));
        		d.setBerth(rs.getString("berth"));
        		d.setComments(rs.getString("Comments"));
        		       		
        	}
        	
        	   
            request.setAttribute("details", d);
            
            session.setAttribute("journey_id", d.getTrain_journey_id());
            
        	rs.close();
        	ps.close();
        	conn.close();
        	
        	rd = request.getRequestDispatcher("/Editinfo.jsp");
        	
        	
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
	
}