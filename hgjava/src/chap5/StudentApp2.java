package chap5;

import java.util.Scanner;

public class StudentApp2 {
	
	//addStudent�޼ҵ忡�� ���� ���� ����ؾ� �Ǵϱ� main �޼ҵ忡 �ִ� �� �� �ۿ����� ����ؾ� �Ǵ� �� �ű��
	static Scanner scn = new Scanner(System.in); // staticŸ���� �Ǿ�� ��� �����ؼ� static����
	static Student[] students = null;
	
	//switch case 2 : �ڵ� �ʹ� �� addStudent �޼ҵ�() ���� �ȿ� ����
	//break �� �ڵ����
	public static void addStudent() {
		System.out.println("�л����� �Է�>> ");
		for(int i = 0; i < students.length; i++) {
			Student student = new Student(); //�л����� �Է��� ���� // Student ��Ʈ�� ������ Ŭ���ϸ� student������ ����ִ� ������ �Ű���
			// Student : ������ Ÿ�� -- int num = 60; ���¶� ���� ( ������ �߰��ϰ� ������ StudentŬ���� �� ���� �Է�)
			System.out.print("- �̸�: ");
			student.name = scn.nextLine();
			System.out.print("- ����: ");
			student.score = Integer.parseInt(scn.nextLine());
			System.out.print("- ��/��: ");
			student.gender = scn.nextLine(); //StudentŬ���� �ȿ� name, score, gender �Ӽ������� ����
			
			students[i] = student; //students ������ .name�̶�.score���� �� �迭�� ����
		}
	}//end of addStudent()
	
	//case3
	public static void searchStudent() {
		System.out.print("��ȸ�� �̸��Է�>> ");
		String name = scn.nextLine();
		boolean exists = false;
		
		for(Student stdn : students) { // StudentŬ����(������ ����ִ� ��) //students�濡 student�Է¹��� �� �־�����ϱ�
			                           // students�迭�� ����� ���� �� �ݺ����� �ϳ��� ������� �а� ������ �����ض� 
			if(name.equals(stdn.name)) {
				System.out.println(" : �̸��� " + stdn.name + ", ������ " + stdn.score +"��");	
				exists = true;
			}
									
		}//for�� ��
		if(!exists) {
			System.out.println("ã�� �̸��� �����ϴ�.");
		}
	}//end of searchStudent
	
	//case4
	public static void analysis() {
		System.out.println("�м�>> ");
		int sumOfMen = 0, cntOfMen = 0;  //���л� ���л� ���� ���� ����// �������� �˾ƾ� ��� ���� �� ������ cout�� �����
		int sumOfWomen = 0, cntOfWomen = 0;
		
		// �ε��� �� �ʿ��ϸ� for�� ����ϰ�, �ε����� �ʿ������ Ȯ��for ����� ����
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
		System.out.println("���л��� ���: " + (sumOfMen * 1.0 / cntOfMen)); // �Ҽ������� ������ *1.0 �Ҽ��� �ϳ� ����� �ָ� ��
		System.out.println("���л��� ���: " + (sumOfWomen * 1.0 / cntOfWomen));
	}//end of analysis
	
	
	public static void modify() { //�̸��Է� �ϰ� - ������ (�տ��� �߸� ����)���� �����ؼ� �ֱ�
		                          //Ȯ��for���� �ε��� �� �� ã�Ƽ� for������

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
		}//end for
		
		
		
	}//end of modify()
	
	
	
	
	public static void main(String[] args) {
		//StudentApp���� �̸�,������ ���� ó���ߴµ� ��ȿ�����̶� �ٽ� �ѹ��� �ְ�
		//61�� ���� ����
		
		boolean run = true;
		int studentNum = 0; //�迭�� ũ�⸦ �����ϱ� ���� �뵵�� �� ����
		
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
				addStudent();
				
				break;
			case 3 : // " �л��̸� - ���� " ���·� ���
				searchStudent();
				break;
			 case 4 :
				analysis();
				break;
			 case 5 :
				 modify();
				 break;
			 case 6 :
				 System.out.println("�����մϴ�.");
				 run = false;				
			}// end of switch.
		}// end of while.

		
		
	}//end main
	
	
}//end class
