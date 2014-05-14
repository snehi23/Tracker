package com.tracker.controller;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.tracker.dao.rememberDao;
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
    	
    	
    	RequestDispatcher rd = null;
    	Boolean flag=true;
    	ConfigurablePasswordEncryptor encryptor = new ConfigurablePasswordEncryptor();
    	User userdetails = new User();
    	
    	boolean remember = "true".equals(request.getParameter("remember"));
    	

        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        
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
        	
        	String sql1 = "select user_id,user_password from user_registration_data where user_id ="+"'"+username+"'";
        	
        	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
  
        	ResultSet rs1 = stmt.executeQuery(sql1);
        	
        	if(rs1!=null && rs1.next())	{
        		rs1.beforeFirst();
        	     	
        	while(rs1.next()) {
        		userdetails.setUsername(rs1.getString(1));
        		userdetails.setPassword(rs1.getString(2));
        	}
        	
        	rs1.close();
        	conn.commit();
        	
        	
        	} else {
        		
        		flag=false;
        		rs1.close();
            	conn.commit();
        		
        	}
        	
        	//conn.close();
   
        	conn.commit();
        	conn.close();
	
        	
        } catch (Exception E) {
        	
        	E.printStackTrace();
        	
        }

        	
        System.out.println(flag);
        	if(flag) {
        				encryptor.setAlgorithm("SHA-512");
        				encryptor.setPlainDigest(true);
        			if(userdetails.getUsername().equals(username) && encryptor.checkPassword(password, userdetails.getPassword())) {
        	
        				session.setAttribute("userid", userdetails.getUsername());
        				
        				if (remember) {
        			        String uuid = UUID.randomUUID().toString();
        			        System.out.println("uuid in generated"+uuid);
        			        rememberDao.save(uuid, userdetails.getUsername());
        			        addCookie(response, "remember", uuid, 2592000);
        			    } else {
        			    	rememberDao.delete(userdetails.getUsername());
        			        removeCookie(response, "remember");
        			    }
        				
        				rd = request.getRequestDispatcher("/success.jsp");
        				
        		
        			} else {
        		
        				rd = request.getRequestDispatcher("/error.jsp");
        				
        			} } else {
        				
        				String uuid = getCookieValue(request, "remember");
        				
        				System.out.println("uuid in else"+uuid);
        				
        				if(uuid!=null) {
        					
        					String user = rememberDao.find(uuid);
        					System.out.println("user fetch from Dao"+user);
        					
        					if(user!=null) {	
        						
        						session.setAttribute("userid", user);
        						rd = request.getRequestDispatcher("/success.jsp");
        						addCookie(response, "remember", uuid, 2592000);
	
        					} else {
        						removeCookie(response, "remember");
        						rd = request.getRequestDispatcher("/error.jsp");
        					}
        				} else {
        		
        				rd = request.getRequestDispatcher("/error.jsp");
        				}
        		
        	}
        	
        	rd.forward(request, response);
        	
        } 
    
    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static void removeCookie(HttpServletResponse response, String name) {
        addCookie(response, name, null, 0);
    }
}
    