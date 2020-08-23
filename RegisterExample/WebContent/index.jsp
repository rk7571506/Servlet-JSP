<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
		<form action="/RegisterExample/Register">
			<table>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name"></td>
				</tr>				
				
				<tr>
					<td>Gender:</td>
					<td><input type="radio" name="gender" value="male">Male.&nbsp; 
					<input type="radio" name="gender" value="female">Female.
					</td>
				</tr>
				
				<tr>
					<td>CheckBox:</td>
					<td>
						<input type="checkbox" name="checkbox" value="c">C &nbsp;
						<input type="checkbox" name="checkbox" value="c++">C++ &nbsp;
						<input type="checkbox" name="checkbox" value="JAVA">JAVA
					</td>
				</tr>
								
				<tr>
					<td>Textarea:</td>
					<td><textarea type="feedback" rows="5" cols="30" name="feedback"></textarea></td>
				</tr>
				
				<tr>
					<td>Select Any One:</td>
					<td>
						<select name="select">
							<option value="select">Select</optipon>
							<option value="cse">Computer Science & Enginerring</option>
							<option value="ce">Civil Enginerring</option>
							<option value="ee">Electrical Engineering</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td><input type="submit" name="submit"></td>
				</tr>
								
			</table>
		</form>
</body>
</html>