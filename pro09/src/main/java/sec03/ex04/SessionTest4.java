package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//login with using session
//@WebServlet("/login")
public class SessionTest4 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		dohandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		dohandle(request, response);
	}
	
	private void dohandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		//get information from login2.html
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// 로그인창에서 서블릿으로 요청했다면 id 가 null이 아니므로 세션에 아이디를 바인딩한다.
		if(session.isNew()) {	//determine whether session is the first time or not
			if(user_id != null) {
				session.setAttribute("user_id", user_id);
				out.println("<a href ='login'>check login status</a>");
			}else {
				out.print("<a href='login2.html'>do login!!</a>");
				session.invalidate();	//세션정보 삭제
			}
		}else {
			user_id = (String)session.getAttribute("user_id");
			if(user_id != null && user_id.length() != 0) {
				out.print("안녕하세요" + user_id);
				
			}else {
				out.print("<a href = 'login2.html'>다시 로그인하세요.</a>");
				session.invalidate();
			}
		}
	}
	
}
