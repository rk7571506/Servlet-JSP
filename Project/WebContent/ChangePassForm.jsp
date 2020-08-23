<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>
	<form action="/Project/ChangePwd">	
		<table>
			<tr>
				<td><label>New Password:</label></td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td><label>Confirm Password:</label></td>
				<td><input type="password" name="cpass"></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="submit"></td>
			</tr>
			
		</table>
	</form>
</body>
</html>