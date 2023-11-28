package chap5;

// "class 사용" 
// : 복합적인 형태의 데이터 구조를 만들겠다 --> 데이터를 담을 수 있음(더 많은 기능이 있지만 우선 기본타입이랑 비교하면

class Friend{  
	String name; //필드
	int age; //필드
	double height; //필드	
	}



	//여기부터 원래대로 class 제목, main 메소드 실행 됨
	public class ReferenceExe1 {
		public static void main(String[] args) {
			
			
    // < 기본타입 >
		
		int a = 10;
		int b = a;
		
		a = 20; // 값 바꾸면 a 값 바뀜 
		        // 근데 b는 위에서 a 10일 때 넣어줬으니 바뀌지 않고 그대로 10
		
		
	// < 참조변수 > : 실제 값을 담는 게 아닌, (실제 값의) 주소를 담고 있다 ---(대표적으로 클래스)
		
		Friend myFriend = new Friend(); // new => 객체 생성. //클래스도 데이터유형이라 Friend가 유형
		myFriend.name = "김철수";
		myFriend.age = 20;
		myFriend.height = 178.3;
		
//		Friend ourFriend = myFriend; //myFriend가 가지고 있는 주소값을 ourFriend에 넣은 것
//		
//		myFriend.name = "홍길동"; // myFriend에 있는 name 속성을 바꿈 - 출력해보면 ourFriend의 값도 바꿔짐
//		                        // why? 똑같은 목적지를 보고있기 때문에! 즉, 주소값을 대입한 거라 (쭉 따라가면 "홍길동"이 있음) 
//		                       // 위에 기본타입은 대입 후 a 값을 바꿔 b는 바뀌지 X 
//		
//		System.out.println(ourFriend.name);
//		System.out.println(ourFriend.age);
//		System.out.println(ourFriend.height);
		
		
		
		Friend yourFriend = new Friend(); // new => 객체 생성. //클래스도 데이터유형이라 Friend가 유형
		yourFriend.name = "김철수";
		yourFriend.age = 20;
		yourFriend.height = 178.3;
		
		// myFriend와 값이 같아 보인다. 그래서 myFriend와 yourFriend를 비교해보았다
		System.out.println(myFriend == yourFriend); 
		// 비교하니 "false" 출력
		// why? 참조변수는 안에 있는 값을 비교하는게 아닌 "주소값을 비교해서" => "항상 false" 가 나옴
		// 그래서 "값을 비교하고 싶으면" 안의 .name, age, height "속성들을 비교" 해야 됨
		
		
		//참조 변수는 기본값이 null ??찾아보기
		yourFriend = null;
		System.out.println(myFriend.name);
		try {       //10장에서 배울 예외처리 (에러 발생하면 원래 중단하는데 catch프로그램의 구문을 출력하고 계속 실행해라
		System.out.println(yourFriend.name);
		} catch (Exception e) {
			System.out.println("null값을 참조합니다.");
		}
		
		
		
			
//-----------------------------------------------------------------------		
		// 참조타입 : 그 값을 담고 있는 주소값을 변수에 저장하는 것
		String name = "신용권"; //신용권이라는 객체의 주소값 : 16진수로 23db~
		String hobby = "독서";
		
//		String name1 = name; //name1에도 신용권이라는 주소값 넣어 따라가면 신용권이라는 값 볼 수 있음
//		name1 = "김용권";
		
		String name1 = "신용권"; // new String("신용권")   //비교연산자 == 로 비교하면 true나옴 //**문자열만

		System.out.println("name: " + name);
		System.out.println("name1: " + name1);
		System.out.println(name.equals(name1)); // 문자열 값 비교할 때 equals 메소드 활용
	
		
		
		
		
		
	}//end main
}//end class