package chap5;

public class ArrayExe2 {
	public static void main(String[] args) {
		
/*     < Q >
        1. 정수를 담을 수 있는 배열을 생성( 변수명: intAry / 값: 10개 담도록 )
        2. intAry 배열에 10단위로 10 ~ 100까지 값 넣기
	    3. 출력	                                                 */
		
	 // 1. 배열 생성
		int[] intAry = new int[10];
		
		
	 // 2. 배열 초기화 (값 할당)	
		// int[] intAry = [ 10,20,30,40,50,60,70,80,90,100 ]; --수 많아지면 비효율적
		
//    * for문 사용해서 값 할당	
		for(int i = 0; i < intAry.length; i++) {
			intAry[i] = (i + 1) * 10;  // or i * 10 + 10;
		}

		
		
	// 3. 출력	
/*     * 확장 for문 사용
		 for( 타입명 변수명 : 배열이름 ) {
		     배열에 저장된 값이 매 반복마다 하나씩 순서대로 읽혀져 변수에 저장된다
		  }                                                           	*/	

		// 배열 중 50보다 큰 값들의 합계 & 평균 구하기
		int sum = 0; 
		double avg = 0;
		int count = 0;
		
		for(int num : intAry) { 
//			System.out.println(num); --num 안에 값들이 들어갔는지 확인하기 위해 코드 사용해 봄
			
			if(num > 50) {
				sum += num;
				count++;
			}
		}
		avg = sum * 1.0 / count; //지금은 80으로 딱 맞아 떨어져 상관없지만
	       // 실수로 표현되려면 지금은 sum,count 둘 다 int형태라 하나를 실수로 바꿔주기 -> sum * 1.0
		
		System.out.println("50보다 큰 수의 합계: " + sum);
		System.out.println("50보다 큰 수의 평균: " + avg); //원래 intAry.length로 나누면 되지만 50보다 큰 수 값만 할거니까 count방 만들어서 50보다 클 경우 수를 넣어라
		
		
		
		
	}//end main
}//end class
