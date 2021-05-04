package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 * HttpSessionBindingListener 를 제외한 리스너를 구현한 모든 이벤트 핸들러는 반드시 애너테이션을
 * 이용해서 리스너로 등록해야한다(그래서 HttpSessionListener 인터페이스 구현)
 */
@WebListener
public class LoginImpl implements HttpSessionListener {
	String user_id;
	String user_pw;
	static int total_user = 0;

	public LoginImpl() {
	}

	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("세션 생성");
		++total_user;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("세션 소멸");
		--total_user;
	}

}
