package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
	 /* 369���� ( 1 ~ 50 ) */
     
	 // 3,6,9�� ����ִ� �� count�� �� (���������)	
	 int count = 0;  
	 // ���� 1~50���� �ݺ���
	 for(int i = 1; i <= 50; i++) {                         
	     count = 0;  //���� ���� ���� �ʱ�ȭ
	     if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) count ++;   // 1�� �ڸ��� 3,6,9 �ִ� �� ���� üũ	 
	     if(i/10 == 3 || i/10 == 6 || i/10 ==9) count ++;          // 10�� �ڸ��� 3,6,9 �ִ� �� ���� üũ
		   
		  //���� 0 -> ���� ��� / ���� 1 -> �� / ���� 2 -> ����
		   switch(count) {
			case 0 : System.out.print(i+"\t"); break;
			case 1 : System.out.print("��\t"); break;
			case 2 : System.out.print("����\t");
			}
		   
			if(i % 10 == 0) System.out.println();	  // �� �ٿ� 10���� ���
		}
	 
	 /* < ������ȯ > */
	 
	 //��ȯ�� �ݾ� �Է¹ޱ�
	 Scanner scanner = new Scanner(System.in);
		System.out.print("��ȯ�� �ݾ� : ");
		String num = scanner.nextLine();
		int money = Integer.parseInt(num);
		int remain = 0;
		
		System.out.println("500��¥�� : " + (money / 500) + "��");
		remain = money % 500;
		
		System.out.println("100��¥�� : " + (remain / 100) + "��");
		remain = remain % 100;
		
		System.out.println("50��¥�� : " + (remain / 50) + "��");
		remain = remain % 50;
		
		System.out.println("10��¥�� : " + (remain / 10) + "��");
		remain = remain % 10;
		
		System.out.println("��ȯ �ݾ� : " + (money-remain) + "��");
		System.out.println("���� �ݾ� : " + remain + "��");
		
		
	/* < ���� ���߱� 1~100���� > */
		
	 // 1~100���� �� �߻� (int�� �ޱ�)  int com = (Math.random()*100)+1;
		
//		boolean run = true;
//		 Scanner sc = new Scanner(System.in);
//			System.out.print("���� �Է� : ");
//			int com = (int)(Math.random()*100) + 1;
//			
//		While(run){
//			
//		}
		
	 //while(true){ mynum = sc.   �� �Է� �ޱ�};
	// 1.if (mynum == com ){ �����մϴ� break;	
		//if( mynum > sc ){ down} else{up
	 
		
		//for.. �߰���
		for(int i=0; i<=10; i++) {
			System.out.println("ddd");
		}
	
	 
	 
		  

	} // end main

} // end class
