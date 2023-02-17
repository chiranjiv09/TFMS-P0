package com.revature.tfms.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.TraineeDao;
import com.revature.model.Trainee;
import com.revature.tfms.database.DatabaseConnection;

/**
 * Servlet implementation class AddTrainer
 */
@WebServlet("/InsertData")
public class AddTrainee extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);
		
		String traineeId =request.getParameter("id");
		String traineeName =request.getParameter("name");
		String traineeTrack =request.getParameter("track");
		String traineeQualifia =request.getParameter("qualification");
		String traineeExp =request.getParameter("experience");

		Trainee trainee= new Trainee(traineeId,traineeName,traineeTrack,traineeQualifia,traineeExp);
		
		System.out.println(trainee);
		TraineeDao  ado=new TraineeDao(DatabaseConnection.getConnection());
		HttpSession session=request.getSession();
		boolean f= ado.addDetails(trainee);
		
		if(f) {
			session.setAttribute("succMsg","Student details submit sucessfully");
			response.sendRedirect("show.jsp");
		}else {
			session.setAttribute("errorMsg","Something wrong on server");
			response.sendRedirect("add.jsp");

		}
	}

}
