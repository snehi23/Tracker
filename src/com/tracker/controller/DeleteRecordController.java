package com.tracker.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;


import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tracker.util.DBConnectionManager;

public class DeleteRecordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public DeleteRecordController() {
        super();
    }
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
   
    	Connection conn = null;
    	HttpSession session = request.getSession(true);
    	
       	String temp = request.getParameter("recordid");
       	Integer train_journey_id = Integer.parseInt(temp);
   
        System.out.println(train_journey_id);
       
        ServletContext ctx=getServletContext();
        
        String userid = (String) session.getAttribute("userid");
        
        String connectionURL= ctx.getInitParameter("dbURL");
        String uname= ctx.getInitParameter("dbUser");
        String pwd= ctx.getInitParameter("dbPassword");
       
        try {
			DBConnectionManager dbconnmng = new DBConnectionManager(connectionURL, uname, pwd);
			
			ctx.setAttribute("DBConnection", dbconnmng.getConnection());
			
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
        
        try {
        	
        	conn = (Connection) ctx.getAttribute("DBConnection");
        	conn.setAutoCommit(false);
        	String sql= "delete from tracker where train_journey_id=?";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setInt(1, train_journey_id);
        	prep.executeUpdate(); 	
        	prep.close();
        	conn.commit();
        	conn.close();
        	
        	} catch(Exception E)  {
        	System.out.println(E.getMessage());
        } 
        
  
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("/DisplayAllController");
        
        request.setAttribute("Record_Confirmation", "Journey Deleted Successfully !!!");
            
            
        rd.forward(request, response);

    }
 
}
