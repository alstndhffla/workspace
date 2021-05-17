package com.spring.ex01;

//임플리먼트로 인터페이스 받고
public class PersonServiceImpl implements PersonService {
	private String name;
	private int age;
	
	//person.xml 안에 선언한 클래스의 <value> 태그의 값을 setter 를 이용해 설정한다.
	public void setName(String name) {
		this.name = name;
	}
	
	//인터페이스 내에 선언된 추상메서드 오버라이드로 재정의
	@Override
	public void sayHello() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
}
