package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//해당 서블릿 작동시 웹 브라우저상에서는 url 의 변화가 보이질 않는다.
//@WebServlet("/second")
public class SecondServlet2 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws  ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();
      
      //다른 서블릿에서 전달된 데이터를 가져온다.
      String name = request.getParameter("name");
      out.println("<html><body>");
      out.println("dispatch 를 이용한 forward 실습입니다.");
      out.println("name: " + name);
      out.println("</body></html>");
   }
}
