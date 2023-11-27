package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
	 /* 369게임 ( 1 ~ 50 ) */
     
	 // 3,6,9가 들어있는 수 count할 방 (변수만들기)	
	 int count = 0;  
	 // 숫자 1~50까지 반복문
	 for(int i = 1; i <= 50; i++) {                         
	     count = 0;  //다음 수를 위한 초기화
	     if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) count ++;   // 1의 자리에 3,6,9 있는 수 개수 체크	 
	     if(i/10 == 3 || i/10 == 6 || i/10 ==9) count ++;          // 10의 자리에 3,6,9 있는 수 개수 체크
		   
		  //개수 0 -> 숫자 출력 / 개수 1 -> ♥ / 개수 2 -> ♥♥
		   switch(count) {
			case 0 : System.out.print(i+"\t"); break;
			case 1 : System.out.print("♥\t"); break;
			case 2 : System.out.print("♥♥\t");
			}
		   
			if(i % 10 == 0) System.out.println();	  // 한 줄에 10개씩 출력
		}
	 
	 /* < 동전교환 > */
	 
	 //교환할 금액 입력받기
	 Scanner scanner = new Scanner(System.in);
		System.out.print("교환할 금액 : ");
		String num = scanner.nextLine();
		int money = Integer.parseInt(num);
		int remain = 0;
		
		System.out.println("500원짜리 : " + (money / 500) + "개");
		remain = money % 500;
		
		System.out.println("100원짜리 : " + (remain / 100) + "개");
		remain = remain % 100;
		
		System.out.println("50원짜리 : " + (remain / 50) + "개");
		remain = remain % 50;
		
		System.out.println("10원짜리 : " + (remain / 10) + "개");
		remain = remain % 10;
		
		System.out.println("교환 금액 : " + (money-remain) + "원");
		System.out.println("남은 금액 : " + remain + "원");
		
		
	/* < 숫자 맞추기 1~100사이 > */
		
	 // 1~100까지 수 발생 (int로 받기)  int com = (Math.random()*100)+1;
		
//		boolean run = true;
//		 Scanner sc = new Scanner(System.in);
//			System.out.print("숫자 입력 : ");
//			int com = (int)(Math.random()*100) + 1;
//			
//		While(run){
//			
//		}
		
	 //while(true){ mynum = sc.   수 입력 받기};
	// 1.if (mynum == com ){ 축하합니다 break;	
		//if( mynum > sc ){ down} else{up
	 
		
		//for.. 추가함
		for(int i=0; i<=10; i++) {
			System.out.println("ddd");
		}
	
	 
	 
		  

	} // end main

} // end class
