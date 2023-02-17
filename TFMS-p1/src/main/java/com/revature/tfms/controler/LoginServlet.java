package com.revature.tfms.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.tfms.database.DatabaseConnection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	Connection connection = DatabaseConnection.getConnection();
	static Connection myCon;
    /**
     * @see HttpServlet#HttpServlet()
     */
	static {
    		myCon = DatabaseConnection.getConnection();
	}
	
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html;charset=UTF-8");
			

			String username=request.getParameter("username");
			String password =request.getParameter("password");
//					loginCredentials.setPassword(request.getParameter("password"));
			HttpSession session=request.getSession(true);
			RequestDispatcher dispatcher;
			try {
				PreparedStatement PStm=myCon.prepareStatement("select username ,password from adminlogin where username=? and password=?");
				PStm.setString(1, username);
				PStm.setString(2, password);
				System.out.println(PStm);
				
				ResultSet rs=PStm.executeQuery();
				if(rs.next()) {
	                dispatcher=request.getRequestDispatcher("admin.jsp");
	                dispatcher.forward(request, response);
//	                System.out.println(rs.getString(1));
	               
	                if (Objects.isNull(session)) {
	                	response.setIntHeader("Refresh", 1);
//						response.sendRedirect("login.jsp");
						System.out.println("this obj112");
						return;
					}
					session.setAttribute("username", rs.getString(1));
					System.out.println(session.getAttribute("username"));
//					System.out.println(rs.getString(1)+" hidbvkdjvksdnkjn" +rs.getString(2));

				}
	            else{
	                request.setAttribute("status", "failed");
	                System.out.println("not availble");
	                dispatcher=request.getRequestDispatcher("login.jsp");
//	                            response.sendRedirect("bookappointment.html");
	                dispatcher.include(request, response);
//	                response.setIntHeader("Refresh", 1);
	            }
			} catch (SQLException e)
			{
				e.printStackTrace();
				}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
