<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>
	<h1>Customer ID and  Password Not Be Blank.Try Again</h1>
	<form action="/Project/Login">
		<table>
			<tr>
				<td><label>Customer ID:</label></td>
				<td><input type="text" name="cid"></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
			<td><input type="submit" name="submit" ></td>
			</tr>
		
		</table>
	</form>
	
</body>
</html>