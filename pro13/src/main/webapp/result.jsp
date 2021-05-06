<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   request.setCharacterEncoding("utf-8");
%> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>결과창</title>
</head>
<body>
<%
   String userID = request.getParameter("userID" );
   if(userID.length()==0){
    /*
      RequestDispatcher를 사용해 포워딩 하지 않아도 된다.ㄴ
      RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");  
      dispatch.forward(request, response);
    */
%>
   <!-- id를 입력하지 않았으면 다시 로그인창으로 포워딩한다. -->
   <jsp:forward  page="login.jsp" />
<%	
  }
%>
	<!-- id를 입력했으므로 브라우저에 출력. -->
  <h1>환영합니다   <%= userID %>님!! </h1>
</body>
</html>
