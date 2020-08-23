

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;

public class View extends HttpServlet {
	
	String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	String user = "SYSTEM";
	String password = "SYSTEM";
	Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	int b_id = 0;
	String b_name = null;
	String a_name = null;
	Double b_price = 0.0;
	public void init()
	{
		try 
		{
			DriverManager.registerDriver(new OracleDriver());
			con = DriverManager.getConnection(url, user, password);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void service(HttpServletRequest request , HttpServletResponse responce)
	{
		try 
		{
			PrintWriter pw = responce.getWriter();
			String query  = "SELECT * FROM BOOK";
			 stmt =  con.createStatement();
			  res = 	stmt.executeQuery(query);	  
			  String html1 = "<!DOCTYPE html>"+"<head>"+" <title>View Record</title>"+"<meta charset="+"\"utf-8\""+">";
			  html1+= " <meta name="+"\"viewport\""+"content="+"\"width=device-width,initial-scale=1\""+">"+"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">";
			  html1+= "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>";
			  html1+= "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>";
			  html1+= "</head><body>"+ "<div class=\"container\">"+"<div class=\"row\">"+"<div class=\"col-sm-3\"></div>"+	"<div class=\"col-sm-6\">"+"<h2><u>Book Record Present In Database</u></h2></div>"+"<div class=\"col-sm-3\"></div></div></div>";
			  html1+=   "<div class=\"container\">"+" <table class=\"table table-striped\">"+"<thead><tr><th>Book ID</th><th>Book Name</th><th>Book Authore</th><th>Book Price</th>"+
					   "</tr></thead><tbody>";
			  
			  pw.println(html1);
			  while(res.next()==true)
			  {
				  b_id = res.getInt(1);
				  b_name = res.getString(2);
				  a_name = res.getString(3);
				  b_price = res.getDouble(4);
				  pw.print("<tr>");
				  pw.println(" <td>");
				  pw.println(b_id);
				  pw.println("</td>");
				  pw.println(" <td>");
				  pw.println(b_name);
				  pw.println("</td>");
				  pw.println("<td>");
				  pw.println(a_name);
				  pw.println("</td>");
				  pw.println("<td>");
				  pw.println(b_price);
				  pw.println("</td>");
				  pw.println("</tr>");
			  }
			  pw.println("</tbody> </table></div>");
			   
			  pw.println("<h4>Go To Home Page?<a href=\"/BookRecordManagementApplication/index.html\">Click Here</a></h4>");
			  
			  pw.println( "</body></html>");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void destroy()
	{
		try 
		{
			con.close();
			stmt.close();
			res.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
