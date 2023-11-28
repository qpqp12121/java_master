package chap4;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		
		//문제2 : 3의 배수 합
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
		 if(i % 3 == 0) {
			sum += i;
		 }
		}
		System.out.println("3의 배수 합: "+ sum);
		
		//문제3 : while문, Math.random()
		while(true) {
			int num1 = (int)(Math.random()*6) +1;
			int num2 = (int)(Math.random()*6) +1;
			System.out.printf("(%d,%d)\n",num1, num2);
			if(num1+num2 == 5) {
				break;
			}
		}System.out.println("종료");
		
		//문제4
		for(int x = 1; x <= 10; x++){
			for(int y = 1; y <= 10; y++){
				if((4 * x + 5 * y) == 60){
					System.out.printf("(%d,%d)\n",x,y);
			}
			
		}
			
			
		//문제5
		String star = "";	
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				star += "*";
			}
			star += "\n";
		}
		System.out.println(star);
		
     	//문제6
		String star2 = "";
		for(int row = 1; row <= 4; row++) {
			for(int b = 1; b<= 4-row; b++) {
				star2 += " ";
			}
			for(int st = 1; st <= row; st++) {
				star2 += "*";
			}
			star2 += "\n";
		}
		System.out.println(star2);
		
		//문제7
		boolean run = true;
		int balance = 0; //잔고 방
		Scanner scanner = new Scanner(System.in);
		
		while(run) {      //run이 true니까 계속하게
		System.out.println("--------------------------------");
		System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
		System.out.println("--------------------------------");
		System.out.print("선택>");
		int sNum = scanner.nextInt(); //숫자라 바로 nextInt()
		int money = 0; //입력받은 돈이 nextInt일땐 상관없지만 nextLine일땐, parseInt 계속 같이 델고 다녀야되니까 밖에서 int로 선언 
		
		
		switch(sNum){
			case 1 : 
			 System.out.print("예금액>");
			 money = scanner.nextInt();
			 balance += money; 
			 break;
		    
			case 2 : 
			 System.out.print("출금액>");
	         money = scanner.nextInt();

	         if(money > balance) {
	        	 System.out.println("잔고부족");
	         }else {
	        	 balance -= money;
	         }
	         break;
			
			case 3 : 
				System.out.print("잔고 > " + balance);
				break;
			
			case 4 : 
				System.out.println("프로그램 종료");
				run = false;
			}
					
		}
			
			
			
	}

}
}