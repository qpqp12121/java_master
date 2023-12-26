package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//3개 파라미터 (jsp파일에 정의한) name: title/content/writer 받고 -> DB에 insert하고 -> 목록페이지 보여주기
		
		//3개 파라미터 받기
		String title = req.getParameter("title");
		String writer= req.getParameter("writer");
		String content = req.getParameter("content"); 
		
		//3개 변수활용해서 BoardVO타입에 저장
		BoardVO vo  = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		//BoardService의 addBoard()메서드의 파라미터로 넘겨줄 것
		BoardService svc = new BoardServiceMybatis();
		
		//이동할 페이지
		try {
			if(svc.addBoard(vo)) {
				resp.sendRedirect("boardList.do");
			}else {
				resp.sendRedirect("boardForm.do");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}//end of class.
