package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 클라이언트와 통신할 때 지정한 name 값이 많아 헷갈리는 경우 getPrameterName() 을 활용하는 방법.
/**
 * Servlet implementation class InputServlet2
 */
//@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
//	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Enumeration enu = request.getParameterNames();	//전송되어 온 name 속성들만 Enumeration 타입으로 받아온다.
		
		// 각 name 을 하나씩 가져와 대응해서 전송되어 온 값을 출력한다.		
		while (enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String[] values = request.getParameterValues(name);
			for (String value : values) {
				System.out.println("name="+name+"values="+value);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
