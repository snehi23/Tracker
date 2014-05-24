package com.tracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tracker.model.StationDetails;
import com.tracker.util.DBConnectionManager;

public class StationDao {
	
	public List<StationDetails> getStation(String station){

        List<StationDetails> stationDetails = new ArrayList<StationDetails>();
        PreparedStatement prep = null;
        ResultSet rs = null;
       
        String connectionURL= "jdbc:mysql://localhost:3306/train_journey";
        String uname= "root";
        String pwd= "root";
        
        try {
			DBConnectionManager dbconnmng = new DBConnectionManager(connectionURL, uname, pwd);
			
			Connection conn	= dbconnmng.getConnection();
			String query = "select station_name,station_code from station_lat_long where station_name like '%"+station+"%' union select station_name,station_code from station_lat_long  where station_code like '%"+station+"%'";
			System.out.println(query);
			prep = conn.prepareStatement(query);
			rs = prep.executeQuery();
			while (rs.next()) {
				
				StationDetails d = new StationDetails();
				d.setStation_Name(rs.getString("station_name"));
				d.setStation_Code(rs.getString("station_code"));
				stationDetails.add(d);
				
			}
			
			rs.close();
			conn.close();
			
		} catch (ClassNotFoundException e1) {
			
		} catch (SQLException e1) {
			
		}
        
        return stationDetails;
}

}
