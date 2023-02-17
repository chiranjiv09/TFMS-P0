package com.revature.tfms.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.jdbc.JdbcConnection;
import com.revature.dao.TraineeDao;
import com.revature.model.Trainee;
import com.revature.tfms.database.DatabaseConnection;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/editTrainer")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String traineeId =request.getParameter("trainerId");
		String traineeName =request.getParameter("trainerName");
		String traineeTrack =request.getParameter("track");
		String traineeQualifia =request.getParameter("trainerQual");
		String traineeExp =request.getParameter("trainerExp");

		Trainee trainee= new Trainee();
		trainee.setTraineeId(traineeId);
		trainee.setTraineeName(traineeName);
		trainee.setTraineeQualification(traineeQualifia);
		trainee.setTraineeExperience(traineeExp);
		trainee.setTraineeTrack(traineeTrack);
		
		System.out.println(trainee);
		TraineeDao  ado=new TraineeDao(null);
		HttpSession session=request.getSession();
		boolean f= ado.addDetails(trainee);
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tfms", "root", "Kushwah@0903");
		String sql="update trainee set traineeId = ?, traineeName = ?,track= ?,qualification =?, experience=? where traineeId = ?";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1, trainee.getTraineeId());
		ps.setString(2, trainee.getTraineeName());
		ps.setString(3, trainee.getTraineeTrack() );
    	ps.setString(4, trainee.getTraineeQualification());
		ps.setString(5, trainee.getTraineeExperience() );
		ps.setString(6, trainee.getTraineeId());
	
		int i=ps.executeUpdate();
		System.out.println("executed");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		if(f) {
			session.setAttribute("succMsg","Student details submit sucessfully");
			response.sendRedirect("edit.jsp");
		}else {
			session.setAttribute("errorMsg","Something wrong on server");
			response.sendRedirect("show.jsp");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
