package chap5;

public class ArrayExe2 {
	public static void main(String[] args) {
		
/*     < Q >
        1. ������ ���� �� �ִ� �迭�� ����( ������: intAry / ��: 10�� �㵵�� )
        2. intAry �迭�� 10������ 10 ~ 100���� �� �ֱ�
	    3. ���	                                                 */
		
	 // 1. �迭 ����
		int[] intAry = new int[10];
		
		
	 // 2. �迭 �ʱ�ȭ (�� �Ҵ�)	
		// int[] intAry = [ 10,20,30,40,50,60,70,80,90,100 ]; --�� �������� ��ȿ����
		
//    * for�� ����ؼ� �� �Ҵ�	
		for(int i = 0; i < intAry.length; i++) {
			intAry[i] = (i + 1) * 10;  // or i * 10 + 10;
		}

		
		
	// 3. ���	
/*     * Ȯ�� for�� ���
		 for( Ÿ�Ը� ������ : �迭�̸� ) {
		     �迭�� ����� ���� �� �ݺ����� �ϳ��� ������� ������ ������ ����ȴ�
		  }                                                           	*/	

		// �迭 �� 50���� ū ������ �հ� & ��� ���ϱ�
		int sum = 0; 
		double avg = 0;
		int count = 0;
		
		for(int num : intAry) { 
//			System.out.println(num); --num �ȿ� ������ ������ Ȯ���ϱ� ���� �ڵ� ����� ��
			
			if(num > 50) {
				sum += num;
				count++;
			}
		}
		avg = sum * 1.0 / count; //������ 80���� �� �¾� ������ ���������
	       // �Ǽ��� ǥ���Ƿ��� ������ sum,count �� �� int���¶� �ϳ��� �Ǽ��� �ٲ��ֱ� -> sum * 1.0
		
		System.out.println("50���� ū ���� �հ�: " + sum);
		System.out.println("50���� ū ���� ���: " + avg); //���� intAry.length�� ������ ������ 50���� ū �� ���� �ҰŴϱ� count�� ���� 50���� Ŭ ��� ���� �־��
		
		
		
		
	}//end main
}//end class
