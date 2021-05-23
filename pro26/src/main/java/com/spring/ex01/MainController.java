package com.spring.ex01;	//애너테이션이 적용되도록 하려면 해당 클래스가 반드시 <component-scan>에서 설정한 패키지나 하위 패키지에 존재해야 한다.

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainController")	//컨트롤러 애너테이션을 이용해 MainController 클래스를 빈으로 자동 변환한다. 빈 id는 mainController이다.
@RequestMapping("/test")	//리퀘스트 매핑을 이용해 첫번째 단계의 URL 요청이 /test이면 mainController 빈을 요청한다.
public class MainController {
   @RequestMapping(value="/main1.do" ,method=RequestMethod.GET)	//두번째 단계의 URL 요청이 /main1.do 이면 mainController 빈의 main1() 메서드에게 요청한다. get방식으로.
   public ModelAndView main1(HttpServletRequest request, HttpServletResponse response)  throws Exception{
      ModelAndView mav=new ModelAndView();
      mav.addObject("msg","main1");
      mav.setViewName("main");
      return mav;
   }

   @RequestMapping(value="/main2.do" ,method = RequestMethod.GET)
   public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) throws Exception{
      ModelAndView mav=new ModelAndView();
      mav.addObject("msg","main2");
      mav.setViewName("main");
      return mav;
   }
}
