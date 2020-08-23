<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Statment</title>
</head>
<body>
<%
	
	out.println("Transcation Statment Account No:"+session.getAttribute("acc_no")+"<br>");
		ArrayList al = (ArrayList)session.getAttribute("al");
		out.println("toacc"+"&nbsp;"+"fromacc"+"&nbsp;"+"amount");
		out.println("<br>");
		int count = 0;
		for(int i=0;i<al.size();i++)
		{
			count++;
			out.print(al.get(i)+"&nbsp;&nbsp;&nbsp;&nbsp;");
			if(count==3)
			{
				count=0;
				out.println("<br>");
			}
		}
	
%>
<br>
<a href="/Project/home.jsp">Home</a>


</body>
</html>