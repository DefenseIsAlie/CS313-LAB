<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to simple Application!!!!!</h1>

Login with your UserName and Password!
<form action="LoginServelet" method="post">
			<table style="with: 50%">
				<tr>
					<td>User Id</td>
					<td><input type="text" name="u_id" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" /></form>

</body>
</html>