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

import com.tracker.util.DBConnectionManager;

public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public RegistrationController() {
        super();
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
    	String name = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        System.out.println(" "+name+" "+username+" "+email+" "+password);
        
        ServletContext ctx=getServletContext() ;
        
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
        	
        	Connection conn = (Connection) ctx.getAttribute("DBConnection");
        	String sql= "insert into user_registration_data(user_registration_data_id,user_name,user_id,user_email,user_password) values(?,?,?,?,?)";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setInt(1, 0);
        	prep.setString(2, name); 	
        	prep.setString(3, username);
        	prep.setString(4, email);
        	prep.setString(5, password);
        	prep.executeUpdate();
        	prep.close();
        	conn.close();
        	
        	} catch(Exception E)  {
        	System.out.println(E.getMessage());
        } 
        finally {
        
        }
        
        
        RequestDispatcher rd = null;
 
            rd = request.getRequestDispatcher("/login.jsp");
            
        rd.forward(request, response);
        
    }
 
}
