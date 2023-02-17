<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%
String id=request.getParameter("id");
out.println("Data Deleted Successfully!");
/* out.println(id); */
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tfms", "root", "Kushwah@0903");
Statement st=conn.createStatement();

int i=st.executeUpdate("DELETE FROM trainee WHERE traineeId="+id);
/* out.println("Data Deleted Successfully!"); */
if(i>0){
	response.sendRedirect("show.jsp");
}

/* PreparedStatement st=conn.prepareStatement("DELETE FROM trainer WHERE trainer_id="+id);
ResultSet rs = st.executeQuery(); */

}
catch(Exception e)
{

e.printStackTrace();
}
%>