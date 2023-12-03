package 연습;

import java.util.Scanner;

public class 조건반복 {

	public static void main(String[] args) {

/* 125p 4단원 조건,반북문 */
		// 1~20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합
//		int sum = 0;
//		for (int i = 1; i <= 20; i++) {
//			if (!(i % 2 == 0 || i % 3 == 0)) {
//				sum += i;
//			}
//		}
//		System.out.println("총합은 " + sum);
		
		// 1+(1+2)+(1+2+3)+ ... +(1+2+3+...+10)의 결과값
//		int sum = 0;
//		int totalSum = 0;
//		for(int i = 1; i <= 10; i++) {
//			sum += i;
//			totalSum += sum;
//		}
//		System.out.println("총합은 " + totalSum);
		
		// 1+(-2)+3+(-4)+5+(-6)... 해서 몇까지 더해야 총합이 100이상이 되는지 구하시오
//		int sum = 0;
//		int s = 1; //값의 부호를 바꿔주는데 사용할 변수
//		int num = 0;
//				
//		for(int i = 1; sum < 100; i++, s = -s) {
//			num = i * s;
//			sum += num;
//		}
//		System.out.println("몇까지 더해야? " + num + " 총합은 " + sum);
		
		//for문 while문으로 변경
//		for(int i = 0; i <= 10; i++) {
//			for(int j = 0; j <= i; j++) {
//				System.out.println("*");
//				System.out.println();
//			}
//		}
//		int i = 0;
//		while(i <= 10) {
//			int j = 0;
//			while(j <= i) {
//				System.out.println("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
		// 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램
//		for(int i = 1; i <= 6; i++) {
//			for(int j = 1; j <= 6; j++) {
//				if(i+j == 6) {
//					System.out.println("(" + i + "," + j + ")");
//				}
//			}
//		}
		
		// Math.random() 이용해서 1~6사이의 임의의 정수를 변수 value에 저장하는 코드 완성해라
//		int value = (int)(Math.random() * 6) + 1;
//		System.out.println("value = " +value);
		
		//int타입의 변수 num이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드 완성해라
		//만약 변수num의 값이 12345라면, 1+2+3+4+5의 결과인 15를 출력해라
//		int num = 12345;
//		int sum = 0;
//		
//		while(num >0) {
//			sum += num % 10; 
//			num /= 10;
//		}
//		System.out.println("sum = "+ sum);
		
		//숫자맞추기 게임(1~100)
//		Scanner scn = new Scanner(System.in);
//		
//		int answer = (int)(Math.random()*100) + 1;
//		int num = 0;
//		int count = 0;
//		
//		do {
//			count ++;
//			System.out.println("1~100까지 사이의 값을 입력하세요");
//			num = scn.nextInt();
//			
//			if(num > answer) {
//				System.out.println("더 작은 수를 입력하세요");
//			}else if(num < answer) {
//				System.out.println("더 큰 수를 입력하세요");
//			}else {
//				System.out.println("정답입니다");
//				System.out.println("시도 횟수는: " + count + "번입니다.");
//				break;
//			}	
//		} while(true);
		
		
		
		

	}// end main.
}// end class.
