<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transfer Money</title>
</head>
<body>
	<form action="/Project/Transfer">
		<table>
			<tr>
				<td><label>To Account:</label></td>
				<td><input type="text" name="toaccno"></td>
			</tr>
			
			<tr>
				<td><label>Amount:</label></td>
				<td><input type="text" name="tamt"></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="transfer" value="Transfer"></td>
			</tr>
		</table>		
	</form>
</body>
</html>