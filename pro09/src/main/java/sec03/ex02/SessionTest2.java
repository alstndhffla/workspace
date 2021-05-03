package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/sess2")
public class SessionTest2 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();	//create session or return session you have
		out.println("session id: " + session.getId()+"<br>"); //get session id you create
		out.println("initial session creation time: "+new Date(session.getCreationTime())+"<br>");
		out.println("last accessed time: "+new Date(session.getLastAccessedTime())+"<br>");
		
		out.println("basic session valid time: "+ session.getMaxInactiveInterval()+"<br>"	);
		session.setMaxInactiveInterval(5);	//reset session valid time 5s
		out.println("confirm changed session valid time : "+ session.getMaxInactiveInterval()+"<br>");		
		
		if(session.isNew()) {
			out.print("새 세션이 만들어졌습니다.");
			//톰캣에서 설정한 기본 유효시간은 30분이다.
		}
	}
}
