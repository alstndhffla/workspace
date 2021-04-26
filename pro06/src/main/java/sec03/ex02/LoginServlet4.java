package sec03.ex02;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet4
 * login4.html 이 get 방식으로 데이터를 줘서 doGet메서드를 타게 된다.
 * 이후 해당 메서드 안에 잇는 doHandle 메서드를 호출하기 때문에 
 */
@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {
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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet메서드 호출");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		dohandle(request, response);	//get으로 호출 시 doHandle로 호출합니다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost메서드 호출");
		dohandle(request, response);	//post 호출시 doHandle로 호출합니다.
	}
	
	//GET/POST 같은 모든 호출방식에 대해 처리할 수 있는 doHandle메서드
	private void dohandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//html 태그를 사용하지 않았기 때문에 브라우저상에 표현되지 않음. 대신 get방식이라 url에 노출됨.
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		System.out.println("doHandle메서드 호출");
		String user_pw = request.getParameter("user_pw");
		System.out.println("아이디: " + user_id);
		System.out.println("비밀번호: " + user_pw);
	}

}
