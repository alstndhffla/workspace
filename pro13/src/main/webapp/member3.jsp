<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, sec01.ex01.*"
    %>
    
<%
	request.setCharacterEncoding("utf-8");
	%>
		<!-- 유즈빈 액션태그를 이용해 유즈빈을 만든다. -->
	    <jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page"></jsp:useBean>
	    
	    <!-- 회원가입창에서 전송된, 동일한 이름의 매개변수에 해당되는 유즈빈 속성에 전송된 값을 설정한다. -->
	    <jsp:setProperty property="id" name="m" value='<%=request.getParameter("id") %>'/>
	    <jsp:setProperty property="pwd" name="m" value='<%=request.getParameter("pwd") %>'/>
	    <jsp:setProperty property="email" name="m" value='<%=request.getParameter("email") %>'/>
	    <jsp:setProperty property="name" name="m" value='<%=request.getParameter("name") %>'/>
	    
<%
MemberDAO memberDAO = new MemberDAO();
memberDAO.addMember(m);
List memberList = memberDAO.listMembers();
%>	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록창</title>
</head>
<body>
<table align="center"  width="100%">
	 <tr align="center" bgcolor="#99ccff">
	      <td width="7%" >아이디</td>
	      <td width="7%">비밀번호</td>
	      <td width="5%" >이름</td>
	      <td width="11%" >이메일</td>
	   </tr>
	   <tr align="center">
	  <td> <jsp:getProperty name="m"  property="id"  /> </td>
          <td> <jsp:getProperty name="m"  property="pwd"  />  </td>
          <td> <jsp:getProperty name="m"  property="name"     /> </td>
          <td> <jsp:getProperty name="m"  property="email"  /> </td>
	   </tr>
	   <tr height="1" bgcolor="#99ccff">
	      <td colspan="5"></td>
	   </tr>
	</table>
</body>
</html>