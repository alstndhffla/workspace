package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/first")
public class FirstServlet2 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//dispatch 방법을 이용해 second 로 데이터를 전달한다.
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatch = request.getRequestDispatcher("second?name=lee");
		dispatch.forward(request, response);
	}
}

