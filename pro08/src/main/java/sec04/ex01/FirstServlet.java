package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//웹 브라우저에서의 요청(request) 객체에 address 값으로 "서울시 성북구"를 바인딩한다.
		request.setAttribute("address", "서울시 성북구");
		response.sendRedirect("second");
		//두번째 서블릿으로 전달하기 위해 sendRedirect호출.
	}
}

