package com.yedam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
		
		String sql1 = "select max_mem from lecture  where lec_no = ?"; //수업의 최대인원 가져오고
		String sql2 = "select count(*) from lec_registration where lec_no = ?"; //수강신청된 테이블에서 그 강의코드 개수 확인
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1, code);
			rs = psmt.executeQuery();
			int maxCnt = 0;
			if (rs.next()) {
				maxCnt = rs.getInt(1);
			}

			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, code);
			rs = psmt.executeQuery();
			int regCnt = 0;
			if (rs.next()) {
				regCnt = rs.getInt(1);
			}

			if (maxCnt <= regCnt) { // (maxCnt > regCnt)
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.disconn();
		}
		return false;
	}

	// 수강연령 확인
	List<Member> member;

	boolean ageCheck(String code, String id){
		conn = dbc.getConn();
		member = new ArrayList<Member>();
		
		String sql1 = "select lec_target from lecture where lec_no = ?"; //강의코드 입력받아 수강대상 확인(일반/시니어/어린이)
		String sql2 = "select m.*, to_char(round(( sysdate - to_date(m.mem_birth,'yyyy-mm-dd')) / 365)) age " 
						+ "from member m where m.mem_id = ?"; //회원나이 구하기(mem_birth 문자)
		int start = 0;
		int end = 0;
		
		try {
			psmt = conn.prepareStatement(sql1);
			psmt.setString(1,code);
			rs = psmt.executeQuery();
			
			String target = null;
			if(rs.next()) {
				target = rs.getString(1);
			}
			
			switch (target) {
			case "시니어": 
				start = 60;
				end = 70;
				break;
			case "어린이" : 
				start = 8;
				end = 13;
				break;
			case "일반" :
				start = 0;
				end = 100;
				break;
			}

			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				int a = Integer.parseInt(rs.getString("age"));
				if(a >= start && a <= end){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbc.disconn();
		}
		return false;
	}
	
	//내수강조회
	List<MyPage> mylec;

	List<MyPage> checkMine(String id) { //내가 신청한 강의 조회
		mylec = new ArrayList<MyPage>();
		conn = dbc.getConn();
		String sql = "select r.mem_id, r.lec_no, l.lec_name, l.teacher_name, l.start_date, l.end_date, l.tuition_fee, r.regist_date "
				+ "from lec_registration r, lecture l "
				+ "where r.lec_no = l.lec_no and r.mem_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				MyPage mine = new MyPage();
				mine.setMemId(rs.getString("mem_id"));
				mine.setLecNo(rs.getString("lec_no"));
				mine.setLecName(rs.getString("lec_name"));
				mine.setTeacherName(rs.getString("teacher_name"));
				mine.setStartDate(rs.getDate("start_date"));
				mine.setEndDate(rs.getDate("end_date"));
				mine.setTuitionFee(rs.getInt("tuition_fee"));
				mine.setRegistDate(rs.getDate("regist_date"));

				mylec.add(mine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.disconn();
		}
		return mylec;
	}

	// 수강취소
	boolean removeLec(String pw, String code) {
		conn = dbc.getConn();
		String sql = "Delete from lec_registration r where exists(select 1 from member m " //강의코드랑 비번 확인
					+ "where r.mem_id = m.mem_id and m.mem_pw = ? and lec_no = ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			psmt.setString(2, code);
			int r = psmt.executeUpdate();

			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}// end of class.
