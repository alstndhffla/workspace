package com.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED)	//어노테이션을 이용해 AccountService클래스의 모든 메서드에 트랜잭션을 적용
public class AccountService {
	private AccountDAO accDAO;
	
	//속성 accDAO에 빈을 주입하기 위해 setter를 구현
	public void setAccDAO(AccountDAO accDAO) {
		this.accDAO = accDAO;
	}
	
	//sendMoney() 메서드 호출 시 accDAO의 두 개의 SQL문을 실행.
	public void sendMoney() throws Exception {
		accDAO.updateBalance1();
		accDAO.updateBalance2();
	}
}


