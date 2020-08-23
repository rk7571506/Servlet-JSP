

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrintPercentage extends HttpServlet {
	
		public void service(HttpServletRequest request , HttpServletResponse response)
		{
			HttpSession session = request.getSession();
			int mark1 = (int) session.getAttribute("m1");
			int mark2 = (int)session.getAttribute("m2");
			int mark3 = (int)session.getAttribute("m3");
			
			float per = ((mark1+mark2+mark3)/300.0f)*100;
			
			try 
			{
				PrintWriter pw = response.getWriter();
				pw.println("Percentage Is:"+per);
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

}
