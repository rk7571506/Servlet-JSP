<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="/MVC2/Register">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="un"></td>
			</tr>
			
			<tr>
				<td>Password:</td>
				<td><input type="password" name="pw"></td>
			</tr>
			
			<tr>
				<td>Confirm Password:</td>
				<td><input type="password" name="cpw"></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="submit"></td>
			</tr>
			
		</table>
	</form>
</body>
</html>