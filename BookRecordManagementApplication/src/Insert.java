

import java.sql.Statement;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleDriver;

public class Insert extends HttpServlet 
{
	
	String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	String user = "SYSTEM";
	String password = "SYSTEM";
	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet res = null;
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
				String b_id = request.getParameter("bid");
				String b_name = request.getParameter("bname");
				String b_authore = request.getParameter("aname");
				String b_price = request.getParameter("bprice");
				String query  = "INSERT INTO BOOK(B_ID,B_NAME, B_AUTHORE,B_PRICE) VALUES(?,?,?,?)";
				String query1 = "SELECT B_ID FROM BOOK";
				stmt = con.createStatement();
				res = stmt.executeQuery(query1);
				int flag = 0;
				
				while(res.next()==true)
				{
					String id = res.getString(1);
					
					if(id.equals(b_id))
					{
							flag = 1;
							break;
					}
				}
				
				if(flag==0)
				{
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, b_id);
					pstmt.setString(2, b_name);
					pstmt.setString(3, b_authore);
					pstmt.setString(4, b_price);
					
					int insert_result = pstmt.executeUpdate();
					
					if(insert_result==1)
					{
						pw.println("<h4>Insertion Successful.</h4>");
						pw.println("<h4>Insert A New Record?<a href=\"/BookRecordManagementApplication/insert.html\">Click Here</a></h4>");
						pw.println("<h4>Go To Home Page?<a href=\"/BookRecordManagementApplication/index.html\">Click Here</a></h4>");
					}
					else
					{
						pw.println("Insertion Failed.");
						pw.println("<h4>Go To Home Page<a href=\"/BookRecordManagementApplication/index.html\">Click Here</a></h4>");
					}
				}
				else
				{
					pw.println("<h4>Book Id Is NOT Valid,Try Again?<a href=\"/BookRecordManagementApplication/insert.html\">Click Here</a></h4>");
				}
				
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
			pstmt.close();
			stmt.close();
			res.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
