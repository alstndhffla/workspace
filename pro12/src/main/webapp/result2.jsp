<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- id가 정상적으로 입력되었는지 체크한 후 정상 입력 여부에 따라 동적으로 다른 결과를 출력하도록 구현. -->
<%
	request.setCharacterEncoding("utf-8");
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result</title>
</head>
<body>
	<%
	if(user_id==null || user_id.length()==0){
	%>
		enter the id.<br>
		<a href="/pro12/login.html">back to the login</a>
	<%
	}else{
	%>
		<h1>welcome</h1>
	<%
	}	
	%>
</body>
</html>