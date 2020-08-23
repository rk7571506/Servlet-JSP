package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class CheckBalance extends HttpServlet 
{
		public void service(HttpServletRequest request, HttpServletResponse response)
		{
			try
			{
					Model m = new Model();
					HttpSession session = request.getSession();
					String acc_no = (String) session.getAttribute("acc_no"); //unboxing.
					m.setAcc_no(acc_no);
					boolean status = m.checkBalance();
					
					
					if(status==true)
					{
						int bal = m.getBlance();
						session.setAttribute("bal", bal);
						response.sendRedirect("/Project/successblc.jsp");
					}
					else
					{
						response.sendRedirect("/Project/balfail.jsp");
					}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

}
