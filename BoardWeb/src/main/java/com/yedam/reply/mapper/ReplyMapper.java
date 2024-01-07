package com.yedam.reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replyList(int boardNo); //1.목록가져오기(몇번글에대한댓글인지
	List<ReplyVO> replyListPaging(@Param("boardNo")int boardNo, @Param("page")int page); //댓글페이징
	int deleteReply(int replyNo); //댓글삭제
	int insertReply(ReplyVO vo);//댓글등록
	ReplyVO selectReply(int replyNo); //단건조회-댓글등록시 이름등록되도록
}
