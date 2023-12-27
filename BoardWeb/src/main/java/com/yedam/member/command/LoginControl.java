package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//id, pw 입력->정상-> 목록으로 이동 (parm2개)
		//            비정상-> 로그인화면으로 다시

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberService svc = new MemberServiceImpl(); //멤버서비스에 기능있
		MemberVO vo = svc.login(id, pw); //사용자가 값 잘 넣어줬으면 vo에 값을 담아줄거고 아니면 null
		
		if(vo != null) {
			//세션객체 로그인정보 저장.
			HttpSession session = req.getSession();	//Session에 저장하면 웹브라우저 종료 전까지 계속 유지(req.setAttribute는 요청할 ㄷ때마다 만들엇다 없어지고 하는 
			session.setAttribute("logId", vo.getId()); //세션객체에 로그인 성공했을 경우 그 아이디 저장 
			session.setAttribute("logName", vo.getName());//세션활용하면 로그인이 안되어있으면옆화면에 로그아웃나오게하거나/ 로그인되어있으면 상단에 누구님환영나오던가 가능
			                                              //위 둘 다 세션에 담고 -> menu.jsp가서 작업해주고 if( ~~ 
			//글등록이름바꾸기
			
			try {
				resp.sendRedirect("boardList.do"); //로그인O 글목록으로
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			req.setAttribute("message", "아이디와 비밀번호를 확인하세요"); //logForm.jsp에서 attribute값 받아서 아이디비번틀리면 이 문구 출력되어 보여지도록(입력null아닐때)
			try {
				req.getRequestDispatcher("member/loginForm.tiles").forward(req, resp); //sendRedirect는 매개값으로 요청정보같은거못넘겨주는데
			} catch (ServletException |IOException e) {                                    //RequestDispatcher는 forward로 매개값 넘겨줄 수 있어서 사용
				e.printStackTrace();
			}
		}
		
		
	}

}
