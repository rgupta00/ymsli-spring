<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new book</title>
</head>
<body>
<form:form action="addbook" method="post" modelAttribute="book">
	<form:hidden path="id"/>
	Enter isbn : <form:input path="isbn" readonly="true"/> <br>
	Enter title : <form:input path="title" readonly="true"/> <br>
	Enter author : <form:input path="author" readonly="true"/> <br>
	Enter pub Date : <form:input path="pubDate" readonly="true"/> <br>
	Enter price : <form:input path="price"/> <br>
	<input type="submit">
</form:form>
</body>
</html>