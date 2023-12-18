package com.yedam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class RegistrationDAO {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	DBConnection dbc = new DBConnection();

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	// 수강신청
	boolean addRegist(Registration rg) {

		String sql = "insert into lec_registration(regist_seq, lec_no, mem_id)" + "values(regist_seq.nextval, ?, ?)"; // 날짜자동으로
																														// 오늘날짜
		try {
			conn = dbc.getConn();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, rg.getLecNo());
			psmt.setString(2, rg.getMemId());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.disconn();
		}
		return false;
	}

	// 해당코드가 있는지 메소드 만들기
	boolean checkCode(String code) {
		String sql = "select lec_no from lecture where lec_no = ?";
		try {
			conn = dbc.getConn();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			rs = psmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.disconn();
		}
		return false;
	}

	// 초과인원시 신청X
	boolean closeLec(String code) {
		conn = dbc.getConn();
		String sql = "select distinct r.lec_no "
				+ "from lec_registration r, lecture l "
				+ "where r.lec_no = l.lec_no "
				+ "and l.max_mem <= (select count(*) "
				+ "                from lec_registration "
				+ "                where lec_no = ? group by ?)"; //max_mem > 서브쿼리면 초과한 강의 안 나옴
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			psmt.setString(2, code);
			rs = psmt.executeQuery();
			
			rs.next();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.disconn();
		}
		return false;
	}
	
	//수강연령 확인
	boolean ageCheck(String code) {
		conn = dbc.getConn();
		String sql = "select lec_target "
				+ "from lecture "
				+ "where lec_no IN(select lec_no "
				+ "                from lec_registration "
				+ "                where lec_no = ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			rs = psmt.executeQuery();
			
			rs.next();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.disconn();
		}
		return false;
	}
	
	
	
	

}// end of class.
