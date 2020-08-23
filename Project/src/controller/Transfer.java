package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class Transfer extends HttpServlet 
{

	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			int toamnt = (Integer.parseInt(request.getParameter("tamt")));
			String toacc_no	= request.getParameter("toaccno");
			
			HttpSession session = request.getSession();
			String acc_no = (String) session.getAttribute("acc_no");
			
			Model m = new Model();
			m.setBlance(toamnt);
			m.setAcc_no(acc_no);
			boolean status = m.transfer(toacc_no);
			
			
			
			
			
			if(status==true)
			{
				response.sendRedirect("/Project/transfersuccess.jsp");
			}
			else
			{
				response.sendRedirect("/Project/transferfail.jsp");
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
