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
		String memBirth = null;

//로그인&회원가입 페이지		
		while (run) {
			System.out.println();
			System.out.println("〓〓〓〓〓 [ 행복 문화센터 ] 〓〓〓〓〓〓");
			System.out.println(" 1.로그인 | 2.회원가입 | 3.나가기 ");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 로그인
				Member mem = null;
				while (run) {
					System.out.print("아이디를 입력하세요\n>> ");
					id = scn.nextLine();
					System.out.print("비밀번호를 입력하세요\n>> ");
					String pw = scn.nextLine();

					mem = mdao.logIn(id, pw);

					if (mem != null) {
						System.out.println();
						System.out.println(" \"" + mem.getMemName() + "\"님 반갑습니다 :)");
						break;
					} else {
						System.out.println();
						System.out.println("※ 로그인 실패 ※");
						System.out.println("아이디와 비밀번호를 확인하세요\n---------------------");
					}
				}
				break;
			case 2: // 회원가입
				id = null;
				String pw = null;
				String name = null;
				memBirth = null;
				String phone = null;

				System.out.println();
				System.out.println("〓〓〓〓〓 < 회원가입 > 〓〓〓〓〓");
				while (true) {
					System.out.print("아이디를 입력하세요\n>> ");
					id = scn.nextLine();
					if (id.isBlank()) {
						System.out.println("※ 입력되지 않았습니다");
						System.out.println("--------------------------");
						continue;
					}
					if (mdao.checkId(id)) {
						System.out.println("\n※ 이미 사용 중인 아이디입니다 ※");
						System.out.println("--------------------------");
						continue;
					}
					break;
				}
				while (true) {
					System.out.print("비밀번호를 입력하세요\n>> ");
					pw = scn.nextLine();
					if (pw.isBlank()) {
						System.out.println("※ 입력되지 않았습니다");
						System.out.println("--------------------------");
						continue;
					}
					break;
				}
				while (true) {
					System.out.print("이름을 입력하세요\n>> ");
					name = scn.nextLine();
					if (name.isBlank()) {
						System.out.println("※ 입력되지 않았습니다");
						System.out.println("--------------------------");
						continue;
					}
					break;
				}

				while (true) {
					System.out.print("생년월일 8자리를 입력하세요 ( ex. 20001231 )\n>> ");
					memBirth = scn.nextLine();
					if (memBirth.isBlank()) {
						System.out.println("※ 입력되지 않았습니다");
						System.out.println("--------------------------");
						continue;
					}
					if (memBirth.length() != 8) {
						System.out.println("※ 생년월일을 잘못 입력하셨습니다");
						continue;
					}
					break;
				}
				while (true) {
					System.out.print("휴대전화번호를 입력하세요 (※숫자만 입력)\n>> ");
					phone = scn.nextLine();
					if (phone.isBlank()) {
						System.out.println("※ 입력되지 않았습니다");
						System.out.println("--------------------------");
						continue;
					}
					if (phone.length() != 11) {
						System.out.println("※ 휴대전화번호를 잘못 입력하셨습니다");
						continue;
					}
					break;
				}
				mem = new Member(id, pw, name, memBirth, phone);
				if (mdao.memJoin(mem)) {
					System.out.println();
					System.out.println(" \"" + name + "\"님 환영합니다 :D");

				}
				break;
			case 3:
				System.out.println("행복문화센터를 방문해 주셔서 감사합니다.");
				run = false;
				run2 = false;
			}// end of switch.
			break;
		} // end of while.
////////////////////////////////////////////////////////밑에 아예 실행 ㅌXXX
//회원이용페이지
		while (run2) {
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println(" 1.수강신청 | 2.마이페이지 | 3.로그아웃");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 수강신청
//				System.out.println();
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓 < 수강신청 > 〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				List<Lecture> cate = ldao.getCategory();
				for (Lecture li : cate) {
					li.showCategory();
				}

				System.out.println("\n〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				System.out.print("원하는 \"카테고리\"를 입력하세요\n>> ");
				String category = scn.nextLine();
				System.out.println();
				System.out.println("< " + category + " >");
				System.out.println("〓 코드 〓〓〓〓 강의명 〓〓〓 수강대상 〓〓〓〓〓〓〓 수강기간 〓〓〓〓〓〓〓 수강료 〓〓〓〓〓〓 \n");

				List<Lecture> allInfo;
				allInfo = ldao.getLectureList();
				for (Lecture lec : allInfo) {
					if (lec.getCategory().contains(category)) {
						lec.showInfo();
					}
				}
				System.out.println();

				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				while (true) {
					System.out.print("신청할 수업의 코드를 입력하세요\n>> ");
					String code = scn.nextLine();
					Registration regist = new Registration(code, id);

					if (rdao.checkCode(code)) { // 입력받은 수업코드 있는지 확인
						if (rdao.ageCheck(code, id)) { // 수강연령 제한
							if (rdao.closeLec(code)) { // 수강인원 초과로 신청X
								System.out.println("※ 수강인원 초과 ※\n다른 수업을 선택하세요\n");
							} else if (rdao.addRegist(regist)) {// 수강신청완료 테이블에 추가
								System.out.println("수강신청 완료! 신청해 주셔서 감사합니다\n");
								break;
							}

						} else {
							System.out.println("※ 수강대상이 아닙니다 ※ (연령확인)\n");
							continue;
						}
					} else {
						System.out.println("\n※등록되지 않은 수업코드입니다※ (다시 입력해 주세요)\n");
					}
				}
				break;

			case 2: // 마이페이지

				boolean runn = true;
				String phone = null;
				while (runn) {
					System.out.println("\n < 마이페이지 >");
					System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
					System.out.println(" 1.수강조회 | 2.수강취소 | 3.내정보수정 | 4.뒤로가기");// 수강조회 / 수강삭제 / 정보수정 /
					System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
					int menu2 = Integer.parseInt(scn.nextLine());

					if (menu2 == 1) {
						System.out.println(" < 수강신청 내역 >");
						System.out.println("〓코드 〓〓〓 강의명 〓〓〓〓〓 담당선생님 〓〓〓〓〓〓〓〓 수강기간 〓〓〓〓〓〓〓 수강료 〓〓〓〓〓 신청한 날짜 〓〓〓〓〓〓");
						List<MyPage> mylec = rdao.checkMine(id);
						for (MyPage mine : mylec) {
							if (mine != null) {
								mine.showInfo();

							}
						}
						System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓\n");
						continue;
					} else if (menu2 == 2) {
						while (true) {
							System.out.print("취소할 수업코드 입력>> ");
							String code = scn.nextLine();

							System.out.print("비밀번호 입력>> ");
							String pw = scn.nextLine();
							if (rdao.removeLec(pw, code)) {
								System.out.println("\n취소 완료!");
							} else {
								System.out.println("\n※ 취소 실패 ※ 수업코드와 비밀번호를 확인하세요");
								continue;
							}
							break;
						}

					} else if (menu2 == 3) {// 내정보수정(번호바꾸기)

						while (true) {
							System.out.print("수정할 휴대전화번호를 형식에 맞게 입력해 주세요 ( ex. 010-0000-0000 )\n>> ");

							phone = scn.nextLine();
							if (phone.length() != 13) {
								System.out.println("※ 수정 실패 ※ 휴대전화번호를 확인하세요\n");
								continue;
							}
							if (mdao.modifyPhone(phone, id)) {
								System.out.println("수정 완료되었습니다");
								break;
							}
						}
					} 
					else { //menu 4번: 나가기
						break;
					}
					runn = false;
				}
				break;//case 2.

			case 3:
				System.out.println(" 로그아웃 완료\n\"행복문화센터를 이용해 주셔서 감사합니다.\"");
				run2 = false;

			}// end of switch;
			run = false;

		} // end of while.

	}// end of main.
}
// end of class.
