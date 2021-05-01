package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/set")
public class SetCookieValue extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
	
		PrintWriter out = response.getWriter();
		Date d = new Date();
		
		//Cookie ��ü�� ������ �� cookieTest �̸����� �ѱ� ������ ���ڵ��ؼ� ��Ű�� �����Ѵ�.
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP���α׷����Դϴ�.", "UTF-8"));
//		c.setMaxAge(24*60*60);	//��ȿ�Ⱓ ����(�Ϸ�) 24�ð� * 60�� * 60�� = ��(����)
		c.setMaxAge(-1);	//���� ������ ��Ű. ���� ��Ű ���ô� -1�� �Է��Ѵ�.
		response.addCookie(c);	//������ ��Ű�� �������� ����
		out.print("����ð�: "+d);
		out.print("���ڿ��� cookie �� �����մϴ�.");		
	}
}
