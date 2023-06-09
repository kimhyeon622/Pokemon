import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	// DB에 접속하기 위한 메소드
	public static Connection DBConnect() {
		// DB에 접속정보를 저장하기 위한 Connection타입의 객체 con 선언
		Connection con = null;
		
		// DB에 접속할 계정정보
		String user = "TeamProject1";
		String passeord = "1111";
		
		// 접속할 DB의 주소 정보
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ojdbc6파일을 현재 소스에 적용
			
			con = DriverManager.getConnection(ur1, user, passeord); 
			// 오라클에 접속하는 계정정보 등록
			
			System.out.println("DB접속 성공!");
			
		} catch (ClassNotFoundException e) {
			// ojdbc6파일이 존재하지 않을 경우 (오라클 드라이버를 찾지 못할경우)
			e.printStackTrace();	// 오류가 발생한 경로를 찾아준다.
			
			System.out.println("DB접속 실패! : 드라이버 로딩 실패");
			
		} catch (Exception e) {
			// 오라클 접속 계정정보가 틀렸을 경우(ur1, user, password 확인)
			e.printStackTrace();
			
			System.out.println("DB접속 실패 : DB접속정보 오류");
		}
		
		return con;		// 접속상태 con을 리턴
	}
	
	
	
	
}
