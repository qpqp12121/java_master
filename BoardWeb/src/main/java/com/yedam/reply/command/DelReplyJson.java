package com.yedam.reply.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;

//1.해당되는 댓글번호 DB에서 삭제 -> 2.화면에서도 제거 (DB삭제는 Ajax호출)
//1번 DB삭제 기능을 다 만들고 여기서 control => 2.화면제거(jsp파일-getBoard)

public class DelReplyJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String rno = req.getParameter("rno");
		
		ReplyService svc = new ReplyServiceImpl();
		
		try {
		if(svc.removeReply(Integer.parseInt(rno))) {
			//결과값을 Json에 넘겨줘야 됨
			//{"retCode": "OK"}
			resp.getWriter().print("{\"retCode\": \"OK\"}");
			
		}else {
			//{"retCode": "NG"}
			resp.getWriter().print("{\"retCode\": \"NG\"}");
			
		}
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
