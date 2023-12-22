package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		map.put("/main.do", new MainControl());
		map.put("/sub.do", new SubControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출."); //service있으면 doget,d
		String url = req.getRequestURI();
		String context = req.getContextPath();
		String path = url.substring(context.length());
		System.out.println(path);//테스트
		
		Control ctrl = map.get(path);
		ctrl.execute(req, resp);
		
	}
	
	public void destroy() {
		System.out.println("destroy() 호출."); //servers탭에서 stop시키면 호출됨
	}
	
	
	
}//end of class.
