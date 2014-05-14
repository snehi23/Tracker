package com.tracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tracker.model.SessionUser;
import com.tracker.util.DBConnectionManager;

public class rememberDao {
	
	public static void save(String uuid, String user){

        List<SessionUser> sessionUser = new ArrayList<SessionUser>();
        
        String connectionURL= "jdbc:mysql://localhost:3306/train_journey";
        String uname= "root";
        String pwd= "root";
        
        try {
			DBConnectionManager dbconnmng = new DBConnectionManager(connectionURL, uname, pwd);
			
			Connection conn	= dbconnmng.getConnection();
			String sql= "insert into session_users(uuid,user_id) values(?,?)";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setString(1, uuid);
        	prep.setString(2, user); 	
        	prep.executeUpdate();
        	prep.close();
        	conn.close();
			
		} catch (ClassNotFoundException e1) {
			
		} catch (SQLException e1) {
			
		}

}
	
	public static void delete(String user){

        String connectionURL= "jdbc:mysql://localhost:3306/train_journey";
        String uname= "root";
        String pwd= "root";
        
        try {
			DBConnectionManager dbconnmng = new DBConnectionManager(connectionURL, uname, pwd);
			
			Connection conn	= dbconnmng.getConnection();
			String sql= "delete from session_users where user_id=?)";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setString(1, user);
        	prep.executeUpdate();
        	prep.close();
        	conn.close();
			
		} catch (ClassNotFoundException e1) {
			
		} catch (SQLException e1) {
			
		}

	}
	
	public static String find(String uuid){

		String user=null;
        String connectionURL= "jdbc:mysql://localhost:3306/train_journey";
        String uname= "root";
        String pwd= "root";
        
        try {
			DBConnectionManager dbconnmng = new DBConnectionManager(connectionURL, uname, pwd);
			
			Connection conn	= dbconnmng.getConnection();
			String sql= "select user_id from session_users where uuid=?";
        	PreparedStatement prep = conn.prepareStatement(sql);
        	prep.setString(1, uuid);
        	ResultSet rs = prep.executeQuery();
        	while(rs.next()) {
        		user=rs.getString(1);        		
        	}
        	System.out.println("user id in rememberDao"+user);
        	prep.close();
        	conn.close();
			
		} catch (ClassNotFoundException e1) {
			
		} catch (SQLException e1) {
			
		}
        
        return user;

	}

}
