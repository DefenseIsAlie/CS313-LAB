<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a new Book!!!!</title>
</head>
<body>

Form to add a book.

<form action="AddServelet" method="post">
			<table style="with: 50%">
				<tr>
					<td>Book Id</td>
					<td><input type="number" name="book_id" /></td>
				</tr>
				<tr>
					<td>Title of the book</td>
					<td><input type="text" name="book_title" /></td>
				</tr>
				<tr>
					<td>Category of the book</td>
					<td><input type="text" name="book_cat" /></td>
				</tr>
					<tr>
					<td>Author of the book</td>
					<td><input type="text" name="book_auth" /></td>
				</tr>

			</table>
			<input type="submit" value="Submit" /></form>
</body>
</html>