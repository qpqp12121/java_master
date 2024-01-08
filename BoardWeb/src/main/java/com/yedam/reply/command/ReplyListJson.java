package com.yedam.reply.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;
import com.yedam.reply.vo.ReplyVO;

public class ReplyListJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//json데이터를 생성해서 반환
		resp.setContentType("text/json;charset=utf-8"); //한글나오도록젤먼저작성
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		page = page == null? "1" :page; //페이지값 안 넘어오면 임의로 1들어가게
		
		
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyListPaging(Integer.parseInt(bno), Integer.parseInt(page)); //(1)요청글번호 parameter로
		
		//[{"replyNo":4, "boardNo":2,"reply":"user1",... ] 형태로 만들어 주려고
		int cnt = list.size();
		String json = "[";
		for(int i = 0; i < cnt; i++) { //reply의 타입 String이라 따옴표 보기(일단reply까지만 만들어 봄)
			json += "{\"replyNo\":" + list.get(i).getReplyNo() 
					+ ",\"boardNo\":"+list.get(i).getBoardNo()
					+",\"reply\":\"" + list.get(i).getReply()
					+"\",\"name\":\"" + list.get(i).getName()
					+"\"}";
			//마지막데이터엔 , 없어야 됨
			if(i != cnt - 1) { //i초기값0이라
				json += ","; 
			}
		}
		json += "]";
		
		//최종적으로 응답정보 웹에 그려주기
		try {
			resp.getWriter().print(json); 
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
