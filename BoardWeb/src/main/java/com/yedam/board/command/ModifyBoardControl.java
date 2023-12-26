package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class ModifyBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		//2개 파라미터 받고 
		String bno = req.getParameter("bno");
		String content = req.getParameter("content");
		//저장. (타입 BoardVO니까)
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setContent(content);
		
		//BoardService의 modBoard()메서드로 파라미터 넘겨줄 것
		BoardService svc = new BoardServiceMybatis();
		
		//이동할 페이지
		try {
			if(svc.modBoard(vo)) {
				resp.sendRedirect("boardList.do");
			}else {
				resp.sendRedirect("modifyForm.do");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		

	}

}
