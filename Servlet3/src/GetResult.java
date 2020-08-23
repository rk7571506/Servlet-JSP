

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import oracle.jdbc.driver.OracleDriver;

public class GetResult extends HttpServlet {
	
	String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	String user = "SYSTEM";
	String password = "SYSTEM";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	String name = null;
	String usn = null;
	int mark1 = 0;
	int mark2 = 0;
	int mark3 = 0;
	
	public void init()
	{
			try
			{
				DriverManager.registerDriver(new OracleDriver());
				 con = DriverManager.getConnection(url, user, password);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	public void service(HttpServletRequest request , HttpServletResponse response)
	{
		try
		{
			String usnvalue = request.getParameter("usn");
			PrintWriter pw = response.getWriter();
			if(usnvalue.length()!=3)
			{
				response.sendRedirect("/Servlet3/error.html");
			}
			else
			{
					int flag = 0;
					String s = "SELECT * FROM STUDENT WHERE USN=?";
					pstmt =  con.prepareStatement(s);
					pstmt.setString(1, usnvalue);
					res = pstmt.executeQuery();
					
					while(res.next())
					{
							name = res.getString(1);
							usn = res.getString(2);
							mark1 = res.getInt(3);
							mark2 = res.getInt(4);
							mark3 = res.getInt(5);
							flag = 1;
					}
					
					if(flag==1)
						pw.print(name+" "+usn+" "+mark1+" "+mark2+" "+mark3);
					else
						response.sendRedirect("/Servlet3/error.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void destroy()
	{
		try
		{
			con.close();
			pstmt.close();
			res.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
