package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet5
 */
@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init 메서드 호출(이 페이지가 호출되면 자동으로 실행되는 메서드)");
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");	//login5.html 에서 hidden 태그로 전송된 값을 받아온다.
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + pw);
		
		//위에서 응답받은 값을 표시하기 위한 html 코드
		String data = "<html>";
		data += "<body>";
		data += "아이디: " + id;
		data += "<br>";
		data += "비밀번호: " + pw;
		data += "<br>";
		data += "주소: " + address;
		data += "</body>";
		data += "</html>";
		out.print(data);				
	}

}
