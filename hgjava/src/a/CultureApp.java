package a;

import java.util.Scanner;



public class CultureApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		boolean run = true;
		int menu = 0;
		
		// 로그인
		
		Member mem = null;
		String id;
		while (run) {
			System.out.print("id 입력>> ");
			id = scn.nextLine();
			System.out.print("pw 입력>> ");
			String pw = scn.nextLine();
			mem = dao.logIn(id, pw);

			if (mem != null) {
				System.out.println(mem.getMemName() + "님 반갑습니다.");
				System.out.println("(권한: " + mem.getResponse() + ")");
				System.out.println();
				break;
			} else {
				System.out.println("로그인실패 *id,pw 확인하세요");
			}
		}
			

		// 회원 화면
		if (mem.getResponse().equals("user")) {

			while (run) {
				System.out.println("1.회원가입, 2.수업조회 & 수강신청 3.마이페이지");
				menu = Integer.parseInt(scn.nextLine());

				switch (menu) {

				}
			}
		} else{ // 관리자화면
			while(run) {
				System.out.println("1.회원관리, 2.수업관리 3.강사관리");
				switch(menu) {
				case 1: System.out.println("1)회원 id, password 발급 2)회원 목록 3)수업별 회원리스트");
					if(menu == 1) {
						
					}
				}
			}//end of while.
				}//관리자끝
			
		

	}// end of main.
}
