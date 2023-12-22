package com.yedam.student.mapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.student.vo.Student;

//저장공간: Oracle DB.

/* 추가/ 수정 / 삭제 / 목록 / 단건조회 */
// executeUpdate(): 추가, 수정, 삭제
// executeQuery() : 목록, 단건조회

public class StudentDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	Connection getConn() { // db연결하는거 중복으로 사용할 거라 메소드로 만들어놓고 각 메소드에 호출 -아래 mainexe에 있는거 들고옴
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공!!"); // 위 예외처리 Surround-로
		} catch (Exception e) { // Exception으로 바꾸기
			e.printStackTrace();
		}
		return conn;
	}

	// 2.목록
	Student[] students;

	public List<Student> getStudentList() {
		getConn(); 
		List<Student> students = new ArrayList<>();
		String sql = "select * from student order by 1"; 
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Student student = new Student(); 
				student.setStuNo(rs.getString("stu_no"));
				student.setStuName(rs.getString("stu_name"));
				student.setEngScore(rs.getInt("eng_score"));
				student.setMathScore(rs.getInt("math_score"));
				
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return students;
	}// end of getStudentList().

	// 1.추가(등록)
	public boolean addStudent(Student std) {
		getConn();
		String sql = "insert into student values(?,?,?,?)"; // 순서정하고 싶으면 student(괄호안에 넣어줘도 되고) --안 적으면 db에 적어놓은 순서대로 지켜서
		try {
			conn.setAutoCommit(false); // 자동커밋 실행 여부.
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, std.getStuNo()); // 매개값으로 들어온 순서,이름... 넣기
			psmt.setString(2, std.getStuName());
			psmt.setInt(3, std.getEngScore());
			psmt.setInt(4, std.getMathScore()); // 여기까지가 쿼리 만든 것

			int r = psmt.executeUpdate(); // db의 처리된 건수가 반환 됨
			if (r == 1) {
				conn.commit(); // 자동커밋
				return true; // 정상적으로 한건이반환되었다
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 처리된 건수가 1이 아니면 false
	}// end of addStudent.

	// 3.단건조회
	public Student getStudent(String no) {
		getConn();
		String sql = "select * from student where stu_no = ?"; // ** 한건조회 쿼리
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no); // 위에 ? 파라메타 1개 있으니까 (1개,no파라메타 변수) 지정해줘야됨
			rs = psmt.executeQuery();// 조회니까 ResultSet에 담아줘야됨 (배열에 값 저장하는거아니니까 for안돌아도됨)
			if (rs.next()) { // rs.next()로 값이 있는지 확인하고 있으면 student값 반환
				Student student = new Student(); // (인스턴스 하나 생성하고)
				student.setStuNo(rs.getString("stu_no"));
				student.setStuName(rs.getString("stu_name"));
				student.setEngScore(rs.getInt("eng_score"));
				student.setMathScore(rs.getInt("math_score"));
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // 조회된 값이 없으면 null값 반환.
	}

	// 4.수정
	public boolean modifyStudent(String no, int eng, int math) {
		getConn();
		String sql = "UPDATE student " // 수정쿼리만들기
				+ "SET eng_score = ?, " + "math_score = ? " + "WHERE stu_no = ?";
		try {
			psmt = conn.prepareStatement(sql); // prepare입력하고 -예외처리
			psmt.setInt(1, eng); // 매개변수 수 만큼 값 채워주기
			psmt.setInt(2, math);
			psmt.setString(3, no);
			int r = psmt.executeUpdate();// 처리된 건수 반환
											// (ex.이름 '홍길동'조회했는데 3명이면 r에 3이 반환된다 그러니 아래서 if(r==1)하면 false가 반환된다 (그러니 0보다
											// 크다로 지정 (한건부턴 다 true되어야되니까

			if (r > 0) { // 값이 많을 수 있으니까?굳이 1로 지정안하고0보다크면ㄷ으로 해도 됨
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// end of modify.

	// 5.삭제
	public boolean removeStudent(String name) { // 이름같은 사람 여러건 삭제되도록
		getConn();
		String sql = "DELETE FROM student " + "WHERE stu_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			int r = psmt.executeUpdate();

			if (r > 0) {
				for (int i = 0; i < students.length; i++) {
					if (students[i] != null && students[i].getStuName().equals(name)) {
						students[i] = null;
						break;
					}
				}
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void disconn() {
		try {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}//end of disconn()

} // end of class.
