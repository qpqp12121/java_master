package todo.p20231205;

import java.util.Scanner;

public class BookApp {
	
	public static void main(String[] args) {
		
		BookExe exe = new BookExe();
		Scanner scn = new Scanner(System.in);
		
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1: //등록
				System.out.print("도서코드 입력>> ");
				String code = scn.nextLine();
				System.out.print("도서명 입력>> ");
				String name = scn.nextLine();
				System.out.print("저자 입력>> ");
				String writer = scn.nextLine();
				System.out.print("출판사 입력>> ");
				String comp = scn.nextLine();
				System.out.print("가격 입력>> ");
				int price = Integer.parseInt(scn.nextLine());
				
				Book bdt = new Book(code, name, writer, comp, price);
				
				if(exe.addBook(bdt)) {
					System.out.println("저장되었습니다.");
				}else {
					System.out.println("저장실패");
				}
				break;
			case 2: //목록
				System.out.println("도서코드\t도서명\t\t 저자\t가격"); //나중에 정렬보고 고치기
				for(Book bdlist : exe.bookList()) {
					if(bdlist != null) {
						bdlist.showInfo();
					}
				}
				break; 
			case 3: //수정
				System.out.print("수정할 도서코드 입력>> ");
				code = scn.nextLine();
				System.out.print("가격 수정>> ");
				price = Integer.parseInt(scn.nextLine());
				
				if(exe.modifyBook(code, price)) {
					System.out.println("수정되었습니다");
				}else {
					System.out.println("수정실패");
				}
				break;
				
			case 4: //삭제	
				System.out.print("삭제할 도서코드 입력>> ");
				code = scn.nextLine();
				if(exe.removeBook(code)) {
					System.out.println("삭제되었습니다");
				}else {
					System.out.println("삭제실패");
				}
				break;
			case 5: //종료
				System.out.println("종료합니다");
				run = false;
			}
		}
		
		
	}//end of main.

}//end of class.
