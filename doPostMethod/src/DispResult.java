

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispResult extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			String username = request.getParameter("un");
			String pass = request.getParameter("pass");
			
			PrintWriter pw = response.getWriter();
			pw.println("UserName:"+username);
			pw.println("Password:"+pass);
	}

}
