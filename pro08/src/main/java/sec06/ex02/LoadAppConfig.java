package sec06.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * loadOnStartup 속성을 추가하고 우선순위를 1로 설정한다.
 */
@WebServlet(name = "/LoadConfig", urlPatterns = {"/loadConfig"}, loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	private ServletContext context;	//변수 context 를 멤버변수로 선언합니다.
	
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("LoadAppConfig의 init 메서드 호출");
		context = config.getServletContext();	//init()메서드에서 servletcontext 객체를 얻습니다.
		
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		context.setAttribute("menu_member", menu_member);
		context.setAttribute("menu-order", menu_order);
		context.setAttribute("menu_goods", menu_goods);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//브라우저에서 요청시 ServletContext 객체의 바인딩된 메뉴 항목을 가져옵니다.
		String menu_member = (String) context.getAttribute("menu_member");
		String menu_order = (String) context.getAttribute("menu_order");
		String menu_goods = (String) context.getAttribute("menu_goods");
		
		out.print("<html><body>");
		out.print("<table border=1 cellspacing=0><tr>메뉴 이름</tr>");
		out.print("<tr><td>"+menu_member+"</td></tr>");
		out.print("<tr><td>"+menu_order+"</td></tr>");
		out.print("<tr><td>"+menu_goods+"</td></tr>");
		out.print("</table></body></html>");
	}

}
