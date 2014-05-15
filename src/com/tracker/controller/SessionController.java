package com.tracker.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import com.tracker.model.User;
import com.tracker.util.DBConnectionManager;

public class SessionController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public SessionController() {
        super();
    }
 
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
    	HttpSession session = request.getSession(true);

    	RequestDispatcher rd = null;
 
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

        /*String user = (String)session.getAttribute("userid");*/

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
							rd = request.getRequestDispatcher("/login.jsp");
        		}
        		
        		} else {
        			
        					rd = request.getRequestDispatcher("/login.jsp");
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