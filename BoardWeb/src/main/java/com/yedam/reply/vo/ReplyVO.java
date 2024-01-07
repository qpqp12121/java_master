package com.yedam.reply.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private int replyNo;
	private int boardNo;
	private String reply;
	private String replyer;
	private Date replyDate;
	
	//댓글목록에 작성자 이름으로 보려고 추가함(member2테이블 name필드랑 조인) 
	private String name; 
}
