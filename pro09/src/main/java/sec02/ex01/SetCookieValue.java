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
		
		//Cookie 객체를 생성한 후 cookieTest 이름으로 한글 정보를 인코딩해서 쿠키에 저장한다.
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP프로그래밍입니다.", "UTF-8"));
//		c.setMaxAge(24*60*60);	//유효기간 설정(하루) 24시간 * 60분 * 60초 = 초(단위)
		c.setMaxAge(-1);	//위는 브라우저 쿠키. 세션 쿠키 사용시는 -1을 입력한다.
		response.addCookie(c);	//생성된 쿠키를 브라우저에 전송
		out.print("현재시간: "+d);
		out.print("문자열을 cookie 에 저장합니다.");		
	}
}
