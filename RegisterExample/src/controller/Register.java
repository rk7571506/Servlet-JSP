package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;
public class Register extends HttpServlet
{
	
		public void service(HttpServletRequest request, HttpServletResponse respnse)
		{
			try
			{
					String name = request.getParameter("name");
					String gender = request.getParameter("gender");
					String checkbox[] = request.getParameterValues("checkbox");
					String textarea = request.getParameter("feedback");
					String select = request.getParameter("select");
					String add = "";
					
					if(checkbox!=null)
					{
						for(String lang : checkbox)
							{
								add = lang+add;
							}
					}
					
					Model m = new Model();
					
					m.setName(name);
					m.setGender(gender);
					m.setCheckbox(add);
					m.setTextarea(textarea);
					m.setDropdown(select);
					
					boolean result = m.resultQuery();
					
					if(result == true)
					{
							respnse.sendRedirect("/RegisterExample/success.jsp");
					}
					else
					{
							respnse.sendRedirect("/RegisterExample/failed.jsp");
					}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

}
