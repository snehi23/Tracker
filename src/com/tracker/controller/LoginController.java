package com.tracker.controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 


import javax.servlet.http.HttpSession;

import com.tracker.model.Authenticator;
import com.tracker.model.User;
 


import sun.text.normalizer.ICUBinary.Authenticate;
 
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginController() {
        super();
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
    	HttpSession session = request.getSession(true);
    	
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        System.out.println(" "+username+" "+password);
        RequestDispatcher rd = null;
 
        Authenticator authenticator = new Authenticator();
        String result = authenticator.authenticate(username, password);
        if (result.equals("success")) {
            rd = request.getRequestDispatcher("/success.jsp");
            User user = new User(username, password);
            
            session.setAttribute("user", user);
            
            
        } else {
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);
    }
 
}