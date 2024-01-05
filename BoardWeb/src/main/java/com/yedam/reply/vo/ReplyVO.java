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
	private String name; //댓글목록에 작성자 이름으로 보려고
}
