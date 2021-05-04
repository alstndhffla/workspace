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
 * �α��� ������ ��, ��� id�� ǥ���� �ִ� ���
 */
/*@WebServlet("/login")*/
public class LoginTest extends HttpServlet {
	ServletContext context = null;
	List user_list = new ArrayList();	//�α����� ������ id�� �����ϴ� ����Ʈ

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
		
		//���۵� ID�� pw�� ����.
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		
		//���� �α��ν� ������ ���̵� ����Ʈ�� ���ʷ� ������ �� �װ��� �ٽ� context ��ü�� �Ӽ����� ����.
		if (session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}

		out.println("<html><body>");
		out.println("���̵�� " + loginUser.user_id + "<br>");
		out.println("�� �����ڼ���" + LoginImpl.total_user + "<br><br>");	//���ǿ� ���ε� �̺�Ʈ ó�� �� �� ������ ���� ǥ��
		out.println("���� ���̵�:<br>");
		
		//context��ü�� ����Ʈ�� ������ ������ id�� ���ʷ� �������� ���.
		List list = (ArrayList) context.getAttribute("user_list");
		for (int i = 0; i < list.size(); i++) {
			out.println(list.get(i) + "<br>");
		}
		
		//�α׾ƿ� Ŭ���� ���� �α׾ƿ����� ������ id�� ������ �α׾ƿ��Ѵ�.
		out.println("<a href='logout?user_id=" + user_id + "'>�α׾ƿ� </a>");
		out.println("</body></html>");
	}

}
