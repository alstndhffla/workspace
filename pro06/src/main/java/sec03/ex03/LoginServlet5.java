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
		System.out.println("init �޼��� ȣ��(�� �������� ȣ��Ǹ� �ڵ����� ����Ǵ� �޼���)");
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
		String address = request.getParameter("user_address");	//login5.html ���� hidden �±׷� ���۵� ���� �޾ƿ´�.
		System.out.println("���̵�: " + id);
		System.out.println("��й�ȣ: " + pw);
		
		//������ ������� ���� ǥ���ϱ� ���� html �ڵ�
		String data = "<html>";
		data += "<body>";
		data += "���̵�: " + id;
		data += "<br>";
		data += "��й�ȣ: " + pw;
		data += "<br>";
		data += "�ּ�: " + address;
		data += "</body>";
		data += "</html>";
		out.print(data);				
	}

}
