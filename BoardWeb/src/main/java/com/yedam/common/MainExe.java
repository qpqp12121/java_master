package com.yedam.common;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;
import com.yedam.reply.vo.PageDTO;

public class MainExe {
//만든 것 실행테스트
	public static void main(String[] args) {		
		
		//ReplyService테스트
//		ReplyService svc = new ReplyServiceImpl();
////		svc.replyList(4).forEach(reply -> System.out.println(reply));
//		svc.replyListPaging(8, 1).forEach(reply -> System.out.println(reply));
		
		int total = 75;
		PageDTO dto = new PageDTO(16, total); //(현재페이지,전체페이지) //현재페이지3이면 => 이전페이지X , 다음O ...
		
		System.out.println(dto.toString());
		
		ReplyService svc = new ReplyServiceImpl();
		List<HashMap<String, Object>> list = svc.chartData();
		
		Gson gson = new GsonBuilder().create();
		System.out.println(gson.toJson(list));

		System.out.println(list);
		
		
	
	}//end of main.
	
}//end of class.
