package com.tracker.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.tracker.util.DBConnectionManager;



public class UserInputController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		
        String username = request.getParameter("username");
        String doj = request.getParameter("DOJ");
        String Train = request.getParameter("Train");
        String From = request.getParameter("From");
        String To = request.getParameter("To");
        String Classes = request.getParameter("classes");
        String Comments = request.getParameter("comments");
        
        
        System.out.println(" "+username+" "+doj+" "+Train+" "+From+" "+To+" "+Classes+" "+Comments);
        
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
        	
        	if(session.getAttribute("userid")!=null) {
        		
        	String userid = (String) session.getAttribute("userid");	
        	Connection conn = (Connection) ctx.getAttribute("DBConnection");
        	String sql= "insert into tracker(train_journey_id,DOJ,Train,From_Station,To_Station,Classes,Comments,user_id) values(?,?,?,?,?,?,?,?)";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setInt(1, 0);
        	prep.setString(2, doj); 	
        	prep.setString(3, Train);
        	prep.setString(4, From);
        	prep.setString(5, To);
        	prep.setString(6, Classes);
        	prep.setString(7, Comments);
        	prep.setString(8, userid);
        	prep.executeUpdate();
        	prep.close();
        	conn.close();
        	
        	rd = request.getRequestDispatcher("/displayinfo.jsp");
        	
        	} else {
	 
             rd = request.getRequestDispatcher("/error.jsp");

        	}
        	
        	
        } 
        catch(Exception E)
        {
        	System.out.println(E.getMessage());
        } 
        finally {
        
        }
        
            rd.forward(request, response);
    }

}
