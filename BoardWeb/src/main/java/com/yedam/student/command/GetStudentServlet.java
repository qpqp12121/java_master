package com.yedam.student.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceImpl;
import com.yedam.student.vo.Student;

//GetStudentServlet클래스로 만들어서 상속

@WebServlet("/getStudentServlet") //url(꼭경로넣어줘야됨 '/'

public class GetStudentServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// url?sno=23-010&sname=홍길동 url다음 ?뒤가 파라미터들어올내용(학번)
		resp.setContentType("text/html;charset=utf-8"); //한글ㄷ보여지게
		
		String sno = req.getParameter("sno");
		
		StudentService dao = new StudentServiceImpl(); // 인터페이스 = 구현하는클래스
		Student std = dao.getStudent(sno); //조회하면 리턴해주는 값 Student타입
		
		String str = "<table border='1'>";
		str += "<caption>학생정보</caption>";
		str += "<tr><th>학번</th><td>" + std.getStuNo() + "</td></tr>";
		str += "<tr><th>이름</th><td>" + std.getStuName() + "</td></tr>";
		str += "<tr><th>영어</th><td>" + std.getEngScore() + "</td></tr>";
		str += "<tr><th>수학</th><td>" + std.getMathScore() + "</td></tr>";
		str += "</table>";
		str += "<br><a href ='modifyStudent?sno="+std.getStuNo()+"'>수정화면</a>"; //학생상세정보)페이지에서 수정할 수 있는 링크로 연결되도록
		str += "<br><a href='studentList'>목록</a>";//목록가는 링크 //위아래다각각Servlet만들억음
		
		resp.getWriter().print(str); //사용자 페이지로 출력하도록.//->실행하고 url에 ?sno=23-001붙여서 실행
		
		
		
		
		
	}//doGet.

}// end of class.
