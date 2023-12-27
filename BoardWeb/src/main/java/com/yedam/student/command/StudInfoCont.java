package com.yedam.student.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class StudInfoCont implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// studentInfo이게jsp파일이름 (.tiles로끝나면tiles서블릿이실행됨)->제일먼저tiles.xml먼저읽음 거기에 WildCard student/들어오면 body부분만 값으로 들어온 거 넝ㅎ어줌
			req.getRequestDispatcher("student/studentInfo.tiles").forward(req, resp); 
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

		
		
	}

	
}
