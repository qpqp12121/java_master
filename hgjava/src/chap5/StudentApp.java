package chap5;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		
/*	Q. ��ȣ �����ϸ� ���� ��µǰ� �����
	  < 1.�л��� 2.�����Է� 3.������ 4.�м�(�ְ�����, ���) 5.���� > */
		
		Scanner scn = new Scanner(System.in);
		int studentNum = 0;
		int[] scores= null; //���� �迭 ���� int[] scores; ���� �� ���� ���� => int[] scores = null;�� �־���
		String[] names = null; //2�� �����Է��ϰ� ���� �������� �𸣱� ������ ���� �� ���� �̸�����(���� �迭����ŭ �ֱ�)
		
		
		
		boolean run = true;
		while(run) {
			System.out.println(" 1.�л��� 2.�����Է� 3.������ 4.�м�(�ְ�����, ���) 5.���� ");
			int menu = scn.nextInt(); //����ڰ� 3 �Է� �� Enter ġ�� �Է��� 3�� �޾Ƶ��̴°� int
			scn.nextLine();    //�ٵ� enter�� ���� �� �޾Ƶ鿩�� ��ٸ��� �ʰ� ���޾� ����--�׷��� enter���� �޾Ƶ��̰�
			
			switch(menu) {
			case 1 :
				System.out.print("�л����Է�>> ");
				studentNum = scn.nextInt();   //������ studentNum, scores �������� int������ ����
				scores = new int[studentNum]; //�Է¹��� �л� �� ���̸�ŭ scores�� ���̸� ������ �Ǵϱ�
				names = new String[studentNum]; //�л� �� ���̸�ŭ ��ũ�� ������ �Ǵ� [studentNum]
				break;	
			case 2 :
				System.out.println("�����Է�>> "); // �����Է� �����߸� ������������, �������� ���� �Է��ؾߵǴ� �Ʒ��� ����
				for(int i = 0; i < scores.length; i++) {   //names,scores ������ [i] �ε��� ���� �����Ϸ��� �Ϲ� for�� ���
					System.out.println("names[ " + i + " ]>> "); //0��° ��ġ�� ���� �̸�����~ ��� => ���: �����Է�>> names[0]>>
					names[i] = scn.nextLine();
					System.out.println("scores[ " + i + " ]>> "); //0��° ��ġ�� ���� ��������~ ��� => ���: scores[0]>>
					scores[i] = scn.nextInt();
					scn.nextLine(); //���� ���� nextInt�� �޾� ���ڸ� ó���ϴϱ� enter�� ó���ϰ� nextLine ���޾� �־��ֱ�
				}
				break;
			case 3 :
				System.out.print("������>> ");
				for(int i = 0; i < scores.length; i++) {
					System.out.println("�̸��� " + names[i] + ", ������ " + scores[i] + "\n");
				}
				break;	
			case 4 :
				System.out.print("�м�>> "); //�м� ����� "�ְ������� ���" ������
				int maxScore = 0;
				int sum = 0;
				double avg = 0;  // avg = sum * 1.0 / scores.length;
				String maxName = "";				
				
				for(int i = 0; i < scores.length; i++) { 
					sum += scores[i];
					if(maxScore < scores[i]) {  //�̸�, ���� ���� �־� ȿ������ �ڵ� X 
						maxScore = scores[i];   //�̸�,������ �ϳ��� ������ ��� ������ Ŭ���� ����ؾ� �ȴ� �׷��� Student���Ϸ� Ŭ���� ������ �ְ� App2���� �۾��� �� Ȯ���ϱ�!
						maxName = names[i];
					}
				}	
				avg = sum * 1.0  / scores.length;  // �� �ϳ� �Ǽ��� �ٲ���� double�� ����			
		
				System.out.println("�ְ������� ���� " + maxName + " => ����: " + maxScore + ", ���: " + avg);
				break;
			case 5 :
				System.out.print("����");
				run = false;	
			}//end of switch.
			
		}//end of while.
		System.out.println("end of prog.");
		
		
		
		
	}//end main
}//end class
