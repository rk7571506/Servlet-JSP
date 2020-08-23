package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Login extends HttpServlet 
{
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			String cid = request.getParameter("cid");
			String pw = request.getParameter("pw");
			
			Model m = new Model();
			
			m.setCust_id(cid);
			m.setPassword(pw);
			
			boolean result = m.login();
			
			if(result==true)
			{
				String acc_no = m.getAcc_no();
				HttpSession session = request.getSession(true);
				session.setAttribute("acc_no", acc_no);
				response.sendRedirect("/Project/home.jsp");
			}
			else
			{
				response.sendRedirect("/Project/loginfail.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
