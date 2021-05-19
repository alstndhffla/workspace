package com.spring.ex01;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";	//MemberDAO �� �� �޼��� ȣ�� �� �ش� ���Ͽ��� ���� ������ ���� �� �����ͺ��̽����� �����غ� �Ѵ�.
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);	//���̹�Ƽ���� �̿��ϴ� sqlMapper ��ü�� �����´�.
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;

	}

	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();	//���� member.xml�� SQL ���� ȣ���ϴµ� ���Ǵ� SqlSession ��ü�� �����´�.
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");	//�������� ��Ŀ�带 ��ȸ�ϹǷ� selectList()�޼��忡 �����ϰ��� �ϴ� SQL���� id�� ���ڷ� ����.
		return memlist;
	}
	
//	 public List<HashMap<String, String>> selectAllMemberList() { 
//		sqlMapper = getInstance(); 
//     	SqlSession session = sqlMapper.openSession();
//		List<HashMap<String, String>> memlist = null; 
//   	memlist = session.selectList("mapper.member.selectAllMemberList"); 
//		return memlist; 
//	 }
	
}
