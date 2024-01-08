package com.yedam.reply.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replyList(int boardNo); //1.목록가져오기(몇번글에대한댓글인지
	List<ReplyVO> replyListPaging(@Param("boardNo")int boardNo, @Param("page")int page); //댓글페이징
	int deleteReply(int replyNo); //댓글삭제
	int insertReply(ReplyVO vo);//댓글등록
	ReplyVO selectReply(int replyNo); //단건조회-댓글등록시 이름등록되도록
	
	//페이지 계산하기 위한 전체건수 반환
	int selectCount(int boardNo);
	//차트 데이터(댓글자, 작성건수)
	List<HashMap<String, Object>> selectReplyCnt(); //키:칼럼이름, 값:데이터(칼럼2개밖에없어서 VO로 하면 귀찮으니 HashMap으로 키,값가져올수잇
}
