package todo.p20231128;

import java.util.Scanner;

public class BoardApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		// 배열(board에 넣어놓음)
		Board ary = new Board();

		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {

			case 1: // 정보등록
				Board allData = new Board(); 
				
				System.out.print("게시글번호 입력>> ");
//				int num = Integer.parseInt(scn.nextLine());
				allData.setBN(Integer.parseInt(scn.nextLine()));
				
				System.out.print("제목 입력 >> ");
//				String head = scn.nextLine();
				allData.setBH(scn.nextLine());
				
				System.out.print("작성자 입력>> ");
//				String who = scn.nextLine();
				allData.setBW(scn.nextLine());
				
				System.out.print("내용 입력>> ");
//				String contents = scn.nextLine();
				allData.setBC(scn.nextLine());
				
				System.out.print("작성일시 입력>> ");
//				String dateTime = scn.nextLine();
				allData.setBDT(scn.nextLine());
				
				// 위에서 입력받은 정보들 담아서 하나의 인스턴스로(생성자)
				Board bd = new Board(setBDT(), );
				// 값 boards 배열에 담기
				for (int i = 0; i < boards.length; i++) {
					if (boards[i] == null) {
						boards[i] = allData;
						break;
					}
				}
				System.out.println("저장되었습니다.");
				break;

			case 2: // 목록출력
				System.out.println("<게시글 목록>");
				System.out.println("-------------------------");
				
				for(int i = 0; i < ary.length; i++) {
					if(boards[i] != null) {
						boards[i].showInfo();
					}
				}
				System.out.println("-------------------------");
				break;

			case 3: // 상세조회
				System.out.println("게시글 상세보기>> ");
				
//				for(int i = 0; i < boards.length; i++) {
//					if(boards[i] != null) {
//						boards[i].getBN();
//						boards[i].getBH();
//						boards[i].getBW();
//						boards[i].getBC();
//						boards[i].getBDT();
//					}
//				}
//				
				for(Board bd :ary.getBoardAllList()) {
					if(bd != null) {
						bd.showAllInfo();
					}
				}
				
				
				break;

			case 4: // 종료
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}// end of switch

		}

	}

}
