package todo.p20231127;

import java.util.Scanner;

public class BoardApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		//배열
		Board[] boards = new Board[100];
		
		boolean run =true;
		while(run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			
			case 1 : //정보등록
				System.out.print("게시글번호 입력>> ");
				int num = Integer.parseInt(scn.nextLine());
				System.out.print("제목 입력 >> ");
				String head = scn.nextLine();
				System.out.print("작성자 입력>> ");
				String who = scn.nextLine();
				System.out.print("내용 입력>> ");
				String contents = scn.nextLine();
				System.out.print("작성일시 입력>> ");
				String dateTime = scn.nextLine();
				
				//위에서 입력받은 정보들 담아서 하나의 인스턴스로(생성자)
				Board data = new Board(num, head, who, contents, dateTime);
				//값 boards 배열에 담기
				for(int i = 0; i < boards.length; i++) {
					if(boards[i] == null) {
						boards[i] = data;
						break;
					}
				}
				System.out.println("저장되었습니다.");
				break;
				
			case 2 : //목록출력
				
				break;
			
			case 3 : //상세조회
				break;
			
			case 4 : //종료
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}//end of switch
			
			
			
			
			
		}
		
		
		
	}
	
	
}
