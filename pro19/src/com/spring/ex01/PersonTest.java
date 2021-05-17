package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		
		//해당 java 실행시 person.xml 을 읽어 들여 빈을 생성
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		PersonService person = (PersonService) factory.getBean("personService");	//id가 personService인 빈을 가져온다.
		// PersonService person = new PersonServiceImpl();	//더이상 자바 코드에서 객체를 직접 생성하지 않아도 되므로 주석처리.
		person.sayHello();	//생성된 빈을 이용해 name 값을 출력한다.
	}

}
