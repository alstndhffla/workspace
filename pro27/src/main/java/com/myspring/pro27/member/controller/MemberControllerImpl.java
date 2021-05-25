package com.myspring.pro27.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro27.member.service.MemberService;
import com.myspring.pro27.member.vo.MemberVO;



@Controller("memberController")
//@EnableAspectJAutoProxy
public class MemberControllerImpl   implements MemberController {
	//LoggerFactory Ŭ������ �̿��� Logger Ŭ���� ��ü�� �����´�.
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO ;
	
	@Override
	@RequestMapping(value="/member/listMembers.do" ,method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//String viewName = getViewName(request);
		String viewName = (String)request.getAttribute("viewName");	//���ͼ��Ϳ��� ���ε��� ���̸��� �����´�.
		System.out.println("viewName: " +viewName);
		logger.info("info ���� viewName: "+ viewName);	//Logger Ŭ������ info()�޼���� �α� �޽��� ������ info�� ����.
		logger.debug("debug viewName: "+ viewName);	//logger Ŭ������ debug()�޼���� �α� �޽��� ������ debug�� ����.
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);	//viewName �� <definition>�±׿� ������ ���̸��� ��ġ�Ѵ�.
		mav.addObject("membersList", membersList);
		return mav;	//ModelAndView ��ü�� ������ ���̸��� Ÿ���� �丮������ ��ȯ�Ѵ�.
	}

	@Override
	@RequestMapping(value="/member/addMember.do" ,method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/removeMember.do" ,method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@RequestMapping(value = { "/member/loginForm.do", "/member/memberForm.do" }, method =  RequestMethod.GET)
//	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	/*
	 * �α��� â���� ���۵� ID�� ��й�ȣ�� MemberVO��ü�� member�� ����, RedirectAttribute Ŭ������ �̿��� �α��� ���н� �ٽ� �α���â���� �����̷�Ʈ�Ͽ�
		���и޽����� �����Ѵ�(rAttr) 
	*/
	@Override
	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member,
				              RedirectAttributes rAttr,
		                       HttpServletRequest request, HttpServletResponse response) throws Exception {		
	ModelAndView mav = new ModelAndView();
	memberVO = memberService.login(member);	//login�޼��带 ȣ���ϸ鼭 �α��� ������ ����.

	//memverVO �� ��ȯ�� ���� ������ ������ �̿��� �α��� ���¸� true�� �Ѵ�.
	if(memberVO != null) {
		    HttpSession session = request.getSession();
		    session.setAttribute("member", memberVO);	//���ǿ� ȸ�� ������ ����.
		    session.setAttribute("isLogOn", true);	//���ǿ� �α��� ���¸� true�� ����
		    mav.setViewName("redirect:/member/listMembers.do");
	}else {
		    rAttr.addAttribute("result","loginFailed");	//�α��� ���н� ���� �޽����� �α���â���� ����.
		    mav.setViewName("redirect:/member/loginForm.do");	//�α��� ���н� �ٽ� �α���â���� �����̷�Ʈ
	}
	return mav;
	}

	@Override
	@RequestMapping(value = "/member/logout.do", method =  RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		//�α׾ƿ� ��û�� ���ǿ� ����� �α��� ������ ȸ�������� ����
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/listMembers.do");
		return mav;
	}	
	
	/*
	 * �α���â ��û�� �Ű����� result�� ���۵Ǹ� ���� result �� ���� �����Ѵ�. ���ʷ� �α���â�� ��û�� �� �Ű����� result�� ���۵��� �����Ƿ� ����
	 */
	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	private ModelAndView form(@RequestParam(value= "result", required=false) String result,
						       HttpServletRequest request, 
						       HttpServletResponse response) throws Exception {
		//String viewName = getViewName(request);
		String viewName = (String)request.getAttribute("viewName");	//���ͼ��Ϳ��� ���ε��� ���̸��� �����´�.
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		mav.setViewName(viewName);
		return mav;
	}
	
	/*
	 * 
	 */
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			//	/member/listMember.do�� ��û�� ��� member/listMember�� �����̸����� �����´�.
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}


}
