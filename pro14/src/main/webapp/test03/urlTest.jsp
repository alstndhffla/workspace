<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.util.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<c:url var="url1"  value="/test01/member1.jsp"  >	<!-- 이동할 페이지 설정 -->
  <!-- 이동할 페이지로 전달할 데이터 설정 -->
  <c:param  name="id" value="hong" />
  <c:param  name="pwd" value="1234" />
  <c:param  name="name" value="홍길동" />
  <c:param  name="email" value="hong@test.com" />
</c:url>
<html>
<head>
<meta charset=”UTF-8">
<title> c:url  태그 실습</title>
</head>
<body>
  <%-- <a href='${contextPath }/test01/member1.jsp'>회원정보출력</a> --%>
<a href='${url1}'>회원정보출력</a>	<!-- 태그의 변수 이름을 '${url1}' 간단하게 설정. -->
</body>
</html>
