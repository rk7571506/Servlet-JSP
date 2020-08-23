

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validation
 */
public class Validation extends HttpServlet {
	
		public void service(HttpServletRequest request , HttpServletResponse response)
		{
			try
			{
				String usnvalue = request.getParameter("usn");
				
				if(usnvalue.length()!=3)
				{
					response.sendRedirect("/Servlet4/error.html");
				}
				else
				{
					request.getServletContext().getRequestDispatcher("/GetResult").forward(request, response);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

}
