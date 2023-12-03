package 연습.Board;

import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		String id = null;
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1: //정보등록
				System.out.print("글번호");
				int no = Integer.parseInt(scn.nextLine());
				System.out.print("제목 입력>> ");
				String head = scn.nextLine();
				System.out.print("내용 입력>> ");
				String content = scn.nextLine();
			  
				Board board = new Board(no, head, content, id);
				
				if(BoardExe.addBoard(board)) {
					System.out.println("입력성공");
				}else {
					System.out.println("처리실패");
				}
				break;
				
			case 2:
				System.out.println("번호--제목--작성자--작성일시");
				for(Board boardli : BoardExe.getBoardList()) {
					if(boardli != null) {
						boardli.showInfo();					
					}
				}
				break;
				
			}//end switch
		}
		
		
		
		
	}

	
	
	
}//end class.
