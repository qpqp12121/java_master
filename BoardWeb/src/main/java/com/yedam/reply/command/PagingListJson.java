package com.yedam.reply.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;
import com.yedam.reply.vo.PageDTO;

public class PagingListJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//bno, page (몇번게시글에대한,페이지인지)-Json데이터 생성
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		ReplyService svc = new ReplyServiceImpl();
		int total = svc.getTotalCnt(Integer.parseInt(bno));
		
		PageDTO dto = new PageDTO(Integer.parseInt(page), total); //생성자에 파라미터(페이지, 전체건수)
		Gson gson = new GsonBuilder().create(); //객체타입을 =>문자로 바꿔서 전송
	
		try {
			resp.getWriter().print(gson.toJson(dto));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
