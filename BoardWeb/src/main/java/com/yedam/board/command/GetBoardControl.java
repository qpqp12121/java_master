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
import com.yedam.reply.vo.PageDTO;

public class GetBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//글번호 누르면 - 상세조회되는 기능
		
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceMybatis();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));
		
		int totalCnt = 70;
		PageDTO dto = new PageDTO(1, totalCnt);
		
		req.setAttribute("vo", vo); // .setAttribute("속성이름", "값"): 선택한 요소의 속성 값을 정함
		req.setAttribute("page", dto); //XXXX이거 사용XXX setAttribute로 값 넘기니까 화면이 고정이라 => json 데이터로 사용함
		
		//페이지 이동
		RequestDispatcher rd = req.getRequestDispatcher("board/getBoard.tiles"); //이동할 페이지
		try{
			rd.forward(req, resp);
		}catch(ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
