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
 * login4.html �� get ������� �����͸� �༭ doGet�޼��带 Ÿ�� �ȴ�.
 * ���� �ش� �޼��� �ȿ� �մ� doHandle �޼��带 ȣ���ϱ� ������ 
 */
@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init �޼��� ȣ��");
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
		System.out.println("doGet�޼��� ȣ��");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		dohandle(request, response);	//get���� ȣ�� �� doHandle�� ȣ���մϴ�.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost�޼��� ȣ��");
		dohandle(request, response);	//post ȣ��� doHandle�� ȣ���մϴ�.
	}
	
	//GET/POST ���� ��� ȣ���Ŀ� ���� ó���� �� �ִ� doHandle�޼���
	private void dohandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//html �±׸� ������� �ʾұ� ������ �������� ǥ������ ����. ��� get����̶� url�� �����.
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		System.out.println("doHandle�޼��� ȣ��");
		String user_pw = request.getParameter("user_pw");
		System.out.println("���̵�: " + user_id);
		System.out.println("��й�ȣ: " + user_pw);
	}

}
