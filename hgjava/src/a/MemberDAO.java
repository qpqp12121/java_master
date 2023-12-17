package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url,"dev","dev");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Member logIn(String id, String pw) { 
		getConn();
		String sql = "select * from member where mem_id = ? And mem_pw = ? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				Member mem = new Member();
				mem.setMemId(rs.getString("mem_id"));
				mem.setMemPw(rs.getString("mem_pw"));
				mem.setMemName(rs.getString("mem_name"));
				mem.setResponse(rs.getString("response"));
				return mem;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}// end of login.

}
