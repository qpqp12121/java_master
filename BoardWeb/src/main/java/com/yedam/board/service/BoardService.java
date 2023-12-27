package com.yedam.board.service;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardService {
	//업무로직.
	public List<BoardVO> boardList();     //1.목록
	public BoardVO getBoard(int bno);     //2.상세보기(단건)+조회수증가
	public boolean addBoard(BoardVO vo);  //3.등록
	public boolean modBoard(BoardVO vo);  //4.수정
	public boolean remBoard(int bno);     //5.삭제
	

}
