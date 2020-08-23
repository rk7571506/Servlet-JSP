

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;


public class GetResult extends HttpServlet
{
			String url = "jdbc:oracle:thin:@//localhost:1521/XE";
			String user = "SYSTEM";
			String password = "SYSTEM";
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet res = null;
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
			
			public void service(HttpServletRequest request, HttpServletResponse responce)
			{
				try
				{
					PrintWriter pw = responce.getWriter();
					String usn = request.getParameter("usn");
					String query = "SELECT * FROM STUDENT WHERE USN = ?";
					 pstmt = con.prepareStatement(query);
					 pstmt.setString(1, usn);
					 res = pstmt.executeQuery();
					 
					 while(res.next()==true)
					 {
						 String a = res.getString(1);
						 String b = res.getString(2);
						 int c = res.getInt(3);
						 int  d = res.getInt(4);
						 int e = res.getInt(5);
						 
						 pw.println(a+" "+b+" "+c+" "+d+" "+e);
						 
						 Integer i1 = new Integer(c);
						 Integer i2 = new Integer(d);
						 Integer i3 = new Integer(e);
						 
						 String s1 = i1.toString();
						 String s2 = i2.toString();
						 String s3 = i3.toString();
						 
						 Cookie ck1 = new Cookie("mark1", s1);
						 Cookie ck2 = new Cookie("mark2", s2);
						 Cookie ck3 = new Cookie("mark3", s3);
						 
						 ck1.setMaxAge(1*24*60*60);
						 ck2.setMaxAge(1*24*60*60);
						 ck3.setMaxAge(1*24*60*60);
						 
						 responce.addCookie(ck1);
						 responce.addCookie(ck2);
						 responce.addCookie(ck3);
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
