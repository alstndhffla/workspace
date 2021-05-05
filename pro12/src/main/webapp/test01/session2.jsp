<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- getattribute 를 이용해 서블릿과 jsp 에서 session에 바인딩된 name과 address 값을 가져온다. -->   
<%
	String name = (String)session.getAttribute("name");
	String address = (String)session.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	name is <%=name %><br>
	address is <%=address %><br>
</body>
</html>