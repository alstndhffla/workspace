<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 첫번째 jsp에서 포워딩된 request객체에서 정보를 가져온다. -->
<%
	String name = (String)request.getAttribute("name");
	String address = (String)request.getAttribute("address");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>name is <%=name %></h1>
	<h1>address is <%=address %></h1>
</body>
</html>