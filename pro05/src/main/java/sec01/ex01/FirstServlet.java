package sec01.ex01;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet�� ��ӹ޴´�.
public class FirstServlet extends HttpServlet {
	@Override
	public void init() throws ServletException{
		System.out.println("init �޼��� ȣ��");
		
	}
	
	//�������� ��ûó��
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		System.out.println("doGet �޼��� ȣ��");
		
	}
	
	//3���� �����ֱ� �޼��带 ���ʷ� ����. �� �޼���� ȣ��� �޽����� ���.
	@Override
	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
	}
}
