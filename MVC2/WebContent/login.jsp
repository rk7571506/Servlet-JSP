<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn</title>
</head>
<body>
	<form action="/MVC2/Login">
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="uname"></td>
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><input type="password" name="pw"></td>
			</tr>
			
			<tr>
				<td ><input type="submit" name="login"></td>
			</tr>
			
		</table>
	</form>
</body>
</html>