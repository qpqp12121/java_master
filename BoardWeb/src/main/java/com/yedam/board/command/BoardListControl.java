package com.yedam.board.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;


public class BoardListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//게시글 목록 (데이터베이스 조회해서) -> boardList.jsp로 전달
		BoardService svc = new BoardServiceMybatis(); // 인터페이스 = 앞인터페이스를 구현하는 클래스
		List<BoardVO> list = svc.boardList(); //BSMybatis의 boardList()메서드 실행하여 목록(데이터) 가지고 오고 요청정보에 실어줌
		
		req.setAttribute("boardList", list); //(요청정보에 값담아서)넘겨주기 //요소.setAttribute("속성이름", "값"): 선택한 요소의 속성 값을 정함
		
		//페이지 이동(forward)
		RequestDispatcher rd = req.getRequestDispatcher("board/boardList.tiles"); //이동할 페이지
		try{
			rd.forward(req, resp);
		}catch(ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
