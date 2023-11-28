package chap5;

import java.util.Scanner;

public class ����â {
	public static void main(String[] args) {

// ArrayExe2.
		
		//�迭 �����ϰ� 10-100���� �� �� 10������ ���� �迭�� �Ҵ�
		int[] array = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = (i + 1) * 10;
		}
		
		//�迭 �� 50���� ū ������ �հ�� ���
		int sum = 0;
		double avg = 0;
		int count = 0;
		
		for( int num : array) {
			if( num > 50 ) {
				sum += num;
				count++;
			}
		 
		}
		avg = sum * 1.0 / count; //������ 80���� �� �¾� ������ ���������
		     // �Ǽ��� ǥ���Ƿ��� ������ sum,count �� �� int���¶� �ϳ��� �Ǽ��� �ٲ��ֱ� -> sum * 1.0
		System.out.println("50���� ū ���� �հ�: " + sum);
		System.out.println("50���� ū ���� ���: " + avg);
		
		
// ArrayExe3.		
		
	// Q. "ȫ�浿" �� �� �� ������ ���϶�	
		
		String[] nameAry = { "ȫ�浿", "��浿", "�ڱ浿", "ȫ�浿", "Ȳ�浿"};
		
		String search = "ȫ�浿";
		int cnt = 0;
		
		for(String name : nameAry) {
			if(name.equals(search)) {
				cnt++;
			}
		}
		System.out.println(search + "�� �� " + cnt + "�� �Դϴ�");
	
		
    // Q. ���� ���� ���� ���ϱ�	
		
		int[] scores = {88, 68, 72, 89, 92, 70};
		
		int max = 0;
		
		//���for��
		for(int num : scores) {
			if(num > max) {
				max = num;
			}
		}
		System.out.println("���for��> ���� ���� ����: " + max + "��");
		
		//�Ϲ�for��
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] > max) {
				max = scores[i];
			}
		}
		System.out.println("�Ϲ�for��> ���� ���� ����: " + max + "��");

		
		
// WhileExe.		

	//Q. ���ڸ� �Է¹޾ƶ�. ���� quit ���ڸ� ������ �����ض�
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.print("���� �� �Է�>> ");
			
			String txt = scn.nextLine();
			if(txt.equals("quit")) {
				System.out.println("���α׷��� �����մϴ�");
				break;
			}
			System.out.println("�Է°�: " + txt);
		}

// ReferenceExe.		
	//Q.
		
		
		

		
		
		
		
		
		
		
		
		
		
		
	}//end of main
}//end of class
