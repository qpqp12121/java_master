package com.yedam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		}finally {
			dbc.disconn();
		}
		return null;
	}
	
	
	//2.회원가입
	public boolean memJoin(Member mem) {
		String sql = "insert into member(mem_id, mem_pw, mem_name, mem_birth, mem_phone)"
			      + "values(?, ?, ?, ? ||'-' || ? || '-' || ?, ? || '-' || ? || '-' || ?)";
		try {
			conn = dbc.getConn();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, mem.getMemId());
			psmt.setString(2, mem.getMemPw());
			psmt.setString(3, mem.getMemName());
			psmt.setString(4, mem.getMemBirth().substring(0,4));
			psmt.setString(5, mem.getMemBirth().substring(4,6));
			psmt.setString(6, mem.getMemBirth().substring(6));
			psmt.setString(7, mem.getMemPhone().substring(0,3));
			psmt.setString(8, mem.getMemPhone().substring(3,7));
			psmt.setString(9, mem.getMemPhone().substring(7));
			
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.disconn();
		}
		return false;
	}//end 회원가입
	

	//-아이디 중복검사
	public boolean checkId(String id) {
		String sql = "select count(mem_id) from member where mem_id = ?";
		
		try {
			conn = dbc.getConn();
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
	
	//폰번호 바꾸기
	boolean modifyPhone(String phone, String id) {
		conn = dbc.getConn();
		String sql = "update member set mem_phone = ? where mem_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, phone);
			psmt.setString(2, id);
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.disconn();
		}
		return false;
	}

	
	
	
}//end of class.
