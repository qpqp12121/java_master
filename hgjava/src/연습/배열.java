package 연습;

public class 배열 {
	public static void main(String[] args) {

		//5-3. 배열 arr에 담긴 모든 값을 더하는 프로글매
		int [] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("배열의 합계: " + sum);
		
		//5-5. 다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램
//		int[] ballArr = {1,2,3,4,5,6,7,8,9};
//		int[] ball3 = new int[3];
//		
//		for(int i = 0; i < ballArr.length; i++) {
//			int j = (int)(Math.random() * ballArr.length);
//			int tmp = 0;
//			
//			tmp = ballArr[i];
//			ballArr[i] = ballArr[j];
//			ballArr[j] = tmp;
//		}
//		System.out.println(b);
		
		
		
	}// end of main.
}// end of class.
