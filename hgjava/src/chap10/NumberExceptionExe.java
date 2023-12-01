package chap10;

import java.util.Scanner;

public class NumberExceptionExe {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("1.추가 2.삭제 3.종료");
			
			int menu = 0; //try안에 menu있어서 아래 switch에서 사용못하니 밖에 선언
			try {
				 menu = Integer.parseInt(scn.nextLine()); // -이 부분 숫자쳐야되는데 A문자 치면 NumberFormatException오류 발생하니 예외처리
			} catch (NumberFormatException e) {
				System.out.println("*숫자를 입력하세요*");
				menu = 1; //잘못되었을 때 어떻게 해야될지 적어야 됨. (만약 위에 int menu = 3으로 되어있어 버리면 숫자입력하세요 하고 바로 case3으로 가서 종료됨
			}
			switch (menu) {
			case 1:
				System.out.println("추가합니다.");
				break;
			case 2:
				System.out.println("삭제합니다.");

				break;
			case 3:
				System.out.println("종료합니다.");
				run = false;
				break;
			}
		}
		System.out.println("end of prog.");

		
		
		
	}// end main

}// end class
