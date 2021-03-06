package com.tracker.controller;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

public class DisplayAllController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        
        List<Details> details_list = new ArrayList<Details>();
        
        HttpSession session = request.getSession(true);
        RequestDispatcher rd = null;
        
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
        		
            	String userid = (String) session.getAttribute("userid");	
            	
        	
        	Connection conn = (Connection) ctx.getAttribute("DBConnection");
        	
        	String sql = "select * from tracker where user_id ="+"'"+userid+"'";
        	ps = conn.prepareStatement(sql);
        	rs = ps.executeQuery();       	
        	while(rs.next()) {

        		Details d = new Details();
        		d.setTrain_journey_id(rs.getInt("train_journey_id"));
        		d.setDOJ(rs.getString("DOJ"));
        		d.setTrain(rs.getString("Train"));
        		d.setTrain_Number(rs.getString("Train_Number"));
        		d.setFrom_Station(rs.getString("From_Station"));
        		d.setTo_Station(rs.getString("To_Station"));
        		d.setClasses(rs.getString("Classes"));
        		d.setComments(rs.getString("Comments"));       		
        		details_list.add(d);        		
        	}
        	
        	Collections.sort(details_list, new CompareDetailsByDOJ());
        	
            request.setAttribute("details_list", details_list);
            
        	rs.close();
        	ps.close();
        	conn.close();
        	
        	rd = request.getRequestDispatcher("/displayinfo.jsp");
        	
        	
        	} else {
        		
        		rd = request.getRequestDispatcher("/invalid-session.html");
        		
        	}
        	
        } 
        catch(Exception E1)
        {
        	System.out.println(E1.getMessage());
        } 
                
        
        rd.forward(request, response);
    }

}

class CompareDetailsByDOJ implements Comparator<Details> {

	@Override
	public int compare(Details d1, Details d2) {
		return d2.getDOJ().compareToIgnoreCase(d1.getDOJ());
	}
	
	
}
