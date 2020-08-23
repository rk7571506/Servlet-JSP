<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.io.*" %>
<%@page import="java.sql.*" %>
<%@page import="javax.servlet.*" %>
<%@page import="oracle.jdbc.driver.OracleDriver" %>
<%@page import="javax.servlet.http.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%! 
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
		%>
		
		<%!
					public void jspInit()
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
		%>
		
		<%!
					public void jspDestroy()
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
		
		%>
		
		<%
						try
						{
								String usnvalue = request.getParameter("usn"); //IN HTML INPUT name Value. 
								
								if(usnvalue.length()!=3)
								{
									
									out.println("Invalid USN");
								}
								else
								{
									
									int flag = 0;
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
											flag  = 1;
									}
									
									if(flag==1)
										out.println(name+" "+usn+" "+mark1+" "+" "+mark2+" "+mark3);
									else
										out.println("Invalid USN:Not Match");
								}
							
						} 
						catch (IOException e)
						{
							e.printStackTrace();
						}
		%>
</body>
</html>