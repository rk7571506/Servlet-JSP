

import java.io.IOException;
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

public class GetResult extends HttpServlet {
	
		String url = "jdbc:oracle:thin:@//localhost:1521/XE";
		String un = "SYSTEM";
		String pw = "SYSTEM";
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
				con = DriverManager.getConnection(url, un, pw);
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
				String usnvalue = request.getParameter("usn"); //IN HTML INPUT name Value. 
				
				if(usnvalue.length()!=3)
				{
					PrintWriter pw = responce.getWriter();
					pw.println("Invalid USN");
				}
				else
				{
					PrintWriter pw = responce.getWriter();
					
					String query = "SELECT * FROM STUDENT WHERE USN = ?";
					pstmt = con.prepareStatement(query);
					
					pstmt.setString(1,usnvalue);
					res = pstmt.executeQuery();
					
					while(res.next())
					{
						
							name = res.getString(1);
							usn = res.getString(2);
							mark1 = res.getInt(3);
							mark2 = res.getInt(4);
							mark3 = res.getInt(5);	
							pw.println(name+" "+usn+" "+mark1+" "+" "+mark2+" "+mark3);
					}
				}
				
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			catch(IOException f)
			{
				f.printStackTrace();
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
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

}
