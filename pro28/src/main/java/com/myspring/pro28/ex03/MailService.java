package com.myspring.pro28.ex03;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/*@Service("mailService")*/
public class MailService {
	
	//mail-context.xml 에서 설정한 빈을 자동으로 주입.
	@Autowired
	 private JavaMailSender mailSender;
    @Autowired
    private SimpleMailMessage preConfiguredMessage;
    
    //
    @Async
	public void sendMail(String to, String subject, String body) {
    	MimeMessage message = mailSender.createMimeMessage();	//MimeMessage 타입 객체를 생성.
    	try {
    		
    	  
    	//메일을 보내기 위해 객체를 생성한다.
    		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
    		messageHelper.setCc("zzzzzz@naver.com");
    		messageHelper.setFrom("송신자@naver.com", "홍길동");	//메일 수신 시 지정한 이름으로 표시되게 합니다. 지정하지 않으면 송신 메일 주소가 표시된다.
		
		//제목, 수신처, 내용을 설정해 메일을 보낸다.
    		messageHelper.setSubject(subject);
    		messageHelper.setTo(to); 
    		messageHelper.setText(body );
    		mailSender.send(message);
    		
		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
    
    //mail-context.xml 에서 미리 설정한 수신 주소로 메일 내용을 보낸다.
	@Async
	public void sendPreConfiguredMail(String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
		mailMessage.setText(message);
		mailSender.send(mailMessage);
	}
}

