package com.tfms.app;

import java.sql.SQLException;

import com.tfms.app.dao.impl.AssociateDaoImplementation;
import com.tfms.model.Associate;

public class App {
	
	public static void main(String[] args) throws SQLException {
		Associate associate = new Associate();
        associate.setTraineeId("123");
        associate.setTraineeName("chiranjiv");
        associate.setTrack("Java");
        associate.setQualification("Btech");
        associate.setExperience("two year");
//        associate.setTrainerId("J123");

        AssociateDaoImplementation asssociateDao
            = new AssociateDaoImplementation();
  
        asssociateDao.addForm(associate);
  
        
        System.out.println("1 ROW INSERTED");
	}

}
