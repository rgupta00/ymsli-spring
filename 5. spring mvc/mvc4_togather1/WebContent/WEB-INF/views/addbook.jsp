<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AddBook page</title>
<style type="text/css">
	.error{
		color: red;
		font-family: serif;
		font-style: italic;
	}
</style>
</head>
<body>
<form:form action="addbook" method="post" modelAttribute="book">
	<form:hidden path="id"/>
	Enter isbn: <form:input path="isbn"/><form:errors path="isbn" class="error"/><br/>
	Enter title: <form:input path="title"/><form:errors path="title" class="error"/><br/>
	Enter author: <form:input path="author"/><form:errors path="author" class="error"/><br/>
	Enter price: <form:input path="price"/><form:errors path="price" class="error"/><br/>
	Enter pub email: <form:input path="pubEmail"/><form:errors path="pubEmail" class="error"/><br/>
	Enter pub name: <form:select path="publisher" items="${pubList }"/><br/>
	Enter pub date: <form:input path="pubDate"/><form:errors path="pubDate" class="error"/><br/>
	<input type="submit"/>
</form:form>
</body>
</html>




