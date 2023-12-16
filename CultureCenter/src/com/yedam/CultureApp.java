package com.yedam;

import java.util.Scanner;

public class CultureApp {
	

		public static void main(String[] args) {

			Scanner scn = new Scanner(System.in);
			MemberDAO dao = new MemberDAO();

			// 로그인
			boolean run = true;
			while (run) {
				System.out.print("id 입력>> ");
				String id = scn.nextLine();
				System.out.print("pw 입력>> ");
				String pw = scn.nextLine();
				Member user = dao.logIn(id, pw);

//				if(user != null) {
//					System.out.println(user.getMemName()+"님 반갑습니다.");
//					System.out.println("(권한: " + user.getResponse() + ")");
//					System.out.println();
//					break;
//				}else {
//					System.out.println("로그인실패 *id,pw 확인하세요");
//				}

				if (user != null && user.getMemName().indexOf("user") != -1) {
					if (user != null && user.getMemName().indexOf("user") == -1) {
						System.out.println("관리자 계정으로 로그인되었습니다.");
						break;
					}
					System.out.println(user.getMemName() + "님 반갑습니다.");
					System.out.println("(권한: " + user.getResponse() + ")");
					break;
				} else {
					System.out.println("로그인실패 *id,pw를 확인하세요");
				}
			}

	///////////////////////////////		
			while (run) {
				System.out.println("1.회원정보 등록, 2.수업조회 & 수강신청 3.마이페이지");
				int menu = Integer.parseInt(scn.nextLine());

				switch (menu) {

				}
			}

		}// end of main.
}//end of class.		
