package chap5;

import java.util.Arrays;

public class ArrayExe1 {

	public static void main(String[] args) {
		
		
		//�迭 ����� ����
//      Ÿ��[] �����̸� = new Ÿ�� [����];   --- ���� = �� ���� ���� 
		
		//�迭�� �ʱ�ȭ : �迭�� �� ��ҿ� ó������ ���� ����
//      Ÿ��[] �����̸� = { 50,60,70,80 }; ---�� ���ȣ���! (���ȣ �տ� new Ÿ��[] �����ؼ� ���� ��)
		
		int[] intAry = new int[5]; 
		double[] heights = new double[3];
		
		 System.out.println(intAry[0]); //������ ����� ����ؼ� 0���� ����
		 System.out.println(heights[0]); //������ ����� ����ؼ� 0.0���� ����
		
		String[] names = new String[10];  //(10���� ���������)
		names[0] = "ȫ�浿";
		names[1] = "��浿";
		
		 System.out.println(names[0]);
		 System.out.println(names[2]); //���� �� �Ҵ�X (������ �ִ� ���¶� null���)
		
		 
		 
		 int[] ary = {10, 20, 33};
		 
		 //�迭 ���  
//       * for�� ����ؼ� ��� ��� ���� ���    -- System.out.println(ary) �ϸ� ���� ��Ұ� �ƴ� �ּҰ��� ����(�迭�� ���������̱⶧��)
		 for(int i = 0; i < ary.length; i++) {
			 System.out.println(ary[i]);
		 }
		 
//	     * ArraysŬ���� �̿� (��) -- �迭�� ���ڿ� �������� ����� ���(������ ����� ctrl+shift+o = import�� ����)
		 System.out.println(Arrays.toString(ary)); //--���ڿ��� �ٲ㼭 [ ] ���ȣ���� ǥ�� ��
		 
		 
		 
		//�迭�� �հ� ���ϱ�
		int sum = 0;       // sum = ary[0] + ary[1] + ary[2]; �̷��� �ص� �ǳ� �� �������� ����

//	 	* for�� ����ؼ� �迭 ���� �� �հ� ���ϱ�		
		for(int i = 0; i < ary.length; i++) {    
			sum += ary[i];
		}
		System.out.println("�հ�� " + sum + "�Դϴ�."); 
		 	 
		 
		
	}//end main
	
}//end class
