package com.tracker.controller;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import javax.servlet.http.HttpSession;

import com.tracker.model.Authenticator;
import com.tracker.model.StationLocation;
import com.tracker.model.User;
 
import com.tracker.util.DBConnectionManager;


 public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginController() {
        super();
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
    	HttpSession session = request.getSession(true);
    	
    	PreparedStatement prep = null;
    	RequestDispatcher rd = null;
    	Boolean flag=true;
    	User userdetails = new User();
    	
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        System.out.println(" "+username+" "+password);
        
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
        	
        	String sql = "select user_id,user_password from user_registration_data where user_id ="+"'"+username+"'";
        	
        	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
  
        	ResultSet rs = stmt.executeQuery(sql);
        	
        	System.out.println(rs.equals(null));
        	
        		
        	if(rs!=null && rs.next())	{
        		rs.beforeFirst();
        	     	
        	while(rs.next()) {
        		userdetails.setUsername(rs.getString(1));
        		userdetails.setPassword(rs.getString(2));
        	}
        	
        	System.out.println(userdetails.getUsername()+" "+userdetails.getPassword());
        	
        	rs.close();
        	conn.commit();
        	
        	
        	} else {
        		
        		flag=false;
        		rs.close();
            	conn.commit();
        		
        	}
        	
        	conn.close();
        	
        } catch (Exception E) {
        	
        	E.printStackTrace();
        	
        }
        	
        	if(flag) {
        	if(userdetails.getUsername().equals(username) && userdetails.getPassword().equals(password)) {
        	
        		session.setAttribute("user", userdetails);
        		rd = request.getRequestDispatcher("/success.jsp");
        		rd.forward(request, response);
        		
        	} else {
        		
        		rd = request.getRequestDispatcher("/error.jsp");
        		rd.forward(request, response);
        	} } else {
        		
        		rd = request.getRequestDispatcher("/error.jsp");
        		rd.forward(request, response);
        		
        	}
        	
        	
        	
        } 
}
    