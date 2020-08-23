package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;

public class Register extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			String name = request.getParameter("name");
			String un = request.getParameter("un");
			String pw = request.getParameter("pw");
			Model m = new Model();
			
			m.setName(name);
			m.setUsername(un);
			m.setPassword(pw);
			
			boolean stauts = m.register();
			
			if(stauts==true)
			{
				response.sendRedirect("/MVC2/successregister.html");
			}
			else
			{
				response.sendRedirect("/MVC2/errorregister.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
