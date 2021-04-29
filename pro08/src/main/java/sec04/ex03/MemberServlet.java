package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		doHandle(request, response);
	}
	
	//get, post 로 받든 아래 doHandle메서드로 처리.
	private void doHandle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		MemberDAO dao = new MemberDAO();
		PrintWriter out = response.getWriter();
		
		List memberList = dao.listMembers();
		//조회된 회원정보를 ArrayList객체에 저장한 후 request에 바인딩한다.
		request.setAttribute("memberList", memberList);
		//바인딩한 request를 viewMembers 서블릿으로 포워딩한다.
		RequestDispatcher dispatch = request.getRequestDispatcher("viewMembers");
		dispatch.forward(request, response);
	}
}
