package com.tracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tracker.util.DBConnectionManager;

public class StationDao {
	
	public List<String> getStation(String station){

        List<String> stations = new ArrayList<String>();
        PreparedStatement prep = null;
        ResultSet rs = null;
        
        
        String connectionURL= "jdbc:mysql://localhost:3306/train_journey";
        String uname= "root";
        String pwd= "root";
        
        try {
			DBConnectionManager dbconnmng = new DBConnectionManager(connectionURL, uname, pwd);
			
			Connection conn	= dbconnmng.getConnection();
			String query = "select distinct Station_Code from station_code where Station_Code LIKE '%"
                    + station + "%'";
			prep = conn.prepareStatement(query);
			rs = prep.executeQuery();
			while (rs.next()) {
				stations.add(rs.getString("Station_Code"));
			}
			
			rs.close();
			conn.close();
			
		} catch (ClassNotFoundException e1) {
			
		} catch (SQLException e1) {
			
		}
        
        return stations;
}

}
