package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		
		//�ش� java ����� person.xml �� �о� �鿩 ���� ����
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		PersonService person = (PersonService) factory.getBean("personService");	//id�� personService�� ���� �����´�.
		// PersonService person = new PersonServiceImpl();	//���̻� �ڹ� �ڵ忡�� ��ü�� ���� �������� �ʾƵ� �ǹǷ� �ּ�ó��.
		person.sayHello();	//������ ���� �̿��� name ���� ����Ѵ�.
	}

}
