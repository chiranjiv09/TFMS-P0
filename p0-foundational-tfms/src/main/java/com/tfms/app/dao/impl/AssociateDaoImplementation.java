package com.tfms.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.tfms.config.DatabaseConnection;
//import com.tfms.util.DatabaseConnection;
import com.tfms.dao.AssociateDao;
import com.tfms.model.Associate;

public class AssociateDaoImplementation implements AssociateDao {
	static Connection con = DatabaseConnection.getConnection();

	@Override
	public int addForm(Associate associate) throws SQLException {
		String query = "insert into associate(traineeId,traineeName,track,qualification,experience,trainerId) values (?,?,?,?,?,?)";
//insert into associate(traineeId,traineeName,track,qualification,experience,trainerId) values (?,?,?,?,?,?);

		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, associate.getTraineeId());
		ps.setString(2, associate.getTraineeName());
		ps.setString(3, associate.getTrack());
		ps.setString(4, associate.getQualification());
		ps.setString(5, associate.getExperience());
		ps.setString(6, associate.getTrainerId());

		int n = ps.executeUpdate();
		if(n>0) {
			System.out.println("Data Inserted !");
		}
		else {
			System.out.println("Data not Inserted\nPlease press 1!");
		}
		return n;
		
	}

	@Override
	public void updateForm() throws SQLException {
		String query = "update Associate set traineeName=?,track=?,qualification=?,experience=?,trainerId=? where traineeId = ?";

		PreparedStatement ps1 = con.prepareStatement("Select * from Associate where traineeId =?");
		PreparedStatement ps2 = con.prepareStatement(query);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter traineeId");
		String traineeI = sc.nextLine();
		
		ps1.setString(1,traineeI);
		ResultSet rs = ps1.executeQuery();
		if(rs.next()) {
			System.out.println("enter New traineeName");
			String name = sc.nextLine();
			
			System.out.println("enter New track");
			String track = sc.nextLine();
			
			System.out.println("enter New qualification");
			String qual = sc.nextLine();
			
			System.out.println("enter New experience");
			String exp = sc.nextLine();
			
			System.out.println("enter New trainerId");
			String tid = sc.nextLine();
			
			ps2.setString(1,name);
			ps2.setString(2,track);
			ps2.setString(3,qual);
			ps2.setString(4,exp);
			ps2.setString(5,tid);
			ps2.setString(6,traineeI);
			
			int k = ps2.executeUpdate();
			if(k>0) {
				System.out.println("Updated Successfully");
			}
			else {
				System.out.println("Not Updated");
			
			}
			
		}

	}

	@Override
	public void deleteForm(String traineeId) throws SQLException {
		String query = "delete from Associate where traineeId =?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, traineeId);
		int k=ps.executeUpdate();
		if(k>0) {
			System.out.println("Deleted Successfully");
		}
		else
			System.out.println("Unsuccessful");
	}

	@Override
	public Associate getAssociate(String traineeId) throws SQLException {
		String query = "select * from Associate where traineeId= ?";
		PreparedStatement ps = con.prepareStatement(query);

		ps.setString(1, traineeId);
		Associate associate = new Associate();
		ResultSet rs = ps.executeQuery();
		boolean check = false;

		while (rs.next()) {
			check = true;
			
			System.out.println(rs.getString(1)); 
			System.out.println(rs.getString(2)); 
			System.out.println( rs.getString(3));
			System.out.println( rs.getString(4));
			System.out.println( rs.getString(5));
			System.out.println( rs.getString(6));
			

		}

		if (check == true) {
			return associate;
		} else
			return null;
	}
}


//		public List<Associate> getAssociates() throws SQLException {
//	        String query = "select * from Associate";
//	        PreparedStatement ps
//	            = con.prepareStatement(query);
//	        ResultSet rs = ps.executeQuery();
//	        List<Associate> ls = new ArrayList<Associate>();
//	  
//	        while (rs.next()) {
//	            Associate associate = new Associate();
//	            associate.setTraineeId(rs.getString("traineeId"));
//	            associate.setTraineeName(rs.getString("traineeName"));
//	            associate.setTrack(rs.getString("track"));
//	            associate.setQualification(rs.getString("qualification"));
//	            associate.setExperience(rs.getString("experience"));
//	            associate.setTrainerId(rs.getString("trainerId"));
//	            ls.add(associate);
//	        }
//	        return ls;
//	    }
//		}
//	  
//	 
//	    
//	    
//	    
//	    
//	    
//	    
//	  
////	    
//	    @Override
//	    public String addForm(Associate a)  throws SQLException
//	    {
//	  
//	        String query
//	            = "insert into Associate(traineeId,traineeName,track,qualification,experience,trainerId) VALUES (?, ?, ?, ?, ?, ?)";
//	        PreparedStatement ps
//	            = con.prepareStatement(query);
//	        ps.setString(1, a.getTraineeId());
//	        ps.setString(2, a.getTraineeName());
//	        ps.setString(3, a.getTrack());
//	        ps.setString(4, a.getQualification());
//	        ps.setString(5, a.getExperience());
//	        ps.setString(6, a.getTrainerId());
//	        
//	        int n = ps.executeUpdate();
//	        return n;
//	    }
//	  
//	    @Override
//	    public void deleteForm(String traineeId)
//	        throws SQLException
//	    {
//	        String query
//	            = "delete from Associate where traineeId =?";
//	        PreparedStatement ps
//	            = con.prepareStatement(query);
//	        ps.setString(1, traineeId);
//	        ps.executeUpdate();
//	    }
//	  
//	    @Override
//	    public Associate searchSpecificForm(String traineeId)
//	        throws SQLException
//	    {
//	  
//	        String query
//	            = "select * from Associate where traineeId= ?";
//	        PreparedStatement ps
//	            = con.prepareStatement(query);
//	  
//	        ps.setString(1, traineeId);
//	        Associate a = new Associate();
//	        ResultSet rs = ps.executeQuery();
//	        boolean check = false;
//	  
//	        while (rs.next()) {
//	            check = true;
//	            a.setTraineeId(rs.getString("traineeId"));
//	            a.setTraineeName(rs.getString("traineeName"));
//	            a.setTrack(rs.getString("track"));
//	            a.setQualification(rs.getString("qualification"));
//	            a.setExperience(rs.getString("experience"));
//	            a.setTrainerId(rs.getString("trainerId"));
//	        }
//	  
//	        if (check == true) {
//	            return a;
//	        }
//	        else
//	            return null;
//	    }
//	  
//	    @Override
//	    public List<Associate> getAssociates()
//	        throws SQLException
//	    {
//	        String query = "select * from Associate";
//	        PreparedStatement ps
//	            = con.prepareStatement(query);
//	        ResultSet rs = ps.executeQuery();
//	        List<Associate> ls = new ArrayList();
//	  
//	        while (rs.next()) {
//	            Associate a = new Associate();
//	            a.setTraineeId(rs.getString("traineeId"));
//	            a.setTraineeName(rs.getString("traineeName"));
//	            a.setTrack(rs.getString("track"));
//	            a.setQualification(rs.getString("qualification"));
//	            a.setExperience(rs.getString("experience"));
//	            a.setTrainerId(rs.getString("trainerId"));
//	            ls.add(a);
//	        }
//	        return ls;
//	    }
//	  
//	    @Override
//	    public void updateForm(Associate a)
//	        throws SQLException
//	    {
//	  
//	        String query
//	            = "update Associate set traineeId=?, "
//	              + "traineeName=?,"
//	              + "track=?,"
//	              + "qualification=?,"
//	              + "experience=?,"
//	              + "trainerId=? where traineeId = ?";
//	        
//	        PreparedStatement ps
//	            = con.prepareStatement(query);
//	        ps.setString(1,a.getTraineeId());
//	        ps.setString(2,a.getTraineeName());
//	        ps.setString(3,a.getTrack());
//	        ps.setString(4,a.getQualification());
//	        ps.setString(5,a.getExperience());
//	        ps.setString(6,a.getTrainerId());
//	        
//	        ps.executeUpdate();
//	    }

//		@Override
//		public String addForm(com.tfms.model.Associate associate) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public String updateForm(com.tfms.model.Associate associate, String traineeId) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public String deleteForm(String traineeId) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public String searchSpecificForm(String traineeId) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public int add(com.tfms.model.Associate a) throws SQLException {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//
//		@Override
//		public void update(com.tfms.model.Associate a) throws SQLException {
//			// TODO Auto-generated method stub
//			
//		}
//}
//
////		@Override
////		public String addForm(Associate associate) throws SQLException {
////			// TODO Auto-generated method stub
////			return null;
////		}
//
//		@Override
//		public String updateForm(Associate associate, String traineeId) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public String deleteForm(String traineeId) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public String searchSpecificForm(String traineeId) throws SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//	}
//	
//	

//	@Override
//	public String addForm(Associate associate) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String updateForm(Associate associate, String traineeId) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String deleteForm(String traineeId) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String searchSpecificForm(String traineeId) throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//
//}
