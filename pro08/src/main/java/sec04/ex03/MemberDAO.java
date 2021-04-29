package sec04.ex03;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//커넥션 풀을 사용하여 사용자 정보 조회
public class MemberDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;	//커넥션 풀을 사용하기 위한 자바유틸.
	
	public MemberDAO() {
		try {
			//JNDI에 접근하기 위해 기본 경로 지정.
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			
			//톰캣 context.xml에 설정한 name 값인 jdbc/oracle을 이용해 톰캣이 미리 연결한 DataSource를 받아옵니다.
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			//DataSource 를 이용해 데이터베이스에 연결한다.
			con=dataFactory.getConnection();
			String query = "select * from t_member";
			System.out.println("prepareStatement: " + query);
			//prepareStatement() 메서드에 SQL문을 전달해서 PreparedStatement 객체를 생성.
			pstmt = con.prepareStatement(query);
			//executeQuery() 메서드를 호출해 미리 설정한 SQL문을 실행.
			ResultSet rs = pstmt.executeQuery();	//sql문으로 회원정보를 조회
			while(rs.next()) {
				//조회한 레코드의 각 컬럼 값을 받아서 해당 변수에 저장.
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				//각 컬럼 값을 다시 MemberVO 객체의 속성에 설정한다.
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);		
				
				//설정된 MemberVO 객체를 다시 ArrayList에 저장.
				list.add(vo);				
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;	//조회한 레코드의 개수만큼 MemberVO 객체를 저장한 ArrayList를 반환한다.
	}
	
	//회원등록
	public void addMember(MemberVO memberVO) {
		try {
			Connection con = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String query = "insert into t_member";
			query += "(id, pwd, name, email)";
			query += "values(?, ?, ?, ?)";
			System.out.println("prepareStatement: " + query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);;
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원삭제
	public void delMember(String id) {
		try {
			Connection con = dataFactory.getConnection();
			Statement stmt = con.createStatement();
			
			String query = "delete from t_member" + "where id=?";
			System.out.println("prepareStatement: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
