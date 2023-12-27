package com.yedam.board.mapper;

import java.util.List;

import com.yedam.board.vo.BoardVO;

//sql쿼리문 호출하기 위한 인터페이스
public interface BoardMapper { //구현클래스가 xml파일

	List<BoardVO> selectList();  //1.목록
	BoardVO selectOne(int bno);  //2.단건조회
	int insertBoard(BoardVO vo); //3.등록
	int updateBoard(BoardVO vo); //4.수정
	int deleteBoard(int bno);    //5.삭제
	int updateCnt(int bno);      //6.조회수증가
	
}
