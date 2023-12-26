package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class BoardFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//등록화면 열어주는 기능만 (등록하는기능XXX)
		//페이지 이동(forward)
				RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/board/addBoardForm.jsp"); //이동할 페이지
				try{
					rd.forward(req, resp);
				}catch(ServletException | IOException e) {
					e.printStackTrace();
				}

	}

}
