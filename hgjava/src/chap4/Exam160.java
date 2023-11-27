package chap4;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		
		//����2 : 3�� ��� ��
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
		 if(i % 3 == 0) {
			sum += i;
		 }
		}
		System.out.println("3�� ��� ��: "+ sum);
		
		//����3 : while��, Math.random()
		while(true) {
			int num1 = (int)(Math.random()*6) +1;
			int num2 = (int)(Math.random()*6) +1;
			System.out.printf("(%d,%d)\n",num1, num2);
			if(num1+num2 == 5) {
				break;
			}
		}System.out.println("����");
		
		//����4
		for(int x = 1; x <= 10; x++){
			for(int y = 1; y <= 10; y++){
				if((4 * x + 5 * y) == 60){
					System.out.printf("(%d,%d)\n",x,y);
			}
			
		}
			
			
		//����5
		String star = "";	
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				star += "*";
			}
			star += "\n";
		}
		System.out.println(star);
		
     	//����6
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
		
		//����7
		boolean run = true;
		int balance = 0; //�ܰ� ��
		Scanner scanner = new Scanner(System.in);
		
		while(run) {      //run�� true�ϱ� ����ϰ�
		System.out.println("--------------------------------");
		System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
		System.out.println("--------------------------------");
		System.out.print("����>");
		int sNum = scanner.nextInt(); //���ڶ� �ٷ� nextInt()
		int money = 0; //�Է¹��� ���� nextInt�϶� ��������� nextLine�϶�, parseInt ��� ���� ���� �ٳ�ߵǴϱ� �ۿ��� int�� ���� 
		
		
		switch(sNum){
			case 1 : 
			 System.out.print("���ݾ�>");
			 money = scanner.nextInt();
			 balance += money; 
			 break;
		    
			case 2 : 
			 System.out.print("��ݾ�>");
	         money = scanner.nextInt();

	         if(money > balance) {
	        	 System.out.println("�ܰ����");
	         }else {
	        	 balance -= money;
	         }
	         break;
			
			case 3 : 
				System.out.print("�ܰ� > " + balance);
				break;
			
			case 4 : 
				System.out.println("���α׷� ����");
				run = false;
			}
					
		}
			
			
			
	}

}
}
