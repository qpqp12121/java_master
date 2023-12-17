package b;

import java.util.List;
import java.util.Scanner;

public class CultureCenterApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		MemberDAO mdao = new MemberDAO();
		LectureDAO ldao = new LectureDAO();

		boolean run = true;
		boolean run2 = true;
		int menu = 0;

//로그인&회원가입 페이지		
		while (run) {
			System.out.println("ㅡㅡㅡㅡ[ 행복 문화센터 ]ㅡㅡㅡㅡ");
			System.out.println(" 1.로그인 | 2.회원가입 | 3.나가기 ");
			menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 로그인
				Member mem = null;
				while (run) {
					System.out.print("id 입력>> ");
					String id = scn.nextLine();
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
				String id = null;
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
				String birth = scn.nextLine();
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
			System.out.println(" 1.카테고리별 강의목록 | 2.수강신청 | 3.마이페이지 | 4.공지사항 | 5.로그아웃");
			menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:// 카테고리별 강의목록: 1)어학 2)운동/댄스 3)요리/디저트
				System.out.println(" 1)어학  2)운동/댄스  3)요리/디저트 4)음악/미술 5)컴퓨터");
				menu = Integer.parseInt(scn.nextLine());
				List<Lecture> lecAry;
				if (menu == 1) {
					lecAry = ldao.getLectureList();
					System.out.println();
					System.out.println("== 강의명 ======= 수강대상 == 수강기간 =============== ");
					for (Lecture lec : lecAry) {
						if (lec != null && lec.getCategory().contains("어학")) {
							lec.showInfo();
						}
					}
					System.out.println();
					break;
				} else if (menu == 2) {
					lecAry = ldao.getLectureList();
					System.out.println();
					System.out.println("== 강의명 ======= 수강대상 == 수강기간 =============== ");
					for (Lecture lec : lecAry) {
						if (lec != null && lec.getCategory().contains("운동/댄스")) {
							lec.showInfo();
						}
					}
					System.out.println();
					break;
				} else if (menu == 3) {
					lecAry = ldao.getLectureList();
					System.out.println();
					System.out.println("== 강의명 ======= 수강대상 == 수강기간 =============== ");
					for (Lecture lec : lecAry) {
						if (lec != null && lec.getCategory().contains("요리/디저트")) {
							lec.showInfo();
						}
					}
					System.out.println();
					break;
				} else if (menu == 4) {
					lecAry = ldao.getLectureList();
					System.out.println();
					System.out.println("== 강의명 ======= 수강대상 == 수강기간 =============== ");
					for (Lecture lec : lecAry) {
						if (lec != null && lec.getCategory().contains("음악/미술")) {
							lec.showInfo();
						}
					}
					System.out.println();
					break;
				} else {
					lecAry = ldao.getLectureList();
					System.out.println();
					System.out.println("== 강의명 ======= 수강대상 == 수강기간 =============== ");
					for (Lecture lec : lecAry) {
						if (lec != null && lec.getCategory().contains("컴퓨터")) {
							lec.showInfo();
						}
					}
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("로그아웃 완료\n\"행복문화센터를 이용해 주셔서 감사합니다.\"");
				run2 = false;

			}// end of switch;
//			run = false;

		} // end of while.

	}// end of main.
}// end of class.
