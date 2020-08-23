<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Print Result</title>
</head>
<body>
		
		<div style="background-color:red;">
		<h1 style="color:gold;">Your Result: is:</h1>
		<%
			String name = (String)session.getAttribute("name");
			String usn = (String)session.getAttribute("usn");
			int m1 = (Integer)session.getAttribute("m1");
			int m2 = (Integer)session.getAttribute("m2");
			int m3 = (Integer)session.getAttribute("m3");
	
			out.println(name+" "+usn+" "+m1+" "+m2+" "+m3);
		%>
		</div>
</body>
</html>