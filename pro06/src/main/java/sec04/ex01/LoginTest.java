package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginTest
 */
//@WebServlet("/loginTest")
public class LoginTest extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init 메서드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy method calling...");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");	//요청할 자료는 utf-8 로 인코딩할거란 코드
		response.setContentType("text/html; charset=utf-8");	//내보낼 자료 인코딩 정보
		PrintWriter out = response.getWriter();	//HTML로 응답을 보내기 때문에 해당 객체를 선언(출력 스트림을 얻는다)
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println("아이디: "+ id);
		System.out.println("비밀번호: "+ pw);
		
		if(id != null && (id.length() != 0)) {
			out.print("<html>");
			out.print("<body>");
			out.print(id + " 님! 로그인을 환영합니다.");
			out.print("</body>");
			out.print("</html>");
			
		}else {
			out.print("<html>");
			out.print("<body>");
			out.print("id 를 입력하세요.");
			out.print("<a href='http://localhost:8090/pro06/test01/login.html'>로그인 창으로 이동</a>");
			out.print("</body>");
			out.print("</html>");
		}
	}

}
