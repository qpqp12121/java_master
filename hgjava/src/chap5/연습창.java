package chap5;

import java.util.Scanner;

public class 연습창 {
	public static void main(String[] args) {

// ArrayExe2.
		
		//배열 생성하고 10-100까지 수 중 10단위의 값을 배열에 할당
		int[] array = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = (i + 1) * 10;
		}
		
		//배열 중 50보다 큰 수들의 합계와 평균
		int sum = 0;
		double avg = 0;
		int count = 0;
		
		for( int num : array) {
			if( num > 50 ) {
				sum += num;
				count++;
			}
		 
		}
		avg = sum * 1.0 / count; //지금은 80으로 딱 맞아 떨어져 상관없지만
		     // 실수로 표현되려면 지금은 sum,count 둘 다 int형태라 하나를 실수로 바꿔주기 -> sum * 1.0
		System.out.println("50보다 큰 수의 합계: " + sum);
		System.out.println("50보다 큰 수의 평균: " + avg);
		
		
// ArrayExe3.		
		
	// Q. "홍길동" 이 총 몇 명인지 구하라	
		
		String[] nameAry = { "홍길동", "김길동", "박길동", "홍길동", "황길동"};
		
		String search = "홍길동";
		int cnt = 0;
		
		for(String name : nameAry) {
			if(name.equals(search)) {
				cnt++;
			}
		}
		System.out.println(search + "은 총 " + cnt + "명 입니다");
	
		
    // Q. 제일 높은 점수 구하기	
		
		int[] scores = {88, 68, 72, 89, 92, 70};
		
		int max = 0;
		
		//향상for문
		for(int num : scores) {
			if(num > max) {
				max = num;
			}
		}
		System.out.println("향상for문> 제일 높은 점수: " + max + "점");
		
		//일반for문
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] > max) {
				max = scores[i];
			}
		}
		System.out.println("일반for문> 제일 높은 점수: " + max + "점");

		
		
// WhileExe.		

	//Q. 문자를 입력받아라. 만약 quit 문자를 만나면 종료해라
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.print("문자 값 입력>> ");
			
			String txt = scn.nextLine();
			if(txt.equals("quit")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			System.out.println("입력값: " + txt);
		}

// ReferenceExe.		
	//Q.
	
		
		

		
		
		
		
		
		
		
		
		
		
		
	}//end of main
}//end of class
