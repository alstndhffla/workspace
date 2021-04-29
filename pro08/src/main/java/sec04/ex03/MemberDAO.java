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

//Ŀ�ؼ� Ǯ�� ����Ͽ� ����� ���� ��ȸ
public class MemberDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;	//Ŀ�ؼ� Ǯ�� ����ϱ� ���� �ڹ���ƿ.
	
	public MemberDAO() {
		try {
			//JNDI�� �����ϱ� ���� �⺻ ��� ����.
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			
			//��Ĺ context.xml�� ������ name ���� jdbc/oracle�� �̿��� ��Ĺ�� �̸� ������ DataSource�� �޾ƿɴϴ�.
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			//DataSource �� �̿��� �����ͺ��̽��� �����Ѵ�.
			con=dataFactory.getConnection();
			String query = "select * from t_member";
			System.out.println("prepareStatement: " + query);
			//prepareStatement() �޼��忡 SQL���� �����ؼ� PreparedStatement ��ü�� ����.
			pstmt = con.prepareStatement(query);
			//executeQuery() �޼��带 ȣ���� �̸� ������ SQL���� ����.
			ResultSet rs = pstmt.executeQuery();	//sql������ ȸ�������� ��ȸ
			while(rs.next()) {
				//��ȸ�� ���ڵ��� �� �÷� ���� �޾Ƽ� �ش� ������ ����.
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				//�� �÷� ���� �ٽ� MemberVO ��ü�� �Ӽ��� �����Ѵ�.
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);		
				
				//������ MemberVO ��ü�� �ٽ� ArrayList�� ����.
				list.add(vo);				
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;	//��ȸ�� ���ڵ��� ������ŭ MemberVO ��ü�� ������ ArrayList�� ��ȯ�Ѵ�.
	}
	
	//ȸ�����
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
	
	//ȸ������
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
