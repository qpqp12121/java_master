package chap5;

public class ArrayExe3 {
	public static void main(String[] args) {
		
		String[] nameAry = { "ȫ�浿", "��浿", "�ڱ浿", "ȫ�浿", "Ȳ�浿"};
		
//   Q. "ȫ�浿" �� �� �� ������ ���϶�
		
		String search = "ȫ�浿";
		int count = 0; 
		
/*    Ȯ��for�� 
      : Ȯ�� for���� �Ϲ����� for���� �޸� �迭�� �÷��ǿ� ����� ��ҵ��� �о���� �뵵�θ� ����� �� �ִ�.
	   + index�� ������ �ʿ䰡 �ִٸ� �Ϲ�for������ ����ؾ� �ȴ�! */
		for(String name : nameAry) { 
			if(name.equals(search)) {
				count++;
			}
		}
		System.out.println(search + "�� �� " + count + "���Դϴ�.");
		
		
		
//    Q. ���� ���� ������ ���ض�		
		int[] scores = {88, 68, 72, 89, 92, 70};
		
		int maxScore = 0;
		
		//��� for�� ���
		for(int num : scores) {
			if(maxScore < num) {
				maxScore = num;
			}
		}
		System.out.println("max��: " + maxScore);
		
		
		//�Ϲ� for�� ���
		for(int i = 0; i < scores.length; i++) {
			if(maxScore < scores[i]) { //[i] �� �־ ���� ������
				maxScore = scores[i];
			}
		}
		System.out.println("max ��: " + maxScore);
		
		
	
	} //end main
	
	
} //end class
