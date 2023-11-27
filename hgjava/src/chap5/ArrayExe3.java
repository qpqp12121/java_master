package chap5;

public class ArrayExe3 {
	public static void main(String[] args) {
		
		String[] nameAry = { "홍길동", "김길동", "홍길동", "박길동", "홍길동", "황길동"};
		
		String search = "홍길동";
		int count = 0; //홍길동 몇명인지 출력되도록
		
		for(String name : nameAry) { 
		
			if(name.equals(search)) {
				count++;
			}
		}
		System.out.println(search + "은 총 " + count + "명입니다.");
		
		
		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScore = 0;
		
		for(int num : scores) {
			if(maxScore < num) {
				maxScore = num;
			}
		}
		System.out.println("max값 : " + maxScore);
		
		
		for(int i = 0; i < scores.length; i++) {
			if(maxScore < scores[i]) {
				maxScore = scores[i];
			}
		}
		System.out.println("제일 큰 값은 : " + maxScore);
		
		
		
		//학생 수, 점수
		
		
		
		
		
		
	} //end main
	
	
} //end class
