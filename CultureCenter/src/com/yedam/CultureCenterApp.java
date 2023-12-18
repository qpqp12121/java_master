package com.yedam;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CultureCenterApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		MemberDAO mdao = new MemberDAO();
		LectureDAO ldao = new LectureDAO();
		RegistrationDAO rdao = new RegistrationDAO();

		boolean run = true;
		boolean run2 = true;
		int menu = 0;

		String id = null;
		String birth = null;

//로그인&회원가입 페이지		
		while (run) {
			System.out.println("ㅡㅡㅡㅡ[ 행복문화센터 ]ㅡㅡㅡㅡ");
			System.out.println(" 1.로그인 | 2.회원가입 | 3.나가기 ");
			menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 로그인
				Member mem = null;
				while (run) {
					System.out.print("id 입력>> ");
					id = scn.nextLine();
					System.out.print("pw 입력>> ");
					String pw = scn.nextLine();

					mem = mdao.logIn(id, pw);

					if (mem != null) {
						System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
						System.out.println(mem.getMemName() + "님 반갑습니다.");
						break;
					} else {
						System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
						System.out.println("로그인 실패! \n※ 아이디/비밀번호를 확인하세요.");
					}
				}
				break;
			case 2: // 회원가입
				id = null;
				while (run) {
					System.out.println("ㅡㅡ회원가입ㅡㅡ");
					System.out.print("아이디 입력>> ");
					id = scn.nextLine();

					if (mdao.checkId(id)) {
						System.out.println(id + "는 이미 사용 중인 아이디 입니다.");
						continue;
					}
					run = false;
				}

				System.out.print("비밀번호 입력>> ");
				String pw = scn.nextLine();
				System.out.print("이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("생년월일 입력>> ");
				birth = scn.nextLine();
				System.out.print("휴대폰번호 입력>> ");
				String phone = scn.nextLine();

				mem = new Member(id, pw, name, birth, phone);
				if (mdao.memjoin(mem)) {
					System.out.println(name + "님 환영합니다");
				} else {
					System.out.println("회원가입 실패(확인)");
				}
				break;

			}// end of switch.
			run = false;
		} // end of while.

//회원이용페이지
		while (run2) {
			System.out.println(" 1.수강신청 | 2.수강조회 | 3.로그아웃");
			menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 수강신청
					System.out.println();
					System.out.print("원하는 카테고리를 입력하세요.");
					System.out.println("=============================");
					List<Lecture> cate = ldao.getCategory();
					for (Lecture li : cate) {
						li.showCategory();
					}
					System.out.println();
					System.out.print(">> ");
					String category = scn.nextLine();
					System.out.println("< " + category + " >");
					System.out.println("= 코드 = 강의명 ======= 수강대상 == 수강기간 =============== ");
					List<Lecture> allInfo;
					allInfo = ldao.getLectureList();
					for (Lecture lec : allInfo) {
						if (lec.getCategory().contains(category)) {
							lec.showInfo();
						}
					}
					System.out.println();
					System.out.println("신청할 수업의 코드를 입력하세요");
					System.out.print(">> ");
					
					
					boolean run3 = true;
					while (run3) {
						String code = scn.nextLine();
						Registration regist = new Registration(code, id);
						
						if (rdao.checkCode(code)) { //입력받은 코드번호 있는지 확인
							if (rdao.closeLec(code)) { //수강인원 초과로 신청X
								System.out.println("수강인원 초과로 신청 불가");
								System.out.println("다른 수업 선택>> ");
							} else if (rdao.ageCheck(code)) { //수강연령 확인
								if() {
									//birth랑 확인하기
								}
								
							} else if (rdao.addRegist(regist)) { //수강신청완료 테이블에 추가
								System.out.println("신청완료");
								break;
							} else {
								System.out.println("없는 수업코드");
								System.out.print("다시입력>> ");
							}
						}
					}
					run3 = false;
					break;
					
					
					
					//수강시간 데이터입력하기
					
					
			case 2: // 수강조회

				break;

			case 3:
				System.out.println("로그아웃 완료\n\"행복문화센터를 이용해 주셔서 감사합니다.\"");
				run2 = false;

			}// end of switch;
			run = false;

		} // end of while.

	}// end of main.
}// end of class.
