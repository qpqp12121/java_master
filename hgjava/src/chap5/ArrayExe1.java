package chap5;

import java.util.Arrays;

public class ArrayExe1 {

	public static void main(String[] args) {
		
		
		//배열 선언과 생성
//      타입[] 변수이름 = new 타입 [길이];   --- 길이 = 들어갈 값의 개수 
		
		//배열의 초기화 : 배열의 각 요소에 처음으로 값을 저장
//      타입[] 변수이름 = { 50,60,70,80 }; ---꼭 대괄호사용! (대괄호 앞에 new 타입[] 생략해서 많이 씀)
		
		int[] intAry = new int[5]; 
		double[] heights = new double[3];
		
		 System.out.println(intAry[0]); //공간만 만들고 출력해서 0으로 나옴
		 System.out.println(heights[0]); //공간만 만들고 출력해서 0.0으로 나옴
		
		String[] names = new String[10];  //(10개의 공간만들기)
		names[0] = "홍길동";
		names[1] = "김길동";
		
		 System.out.println(names[0]);
		 System.out.println(names[2]); //아직 값 할당X (공간만 있는 상태라 null출력)
		
		 
		 
		 int[] ary = {10, 20, 33};
		 
		 //배열 출력  
//       * for문 사용해서 모든 요소 각각 출력    -- System.out.println(ary) 하면 안의 요소가 아닌 주소값이 나옴(배열은 참조변수이기때문)
		 for(int i = 0; i < ary.length; i++) {
			 System.out.println(ary[i]);
		 }
		 
//	     * Arrays클래스 이용 (多) -- 배열을 문자열 형식으로 만들어 출력(빨간줄 생기면 ctrl+shift+o = import문 생성)
		 System.out.println(Arrays.toString(ary)); //--문자열로 바꿔서 [ ] 대괄호까지 표현 됨
		 
		 
		 
		//배열의 합계 구하기
		int sum = 0;       // sum = ary[0] + ary[1] + ary[2]; 이렇게 해도 되나 수 많아지면 불편

//	 	* for문 사용해서 배열 안의 값 합계 구하기		
		for(int i = 0; i < ary.length; i++) {    
			sum += ary[i];
		}
		System.out.println("합계는 " + sum + "입니다."); 
		 	 
		 
		
	}//end main
	
}//end class