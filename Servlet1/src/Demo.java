

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo extends HttpServlet {
	
	public void service(HttpServletRequest request , HttpServletResponse responce)
	{
		try 
		{
			responce.sendRedirect("/Servlet1/gudmorning.html");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	

}
