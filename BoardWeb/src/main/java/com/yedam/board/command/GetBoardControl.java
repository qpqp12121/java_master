package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class GetBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//글번호 누르면 - 상세조회되는 기능
		
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceMybatis();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));
		
		req.setAttribute("vo", vo); // .setAttribute("속성이름", "값"): 선택한 요소의 속성 값을 정함
		
		//페이지 이동
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/board/getBoard.jsp"); //이동할 페이지
		try{
			rd.forward(req, resp);
		}catch(ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
