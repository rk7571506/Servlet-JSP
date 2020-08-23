

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validation extends HttpServlet {
	
	   public void service(HttpServletRequest request , HttpServletResponse response)
	   {
		   		String usnvalue = request.getParameter("usn");
		   		
		   		if(usnvalue.length()!=3)
		   		{
		   			try
		   			{
		   				response.sendRedirect("/Servlet7_Cookie/error.html");
		   			}
		   			catch(Exception e)
		   			{
		   				e.printStackTrace();
		   			}
		   		}
		   		else
		   		{
		   			try
		   			{
		   				request.getServletContext().getRequestDispatcher("/GetResult").forward(request, response);
		   			}
		   			catch(Exception e)
		   			{
		   				e.printStackTrace();
		   			}
		   		}
	   }

}
