package common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyInfoServlet") //MyInfoServlet이 url
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //생성자   
    public MyInfoServlet() {
        super();
    }
    //메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//content 타입: txt, html,json                  //밑에 웹페이지 html로 만들면 텍스트로 읽지 않도록 타입 넣어줘야됨
		
		//파라미터 확인.
		//?sno=23-010&sname=황철수&escore=80&mscore=85 (&: parameter구분자역할)
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname"); //sname이라는 파라미터를 가져와 변수에 담아라
		String escore = request.getParameter("escore");
		String mscore = request.getParameter("mscore");
		
		System.out.println("sno: " + sno + ", sname: "+ sname + ", escore: " + escore + ", mscore: "+mscore);
		
		//db 저장.
		Student std = new Student(sno, sname, Integer.parseInt(escore), Integer.parseInt(mscore));
		StudentDAO dao = new StudentDAO();
		
		boolean done = dao.addStudent(std);
		
		PrintWriter out = response.getWriter(); //getWriter() 반환타입이 PrintWriter (out.append로 해도되고)
		//response.getWriter().out.append("Served at: ").append(request.getContextPath()); //실행시 출력(getContextPath
		out.println("<h3>Welcome Servlet, 안녕</h3>"); //servlet은 한글x (servlet으로 웹페이지 만들수잇는데 잘X html로 사용
		out.println("<a href='index.html'>인덱스 이동</a>");
		
		if(done) {	
 			out.println("<script>alert('OK'); location.href='student/studentList.jsp'; </script>"); //location.href=''; 이동할 페이지 적으면 이동
		}else {
			out.println("<script>alert('Fail'); location.href='index.html'; </script>");
		}
	
	}//주소치거나 링크는 get방식으로 요청


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
