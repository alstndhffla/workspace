package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//첫번째 서블릿에서 전송한 데이터 중 id와 비밀번호를 갖왔으면 이미 첫번재 서블릿에ㅓ 로그인한 것이므로 고르인 상태를 유지하도록 해준다.
@WebServlet("/second")
public class SecondServlet extends HttpServlet{
	public void init() {
		System.out.println("init() calling...");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//첫번째 서블릿에서 전송한 로그인정보를 가져온다.
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		
		out.println("<html><body>");
		if(user_id != null && user_id.length() != 0) {	//첫번째 서블릿의 id 정보를 이용해 로그인 상태를 유지한다.
			out.println("이미 로그인 상태입니다!<br><br>");
			out.println("첫 번째 서블릿에서 넘겨준 아이디:" + user_id + "<br>");
			out.println("첫 번째 서블릿에서 넘겨준 비밀번호:" + user_pw +"<br>");
			out.println("첫 번째 서블릿에서 넘겨준 주소: " + user_address + "<br>");
			out.println("</body></html>");
			
		}else {	//로그인하지 않고 바로 요청했을때 보이는 페이지 브라우저에서 localhost:8090/pro09/second 를 입력하면 나옴.
			out.println("로그인하지 않았습니다.<br><br>");
			out.println("다시 로그인하세요!!<br>");
			out.println("<a href='/pro09/login.html'>로그인창으로 이동하기");
		}		
	}
	
	public void destroy() {
		System.out.println("destroy() calling...");
	}

}
