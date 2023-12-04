package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListExe3 {

	public static void main(String[] args) {
		
		//회원등록(회원번호,이름,포인트)
		//1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료 //회원번호 넣고 포인트 한건바꾸기 /회원번호받아서 한건 삭제
		
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		List<Member> members = new ArrayList<>();
		
		
		while(run) {
			System.out.println("1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1://등록
				System.out.print("회원번호>> ");
				String memberNo = scn.nextLine();
				System.out.print("이름>> ");
				String memberName = scn.nextLine();
				System.out.print("포인트>> ");
				int point = Integer.parseInt(scn.nextLine());
				
				members.add(new Member(memberNo, memberName, point));
				break;
			case 2://조회
				System.out.print("조회할 이름 입력>> ");
				memberName = scn.nextLine();
				for(int i = 0; i < members.size(); i++) {
					if(members.get(i).getMemberName().indexOf(memberName) != -1) {
						for(Member mem : members) {
							if(mem != null) {
								System.out.println(mem);
							}
							
						}
						
					}
				}
				break;
//			case 3://포인트 변경	
//				System.out.println("회원번호 입력>> ");
//				int no = Integer.parseInt(scn.nextLine());
//				if(members.getMemberNo() == no) {
//					members.set(point);
//				}
//			case 4:
//				System.out.println("회원번호 입력>> ");
//				if()
			case 5:
				System.out.println("종료합니다");	
				run = false;	
			}//end switch
			
		 }//end while
		
		
	}//end of main.


	

}//end of class.
