import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	// DB�� �����ϱ� ���� �޼ҵ�
	public static Connection DBConnect() {
		// DB�� ���������� �����ϱ� ���� ConnectionŸ���� ��ü con ����
		Connection con = null;
		
		// DB�� ������ ��������
		String user = "TeamProject1";
		String passeord = "1111";
		
		// ������ DB�� �ּ� ����
		String ur1 = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ojdbc6������ ���� �ҽ��� ����
			
			con = DriverManager.getConnection(ur1, user, passeord); 
			// ����Ŭ�� �����ϴ� �������� ���
			
			System.out.println("DB���� ����!");
			
		} catch (ClassNotFoundException e) {
			// ojdbc6������ �������� ���� ��� (����Ŭ ����̹��� ã�� ���Ұ��)
			e.printStackTrace();	// ������ �߻��� ��θ� ã���ش�.
			
			System.out.println("DB���� ����! : ����̹� �ε� ����");
			
		} catch (Exception e) {
			// ����Ŭ ���� ���������� Ʋ���� ���(ur1, user, password Ȯ��)
			e.printStackTrace();
			
			System.out.println("DB���� ���� : DB�������� ����");
		}
		
		return con;		// ���ӻ��� con�� ����
	}
	
	
	
	
}
