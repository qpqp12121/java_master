package chap5;

public class ArrayExe3 {
	public static void main(String[] args) {
		
		String[] nameAry = { "ȫ�浿", "��浿", "ȫ�浿", "�ڱ浿", "ȫ�浿", "Ȳ�浿"};
		
		String search = "ȫ�浿";
		int count = 0; //ȫ�浿 ������� ��µǵ���
		
		for(String name : nameAry) { 
		
			if(name.equals(search)) {
				count++;
			}
		}
		System.out.println(search + "�� �� " + count + "���Դϴ�.");
		
		
		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScore = 0;
		
		for(int num : scores) {
			if(maxScore < num) {
				maxScore = num;
			}
		}
		System.out.println("max�� : " + maxScore);
		
		
		for(int i = 0; i < scores.length; i++) {
			if(maxScore < scores[i]) {
				maxScore = scores[i];
			}
		}
		System.out.println("���� ū ���� : " + maxScore);
		
		
		
		//�л� ��, ����
		
		
		
		
		
		
	} //end main
	
	
} //end class
