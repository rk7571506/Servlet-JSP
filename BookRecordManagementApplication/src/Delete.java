
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;

public class Delete extends HttpServlet {
	
	String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	String user = "SYSTEM";
	String password = "SYSTEM";
	Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	PreparedStatement pstmt = null;
	String b_id = null;
	String b_name = null;
	String a_name = null;
	String b_price = null;
	String bookname = null;
	String bookauthore = null;
	String bookprice = null;
	String bookid = null;
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
			  String html1 = "<!DOCTYPE html>"+"<head>"+" <title>Delete Record</title>"+"<meta charset="+"\"utf-8\""+">";
			  html1+= " <meta name="+"\"viewport\""+"content="+"\"width=device-width,initial-scale=1\""+">"+"<link rel=\"stylesheet\" "
			  					+ "href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">";
			  html1+= "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>";
			  html1+= "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>";
			  html1+= "</head><body>"+ "<div class=\"container-fluid\">"+"<div class=\"row\">"+"<div class=\"col-sm-3\"></div>"+	"<div class=\""
			  				 + "col-sm-6\">"+"<h2><u>Delete Book Record Present In Database</u></h2></div>"+"<div class=\"col-sm-3\"></div>"
			  						+ "</div></div>";
			  html1+=   "<div class=\"container\">"+" <table class=\"table table-striped\">"+"<thead><tr><th>Book ID</th><th>"
			  					+ "Book Name</th><th>Book Authore</th><th>Book Price</th>"+
					   "</tr></thead><tbody>";
			  
			  pw.println(html1);
			  while(res.next()==true)
			  {
				  b_id = res.getString(1);
				  b_name = res.getString(2);
				  a_name = res.getString(3);
				  b_price = res.getString(4);
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
			  pw.println("</tbody> </table></div><br><br><br>");
			  
			  
			  String html2 = "<div class=\"container\"><div class=\"row\"><div class=\"col-sm-3\"></div>"
			  						+ "<div class=\"col-sm-6\"><h2><u>Fill The Book ID For Delete A Record.</u></h2>"
			  						+ "</div><div class=\"col-sm-3\"></div></div>";
			  
			  
			  String html3 = "<div class=\"container\">"
					  				+"<div class=\"row\">"
					  				+"<div class=\"col-sm-3\"></div>"	
					  				+"<div class=\"col-sm-6\">"
					  				+"<form class=\"form-horizontal\" action=\"/BookRecordManagementApplication/Delete\">"
					  				+"<div class=\"form-group\">"
					  				+"<label for=\"bookid\">Book ID:</label>"
					  				+"<input type=\"text\" class=\"form-control\" id=\"bid\" name=\"bid\"></div>"
					  				+"<input type=\"submit\" name = \"submit\" class=\"btn btn-warning\">"
					  				+"&nbsp; &nbsp; &nbsp;"
					  				+"<input type=\"reset\" class=\"btn btn-success\"></form>	</div><div class=\"col-sm-3\"></div>	</div></div>";
			  pw.println(html2);
			  pw.println(html3);
			  if(request.getParameter("submit")!=null)
			  {
				  
				  String updatequery = "DELETE FROM BOOK WHERE B_ID=?";
				  pstmt = con.prepareStatement(updatequery);
				  bookid = request.getParameter("bid");
				  pstmt.setString(1,bookid);
				  int delete_result = pstmt.executeUpdate();
				  if(delete_result == 1)
				  {
						  pw.println("<h4>Record Deletion Successfully<h4>");
								  
				  }
				else
			    {
			 		pw.println("<h4>Record Deletion Failed.</h4>");
			    }
			}	  
			 pw.println("<h4>Go To Home Page?<a href=\"/BookRecordManagementApplication/index.html\">Click Here</a></h4>");
			 pw.println("</body></html>");
			  
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
