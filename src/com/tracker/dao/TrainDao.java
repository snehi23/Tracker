package com.tracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tracker.model.TrainDetails;
import com.tracker.util.DBConnectionManager;

public class TrainDao {
	
	public List<TrainDetails> getTrain(String train){

        List<TrainDetails>  trainDetails = new ArrayList<TrainDetails>();
        PreparedStatement prep = null;
        ResultSet rs = null;
        
        System.out.println(train);
        String connectionURL= "jdbc:mysql://localhost:3306/train_journey";
        String uname= "root";
        String pwd= "root";
        
        /*String connectionURL= "jdbc:mysql://localhost/jouneyt_tracker";
        String uname= "jouneyt_tracker";
        String pwd= "tracker";*/
        
        /*String connectionURL= "jdbc:mysql://mysql-travelogue.whelastic.net/train_journey";
        String uname= "root";
        String pwd= "d7iBieSulj";*/
        
        try {
			DBConnectionManager dbconnmng = new DBConnectionManager(connectionURL, uname, pwd);
			
			Connection conn	= dbconnmng.getConnection();
			String query = "select Train_Name,Train_Number from train_number_name_type_route where Train_Name LIKE '%"
                    + train + "%'";
			prep = conn.prepareStatement(query);
			rs = prep.executeQuery();
			while (rs.next()) {
				
				TrainDetails d = new TrainDetails();
				d.setTrain_Name(rs.getString("Train_Name"));
				d.setTrain_Number(rs.getInt("Train_Number"));
				trainDetails.add(d);

			}
			
			rs.close();
			conn.close();
			
		} catch (ClassNotFoundException e1) {
			
		} catch (SQLException e1) {
			
		}
        
        return trainDetails;
}

}
