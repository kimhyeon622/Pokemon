import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class pokemonSQL {

	Connection con = null;

	Statement stmt = null;
	PreparedStatement pstmt = null;

	ResultSet rs = null;

	String[][][] A = new String[10][10][10];
	String name1 = null;
	String name2 = null;
	int hp1 = 0;
	int hp2 = 0;
	int at1 = 0;
	int at2 = 0;
	int p2 = 1;
	
	public void connect() {

		con = DBConnection.DBConnect();
	}

	public void conClose() {
		try {
			con.close();
			System.out.println("DB접속 해제!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int hp(String name) {
		String sql = "SELECT hp FROM poketmon WHERE name=?";
		int hp = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			rs.next();
			hp = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hp;
	}
	
	// 스킬 이름
	public String skillname(String name1) {
		String skillname = null;
		String sql = "SELECT skill FROM poketmon WHERE name=?";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, name1);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("1. skill : " + rs.getString(1));
				System.out.println("");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return skillname;
	}

	// 스킬 대미지
	public String skill(String name) {
		String skillname = null;
		String sql = "SELECT skill FROM poketmon WHERE name=?";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, name);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				skillname = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return skillname;
	}

	
	public int at(String name) {
		String sql = "SELECT attack FROM poketmon WHERE name=?";
		int at = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			rs.next();
			at = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return at;
	}
	
	// 아군
	public void player1(int num1, String name, int hp1, int at1) {
		String sql = "INSERT INTO player1 VALUES(?, ?, ?, ?)";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, num1);

			pstmt.setString(2, name);

			pstmt.setInt(3, hp1);

			pstmt.setInt(4, at1);

			rs = pstmt.executeQuery();

			rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// 아군 공격력 불러오기
	public int at1(int num1) {
		String sql = "SELECT at1 FROM player1 WHERE num1=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num1);
			rs = pstmt.executeQuery();
			rs.next();
			at1 = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return at1;
	}
	
	// 아군 hp 불러오기
	public int hp1(int num1) {
		String sql = "SELECT hp1 FROM player1 WHERE num1=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num1);
			rs = pstmt.executeQuery();
			rs.next();
			hp1 = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hp1;
	}

	// 아군 이름 불러오기
	public String name1(int num1) {
		String sql = "SELECT name1 FROM player1 WHERE num1=?";
		String name1 = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num1);
			rs = pstmt.executeQuery();
			rs.next();
			name1 = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name1;
	}

	// 아군 hp 저장
	public void player1hp(int hp1, int num1) {
		String sql = "UPDATE player1 SET hp1=? WHERE num1=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, hp1);
			pstmt.setInt(2, num1);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	// 아군 기절 설정
	public void player1name(String name1, int num1) {
		String sql = "UPDATE player1 SET name1=? WHERE num1=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name1);
			pstmt.setInt(2, num1);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 아군 리셋
	public void re1() {
		String sql1 = "DELETE FROM player1 WHERE num1=1";

		try {
			stmt = con.prepareStatement(sql1);
			int result = stmt.executeUpdate(sql1);

			if (result > 0) {
			} else {
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2 = "DELETE FROM player1 WHERE num1=2";
		try {
			stmt = con.prepareStatement(sql2);
			int result = stmt.executeUpdate(sql2);

			if (result > 0) {
			} else {
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql3 = "DELETE FROM player1 WHERE num1=3";
		try {
			stmt = con.prepareStatement(sql3);
			int result = stmt.executeUpdate(sql3);

			if (result > 0) {
			} else {
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 적군 리셋
	public void re2() {
		String sql1 = "DELETE FROM player2 WHERE num2=1";

		try {
			stmt = con.prepareStatement(sql1);
			int result = stmt.executeUpdate(sql1);

			if (result > 0) {
			} else {
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2 = "DELETE FROM player2 WHERE num2=2";
		try {
			stmt = con.prepareStatement(sql2);
			int result = stmt.executeUpdate(sql2);

			if (result > 0) {
			} else {
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql3 = "DELETE FROM player2 WHERE num2=3";
		try {
			stmt = con.prepareStatement(sql3);
			int result = stmt.executeUpdate(sql3);

			if (result > 0) {
			} else {
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	// 적군
	public void player2(int num2, String name, int hp2, int at2) {
		String sql = "INSERT INTO player2 VALUES(?, ?, ?, ?)";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, num2);

			pstmt.setString(2, name);

			pstmt.setInt(3, hp2);

			pstmt.setInt(4, at2);

			rs = pstmt.executeQuery();

			rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 적군 이름 저장
	public String name2(int num2) {
		String sql = "SELECT name2 FROM player2 WHERE num2=?";
		String name2 = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num2);
			rs = pstmt.executeQuery();
			rs.next();
			name2 = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name2;
	}

	
	
	public int at2(int num2) {
		String sql = "SELECT at2 FROM player2 WHERE num2=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num2);
			rs = pstmt.executeQuery();
			rs.next();
			at2 = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return at2;
	}
	
	
	public int hp2(int num2) {
		String sql = "SELECT hp2 FROM player2 WHERE num2=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num2);
			rs = pstmt.executeQuery();
			rs.next();
			hp2 = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hp2;
	}
	
	

		public void player2hp(int hp2, int num2) {
			String sql = "UPDATE player2 SET hp2=? WHERE num2=?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, hp2);
				pstmt.setInt(2, num2);
				pstmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
