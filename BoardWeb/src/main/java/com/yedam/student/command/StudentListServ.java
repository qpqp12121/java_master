package com.yedam.student.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceMybatis;
import com.yedam.student.vo.Student;


@WebServlet("/studentList")//url이라서 바꿔도 됨(밑에 servlet을 실행하기 위한 url)
public class StudentListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StudentListServ() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=utf-8"); //먼저나와야됨!
		PrintWriter out = response.getWriter();
		
/* 목록페이지(학생) */ //아래내용에서 href링크연결 없애고 & str += "<tr><td>+std.getStuNo()+"</td><td>"+ std.getStuNo()~~
/* 단건조회 --목록페이지에서 학번 누르면 개인정보 보여지도록*/		
		StudentService dao = new StudentServiceMybatis();
//		StudentService dao = new StudentServiceImpl(); //데이터가져오기
		List<Student> list = dao.studentList();
		
//		out.print("<table border='1'>"); --쓸때마다 사용해댜되니 변수에 담기
		String str = "<table border='1'>";
		str += "<thead><tr><th>학생번호</th><th>학생이름</th><th>영어점수</th><th>수학점수</th></tr></thead>"; //한칼럼
		str += "<tbody>";
		
		for(Student std : list) { //밑에 href링크 연결할 때 구분해줘야 됨 sno= 다음에 학번들어가고 "'>" ---href에는 url?sno=연결될값 (GetStudentServlet클래스 참조
			str += "<tr><td><a href='getStudentServlet?sno="+std.getStuNo()+"'>" + std.getStuNo() + "</a></td><td>" + std.getStuName() 
				   +"</td><td>" + std.getEngScore()+"</td><td>" + std.getMathScore()+"</td></tr>";
		}
		str += "<tbody></table>";	
		str += "<br><a href='student/inform.html'>등록하기</a>"; //등록하기 주소 누러서 inform페이지로 넘어가게
		out.print(str);
	}
		


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
