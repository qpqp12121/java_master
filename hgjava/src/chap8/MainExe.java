package chap8;

import java.util.Scanner;

public class MainExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		DatabaseService svc = new OracleService();//new MySQLService(); //부모클래스의 변수유형에 자식클래스를 담앗ㅅ다 -상속이랑 비슷
		
		boolean run = true;
		while(run) {
			System.out.println("1.등록 2.수정 3.삭제 4.종료");
			int menu = scn.nextInt();
			switch(menu) {
			case 1://등록기능
				svc.add(); break;
			case 2://수정
				svc.modify(); break;
			case 3:	
				svc.remove(); break;
			}
		}
	
		
		
		
	}//end main.
	
}//end class.
