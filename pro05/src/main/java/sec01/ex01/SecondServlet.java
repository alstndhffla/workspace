package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//현재 웹들은 기능에 따라 서블릿을 하나씩 만들어 추가한다.
public class SecondServlet extends HttpServlet {

	@Override
	public void init() throws ServletException{
		System.out.println("init method calling>>>>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		System.out.println("doGet method calling>>>>");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy method calling>>>>");
	}
}
