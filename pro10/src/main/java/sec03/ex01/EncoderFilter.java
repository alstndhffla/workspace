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
//@WebFilter("/*")	//������ �ֳ����̼��� �̿��� ��� ��û�� ���͸� ��ġ�� �Ѵ�.
public class EncoderFilter implements Filter {	//����� ���� ���ʹ� �ݵ�� ���� �������̽��� �����ؾ� �Ѵ�.
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
	 * filterchain Ÿ���� chain�� ������ �Ű������� ���´�.
	 * ���޵� request�� �̿��� �ѱ� ���ڵ� �۾��� �Ѵ�..
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("doFilter() calling...");
		request.setCharacterEncoding("utf-8");	//�ѱ� ���ڵ� �۾��� ����.
		String context = ((HttpServletRequest)request).getContextPath();	//�� ���ø����̼��� ���ؽ�Ʈ �̸��� �����´�.
		String pathinfo = ((HttpServletRequest)request).getRequestURI();	//�� �������� ��û�� uri�� �����´�.
		String realPath = request.getRealPath(pathinfo);	//��û uri�� ���� ��θ� �����´�.
		String mesg = " Context  ����:" + context + "\n URI ���� : " + pathinfo + "\n ������ ���:  " + realPath;
		System.out.println(mesg);
		long begin = System.currentTimeMillis();	//��û ���Ϳ��� ��û ó�� ���� �ð��� ���Ѵ�.
		
		// doFilter() �ȿ��� ��û���Ϳ� �������� 2���� ���ÿ� �� �� �ִ�. 
		// �� �ּ��� �������� ������ ��û���Ͱ� �Ʒ��� ��������.
		// pass the request along the filter chain. ���� ���ͷ� �ѱ�� �۾��� ����.
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();	//�������Ϳ��� ��û ó�� ���� �ð��� ���Ѵ�.
		System.out.println("�۾��ð�: " + (end-begin) + "ms");
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
