<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>forgot password</title>
</head>
<body>
<form:form id="forgotform" modelAttribute="forgotpassword" action="forgotprocess"
		method="post">
 <tr>
  <td><form:label path="forgotpassword">forgotpassword</form:label></td>
  <td><form:input path="forgotpassword" name="forgotpassword" id="forgotpassword"/></td>
</tr>
  <input type="submit" value="Submit">
</form:form>	
</body>
</html>