package chap1;

import java.io.IOException;
import java.util.Scanner;

public class Hello {

	public static void main(String[] args) throws IOException {
		System.out.println("hello java");
		
		int x = 5;
		int y = x + 10;
		System.out.println(y);
		
		double z = 3.5; //�Ǽ����� --�ڹٿ��� ������ Ÿ�Կ� �´� ������ ���
		System.out.println(z);
		System.out.println("y = " + y);
		
		//������ �� ��ȯ
		x = 3; //���� �̹� ����Ǿ��־� int ���� ����
		y = 10;
		
		//�� ��ȯ
		int temp = y; //x�� y�� ������� �Ŵϱ� �켱 y���� �� ������ ���ؼ� �ǽ�
		y = x; // �׸��� x���� y�� ������ '3'����
		x = temp; //temp�� ������ ���� y ���� �� '10'�� �ٽ� x�� �ֱ�
		
		//���
		System.out.println("x = " + x + " y = "+ y);
		
		
		//<�⺻Ÿ��>
		//ũ����� : byte -> short -> char(����ǥ��X) -> int -> long
		char charData = 'a';
		int intData = charData;
		System.out.println("char: " + charData + ", int: " + intData); //(a�� �ڵ尪�� 97��)
		
		char c1 = 'a';
		int c2 = c1 + 2; // �ڵ�Ÿ�� ��ȯ ----------c1�� 'a'�ϱ� c1+1 �ϸ� b������ 
		char c3 = (char)c2; // ����Ÿ�� ��ȯ
		System.out.printf("c2���� %d, c3���� %s \n",c2,c3); //charŸ���� ���ڷ� ��µǴ� %s�� �޾��ָ� �� --("format",����,����...)
		
		x = 5;
		y = 2;
		double result = (double)x / y;  //87p 6��
		System.out.println(result);
		
		double v1 = 3.5;
		double v2 = 2.7;
		int result2 = (int)(v1 + v2); //87p 8��
		System.out.println(result2);
		
		long var1 = 2L; //88p 9��
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9"; //string�̴ϱ� �Ǽ��� �����
		int result3 = (int)(var1 + var2 + var3) + (int)(Double.parseDouble(var4)); 
		System.out.println(result3);		
		
		//ǥ���Է� : Ű���� = > System.in.read()
		//�ѱ��ڸ� �о����
		
//		int keyCode;
//		while(true) {
//			keyCode = System.in.read(); //������ �ߴµ� �׷� throws�� �ؼ� IOException(7������)
//			System.out.println("keyCode : " + keyCode);
//			if(keyCode == 113) { //�ܼ�â���� q�Է��ϸ� keycode�� 113�̶� ���� �Է������
//				break;
//			}
//		}
//		System.out.println("����"); //System.in�� ���⼭ ����ߴµ� �ؿ��� �� �����ؼ� �ּ�ó���س���
		
		//���ڿ� �Է� -> Scanner Ŭ���� -> ��ü�� �����ؼ� ���
		String scinput;
		Scanner sc = new Scanner(System.in); //ctrl + shift + O : scannerŬ���� ����ϱ� ���� ����� �ҷ����� �� 4������)
		while(true) {
			System.out.print("�̸� �Է� :"); //println�ϸ� �����ٿ� �ۼ��Ǵϱ� �׳� print��
			scinput = sc.nextLine();
			
			if(scinput.equals("q")) {
				break;
			}
			System.out.println("�� �̸��� " + scinput);
		}
		System.out.println("����");
		
		System.out.print("�� �Է� : ");
		scinput = sc.nextLine();
		System.out.println(Integer.parseInt(scinput) + 10); //�׳� ScannerŬ������ scinput + 10�ϸ� ���ڿ��� 1010����.�׷��� ���ڷ� ������Ű��
		
		
		sc.close();
		
		
		
		
		
		
		
	} // end main method

} //end class ������ ��(helloŬ����)
