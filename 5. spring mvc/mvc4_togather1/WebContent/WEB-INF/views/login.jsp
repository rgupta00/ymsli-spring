<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book app login page!</title>
<style type="text/css">
.error{
 color: red;
 font-family: sans-serif;
 font-style: italic;
}
</style>
</head>
<body>
${error }<br/>
${message }<br/>
<form:form action="login" method="post" modelAttribute="userbean">
	<table>
	<tr>
		<td>Enter email</td>
		<td><form:input path="email"/><form:errors path="email" class="error"/></td>
	</tr>
	<tr>
		<td>Enter password</td>
		<td><form:input path="password"/><form:errors path="password" class="error"/></td>
	</tr>
	<tr>
		<td><input type="submit"/></td>
	</tr>
</table>
	
</form:form>
</body>
</html>




