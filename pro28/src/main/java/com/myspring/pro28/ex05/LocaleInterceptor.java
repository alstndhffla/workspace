package com.myspring.pro28.ex05;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

//����� ���� ���ͼ��ʹ� �ݵ�� HandlerInterceptorAdapter�� ��ӹ޾ƾ� �Ѵ�.
public class LocaleInterceptor extends  HandlerInterceptorAdapter{
	   
		//��Ʈ�ѷ� ���� �� ȣ��ȴ�.
		@Override
	   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
	      HttpSession session=request.getSession();
	      String locale=request.getParameter("locale");	//���������� ������ locale ������ �����´�.
	      if(locale==null) locale="ko";	//���� ��û�� locale�� �ѱ���� ����
	      
	      //LOCALE �Ӽ� ���� ���ǿ� ������ SessionLocaleResolver�� ����� �� �ְ� �Ѵ�.
	      session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE",new Locale(locale));
	      return true;
	   }
		
		//��Ʈ�ѷ� ���� �� ȣ��ȴ�.
	   @Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response,
	                           Object handler, ModelAndView modelAndView) throws Exception {
	   }
	   
	   //��(JSP)�� ������ �� ȣ��ȴ�.
	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
	                                    Object handler, Exception ex)    throws  Exception {
	   }
	}
