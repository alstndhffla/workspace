package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서로 다른 서블릿으로 데이터도 전달하는 방법.
//@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                                                                 throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();
      
      response.sendRedirect("second?name=lee");
      //get방식을 이용해 이름/값 쌍으로 데이터를 다른 서블릿으로 전달한다.
     }
}

