package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/input")
public class InputServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init method calling...");
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");	//한개씩 전송된 값은 getParameter
		String user_pw = request.getParameter("user_pw");
		System.out.println("아이디: "+user_id);
		System.out.println("비밀번호: "+user_pw);
		String[] subject = request.getParameterValues("subject");	//하나의 subject 네임으로 여러 값을 전송하는 경우 getParameterValues를 이용해 배열 형태로 반환.
		//subject 배열을 String형태의 str로 하나씩 대입해 선택된 것들을 출력
		for(String str : subject) {
			System.out.println("선택한 과목:"+str);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
