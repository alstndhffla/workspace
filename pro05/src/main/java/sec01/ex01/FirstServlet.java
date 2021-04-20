package sec01.ex01;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet을 상속받는다.
public class FirstServlet extends HttpServlet {
	@Override
	public void init() throws ServletException{
		System.out.println("init 메서드 호출");
		
	}
	
	//브라우저의 요청처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		System.out.println("doGet 메서드 호출");
		
	}
	
	//3개의 생명주기 메서드를 차례로 구현. 각 메서드는 호출시 메시지만 출력.
	@Override
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
