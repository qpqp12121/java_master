package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class LogoutControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//로그인할 때 만든 세션삭제(로그아웃기능)
		HttpSession session = req.getSession();
		session.invalidate();
		
		try {
			resp.sendRedirect("loginForm.do"); //로그아웃하면 이동할 곳 (다시 로그인화면으로
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
