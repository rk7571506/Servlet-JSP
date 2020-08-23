package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class GetStatement extends HttpServlet 
{
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			HttpSession session = request.getSession();
			String acc_no = (String) session.getAttribute("acc_no");
			
			Model m = new Model();
			m.setAcc_no(acc_no);
			ArrayList al = m.getstmt();
			
			if(al.isEmpty())
			{
				response.sendRedirect("/Project/getstmtempty.jsp");
			}
			else
			{
				session.setAttribute("al", al);
				response.sendRedirect("/Project/getstmt.jsp");
			}
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
