package com.tfms.app.menu;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.tfms.app.dao.impl.AssociateDaoImplementation;
import com.tfms.dao.AssociateDao;
import com.tfms.model.Associate;
import com.tfms.model.AssociateTrack;
//import com.revature.dao.UserDao;
//import com.revature.dao.UserDaoImpl;
//import com.revature.model.User;
//import com.revature.util.DateTimeUtil;
import com.tfms.util.MenuCard;

public class MenuDrivenApplication {

private static final Logger logger = Logger.getLogger(MenuDrivenApplication.class);

	public static void main(String[] args) throws Exception{
		char choice = 'y';
		authenticateUser();
		
	}




	private static void adminPanel() throws Exception, SQLException {
		char choice;
		do {
			MenuCard.print();
			Scanner choiceScan = new Scanner(System.in);
			choice = choiceScan.next().charAt(0);
			switch (choice) {
			case '1':
				addForm();
				break;
			case '2':
				updateForm();
				break;
			case '3':
				deleteForm();
				break;
			case '4':
				getAssociate();
				break;
			default:
				logger.info("      Wrong option selected!");
			}
		} while (choice !='n');
	}


	
	
	private static void authenticateUser() throws SQLException, Exception {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username : ");
		String username = sc.nextLine();
		System.out.println("Enter password : ");
		String password = sc.nextLine();
		
		if(username.equalsIgnoreCase("admin") && password.equals("admin")) {
			System.out.println("logged in successful");
			adminPanel();
		}else {
			System.out.println("Invalid login password");
		}
	}




	private static void getAssociate(){
		Associate getAssociate = new Associate();
		
		Scanner scan = new Scanner(System.in);
		logger.info("You Selected -Search Associate");
		System.out.print("Please Enter Associate ID To Search:");
		String loginId = scan.nextLine();
		
		AssociateDao a=new AssociateDaoImplementation();
		try {
			getAssociate=a.getAssociate(loginId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
	
		
	}
		private static void deleteForm() throws SQLException {
		Scanner scan = new Scanner(System.in);
		logger.info("You Selected -Delete Associate");
		System.out.print("Please Enter Login ID To Delete:");
		String loginId = scan.nextLine();
		AssociateDao b=new AssociateDaoImplementation();
		
			b.deleteForm(loginId);
		
		
	}

				
		
		
		
		
		

	private static void updateForm() throws SQLException {
		Scanner scan = new Scanner(System.in);
		logger.info("You Selected -Update Associate");
		AssociateDaoImplementation ad = new AssociateDaoImplementation();
		ad.updateForm();
		//String loginId = scan.nextLine();
		

}

	private static void addForm() throws Exception {
		AssociateDaoImplementation imp= new AssociateDaoImplementation();
		Associate newAssociate = new Associate();
		String track;
		
		Scanner scan = new Scanner(System.in);
		logger.info("You Selected -Add Associate");
		
		System.out.print("(1) Please enter Associate Id :");
		String associateId  = scan.nextLine();
	    newAssociate.setTraineeId(associateId);
	    
	    System.out.print("(2) Please enter Associate name :");
		String associateName  = scan.nextLine();
	    newAssociate.setTraineeName(associateName);
	    
	    String java = AssociateTrack.JAVA.toString();
		String dotnet = AssociateTrack.DOTNET.toString();
		String mainframe = AssociateTrack.MAINFRAME.toString();
		String testing = AssociateTrack.TESTING.toString();
		int Check = 0;
		do {
			System.out.print("(3) Enter track: ");
			track = scan.nextLine().toUpperCase();
			System.out.println(track);
			if (track.equals(java) || track.equals(dotnet) || track.equals(mainframe) || track.equals(testing)) {
				newAssociate.setTrack(track);
				Check++;
			} else {
				logger.info("\tEnter valid track");
			}
		} while (Check == 0);
	    
//	    System.out.print("(3) Please enter Associate track :");
//		String associateTrack  = scan.nextLine();
//		newAssociate.setTrack(associateTrack);
		
		System.out.print("(4) Please enter Associate qualification :");
		String associateQualification  = scan.nextLine();
		newAssociate.setQualification(associateQualification);
		
		System.out.print("(5) Please enter Associate experience :");
		String associateExperience  = scan.nextLine();
		newAssociate.setExperience(associateExperience);
		
		
		System.out.print("(6) Please enter TrainerId :");
		String trainerId = scan.nextLine();
		newAssociate.setTrainerId(trainerId);
		logger.info("\n");
		
//		Associate associate = new Associate(associateName,associateId,associateTrack,associateQualification,associateExperience,trainerId);
		
		imp.addForm(newAssociate);
		logger.info("\t***********Associate details saved*************");
	    
		

	}
}







//package com.revature.service.impl;
//import com.revature.service.*;
//import static java.lang.System.out;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Scanner;
//
//import com.revature.constant.Constant;
//import com.revature.model.Associate;
//import com.revature.model.AssociateTrack;
//import com.revature.model.Menu;
//
//public class AssociateDetailsImp extends Associate implements AssociateDetails{
//	
//	static ArrayList<Associate> l=new ArrayList<Associate>();
//	Constant constant= new Constant();
//	Scanner scInt= new Scanner(System.in);
//	Scanner scString= new Scanner(System.in);
//	Menu menu= new Menu();
//	
//	int choice;	
//	
//
//	public void addDetails() {
//		
//		out.println(constant.ENTERASSOCIATEDETAILS);
//		do {
//			
//		    
//			out.print(constant.ASSOCIATEID);
//			int Id =scInt.nextInt();
//						
//			out.print(constant.ASSOCIATENAME);
//			String Name =scString.nextLine();
//			
//			out.print(constant.ASSOCIATETRACK);
//			int count=0;
//			String Track;
//			do {
//			 Track=scString.nextLine().toUpperCase();
//			
//			if(Track.equals(AssociateTrack.JAVA.toString()) || Track.equals(AssociateTrack.MAINFRAME.toString()) || Track.equals(AssociateTrack.TEASTING.toString()) || Track.equals(AssociateTrack.DOTNET.toString()) ) {
//			    count++;
//			}
//			else {
//				out.print("Invalid input please enter correct input:- \n");
//				
//			}
//			}while(count!=1);
//			
//			out.print(constant.ASSOCIATEQUALIFICATION);
//			String Qualification = scString.nextLine();
//			
//			out.print(constant.ASSOCIATEEXPERIENCE);
//			String Experience =scString.nextLine();
//			
//			Associate a1=new Associate(Id,Name,Track,Qualification,Experience);
//			l.add(a1);
//			
//			int sizeoflist=l.size();
//			out.print("\n--------------------------------------------");
//			out.print("\nNumber of Associates are :- "+sizeoflist);
//			out.print("\n--------------------------------------------\n");
//			out.print("\nIf you want to enter more data press - 1  Otherwise press- 0:-");
//			choice =scInt.nextInt();
//		
//
//		}while(choice==1);
//	 			
//	}	
//		
//       
//
//		public void listAssociateDetails() {
//        	
//           out.println(constant.SHOWASSOCIATEDETAILS+ "\n");
//           
//           for (Associate associate : l) {
//		      out.println(constant.ASSOCIATEID +" "+ associate.getAssociateId());
//	          out.println(constant.ASSOCIATENAME + " "+ associate.getAssociateName());
//	          out.println(constant.ASSOCIATETRACK + " "+ associate.getAssociateTrack());
//		      out.println(constant.ASSOCIATEQUALIFICATION + " " + associate.getAssociateQualification());
//		      out.println(constant.ASSOCIATEEXPERIENCE +" "+ associate.getAssociateExperience()+"\n");
//		      out.println("-------------------------------------------------------------");
//		
//             }
//
//    } 	
//		
//		
//	public void deleteAssociateaDetails() {
//		int temp;
//		Iterator<Associate> itr = l.iterator();
//		do {
//			
//			while(itr.hasNext()) {
//				out.print("Enter Associate Id which yoy want delete:-");
//				int del=scInt.nextInt();
//				
//				if(itr.next().getAssociateId()==del) {
//				     itr.remove();
//				     out.print("\nData Deleted Successful for Associate Id:-"+ del+"\n");
//       			     break;
//				}
//		}
//			
//		if(l.isEmpty()) {
//		    out.print("\nTher is no data present! Enter data first\n");
//			break;
//		}else {
//				out.print("\nYou want to delete more then press :- 2 Otherwise press- 0 \n");
//			    temp= scInt.nextInt();
//			  }
//			
//		}while(temp==2);
//		
//	}
//	
//	
//	public void updateAssociateDetails() {
//		int check;
//		do {
//			out.print("\nEnter the associate Id for which you want to update:- ");
//			int tempAssoc= scInt.nextInt();
//			
//			out.println(" -------- Select what you want to update --------");
//			out.println("1.Name");
//			out.println("2.Track");
//			out.println("3.qualification");
//			out.println("4.Experience");
//            
//			logger.info("\nEnter your choice:-");
//			int cheak1=scInt.nextInt();
//			switch(cheak1 ) {
//			
//			case 1:
//				for (Associate associate : l) {
//					
//					if(tempAssoc==(associate.getAssociateId())) {
//						
//					    out.print("\nEnter the updated name :-");
//					    String newname= scString.nextLine();
//						associate.setAssociateName(newname);
//					}
//					else {
//						out.print("\nWrong Associate Id provide correct Associate Id please ...");
//					}
//				
//			
//			        }  
//			;break;
//			
//			case 2 :
//				for (Associate associate : l) {
//					     
//                        if(tempAssoc==(associate.getAssociateId())) {
//					    out.println("Enter the updated Track :- \n");
//					    String newname= scString.nextLine();
//						associate.setAssociateTrack(newname);
//					}
//					
//				}
//				;break;
//				
//			case 3 :
//				for (Associate associate : l) {
//					     
//                        if(tempAssoc==(associate.getAssociateId())) {
//					    out.println("Enter the updated Associate qualification :- \n");
//					    String newname= scString.nextLine();
//						associate.setAssociateQualification(newname);
//					}
//					
//				}
//				;break;
//				
//			case 4 :
//				for (Associate associate : l) {
//					     
//                        if(tempAssoc==(associate.getAssociateId())) {
//					    out.println("Enter the updated  Experience :- \n");
//					    String newname= scString.nextLine();
//						associate.setAssociateExperience(newname);;
//					}
//					
//				}
//				;break;
//			}
//			
//			out.println("\nyou want to update more press:- 1 Otherewise press- 0\n");
//			check=scInt.nextInt();
//			
//		}while(check==1);
//		
//	
//		}
//
//}