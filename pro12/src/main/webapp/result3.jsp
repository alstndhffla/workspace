<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if(user_id == null || user_id.length()==0){
	%>
		enter the id<br>
		<a href="/pro12/login.html">back to the login</a>
	<%
	}else{
		if(user_id.equals("admin")){
	%>	
		<!-- id가 admin이면 관리자창을 나타낸다. -->
		<h1>관리자로 로그인하셨습니다.</h1>
		<form action="">
			<input type=button value="modify member">
			<input type=button value="delete member">
		</form>
	<%
		}else{
	%>
			<h1>welcome</h1>
	<%	
		}
	}
	%>
</body>
</html>