<%@page import="sec02.ex01.MemberDAO"%>
<%@page import="sec02.ex01.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="sec02.ex01.*"
    %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	h1 {
		text-align: center;
	}
</style>
<meta charset="UTF-8">
<title>회원정보출력</title>
</head>
<body>
	<h1>회원정보출력</h1>
	
	<%
		request.setCharacterEncoding("utf-8");
		String _name = request.getParameter("name");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setName(_name);
		
		MemberDAO dao = new MemberDAO();
		List membersList = dao.listMembers(memberVO);
		
	%>	
	
	<table border=1 width=800 align=center>
		<tr align=center bgcolor="#FFFF66">
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>이메일</td>
			<td>가입일자</td>		
		</tr>
	
	<%
		for(int i=0; i<membersList.size(); i++){
			MemberVO vo = (MemberVO) membersList.get(i);
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			Date joinDate = vo.getJoinDate();
	%>
	
		<tr align=center>
			<td><%=id %></td>
			<td><%=pwd %></td>
			<td><%=name %></td>
			<td><%=email %></td>
			<td><%=joinDate %></td>	
		</tr>
	<%		
		}
	%>
	</table>
</body>
</html>