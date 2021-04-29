package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	protected void doGet(HttpServletRequest reqeust, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("sendRedirect를 이용한 redirect 실습");	//브라우저에 출력.
		out.print("</html></body>");
		
		
	}

}
