package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuguTest2
 */
@WebServlet("/guguTest2")
public class GuguTest2 extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init method calling...");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy method calling...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int dan = Integer.parseInt(request.getParameter("dan"));	//전송된 dan 값을 int 로 형변환
		out.print("<table border=1 width=800 align=center>");
		out.print("<tr align=center bgcolor='#FFFF66'>");
		out.print("<td colspan=2>" + dan + " 단 출력 </td>");
		out.print("</tr>");
		
		for(int i = 1; i < 10; i++) {
			if(i % 2 ==0) {
				out.print("<tr align=center bgcolor='#ACFA58'>");
			}else {
				out.print("<tr align=center bgcolor='#81BEF7'>");
			}
			out.print("<td width=400>");
			out.print(dan+" * "+ i);
			out.print("</td>");
			out.print("<td width=400>");
			out.print(i * dan);
			out.print("</td>");
			out.print("</tr>");
		}
		out.print("</table>");		
	}
}
