package com.yedam.student.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class StudentListCont implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			//tiles.xml -> WILDCARD:student/* -> student/{1}.jsp //student밑에 studentList.tiles url들어오면 -> student밑에 있는 그 값을 받아서 그 값의 jsp파일보여주겠다(studentList.jsp)
			req.getRequestDispatcher("student/studentList.tiles").forward(req, resp);
		} catch (ServletException|IOException e) {
			e.printStackTrace();
		}

		
		
	}

}
