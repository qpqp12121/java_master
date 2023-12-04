package chap11.object;

public class MathExe {
	public static void main(String[] args) {
		// 양수일 땐 round, rint??s
		long result = Math.round(-1.5);
		System.out.println("round: " + result);

		long result2 = (long) Math.rint(-1.5); // double타입이라 long타입으로 강제변환 함
		System.out.println("rint: " + result);

		// 0 <= x < 1
		// 61~100
		for (int i = 1; i <= 10; i++) {
			int r = (int) (Math.random() * 40) + 61;
			System.out.println(r);
		}

		// 1~6까지 수 만들고 배열에다 넣기
		int[] numbers = new int[5];
		// 중복되지 않는 값을 배열에 저장
		// 1. 1~6 숫자 생성
		// 2. 생성된 값이 배열에 있는지 체크
		// 3. 없으면 추가, 배열에 값 다 저장되면 종료.

//		int random = 0;

//		for (int r = 1; r <= 6; r++) {
//			int random = (int) (Math.random() * 6) + 1; //랜덤숫자 구하고

		for (int i = 0; i < numbers.length; i++) {
			boolean exist = false;
			int no = (int) (Math.random() * 6) + 1;
			// 체크
			for (int j = 0; j < i; j++) {
				if (numbers[j] == no) {
					exist = true;
				}
			}
			//있으면저장X
			if (exist) {
				i--;
				continue;
			}
			//없으면 저장
			numbers[i] = no;
		}
		System.out.println(numbers);

	}// end of main.
}// end of class.
