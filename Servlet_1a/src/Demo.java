

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo extends HttpServlet {
		public void service(HttpServletRequest request , HttpServletResponse responce)
		{
			try 
			{
				PrintWriter pw = responce.getWriter();
				
				pw.println("<html>");
				pw.println("<head>");
				pw.println("<title>");
				pw.println("My Servlet Program 2");
				pw.println("</title>");
				pw.println("</head>");
				pw.println("<body>");
				pw.println("<h1>My Servlet Program!</h1>");
				pw.println("</body>");
				pw.println("</html>");
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
}
