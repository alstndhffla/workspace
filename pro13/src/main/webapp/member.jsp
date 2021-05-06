<%@ page language="java"   contentType="text/html; charset=UTF-8"
     import="java.util.*,sec01.ex01.*" 
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("UTF-8");	//한글 인코딩 설정
%> 

<%
	//전송된 회원 정보를 가졍ㄴ다.
   String   id=request.getParameter("id");
   String  pwd = request.getParameter("pwd");
   String  name = request.getParameter("name");
   String  email = request.getParameter("email");
 
  //멤버빈 객체 생성 후 회원 정보를 속성에 설정.
   MemberBean  m =  new MemberBean(id, pwd, name, email);
   MemberDAO  memberDAO=new MemberDAO();
   
   //회원정보를 테이블에 추가
   memberDAO.addMember(m);
   
  //전체 회원정보 조회
   List membersList = memberDAO.listMembers();	
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 목록창</title>
</head>
<body>
  <table align="center"  width="100%">
	 <tr align="center" bgcolor="#99ccff">
	      <td width="7%" >아이디</td>
	      <td width="7%">비밀번호</td>
	      <td width="5%" >이름</td>
	      <td width="11%" >이메일</td>
	      <td width="5%" >가입일</td>
	   </tr>
	<%
	   if(membersList.size()==0){	//리스트 안에 값이 없다면
	%>
	  <tr>
	      <td colspan="5">
	        <p align="center"><b><span style="font-size:9pt;">
	                      등록된 회원이  없습니다.</span></b></p>
	      </td>
	  </tr>
	<%
	}else{	//그게 아니라면 반복문을 통해 리스트 출력.
	   for( int i = 0; i < membersList.size(); i++ ) {
	      MemberBean bean = (MemberBean) membersList.get(i);
	      //멤버빈 객체를 한개씩 가져온 후 각 속성의 회원정보를 다시 getter를 이용해 출력.
	%>
	   <tr align="center">
	       <td><%=bean.getId() %></td>
	       <td><%=bean.getPwd() %></td>
	       <td><%=bean.getName() %></td>
	       <td><%=bean.getEmail() %></td>
	       <td><%=bean.getJoinDate() %></td>
	   </tr>
	<%
	      } // end for
	
	   } // end if
	%>
	   <tr height="1" bgcolor="#99ccff">
	      <td colspan="5"></td>
	   </tr>
	</table>
</body>
</html>
