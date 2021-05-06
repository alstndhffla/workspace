<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="addException.jsp"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int sum = 0;
	for(int i=1; i<=num; i++){
		sum = sum + i;
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>total</h1>
	<h1>1 ~ <%=num %> 까지의 합은 <%=sum %></h1>
</body>
</html>