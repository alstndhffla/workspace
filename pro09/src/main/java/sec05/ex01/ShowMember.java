package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/show")
public class ShowMember extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String id ="", pwd="";
		
		Boolean isLogon = false;
		
		//�̹� ������ �����ϸ� ������ ��ȯ�ϰ� ������ null�� ��ȯ�մϴ�.
		HttpSession session = request.getSession(false);
		if(session != null) {
			isLogon = (Boolean)session.getAttribute("isLogon");	//isLogon�Ӽ��� ������ �α��� ���¸� Ȯ��.
			
			//�α��� �����̹Ƿ� ȸ�������� �������� ǥ��
			if(isLogon==true) {
				id = (String)session.getAttribute("login.id");
				pwd = (String)session.getAttribute("login.pwd");
				
				out.print("<html><body>");
				out.print("���̵�: "+ id +"<br><br>");
				out.print("pwd: "+ pwd + "<br><br>");
				out.print("</body></HTML>");
			}else {
				response.sendRedirect("login3.html"); //�α��� ���°� �ƴϸ� �α���â���� �̵�.
			}
		}else {
			response.sendRedirect("login3.html");	//������ �������� �ʾ����� �α���â���� �̵�.
		}
	}
}
