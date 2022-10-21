<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Issue a new book!!!!

<form action="IssueServelet" method="post">
			<table style="with: 50%">
				<tr>
					<td>Student Id</td>
					<td><input type="number" name="s_id" /></td>
				</tr>
				<tr>
					<td>Book Id</td>
					<td><input type="number" name="book_id" /></td>
				</tr>
				<tr>
					<td>Issue Date</td>
					<td><input type="date" name="issue_dt" /></td>
				</tr>
					<tr>
					<td>Return Date</td>
					<td><input type="date" name="ret_dt" /></td>
				</tr>

			</table>
			<input type="submit" value="Submit" /></form>

</body>
</html>