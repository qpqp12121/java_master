package chap5;

import java.util.Scanner;

public class WhileExe1 {
	public static void main(String[] args) {
		// for : �ݺ�Ƚ���� ������ �ִ� ��� ���
		
		
		// while : ������ �����ϴ� ���� �ݺ�
		
		Scanner scn = new Scanner(System.in); //System-Ű����� �Է��ϴ�
		
		while(true) {
			System.out.print("���� �� �Է�>>");
			
			String txt = scn.nextLine();
			if(txt.equals("quit")) { // quit ���� ������
				System.out.println("�����մϴ�.");
				break; //�ݺ��� ����������
			}
			System.out.println("�Է°��� " + txt);
		}
		System.out.println("end of prog.");
		
		
		
		
		
		
		
		
		
	}//end main
}//end class
