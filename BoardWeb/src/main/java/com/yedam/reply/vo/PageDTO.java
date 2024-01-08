package com.yedam.reply.vo;

import lombok.Data;

/* 참고
   1 2 3 4 5  >>
<< 6 7 8 9 10 >> 
<< 11 12 13 14 15   

*/

@Data
public class PageDTO {
	
	//필드
	private int currPage;
	private int totalCnt;
	private boolean prev, next; //이전, 이후 페이지 여부
	private int startPage, lastPage; //현재페이지를 기준으로 첫,끝
	
	
	//생성자: 전체건수, 현재페이지 매개값2개
	public PageDTO(int page, int totalCnt) {
		this.currPage = page;
		this.totalCnt = totalCnt;
		
		//전체건수: 75건. 15페이지
		
		int realLast = (int)Math.ceil(totalCnt / 5.0); //전체건수의 마지막페이지 Math.ceil()더블타입
		
		this.lastPage = (int)Math.ceil(page / 5.0) * 5; //현재페이지의 마지막페이지(*5개씩보여지기)
		this.startPage = this.lastPage - 4; //현재페이지의 첫번째페이지
		this.lastPage = this.lastPage > realLast ? realLast : this.lastPage;
		
		
		this.prev = this.startPage > 1; //이전페이지 여부
		this.next = this.lastPage < realLast; //이후페이지 여부
		
	}


	@Override
	public String toString() {
		return "PageDTO [currPage=" + currPage + ", totalCnt=" + totalCnt + ", prev=" + prev + ", next=" + next
				+ ", startPage=" + startPage + ", lastPage=" + lastPage + "]";
	}
	
	
	
}
