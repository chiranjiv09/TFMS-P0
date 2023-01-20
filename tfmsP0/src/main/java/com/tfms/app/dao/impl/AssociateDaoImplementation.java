package com.tfms.app.dao.impl;


import com.tfms.model.Associate;
import com.tfms.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.tfms.util.DatabaseConnection;
import com.tfms.dao.AssociateDao;

public class AssociateDaoImplementation implements AssociateDao{

	
	static Connection con
    = DatabaseConnection.getConnection();
	    
	
		@Override
		public int addForm(Associate associate) throws SQLException {
			 String query
	            = "insert into Associate(traineeId,traineeName,track,qualification,experience,trainerId) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement ps
	            = con.prepareStatement(query);
	        ps.setString(1, associate.getTraineeId());
	        ps.setString(2, associate.getTraineeName());
	        ps.setString(3, associate.getTrack());
	        ps.setString(4, associate.getQualification());
	        ps.setString(5, associate.getExperience());
	        ps.setString(6, associate.getTrainerId());
	        
	        int n = ps.executeUpdate();
	        return n;
	    }

		@Override
		public String updateForm(Associate associate, String traineeId) throws SQLException {
	        String query
            = "update Associate set traineeId=?, "
              + "traineeName=?,"
              + "track=?,"
              + "qualification=?,"
              + "experience=?,"
              + "trainerId=? where traineeId = ?";
        
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setString(1,associate.getTraineeId());
        ps.setString(2,associate.getTraineeName());
        ps.setString(3,associate.getTrack());
        ps.setString(4,associate.getQualification());
        ps.setString(5,associate.getExperience());
        ps.setString(6,associate.getTrainerId());
        
        ps.executeUpdate();
		return query;
    }
		

		@Override
		public void deleteForm(String traineeId) throws SQLException {
	        String query
            = "delete from Associate where traineeId =?";
        PreparedStatement ps
            = con.prepareStatement(query);
        ps.setString(1, traineeId);
        ps.executeUpdate();
    }
		

		@Override
		public Associate getAssociate(String traineeId) throws SQLException {
	        String query
            = "select * from Associate where traineeId= ?";
        PreparedStatement ps
            = con.prepareStatement(query);
  
        ps.setString(1, traineeId);
        Associate associate = new Associate();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
  
        while (rs.next()) {
            check = true;
 
            associate.setTraineeId(rs.getString("traineeId"));
            associate.setTraineeName(rs.getString("traineeName"));
            associate.setTrack(rs.getString("track"));
            associate.setQualification(rs.getString("qualification"));
            associate.setExperience(rs.getString("experience"));
            associate.setTrainerId(rs.getString("trainerId"));
        }
  
        if (check == true) {
            return associate;
        }
        else
            return null;
    }
  

		@Override
		public List<Associate> getAssociates() throws SQLException {
	        String query = "select * from Associate";
	        PreparedStatement ps
	            = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        List<Associate> ls = new ArrayList<Associate>();
	  
	        while (rs.next()) {
	            Associate associate = new Associate();
	            associate.setTraineeId(rs.getString("traineeId"));
	            associate.setTraineeName(rs.getString("traineeName"));
	            associate.setTrack(rs.getString("track"));
	            associate.setQualification(rs.getString("qualification"));
	            associate.setExperience(rs.getString("experience"));
	            associate.setTrainerId(rs.getString("trainerId"));
	            ls.add(associate);
	        }
	        return ls;
	    }
		}
	  
	 
	    
	    
	    
	    
	    
	    
	  
//	    
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
