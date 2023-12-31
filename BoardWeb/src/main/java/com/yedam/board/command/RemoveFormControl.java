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

public class RemoveFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//단건조회 GetBoardControl이랑 같음 (이동페이지만 수정)
		String bno = req.getParameter("bno");

		BoardService svc = new BoardServiceMybatis();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));

		req.setAttribute("vo", vo); // .setAttribute("속성이름", "값"): 선택한 요소의 속성 값을 정함

		// 페이지 이동
		RequestDispatcher rd = req.getRequestDispatcher("board/remBoardForm.tiles"); // 이동할 페이지
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
