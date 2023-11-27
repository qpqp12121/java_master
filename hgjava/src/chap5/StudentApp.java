package chap5;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int studentNum = 0;
		int[] scores= null; //���� �迭 ���� int[] scores; ���� �� ���� ���� => int[] scores = null;�� �־���
		String[] names = null; //2�� �����Է��ϰ� ���� �������� �𸣱� ������ ���� �� ���� �̸�����(���� �迭����ŭ �ֱ�)
		
		
		// 1.�л��� 2.�����Է� 3.������ 4.�м�(�ְ�����, ���) 5.����
		
		boolean run = true;
		while(run) {
			System.out.println(" 1.�л��� 2.�����Է� 3.������ 4.�м�(�ְ�����, ���) 5.����");
			int menu = scn.nextInt(); //����ڰ� 3 �Է� �� Enter ġ�� �Է��� 3�� �޾Ƶ��̴°� int
			scn.nextLine();    //�ٵ� enter�� ���� �� �޾Ƶ鿩�� ��ٸ��� �ʰ� ���޾� ����--�׷��� enter���� �޾Ƶ��̰�
			
			switch(menu) {
			case 1 :
				System.out.print("�л����Է�>> ");
				studentNum = scn.nextInt();
				scores = new int[studentNum];
				names = new String[studentNum]; //���� �Է¹޴� ũ�⸸ŭ �Ȱ��� ����� �Ǵϱ�
				break;	
			case 2 :
				System.out.println("�����Է�>> ");
				for(int i = 0; i < scores.length; i++) {
					System.out.println("names[ " + i + " ]>> "); //���° ��ġ�� �̸�
					names[i] = scn.nextLine();
					System.out.println("scores[ " + i + " ]>> "); //���° ��ġ�� ����
					scores[i] = scn.nextInt();
					scn.nextLine(); //nextInt ���ڸ� ó���ϴϱ� enter�� ó���ϰ� nextLine ���޾� �־��ֱ�
				}
				break;
			case 3 :
				System.out.print("������>> ");
				for(int i = 0; i < scores.length; i++) {
					System.out.println("�̸��� " + names[i] + ", ������ " + scores[i] + "\n");
				}
				break;	
			case 4 :
				System.out.print("�м�>> ");
				//�ְ����� ���. ����
				int maxScore = 0;
				int sum = 0;
				double avg = 0; //avg = sum * 1.0 / scores.length;
				String maxName = "";
				
//				for(int num : scores) { //�̰ɷ� ���� �� maxScore���� ����ϰ� maxName�� ���� �� ����ؼ�? �Ʒ� �ݺ�������
//				 sum += num;
//				 if(maxScore < num) {
//					 maxScore = num;
//				 }
				
				for(int i = 0; i < scores.length; i++) { 
					sum += scores[i];
					if(maxScore < scores[i]) { //�̸�,������ �ϳ��� ������ ��� ������ Ŭ���� ����ؾ� �ȴ� �׷��� class���� Ȯ���ϱ�!
						maxScore = scores[i];
						maxName = names[i];
					}
				}	avg = sum * 1.0  / scores.length;  // �� �ϳ� �Ǽ��� �ٲ���� double�� ����			
		
				System.out.println("�ְ������� " + maxName + " => ����: " + maxScore + ", ���: " + avg);
				break;
			case 5 :
				System.out.print("����");
				run = false;
				
			}//end of switch.
			
		}//end of while.
		System.out.println("end of prog.");
		
		
		
		
	}//end main
}//end class
