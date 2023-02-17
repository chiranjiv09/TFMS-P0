package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Trainee;

public class TraineeDao extends Trainee{
	private Connection conn;
	public TraineeDao(Connection conn){
		super();
		this.conn = conn;
	}
	
	public boolean addDetails(Trainee trainee) {
		boolean f= false;
		try {
			String sql="insert into trainee(traineeId,traineeName,track,qualification,experience) values(?,?,?,?,?)";
			PreparedStatement ps= conn.prepareStatement(sql);
			System.out.println(trainee.getTraineeName());
			
			ps.setString(1, trainee.getTraineeId());
			ps.setString(2, trainee.getTraineeName());
			ps.setString(3, trainee.getTraineeTrack() );
        	ps.setString(4, trainee.getTraineeQualification());
			ps.setString(5, trainee.getTraineeExperience() );

			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch( Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	
	public Trainee getTraineeById(String id) {
		Trainee a=null;
		try {
			String sql="select * from trainee where traineeId=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(id));
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				a=new Trainee();
				a.setTraineeId(String.valueOf(rs.getInt(1)));
				a.setTraineeName(rs.getString(2));
				a.setTraineeTrack(rs.getString(3));
				a.setTraineeQualification(rs.getString(4));
				a.setTraineeExperience(rs.getString(5));
				
				
                 
			}
			System.out.println(a.getTraineeId());
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return a;
	}
	
	
	
	public boolean updateUser(Trainee trainee) throws SQLException {
        boolean rowUpdated = false;
        try {
			String sql="update trainee set traineeId = ?, traineeName = ?,track= ?,qualification =?, experience=? where traineeId = ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setString(1, trainee.getTraineeId());
			ps.setString(2, trainee.getTraineeName());
			ps.setString(3, trainee.getTraineeTrack() );
        	ps.setString(4, trainee.getTraineeQualification());
			ps.setString(5, trainee.getTraineeExperience() );
			ps.setString(6, trainee.getTraineeId());
			
			int i=ps.executeUpdate();
			if(i==1) {
				rowUpdated=true;
			}
		}catch( Exception e) {
			e.printStackTrace();
		}
        return rowUpdated;
    }
}
