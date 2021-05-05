<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 출력창</title>
</head>
<body>
	<h1>result</h1>
	<%
		request.setCharacterEncoding("utf-8");
	
		//getParameter 를 활용해 입력정보를 가져온다.
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
	%>
	
	<!-- 입력정보를 표현식으로 출력 -->
	<h1>id: <%=user_id %></h1>
	<h1>pw: <%=user_pw %></h1>
</body>
</html>