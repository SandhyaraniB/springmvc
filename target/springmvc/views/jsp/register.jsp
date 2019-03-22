<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
     <h2 align="center">Register</h2>
	<form:form id="regForm" modelAttribute="user" action="registerProcess"
		method="post">
		<table align="center">

			<tr>
				<td><form:label path="firstName">FirstName</form:label></td>
				<td><form:input path="firstName" name="firstName"
						id="firstName" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">LastName</form:label></td>
				<td><form:input path="lastName" name="lastName" id="lastName" />
				</td>
			</tr>
			<tr>
				<td><form:label path="phoneNumber">PhoneNumber</form:label></td>
				<td><form:input path="phoneNumber" name="phoneNumber"
						id="phoneNumber" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><form:label path="userName">UserName</form:label></td>
				<td><form:input path="userName" name="userName" id="userName" />
				</td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" name="password"
						id="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="register" name="register">Register</form:button>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="index.jsp">Home</a></td>
			</tr>
		</table>
	</form:form>
	
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table>
</body>

</html>