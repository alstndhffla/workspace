package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws  ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String address = (String)request.getAttribute("address");	//전달된 request에서 getAtribute()를 이용해 address의 값을 가져온다.
		out.println("<html><body>");
		out.println("address: "+address);
		out.println("</body></html>");
		//실행시키면 브라우저에서 address 값이 null 나온다. 
		//redirect 를 이용한 경우 브라우저에서 요청한 첫번째 것과 다시 서블릿으로부터 응답받아 다른 서블릿에 요청하는 두번째 것이 다르기 때문이다.
		//get 방식으로 하면 해결되긴 한데, 데이터의 양이 많아지면 문제가 생긴다. -> dispatch 를 사용해 전반적인 문제를 해결한다.
   }
}
