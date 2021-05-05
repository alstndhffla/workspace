<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("name", "lee");
	application.setAttribute("address", "seoul");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>save the name, address</h1>
	<a href=appTest2.jsp>move second page</a>
</body>
</html>