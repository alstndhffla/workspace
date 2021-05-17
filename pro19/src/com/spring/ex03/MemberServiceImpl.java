package com.spring.ex03;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;	//���ԵǴ� ���� ������ MemberDAO Ÿ���� �Ӽ��� ����
	
	//���� ���Ͽ��� memberDAO ���� ������ �� setter�� �Ӽ� memberDAO�� ����.
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public void listMembers() {
		memberDAO.listMembers();	//���Ե� ���� �̿��� listmembers()�޼��带 ȣ��
	}
}
