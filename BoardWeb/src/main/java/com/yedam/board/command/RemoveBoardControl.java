package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.common.Control;

public class RemoveBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//param("bno") 받아서 -> 삭제기능 실행 후 -> 목록
		String bno = req.getParameter("bno");
		
		//BoardService의 remBoard() 메서드 호출에서 파라미터 넘겨줄 거임
		BoardService svc = new BoardServiceMybatis();
		
		//이동할 페이지
		try {
		if(svc.remBoard(Integer.parseInt(bno))) { //int타입
			resp.sendRedirect("boardList.do");
		}else {
			resp.sendRedirect("remBoardForm.do");
		}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
