package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class ChangePwd extends HttpServlet
{
	 public void service(HttpServletRequest request , HttpServletResponse response)
	 {
		 try
		 {
			 	String pass = request.getParameter("pass");
			 	HttpSession session = request.getSession();
			 	String acc_no = (String)session.getAttribute("acc_no");	
			 	Model m = new Model();
			 	m.setAcc_no(acc_no);
			 	m.setPassword(pass);
			 	
			 	int status = m.changePassword();
			 	
			 	
			 	if(status==1)
			 	{
			 		response.sendRedirect("/Project/passwordupdatesuccess.jsp");
			 	}
			 	else
			 	{
			 		response.sendRedirect("/Project/passwordupdatefail.jsp");
			 	}
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 } 	
	 }
}
