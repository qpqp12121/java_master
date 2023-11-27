package chap5;

public class ArrayExe3 {
	public static void main(String[] args) {
		
		String[] nameAry = { "홍길동", "김길동", "박길동", "홍길동", "황길동"};
		
//   Q. "홍길동" 이 총 몇 명인지 구하라
		
		String search = "홍길동";
		int count = 0; 
		
/*    확장for문 
      : 확장 for문은 일반적인 for문과 달리 배열과 컬렉션에 저장된 요소들을 읽어오는 용도로만 사용할 수 있다.
	   + index에 접근할 필요가 있다면 일반for문으로 사용해야 된다! */
		for(String name : nameAry) { 
			if(name.equals(search)) {
				count++;
			}
		}
		System.out.println(search + "은 총 " + count + "명입니다.");
		
		
		
//    Q. 제일 높은 점수를 구해라		
		int[] scores = {88, 68, 72, 89, 92, 70};
		
		int maxScore = 0;
		
		//향상 for문 사용
		for(int num : scores) {
			if(maxScore < num) {
				maxScore = num;
			}
		}
		System.out.println("max값: " + maxScore);
		
		
		//일반 for문 사용
		for(int i = 0; i < scores.length; i++) {
			if(maxScore < scores[i]) { //[i] 안 넣어서 오류 떴었음
				maxScore = scores[i];
			}
		}
		System.out.println("max 값: " + maxScore);
		
		
	
	} //end main
	
	
} //end class
