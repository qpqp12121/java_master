package chap3;

import java.util.Scanner; //���߿� ���� ��ƿ ����� �� ���Ƽ� import java.util.* (��ü�� �ٲٸ� ����)

public class Exam128 {

	public static void main(String[] args) {
	 // < ����4 >
		int penNum = 534;
		int stuNum = 30;
		
		//�л�1�� ������ ���� ����
		int ppsNum = penNum / stuNum; //����� �� ���� ������ �ޱ� (�ƴϸ� �Ҽ����� �����ϱ�)
		//�����ִ� ���� ��
		int rempNum = penNum % stuNum;
		
		System.out.printf("�л��� ���� �� : %d, ���� ���� �� : %d \n", ppsNum, rempNum); //println���� �ϸ� �ΰ��� �ޱ� �����ϴ�
		
	 // < ����5 > ����Ÿ�Ժ�ȯ
		
		
     // < ����6 >
		int value = 356;
		System.out.println(value/100*100);
	
	/* < ����7 > �ε��Ҽ��� ǥ����Ķ��� 
	    : (0.1�� 0.1���� ū �� �����ϱ� ����Ÿ�Ժ�ȯ --> (float)0.1 */
	
   // <����8> ��ٸ��� �ʺ� = ( ���� + �Ʒ��� ) * ���� / 2 ----->�Ҽ� �ڸ������� ���� �� �ֵ���
		int lenTop = 5;
		int lenBottom = 10;
		int height = 7;
		double area = ((lenTop+lenBottom) * height / 2.0); // �� �ϳ��� �Ǽ��� �־�� �Ǵϱ�
		System.out.println(area);
		
	// <����9>
		 // System.out.println(); �ڵ��ϼ� : syso + ctrl + space 
		//���� : ctrl + alt + ����Ű�Ʒ�
		//�� �� ����� : ctrl + d
		
		Scanner sc = new Scanner(System.in); //��ƿ��⿡ �־ ctrl + shift + O
		
		System.out.print("ù��° �� : ");
		double num1 = sc.nextDouble(); //���� Scanner String���� �޴µ� �޴� �� �Ǽ��ϱ� double�� �޴°ɷ�����
		
		System.out.print("�ι�° �� : ");
		double num2 = sc.nextDouble();
		
		if(num2 == 0) { //num2�� �����̴ϱ� �˾Ƽ� 0.0���� �޴´� (�׷��� ���� num2 == 0 || num2 ==0.0)���� �� �ʿ� ���� ���⶧���� int�� ���� double������ �ڵ�����ȯ�Ǵϱ�
			System.out.print("���: ���Ѵ�");
		}else {
			System.out.println("���: "+ (num1 / num2));
		}
	
		//<����10��>
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("���� ���� : " + var4);
		
		//<����11��>
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���̵�: ");
		String name = scanner.nextLine();
		
		System.out.print("�н�����: ");
		String strPassword = scanner.nextLine();
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")) {
			if(password == 12345) {
				System.out.println("�α��� ����");
			}else {
				System.out.println("�α��� ����: �н����尡 Ʋ��");
			}
		}else {
			System.out.println("�α��� ����: ���̵� �������� ����");
		}
		

	} //end main

} //end class
