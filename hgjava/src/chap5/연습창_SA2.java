package chap5;

import java.util.Scanner;

public class ����â_SA2 {

 // StudentApp2. ���� �޼ҵ�� ����� �� �ڵ�		
			
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		Student[] students = null;
		boolean run = true;
		int studentNum = 0; 
	
		while(run) {
			System.out.println(" 1.�л��� 2.�л��̸�,�����Է� 3.��ȸ 4.�м�(���) 5.���� 6.����");
			int menu = scn.nextInt(); 
			scn.nextLine();   
			
			switch(menu) {
			case 1 :
				System.out.print("�л��� �Է�>> ");
				studentNum = Integer.parseInt(scn.nextLine()); 
				students = new Student[studentNum]; //�迭 ũ�� �����ϱ�
				break;
				
			case 2 :
				System.out.println("�л����� �Է�>> ");
				for(int i = 0; i < students.length; i++) {
					Student student = new Student(); 
					
					System.out.print("- �̸�: ");
					student.name = scn.nextLine();
					System.out.print("- ����: ");
					student.score = Integer.parseInt(scn.nextLine());
					System.out.print("- ��/��: ");
					student.gender = scn.nextLine(); 
					
					students[i] = student; //students ������ .name�̶�.score���� �� �迭�� ����
				}	
				break;
				
			case 3 : // " �л��̸� - ���� " ���·� ���
				System.out.print("��ȸ�� �̸��Է�>> ");
				String name = scn.nextLine();
				boolean exists = false;
				
				for(Student stdn : students) { 	                           
					if(name.equals(stdn.name)) {
						System.out.println(" : �̸��� " + stdn.name + ", ������ " + stdn.score +"��");	
						exists = true;
					}
											
				}//for�� ��
				
				if(!exists) {
					System.out.println("ã�� �̸��� �����ϴ�.");
				}
				break;
				
			 case 4 :
				 System.out.println("�м�>> ");
				 int sumOfMen = 0, cntOfMen = 0;  
				 int sumOfWomen = 0, cntOfWomen = 0;
					
				 for(Student stn : students) {
					if(stn.gender.equals("��")) {
					   sumOfMen += stn.score;
					   cntOfMen ++;
					}
					else if(stn.gender.equals("��")) {
						 sumOfWomen += stn.score;
						 cntOfWomen ++;
					}
				 }
				 System.out.println("���л��� ���: " + (sumOfMen * 1.0 / cntOfMen)); 
				 System.out.println("���л��� ���: " + (sumOfWomen * 1.0 / cntOfWomen));
				 break;
			 case 5 :
				 System.out.print("��ȸ�� �̸��Է�>> ");
				 String name = scn.nextLine();
				 boolean exists = false;
					
				 for(int i = 0; i < students.length; i++) {
					// �̸� ������ ������ �������� �Է�
				   if(name.equals(students[i].name)) {
					 System.out.print("������ ���� �Է�: ");
					 students[i].score = Integer.parseInt(scn.nextLine());
					 exists = true;
					}
						
				   if(!exists) {
					 System.out.println("ã�� �̸��� �����ϴ�.");
				   }
				 }
				 break;
				 
			 case 6 :
				 System.out.println("�����մϴ�.");
				 run = false;				
			}// end of switch.
		}// end of while.
	  }//end main
}//end class
	
	
	
