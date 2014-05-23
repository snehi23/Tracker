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

public class UserInputUpdateController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
		HttpSession session = request.getSession(true);
		RequestDispatcher rd = null;
		
        String username = request.getParameter("username");
        String doj = request.getParameter("DOJ");
        String Train = (String)request.getParameter("Train");
        String From = request.getParameter("From");
        String To = request.getParameter("To");
        String Classes = request.getParameter("classes");
        String Comments = request.getParameter("comments");
        String Berth = request.getParameter("berth");
        
        System.out.println(" "+username+" "+doj+" "+Train+" "+From+" "+To+" "+Classes+" "+Berth+" "+Comments);
        
        String Train_Number = Train.replaceAll("[^0-9]","");
        System.out.println(Train_Number);
        
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
        	Integer journey_id = (Integer) session.getAttribute("journey_id");
        	
        	Connection conn = (Connection) ctx.getAttribute("DBConnection");
        	String sql= "update tracker set DOJ=?,Train=?,Train_Number=?,From_Station=?,To_Station=?,Classes=?,berth=?,Comments=?,user_id=? where train_journey_id=?";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setString(1, doj); 	
        	prep.setString(2, Train.replaceAll("\\P{L}", " ").trim());
        	prep.setString(3, Train_Number);
        	prep.setString(4, From.replaceAll(".*\\(", "").replaceAll("\\)", "").trim());
        	prep.setString(5, To.replaceAll(".*\\(", "").replaceAll("\\)", "").trim());
        	prep.setString(6, Classes);
        	prep.setString(7, Berth);
        	prep.setString(8, Comments);
        	prep.setString(9, userid);
        	prep.setInt(10, journey_id);
        	prep.executeUpdate();
        	prep.close();
        	conn.close();
        	
        	rd = request.getRequestDispatcher("/Editinfo.jsp");
        	
        	request.setAttribute("Record_Confirmation", "Journey Updated Successfully !!!");
        	
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