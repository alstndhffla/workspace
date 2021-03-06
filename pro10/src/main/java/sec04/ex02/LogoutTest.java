package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutTest
 * 로그아웃 링크 클릭시 접속자 1감소, uesr_list에서 로그아웃한 접속자 id 삭제 후 다시 바인딩.
 */
/*@WebServlet("/logout")*/
public class LogoutTest extends HttpServlet {
	ServletContext context;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		context = getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//삭제할 유저 아이디를 가져온다.
		String user_id = request.getParameter("user_id");
		
		//로그아웃시 세션을 소멸.
		session.invalidate();
		
		//로그아웃한 접속자 id를 삭제한 후 다시 user_list를 컨텍스트 객체에 저장.
		List user_list = (ArrayList) context.getAttribute("user_list");
		user_list.remove(user_id);
		context.removeAttribute("user_list");
		context.setAttribute("user_list", user_list);
		out.println("<br>로그아웃 했습니다.");
	}

}
