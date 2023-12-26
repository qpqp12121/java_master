package com.yedam.board.mapper;

import java.util.List;

import com.yedam.board.vo.BoardVO;

//sql쿼리문 호출하기 위한 인터페이스
public interface BoardMapper {

	//목록,단건조회,추가,수정,삭제,조회수증가
	List<BoardVO> selectList();
	BoardVO selectOne(int bno);
	int insertBoard(BoardVO vo);
	int updateBoard(BoardVO vo);
	int deleteBoard(int bno);
	int updateCnt(int bno);
	
}
