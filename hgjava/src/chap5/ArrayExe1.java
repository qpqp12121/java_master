package chap5;

public class ArrayExe1 {

	public static void main(String[] args) {
		
		int a = 10;
		int[] ary = {10, 20, 33}; //�ʱⰪ ����
		//�迭 ���� �հ� ���ϱ�
		int sum = 0;
//		sum = ary[0] + ary[1] + ary[2];
//		System.out.println("�հ�� " + sum + "�Դϴ�.");

// 		for�� ����ؼ� �迭 ���� �� �հ� ���ϱ�		
		for(int i = 0; i < ary.length; i++) {    // i<= 2 �� �ص��Ǵµ� �׷� ���� ���� ���� �ٲ�ߵǴϺ���
			sum += ary[i];
		}
		System.out.println("�հ�� " + sum + "�Դϴ�.");
		
		
		
		int[] intAry = new int[5]; //������ ����� ����ϸ� 0���� ����
			System.out.println(intAry[0]);
		double[] heights = new double[3];
			System.out.println(heights[0]); //������ ����� ����ϸ� 0.0���� ����
		
		String[] names = new String[10];  //�ʱⰪ ���� ��� �� ����(10���� ���������)
		names[0] = "ȫ�浿";
		names[1] = "��浿";
		
		System.out.println(names[0]);
		System.out.println(names[2]); //���� �� �Ҵ�X (������ �ִ� ���¶� null���)
		
	}//end main
	
}//end class
