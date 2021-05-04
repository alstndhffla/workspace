package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//�������� ���� ������ �� ǥ���ϴ� �ڵ鷯.
//@WebServlet("/login")
public class LoginTest extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		//�̺�Ʈ �ڵ鷯�� ������ �� ���ǿ� ����.
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		if(session.isNew()) {
			session.setAttribute("loginUser", "loginUser");	//���ǿ� ���ε��� LoginImpl�� valueBound()�� ȣ���մϴ�.
			
		}
		
		out.println("<head>");
		out.println("<script  type='text/javascript'>");
		out.println("setTimeout('history.go(0);', 5000)");	//�ڹٽ�ũ��Ʈ�� setTimeout()�Լ��� �̿��� 5�ʸ��� ���긴�� ���û�Ͽ� ���� �����ڼ� ǥ��
		out.println("</script>");
		out.println("</head>");
		out.println("<html><body>");

		//������ ���� �������� ǥ��
		out.println("���̵�� " + loginUser.user_id + "<br>");
		out.println("�� �����ڼ���" + LoginImpl.total_user + "<br>");
		
		out.println("</body></html>");
		
		
		
	}
}
