package b;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Controller인 DAO클래스 (Database Access Object)

public class MemberDAO {
	
	DBConnection dbc = new DBConnection();

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	
	//1.로그인
	public Member logIn(String id, String pw) {
		String sql = "select * from member where mem_id=? and mem_pw=?";
		try {
			conn = dbc.getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				Member mem = new Member();
				mem.setMemId(rs.getString("mem_id"));
				mem.setMemPw(rs.getString("mem_pw"));
				mem.setMemName(rs.getString("mem_name"));
				return mem;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//2.회원가입
	public boolean memjoin(Member mem) {
		String sql = "insert into member(mem_no, mem_id, mem_pw, mem_name, mem_birth, mem_phone)"
				      + "values(member_seq.nextval, ?, ?, ?, ?, ?)";
		try {
			conn = DBConnection.getConn();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mem.getMemId());
			psmt.setString(2, mem.getMemPw());
			psmt.setString(3, mem.getMemName());
			psmt.setString(4, mem.getMemBirth());
			psmt.setString(5, mem.getMemPhone());
			
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//end 회원가입
	

	//-아이디 중복검사
	public boolean checkId(String id) {
		String sql = "select count(mem_id) from member where mem_id = ?";
		
		try {
			conn = DBConnection.getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,id);
			rs = psmt.executeQuery();
			
			rs.next();
			if(rs.getInt(1) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//end 중복체크
	
	
}//end of class.
