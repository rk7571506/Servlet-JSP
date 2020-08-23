

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validation extends HttpServlet {
	
		public void service(HttpServletRequest request , HttpServletResponse responce)
		{
			
			try
			{
				String usn = request.getParameter("usn");
				if(usn.length()!=3)
				{		
						responce.sendRedirect("/Servlet6/error.html");	
				}
				else
				{
								request.getServletContext().getRequestDispatcher("/GetResult").forward(request, responce);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}
