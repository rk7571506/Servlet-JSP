<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Balance</title>
</head>
<body>
	<%
			int bal = (Integer)session.getAttribute("bal");
			out.println("Current Account Balance Is : "+bal);
	%>
	<br>
	<a href="/Project/home.jsp"type="button" value="Home">Home</a>
</body>
</html>