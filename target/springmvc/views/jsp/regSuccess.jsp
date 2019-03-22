<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regSuccess</title>
</head>
<body>
	<table>
		<tr>
			<td>Hi ${firstname}... your registration is successfull.</td>
		</tr>
		<tr>
			<td>email : ${email}</td>
		</tr>
		<tr>
			<td>Password : ${password}</td>
		</tr>
		<tr>
			<td><a href="login">Login</a></td>
		</tr>
	</table>
</body>
</html>