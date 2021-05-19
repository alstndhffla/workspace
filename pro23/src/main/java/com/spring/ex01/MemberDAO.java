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
				String resource = "mybatis/SqlMapConfig.xml";	//MemberDAO 의 각 메서드 호출 시 해당 파일에서 설정 정보를 읽은 후 데이터베이스와의 연동준비를 한다.
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);	//마이바티스를 이용하는 sqlMapper 객체를 가져온다.
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;

	}

	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();	//실제 member.xml의 SQL 문을 호출하는데 사용되는 SqlSession 객체를 가져온다.
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");	//여러개의 레커드를 조회하므로 selectList()메서드에 실행하고자 하는 SQL문의 id를 인자로 전달.
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
