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
 * Servlet implementation class LoginTest
 * 로그인 접속자 수, 모든 id를 표시해 주는 기능
 */
/*@WebServlet("/login")*/
public class LoginTest extends HttpServlet {
	ServletContext context = null;
	List user_list = new ArrayList();	//로그인한 접속자 id를 저장하는 리스트

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		context = getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		//전송된 ID와 pw를 저장.
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		
		//최초 로그인시 접속자 아이디를 리스트에 차례로 저장한 후 그것을 다시 context 객체에 속성으로 저장.
		if (session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}

		out.println("<html><body>");
		out.println("아이디는 " + loginUser.user_id + "<br>");
		out.println("총 접속자수는" + LoginImpl.total_user + "<br><br>");	//세션에 바인딩 이벤트 처리 후 총 접속자 수를 표시
		out.println("접속 아이디:<br>");
		
		//context객체의 리스트를 가져와 접속자 id를 차례로 브라우저로 출력.
		List list = (ArrayList) context.getAttribute("user_list");
		for (int i = 0; i < list.size(); i++) {
			out.println(list.get(i) + "<br>");
		}
		
		//로그아웃 클릭시 서블릿 로그아웃으로 접속자 id를 전송해 로그아웃한다.
		out.println("<a href='logout?user_id=" + user_id + "'>로그아웃 </a>");
		out.println("</body></html>");
	}

}
