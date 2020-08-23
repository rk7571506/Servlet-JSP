package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;

public class Login extends HttpServlet 
{

	public void service(HttpServletRequest request ,HttpServletResponse response)
	{
		try
		{
			 String username = request.getParameter("uname");
			 String pw = request.getParameter("pw");
			  
			  Model m = new Model();
			  m.setUsername(username);
			  m.setPassword(pw);
			  
			  boolean result = m.login();
			  
			  if(result==true)
			  {
				  response.sendRedirect("/MVC2/loginsuccess.html");
			  }
			  else
			  {
				  response.sendRedirect("/MVC2/loginfailed.html");
			  }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
}
