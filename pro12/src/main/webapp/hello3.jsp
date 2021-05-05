<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "leesoonsin";
	public String getName(){
		return name;
	}
	
%> 
<% String age = request.getParameter("age"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습</title>
</head>
<body>
	<h1>안녕하세요. <%=name %></h1>
	<h1><%=age %>살이시군요.</h1>
	<h1>height is <%=180 %>cm</h1>
	<h1>age + 10 is <%=Integer.parseInt(age)+10 %></h1>
</body>
</html>