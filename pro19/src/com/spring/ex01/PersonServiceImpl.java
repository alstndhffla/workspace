package com.spring.ex01;

//���ø���Ʈ�� �������̽� �ް�
public class PersonServiceImpl implements PersonService {
	private String name;
	private int age;
	
	//person.xml �ȿ� ������ Ŭ������ <value> �±��� ���� setter �� �̿��� �����Ѵ�.
	public void setName(String name) {
		this.name = name;
	}
	
	//�������̽� ���� ����� �߻�޼��� �������̵�� ������
	@Override
	public void sayHello() {
		System.out.println("�̸�: " + name);
		System.out.println("����: " + age);
	}
}
