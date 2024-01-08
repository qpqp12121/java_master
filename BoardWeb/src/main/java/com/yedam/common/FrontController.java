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
import com.yedam.member.command.GetMemberControl;
import com.yedam.member.command.LoginControl;
import com.yedam.member.command.LoginFormControl;
import com.yedam.member.command.LogoutControl;
import com.yedam.member.command.MemberListControl;
import com.yedam.reply.command.AddReplyJson;
import com.yedam.reply.command.ChartForm;
import com.yedam.reply.command.Covid19Form;
import com.yedam.reply.command.DelReplyJson;
import com.yedam.reply.command.MapForm;
import com.yedam.reply.command.PagingListJson;
import com.yedam.reply.command.ReplyCountJson;
import com.yedam.reply.command.ReplyListJson;
import com.yedam.student.command.StudInfoCont;
import com.yedam.student.command.StudentListCont;

//컨트롤러: url -> 서블릿 실행. 

//@WebServlet("/url매핑..") --방법1 
//@WebServlet("*.do")  ---------BoardWeb에서 오른쪽마우스 Run As - 1run on Server실행 
								//- 하면 http://localhost/BoardWeb/열리고 뒤에 아무글자.do붙이고 엔터치면 밑에거 콘솔창에 실행
                                //또치면 service()호출만 실행 계속
//생명주기: 생성자 -> init() -> service() -> destroy()

public class FrontController extends HttpServlet {
	
	//필드
	Map<String, Control> map;
	//생성자
	public FrontController() {
		System.out.println("생성자 호출.");
		map = new HashMap<String, Control>();
	}
	
	// init() 초기값
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출.");
		
		//게시판 관련
		map.put("/boardList.do", new BoardListControl());     //1.목록조회
		map.put("/boardForm.do", new BoardFormControl());     //2-1.등록화면만!
		map.put("/addBoard.do", new AddBoardControl());       //2-2.등록기능
		map.put("/getBoard.do", new GetBoardControl());       //3.단건조회(상세화면)
		map.put("/modifyForm.do", new ModifyFormControl());   //4-1.수정화면만!
		map.put("/modifyBoard.do", new ModifyBoardControl()); //4-2.수정기능
		map.put("/removeForm.do", new RemoveFormControl());   //5-1.삭제화면만!
		map.put("/removeBoard.do", new RemoveBoardControl()); //5-2.삭제기능
		
		//회원관련
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		//관리자(회원목록보여지게)
		map.put("/memberList.do", new MemberListControl());
		map.put("/getMember.do", new GetMemberControl());
		
		
		//tiles관련
		map.put("/studentList.do", new StudentListCont());
		map.put("/studInfo.do", new StudInfoCont()); // studInfo.do?sno=23-002 (파라미터값넣어줘야됨)
		
		//reply 관련.(json포맷의 데이터를 생성해서 반환)
		map.put("/replyListJson.do", new ReplyListJson()); //bno
		map.put("/delReplyJson.do", new DelReplyJson()); //rno
		map.put("/addReplyJson.do", new AddReplyJson());
		
		//페이지 생성하기 위한 json데이터
		map.put("/pagingListJson.do", new PagingListJson()); //bno,page
		
		//chart
		map.put("/chart.do", new ChartForm()); //차트페이지
		map.put("/replyCountJson.do", new ReplyCountJson()); //json데이터 (Ajax쓰기) 
		
		//코로나19 관련
		map.put("/covid19.do", new Covid19Form());
		
		//지도api
		map.put("/map.do", new MapForm());
	}           
	
	
	// service() 여기가 실행되는 것
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); //요청정보에 한글이 있으면 알아서 계속 처리해 줌
		
		System.out.println("service() 호출."); //service있으면 doget,d
		String url = req.getRequestURI();
		String context = req.getContextPath();
		String path = url.substring(context.length()); // url'/'부터 읽을 수 있게 여기서 처리하는 것(만약 /없고 뒤부터 하고 싶으면 context.length() - 1 해주면 됨
		System.out.println(path);//테스트
		
		//url 확인하고 거기에 해당되는 Control로 넘겨줌
		Control ctrl = map.get(path);
		ctrl.execute(req, resp);
		
	}
	
	// destroy() 종료
	public void destroy() {
		System.out.println("destroy() 호출."); //servers탭에서 stop시키면 호출됨
	}
	
	
	
}//end of class.
