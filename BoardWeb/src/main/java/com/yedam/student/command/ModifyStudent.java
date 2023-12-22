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

@WebServlet("/modifyStudent")
public class ModifyStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//수정하는 화면 만들기(영어,수학점수)
	public ModifyStudent() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		// 파라미터 활용해서 조회.
		String sno = request.getParameter("sno");

		StudentService dao = new StudentServiceImpl();
		Student std = dao.getStudent(sno);
													 //3개파라미터(?sno=23-001&escore=33&mscore=55)
		String str = "<form action='updateStudent'>";//action =파라미터받아서 수정할 수 있도록 이동될 Servlet(//form태그는 사용자가 호출하면 학생상세정보 그대로 들고가서 점수수정할 수 있도록 사용
		str += "<table border='1'><caption>학생정보</caption>";
		str += "<tr><th>학번</th><td><input type='text'" + "readonly name='sno' value='"+std.getStuNo()+"'></td></tr>"; //학번,이름 수정할 수 없도록 read only//input태그에 학번넣은건 sno파라미터로 넘어가야돼서
		str += "<tr><th>이름</th><td>"+std.getStuName()+"</td></tr>";
		str += "<tr><th>영어</th><td><input type='number' name='escore' value='"+std.getEngScore()+"'></td></tr>";
		str += "<tr><th>수학</th><td><input type='number' name='mscore' value='"+std.getMathScore()+"'></td></tr>";
		str += "<tr><td><input type='submit' value='수정'></td></tr></table>";
		
		str += "</form>";
		
		response.getWriter().print(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
