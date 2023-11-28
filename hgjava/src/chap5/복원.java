package chap5;

public class 복원 {
	
//	package chap5;
//
//	import java.util.Arrays;
//
//	public class ArrayExe1 {
//
//		public static void main(String[] args) {
//
//			int a = 10;
//			int[] ary = {10, 20, 33}; //초기값 설정
//			//배열 안의 합계 구하기
//			int sum = 0;
////			sum = ary[0] + ary[1] + ary[2];
////			System.out.println("합계는 " + sum + "입니다.");
//
////	 		for문 사용해서 배열 안의 값 합계 구하기		
//			for(int i = 0; i < ary.length; i++) {    // i<= 2 로 해도되는데 그럼 값에 따라 숫자 바꿔야되니불편
//				sum += ary[i];
//			}
//			System.out.println("합계는 " + sum + "입니다.");
//
//			//배열 선언과 생성
////	      타입[] 변수이름 = new 타입 [길이];   --- 길이 = 들어갈 값의 개수 
//
//			//배열의 초기화 : 배열의 각 요소에 처음으로 값을 저장
////	      타입[] 변수이름 = { 50,60,70,80 }; ---꼭 대괄호사용! (대괄호 앞에 new 타입[] 생략해서 많이 씀)
//
//			int[] intAry = new int[5]; //공간만 만들고 출력하면 0으로 나옴
//				System.out.println(intAry[0]);
//			int[] intAry = new int[5]; 
//			double[] heights = new double[3];
//				System.out.println(heights[0]); //공간만 만들고 출력하면 0.0으로 나옴
//
//			String[] names = new String[10];  //초기값 말고 몇개의 값 들어갈지(10개의 공간만들기)
//			 System.out.println(intAry[0]); //공간만 만들고 출력해서 0으로 나옴
//			 System.out.println(heights[0]); //공간만 만들고 출력해서 0.0으로 나옴
//
//			String[] names = new String[10];  //(10개의 공간만들기)
//			names[0] = "홍길동";
//			names[1] = "김길동";
//
//			System.out.println(names[0]);
//			System.out.println(names[2]); //아직 값 할당X (공간만 있는 상태라 null출력)
//			 System.out.println(names[0]);
//			 System.out.println(names[2]); //아직 값 할당X (공간만 있는 상태라 null출력)
//
//
//
//			 int[] ary = {10, 20, 33};
//
//			 //배열 출력  
////	       * for문 사용해서 모든 요소 각각 출력    -- System.out.println(ary) 하면 안의 요소가 아닌 주소값이 나옴(배열은 참조변수이기때문)
//			 for(int i = 0; i < ary.length; i++) {
//				 System.out.println(ary[i]);
//			 }
//
////		     * Arrays클래스 이용 (多) -- 배열을 문자열 형식으로 만들어 출력(빨간줄 생기면 ctrl+shift+o = import문 생성)
//			 System.out.println(Arrays.toString(ary)); //--문자열로 바꿔서 [ ] 대괄호까지 표현 됨
//
//
//
//			//배열의 합계 구하기
//			int sum = 0;       // sum = ary[0] + ary[1] + ary[2]; 이렇게 해도 되나 수 많아지면 불편
//
////		 	* for문 사용해서 배열 안의 값 합계 구하기		
//			for(int i = 0; i < ary.length; i++) {    
//				sum += ary[i];
//			}
//			System.out.println("합계는 " + sum + "입니다."); 
//
//
//
//		}//end main
	
//	public class ArrayExe2 {
//		public static void main(String[] args) {
//		 // 1. 정수를 담을 수 있는 배열을 생성
//	     // 2. intAry => 10~100 값 넣기 (10단위로)
//		 // 3. 출력	
//
//	/*     < Q >
//	        1. 정수를 담을 수 있는 배열을 생성( 변수명: intAry / 값: 10개 담도록 )
//	        2. intAry 배열에 10단위로 10 ~ 100까지 값 넣기
//		    3. 출력	                                                 */
//
//		 // 1. 배열 생성
//			int[] intAry = new int[10];
//
//
//		 // 2. 배열 초기화 (값 할당)	
//			// int[] intAry = [ 10,20,30,40,50,60,70,80,90,100 ]; --수 많아지면 비효율적
//
////	    * for문 사용해서 값 할당	
//			for(int i = 0; i < intAry.length; i++) {
//				intAry[i] = (i + 1) * 10; //or i * 10 + 10;
//				intAry[i] = (i + 1) * 10;  // or i * 10 + 10;
//			}
//
//
//
//			/*
//			< 확장for문 >
//			  for(타입명 변수명 : 배열이름) {
//		// 3. 출력	
//	/*     * 확장 for문 사용
//			 for( 타입명 변수명 : 배열이름 ) {
//			     배열에 저장된 값이 매 반복마다 하나씩 순서대로 읽혀져 변수에 저장된다
//			   }                                                       */		
//			  }                                                           	*/	
//
//			//출력. 확장for구문
//			int sum = 0; // 50보다 큰 수를 저장
//			// 배열 중 50보다 큰 값들의 합계 & 평균 구하기
//			int sum = 0; 
//			double avg = 0;
//			int count = 0;
//
//			for(int num : intAry) { 
//				System.out.println(num);
////				System.out.println(num); --num 안에 값들이 들어갔는지 확인하기 위해 코드 사용해 봄
//
//				if(num > 50) {
//					sum += num;
//					count++;
//				}
//			}
//			avg = sum / count;
//			avg = sum * 1.0 / count; //지금은 80으로 딱 맞아 떨어져 상관없지만
//		       // 실수로 표현되려면 지금은 sum,count 둘 다 int형태라 하나를 실수로 바꿔주기 -> sum * 1.0
//
//			System.out.println("50보다 큰 수의 합계: " + sum);
//			System.out.println("50보다 큰 수의 평균: " + avg); //원래 intAry.length로 나누면 되지만 50보다 큰 수 값만 할거니까 count방 만들어서 50보다 클 경우 수를 넣어라
//

//
//		}//end main
//	}//end class
	
	
//	public class ArrayExe3 {
//		public static void main(String[] args) {
//
//			String[] nameAry = { "홍길동", "김길동", "홍길동", "박길동", "홍길동", "황길동"};
//			String[] nameAry = { "홍길동", "김길동", "박길동", "홍길동", "황길동"};
//
//	//   Q. "홍길동" 이 총 몇 명인지 구하라
//
//			String search = "홍길동";
//			int count = 0; //홍길동 몇명인지 출력되도록
//			int count = 0; 
//
//	/*    확장for문 
//	      : 확장 for문은 일반적인 for문과 달리 배열과 컬렉션에 저장된 요소들을 읽어오는 용도로만 사용할 수 있다.
//		   + index에 접근할 필요가 있다면 일반for문으로 사용해야 된다! */
//			for(String name : nameAry) { 
//
//				if(name.equals(search)) {
//					count++;
//				}
//			}
//			System.out.println(search + "은 총 " + count + "명입니다.");
//
//
//
////	    Q. 제일 높은 점수를 구해라		
//			int[] scores = {88, 68, 72, 89, 92, 70};
//
//			int maxScore = 0;
//
//			//향상 for문 사용
//			for(int num : scores) {
//				if(maxScore < num) {
//					maxScore = num;
//				}
//			}
//			System.out.println("max값 : " + maxScore);
//			System.out.println("max값: " + maxScore);
//
//
//			//일반 for문 사용
//			for(int i = 0; i < scores.length; i++) {
//				if(maxScore < scores[i]) {
//				if(maxScore < scores[i]) { //[i] 안 넣어서 오류 떴었음
//					maxScore = scores[i];
//				}
//			}
//			System.out.println("제일 큰 값은 : " + maxScore);
//
//
//
//			//학생 수, 점수
//
//
//
//
//			System.out.println("max 값: " + maxScore);
//
//		} //end main
	
	
//	package chap5;
//
//	//복합적인 형태의 데이터 구조를 만들겠다 ( -- 데이터를 담을 수 있음(더 많은 기능이 있지만 우선 기본타입이랑 비교하면
//	// "class 사용" 
//	// : 복합적인 형태의 데이터 구조를 만들겠다 --> 데이터를 담을 수 있음(더 많은 기능이 있지만 우선 기본타입이랑 비교하면
//
//	class Friend{  
//		String name; //필드
//		int age; //필드
//		double height; //필드
//
//	}
//		double height; //필드	
//		}
//
//	public class ReferenceExe1 {
//		public static void main(String[] args) {
//
//
//
//		//여기부터 원래대로 class 제목, main 메소드 실행 됨
//		public class ReferenceExe1 {
//			public static void main(String[] args) {
//
//
//	    // < 기본타입 >
//
//			/**/
//			// 기본타입
//			int a = 10;
//			int b = a;
//
//			a = 20; //값 바꿔서 a 값 바뀜 (b는 안 바뀌고)
//			a = 20; // 값 바꾸면 a 값 바뀜 
//			        // 근데 b는 위에서 a 10일 때 넣어줬으니 바뀌지 않고 그대로 10
//
//
//		// < 참조변수 > : 실제 값을 담는 게 아닌, (실제 값의) 주소를 담고 있다 ---(대표적으로 클래스)
//
//			// 참조변수: 실제 값을 담는 게 아닌, 실제 값의 주소를 담고 있다 (대표적으로 클래스)
//			Friend myFriend = new Friend(); // new => 객체 생성. //클래스도 데이터유형이라 Friend가 유형
//			myFriend.name = "김철수";
//			myFriend.age = 20;
//			myFriend.height = 178.3;
//
////			Friend ourFriend = myFriend; //myFriend가 가지고 있는 주소값을 ourFriend에 넣은 것
////			
////			myFriend.name = "홍길동"; //myFriend에 있는 name 속성을 바꿈 - 출력해보면 ourFriend의 값도 바꿔짐
////			                         //똑같은 목적지를 보고있기 때문에 //밑에 기본타입은 a를 바꿔도 b는 안 바꼈는데
////			myFriend.name = "홍길동"; // myFriend에 있는 name 속성을 바꿈 - 출력해보면 ourFriend의 값도 바꿔짐
////			                        // why? 똑같은 목적지를 보고있기 때문에! 즉, 주소값을 대입한 거라 (쭉 따라가면 "홍길동"이 있음) 
////			                       // 위에 기본타입은 대입 후 a 값을 바꿔 b는 바뀌지 X 
////			
////			System.out.println(ourFriend.name);
////			System.out.println(ourFriend.age);
//	@@ -42,24 +49,25 @@ public static void main(String[] args) {
//			yourFriend.age = 20;
//			yourFriend.height = 178.3;
//
//			//myFriend와 값이 같아 보인다. 그래스 myFriend와 yourFriend를 비교해보았다
//			// 근데 참조변수는 안에 있는 값을 비교하는게 아닌 주소값을 비교해서 항상 false가 나옴
//			// myFriend와 값이 같아 보인다. 그래서 myFriend와 yourFriend를 비교해보았다
//			System.out.println(myFriend == yourFriend); 
//			// = > 값을 비교하고 싶으면 안의 .name, age, height 속성들을 비교해야 됨
//			// 비교하니 "false" 출력
//			// why? 참조변수는 안에 있는 값을 비교하는게 아닌 "주소값을 비교해서" => "항상 false" 가 나옴
//			// 그래서 "값을 비교하고 싶으면" 안의 .name, age, height "속성들을 비교" 해야 됨
//
//
//			//참조 변수는 기본값이 null ??찾아보기
//			yourFriend = null;
//			System.out.println(myFriend.name);
//			try {       //10장에서 배울 예외처리 (에러 발생하면 원래 중단하는데 catch프록램의 구문을 출력하고 계속 실행해라
//			try {       //10장에서 배울 예외처리 (에러 발생하면 원래 중단하는데 catch프로그램의 구문을 출력하고 계속 실행해라
//			System.out.println(yourFriend.name);
//			} catch (Exception e) {
//				System.out.println("null값을 참조합니다.");
//			}
//
//
//
//
//
//
//	//-----------------------------------------------------------------------		
//			// 참조타입 : 그 값을 담고 있는 주소값을 변수에 저장하는 것
//			String name = "신용권"; //신용권이라는 객체의 주소값 : 16진수로 23db~
//			String hobby = "독서";
//			
////			String name1 = name; //name1에도 신용권이라는 주소값 넣어 따라가면 신용권이라는 값 볼 수 있음
////			name1 = "김용권";
//			
//			String name1 = "신용권"; // new String("신용권")   //비교연산자 == 로 비교하면 true나옴 //**문자열만
//			System.out.println("name: " + name);
//			System.out.println("name1: " + name1);
//			System.out.println(name.equals(name1)); // 문자열 값 비교할 때 equals 메소드 활용
//
//		}//end main
//	}//end class
	
	
	
	
	
	
	
	
	
//	package chap5;
//
//	import java.util.Scanner;
//
//	public class 연습창 {
//		public static void main(String[] args) {
//
//	// ArrayExe2.
//
//			//배열 생성하고 10-100까지 수 중 10단위의 값을 배열에 할당
//			int[] array = new int[10];
//
//			for(int i = 0; i < array.length; i++) {
//				array[i] = (i + 1) * 10;
//			}
//
//			//배열 중 50보다 큰 수들의 합계와 평균
//			int sum = 0;
//			double avg = 0;
//			int count = 0;
//
//			for( int num : array) {
//				if( num > 50 ) {
//					sum += num;
//					count++;
//				}
//
//			}
//			avg = sum * 1.0 / count; //지금은 80으로 딱 맞아 떨어져 상관없지만
//			     // 실수로 표현되려면 지금은 sum,count 둘 다 int형태라 하나를 실수로 바꿔주기 -> sum * 1.0
//			System.out.println("50보다 큰 수의 합계: " + sum);
//			System.out.println("50보다 큰 수의 평균: " + avg);
//
//
//	// ArrayExe3.		
//
//		// Q. "홍길동" 이 총 몇 명인지 구하라	
//
//			String[] nameAry = { "홍길동", "김길동", "박길동", "홍길동", "황길동"};
//
//			String search = "홍길동";
//			int cnt = 0;
//
//			for(String name : nameAry) {
//				if(name.equals(search)) {
//					cnt++;
//				}
//			}
//			System.out.println(search + "은 총 " + cnt + "명 입니다");
//
//
//	    // Q. 제일 높은 점수 구하기	
//
//			int[] scores = {88, 68, 72, 89, 92, 70};
//
//			int max = 0;
//
//			//향상for문
//			for(int num : scores) {
//				if(num > max) {
//					max = num;
//				}
//			}
//			System.out.println("향상for문> 제일 높은 점수: " + max + "점");
//
//			//일반for문
//			for(int i = 0; i < scores.length; i++) {
//				if(scores[i] > max) {
//					max = scores[i];
//				}
//			}
//			System.out.println("일반for문> 제일 높은 점수: " + max + "점");
//
//	// WhileExe.		
//
//		//Q. 문자를 입력받아라. 만약 quit 문자를 만나면 종료해라
//			Scanner scn = new Scanner(System.in);
//			boolean run = true;
//
//			while(run) {
//				System.out.print("문자 값 입력>> ");
//
//				String txt = scn.nextLine();
//				if(txt.equals("quit")) {
//					System.out.println("프로그램을 종료합니다");
//					break;
//				}
//				System.out.println("입력값: " + txt);
	
//	package chap5;
//
//	import java.util.Scanner;
//
//	public class 연습창_SA2 {
//
//	 // StudentApp2. 여러 메소드들 만들기 전 코드		
//
//		public static void main(String[] args) {
//
//			Scanner scn = new Scanner(System.in);
//			Student[] students = null;
//			boolean run = true;
//			int studentNum = 0; 
//
//			while(run) {
//				System.out.println(" 1.학생수 2.학생이름,점수입력 3.조회 4.분석(평균) 5.수정 6.종료");
//				int menu = scn.nextInt(); 
//				scn.nextLine();   
//
//				switch(menu) {
//				case 1 :
//					System.out.print("학생수 입력>> ");
//					studentNum = Integer.parseInt(scn.nextLine()); 
//					students = new Student[studentNum]; //배열 크기 지정하기
//					break;
//
//				case 2 :
//					System.out.println("학생정보 입력>> ");
//					for(int i = 0; i < students.length; i++) {
//						Student student = new Student(); 
//
//						System.out.print("- 이름: ");
//						student.name = scn.nextLine();
//						System.out.print("- 점수: ");
//						student.score = Integer.parseInt(scn.nextLine());
//						System.out.print("- 남/여: ");
//						student.gender = scn.nextLine(); 
//
//						students[i] = student; //students 변수에 .name이랑.score담은 것 배열에 들어가게
//					}	
//					break;
//
//				case 3 : // " 학생이름 - 점수 " 형태로 출력
//					System.out.print("조회할 이름입력>> ");
//					String name = scn.nextLine();
//					boolean exists = false;
//
//					for(Student stdn : students) { 	                           
//						if(name.equals(stdn.name)) {
//							System.out.println(" : 이름은 " + stdn.name + ", 점수는 " + stdn.score +"점");	
//							exists = true;
//						}
//
//					}//for문 끝
//
//					if(!exists) {
//						System.out.println("찾는 이름이 없습니다.");
//					}
//					break;
//
//				 case 4 :
//					 System.out.println("분석>> ");
//					 int sumOfMen = 0, cntOfMen = 0;  
//					 int sumOfWomen = 0, cntOfWomen = 0;
//
//					 for(Student stn : students) {
//						if(stn.gender.equals("남")) {
//						   sumOfMen += stn.score;
//						   cntOfMen ++;
//						}
//						else if(stn.gender.equals("여")) {
//							 sumOfWomen += stn.score;
//							 cntOfWomen ++;
//						}
//					 }
//					 System.out.println("남학생의 평균: " + (sumOfMen * 1.0 / cntOfMen)); 
//					 System.out.println("여학생의 평균: " + (sumOfWomen * 1.0 / cntOfWomen));
//					 break;
//				 case 5 :
//					 System.out.print("조회할 이름입력>> ");
//					 String name = scn.nextLine();
//					 boolean exists = false;
//
//					 for(int i = 0; i < students.length; i++) {
//						// 이름 가지고 있으면 변경점수 입력
//					   if(name.equals(students[i].name)) {
//						 System.out.print("변경할 점수 입력: ");
//						 students[i].score = Integer.parseInt(scn.nextLine());
//						 exists = true;
//						}
//
//					   if(!exists) {
//						 System.out.println("찾는 이름이 없습니다.");
//					   }
//					 }
//					 break;
//
//				 case 6 :
//					 System.out.println("종료합니다.");
//					 run = false;				
//				}// end of switch.
//			}// end of while.
//		  }//end main
//	}//end class
	
	
	
	
	
	
	
	
	
	
	
	
			}//end main
}//end class
