package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

public class GetResult extends HttpServlet
{
		public void service(HttpServletRequest request , HttpServletResponse responce)
		{
			try
			{
					String usnvalue = request.getParameter("usn");
					
					Model m = new Model();
					
					m.setUsn(usnvalue);
					m.getResult();
					
					
					String name = m.getName();
					String usn = m.getUsn();
					int m1  =  m.getMarks1();
					int m2=  m.getMarks2();
					int m3 = m.getMarks3();
					
					HttpSession session = request.getSession(true);
					session.setAttribute("name", name);
					session.setAttribute("usn", usn);
					session.setAttribute("m1", m1);
					session.setAttribute("m2", m2);
					session.setAttribute("m3", m3);
					
					responce.sendRedirect("/MVC1/disp.jsp");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}
