package chap5;

public class ArrayExe2 {
	public static void main(String[] args) {
	 // 1. 정수를 담을 수 있는 배열을 생성
     // 2. intAry => 10~100 값 넣기 (10단위로)
	 // 3. 출력	
		int[] intAry = new int[10];
		
		for(int i = 0; i < intAry.length; i++) {
			intAry[i] = (i + 1) * 10; //or i * 10 + 10;
		}
		
		/*
		< 확장for문 >
		  for(타입명 변수명 : 배열이름) {
		     배열에 저장된 값이 매 반복마다 하나씩 순서대로 읽혀져 변수에 저장된다
		   }                                                       */		

		//출력. 확장for구문
		int sum = 0; // 50보다 큰 수를 저장
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
		System.out.println("50보다 큰 수의 합계: " + sum);
		System.out.println("50보다 큰 수의 평균: " + avg); //원래 intAry.length로 나누면 되지만 50보다 큰 수 값만 할거니까 count방 만들어서 50보다 클 경우 수를 넣어라
		
		
		
		
		
		
		
		
	}//end main
}//end class
