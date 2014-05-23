package com.tracker.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.tracker.util.DBConnectionManager;

public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public RegistrationController() {
        super();
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
    	
    	Connection conn = null;
    	HttpSession session = request.getSession(true);
    	Boolean flag=true;
    	
    	String name = request.getParameter("name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        List<String> userids = new ArrayList<String>();
        
        
        System.out.println(" "+name+" "+username+" "+email+" "+pass);
        
        ConfigurablePasswordEncryptor encryptor = new ConfigurablePasswordEncryptor();
        encryptor.setAlgorithm("SHA-512");
        encryptor.setPlainDigest(true);
        String password = encryptor.encryptPassword(pass);
       
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
        
        conn = (Connection) ctx.getAttribute("DBConnection");
    	
    	conn.setAutoCommit(false);
    	
    	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    	
    	ResultSet rs1 = stmt.executeQuery("select user_id from user_registration_data where user_id ="+"'"+username+"'");

        
        if(rs1!=null && rs1.next()) { 
        	
        	flag=false;
        	
        	session.setAttribute("userid uniqueness", "Username already exist!");
        	rs1.close();
        	conn.commit();
        	
        } else {
        		
        	rs1.close();
        	conn.commit();
        
        try {
        	
        	conn = (Connection) ctx.getAttribute("DBConnection");
        	String sql= "insert into user_registration_data(user_registration_data_id,user_name,user_id,user_email,user_password) values(?,?,?,?,?)";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setInt(1, 0);
        	prep.setString(2, name); 	
        	prep.setString(3, username);
        	prep.setString(4, email);
        	prep.setString(5, password);
        	prep.executeUpdate();
        	prep.close();
        	conn.commit();
        	
        	} catch(Exception E)  {
        	System.out.println(E.getMessage());
        } 
        
        }
        
        conn.close();
        
        RequestDispatcher rd = null;
        
        if(flag) {
 
            rd = request.getRequestDispatcher("/login.jsp");
            session.removeAttribute("userid uniqueness");
               
        } else {
	
        	rd = request.getRequestDispatcher("/register.jsp");
        }
            
        rd.forward(request, response);
        
    } catch (Exception E1) {
    	E1.printStackTrace();
    	
    }
        
    }
 
}
