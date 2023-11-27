package chap5;

public class ArrayExe1 {

	public static void main(String[] args) {
		
		int a = 10;
		int[] ary = {10, 20, 33}; //초기값 설정
		//배열 안의 합계 구하기
		int sum = 0;
//		sum = ary[0] + ary[1] + ary[2];
//		System.out.println("합계는 " + sum + "입니다.");

// 		for문 사용해서 배열 안의 값 합계 구하기		
		for(int i = 0; i < ary.length; i++) {    // i<= 2 로 해도되는데 그럼 값에 따라 숫자 바꿔야되니불편
			sum += ary[i];
		}
		System.out.println("합계는 " + sum + "입니다.");
		
		
		
		int[] intAry = new int[5]; //공간만 만들고 출력하면 0으로 나옴
			System.out.println(intAry[0]);
		double[] heights = new double[3];
			System.out.println(heights[0]); //공간만 만들고 출력하면 0.0으로 나옴
		
		String[] names = new String[10];  //초기값 말고 몇개의 값 들어갈지(10개의 공간만들기)
		names[0] = "홍길동";
		names[1] = "김길동";
		
		System.out.println(names[0]);
		System.out.println(names[2]); //아직 값 할당X (공간만 있는 상태라 null출력)
		
	}//end main
	
}//end class
