package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
//@WebFilter("/*")	//웹필터 애너테이션을 이용해 모든 요청이 필터를 거치게 한다.
public class EncoderFilter implements Filter {	//사용자 정의 필터는 반드시 필터 인터페이스를 구현해야 한다.
	ServletContext context;
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy() calling...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * filterchain 타입인 chain을 세번재 매개변수로 갖는다.
	 * 전달된 request를 이용해 한글 인코딩 작업을 한다..
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("doFilter() calling...");
		request.setCharacterEncoding("utf-8");	//한글 인코딩 작업을 수행.
		String context = ((HttpServletRequest)request).getContextPath();	//웹 애플리케이션의 컨텍스트 이름을 가져온다.
		String pathinfo = ((HttpServletRequest)request).getRequestURI();	//웹 브라우저가 요청한 uri를 가져온다.
		String realPath = request.getRealPath(pathinfo);	//요청 uri의 실제 경로를 가져온다.
		String mesg = " Context  정보:" + context + "\n URI 정보 : " + pathinfo + "\n 물리적 경로:  " + realPath;
		System.out.println(mesg);
		long begin = System.currentTimeMillis();	//요청 필터에서 요청 처리 전의 시간을 구한다.
		
		// doFilter() 안에서 요청필터와 응답필터 2개를 동시에 할 수 있다. 
		// 이 주석을 기준으로 위쪽은 요청필터고 아래는 응답필터.
		// pass the request along the filter chain. 다음 필터로 넘기는 작업을 수행.
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();	//응답필터에서 요청 처리 후의 시각을 구한다.
		System.out.println("작업시간: " + (end-begin) + "ms");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("utf-8 encoding...");
		context = fConfig.getServletContext();
	}

}
