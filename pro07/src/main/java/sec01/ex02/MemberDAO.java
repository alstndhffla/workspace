package sec01.ex02;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//ex01에서는 statement 를 사용했다면, 여기서는 PreparedStatement 사용. sql 문에 ? 를 쓸 수 있음.
public class MemberDAO {
	//sqldeveloper에 연결하기 위한 설정
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	
	private Connection con;
//	private Statement stmt;
	private PreparedStatement pstmt;	//위 대신 이거 사용.
	
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			connDB();	//데이터베이스를 연결한다.
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
	
	//드라이버 연결 메서드(생성자)
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");

			//pstmt를 사용하기 때문에 아래 2개를 생성할 필요가 없음. 재사용이 가능하기 때문.
//			stmt = con.createStatement();
//			System.out.println("Statement 생성 성공");			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
