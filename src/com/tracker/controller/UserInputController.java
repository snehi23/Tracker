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

import com.tracker.util.DBConnectionManager;



public class UserInputController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
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
        	
        	Connection conn = (Connection) ctx.getAttribute("DBConnection");
        	String sql= "insert into tracker(train_journey_id,DOJ,Train,From_Station,To_Station,Classes,Comments) values(?,?,?,?,?,?,?)";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setInt(1, 0);
        	prep.setString(2, doj); 	
        	prep.setString(3, Train);
        	prep.setString(4, From);
        	prep.setString(5, To);
        	prep.setString(6, Classes);
        	prep.setString(7, Comments);
        	prep.executeUpdate();
        	prep.close();
        	conn.close();
        	
        } 
        catch(Exception E)
        {
        	System.out.println(E.getMessage());
        } 
        finally {
        
        }
        
        
        RequestDispatcher rd = null;
 
            rd = request.getRequestDispatcher("/displayinfo.jsp");
            
        rd.forward(request, response);
    }

}
