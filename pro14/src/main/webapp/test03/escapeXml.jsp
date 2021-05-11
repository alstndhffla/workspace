<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.io.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html >
<html>
<head>
<meta charset=”UTF-8">
<title>escapeXml 실습하기</title>
</head>
<body>
<h2>escapeXml 변환하기</h2>
<h2>
<pre>
  <c:out  value="&lt;" escapeXml="true" />	<!-- true이므로 value의 값이 그대로 화면에 출력됩니다. -->
  <c:out  value="&lt;" escapeXml="false" />	<!-- false이므로 value의 값에 해당하는 특수문자로 변환되어 화면에 출력. -->
 
  <c:out  value="&gt;" escapeXml="true" />
  <c:out  value="&gt;" escapeXml="false" />
 
  <c:out  value="&amp;" escapeXml="true" />
  <c:out  value="&amp;" escapeXml="false" />

<c:out  value="&#039;" escapeXml="true" />
  <c:out  value="&#039;" escapeXml="false" />
 
  <c:out  value="&#034;" escapeXml="true" />
  <c:out  value="&#034;" escapeXml="false" />
</pre>
</h2>
</body>
</html>
