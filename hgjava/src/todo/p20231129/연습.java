package todo.p20231129;

public class 연습 {
	public static void main(String[] args) {
		
		//총합과 평균 구하기
		int[] score = {100, 88, 100, 100, 90};
		
		int sum = 0;
		double avg = 0f;
		
		for(int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		avg = sum / (double)score.length;
		
		System.out.println("score배열의 합계: " + sum + " 평균: " + avg);
		
		
		//최대값&최소값 구하기
		int[] score2 = {79, 88, 91, 33, 100, 55, 95};
		
		int max = score2[0];
		int min = score2[0];
		
		for(int i = 0; i < score2.length; i++) {
			if(score2[i] > max) {
				max = score2[i];
			}
			else if(score2[i] < min) {
				min = score2[i];
			}
		}
		System.out.println("최대: " + max + " 최소: "+ min);
		
		
	}//end of main.
	
	
	
}//end of class.
