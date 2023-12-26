package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.command.AddBoardControl;
import com.yedam.board.command.BoardFormControl;
import com.yedam.board.command.BoardListControl;
import com.yedam.board.command.GetBoardControl;
import com.yedam.board.command.ModifyBoardControl;
import com.yedam.board.command.ModifyFormControl;
import com.yedam.board.command.RemoveBoardControl;
import com.yedam.board.command.RemoveFormControl;
import com.yedam.member.command.LoginControl;
import com.yedam.member.command.LoginFormControl;
import com.yedam.member.command.LogoutControl;

//컨트롤러: url -> 서블릿 실행. 

//@WebServlet("/url매핑..") --방법1 
//@WebServlet("*.do")  ---------BoardWeb에서 오른쪽마우스 Run As - 1run on Server실행 
								//- 하면 http://localhost/BoardWeb/열리고 뒤에 아무글자.do붙이고 엔터치면 밑에거 콘솔창에 실행
                                //또치면 service()호출만 실행 계속
public class FrontController extends HttpServlet {
	//생명주기: 생성자 -> init() -> service() -> destroy()
	
	Map<String, Control> map;
	
	public FrontController() {
		System.out.println("생성자 호출.");
		map = new HashMap<String, Control>();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출.");
		//게시판 관련
		map.put("/boardList.do", new BoardListControl()); //조회하고 결과를 boardList.jsp로 보냄
		map.put("/boardForm.do", new BoardFormControl());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/getBoard.do", new GetBoardControl());
		map.put("/modifyForm.do", new ModifyFormControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
		map.put("/removeForm.do", new RemoveFormControl()); //삭제화면
		map.put("/removeBoard.do", new RemoveBoardControl()); //삭제처리기능
		
		//회원관련
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
	}           
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); //요청정보에 한글이 있으면 알아서 계속 처리해 줌
		
		System.out.println("service() 호출."); //service있으면 doget,d
		String url = req.getRequestURI();
		String context = req.getContextPath();
		String path = url.substring(context.length()); // url'/'부터 읽을 수 있게 여기서 처리하는 것(만약 /없고 뒤부터 하고 싶으면 context.length() - 1 해주면 됨
		System.out.println(path);//테스트
		
		//여기가 계속 실행되는 것
		Control ctrl = map.get(path);
		ctrl.execute(req, resp);
		
	}
	
	public void destroy() {
		System.out.println("destroy() 호출."); //servers탭에서 stop시키면 호출됨
	}
	
	
	
}//end of class.
