package chap5;

public class ArrayExe2 {
	public static void main(String[] args) {
	 // 1. ������ ���� �� �ִ� �迭�� ����
     // 2. intAry => 10~100 �� �ֱ� (10������)
	 // 3. ���	
		int[] intAry = new int[10];
		
		for(int i = 0; i < intAry.length; i++) {
			intAry[i] = (i + 1) * 10; //or i * 10 + 10;
		}
		
		/*
		< Ȯ��for�� >
		  for(Ÿ�Ը� ������ : �迭�̸�) {
		     �迭�� ����� ���� �� �ݺ����� �ϳ��� ������� ������ ������ ����ȴ�
		   }                                                       */		

		//���. Ȯ��for����
		int sum = 0; // 50���� ū ���� ����
		double avg = 0;
		int count = 0;
		
		for(int num : intAry) { 
			System.out.println(num);
			
			if(num > 50) {
				sum += num;
				count++;
			}
		}
		avg = sum / count;
		System.out.println("50���� ū ���� �հ�: " + sum);
		System.out.println("50���� ū ���� ���: " + avg); //���� intAry.length�� ������ ������ 50���� ū �� ���� �ҰŴϱ� count�� ���� 50���� Ŭ ��� ���� �־��
		
		
		
		
		
		
		
		
	}//end main
}//end class
