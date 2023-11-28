package chap6;

public class MemberApp {
	//main에서 부터 프로그램 실행
	public static void main(String[] args) {
	
		Member[] members = new Member[10]; 
		//Member 인스턴스(실체)를 만들고 members에 배열 값 담음
		members[0] = new Member(1, "Hong", "010-1111", "Men");
		members[1] = new Member(2, "Park", "010-2222", "Women");
		members[2] = new Member(3, "Choi", "010-3333", "Women");
		
		for(int i = 0; i < members.length; i++) {
//			if(members[i] != null && members[i].gender.equals("Women"))  //---그래서 null이 아닐 때만 실행되도록
				if(members[i] != null && members[i].getGender().equals("Women")) //위에거 gender private로 막혀서 get~메소드 만들고 실행

//				System.out.println(members[i].showAllInfo()); //0,1번 방엔 값이 있어서 나오지만, 나머진 null로 나옴//class에 있는 showAll메소드 실행			                                
				members[i].showInfo(); //showInfo는 void로 반환값이 없어서 System.out.println 적으면 X
		}
				
	}//end of main	
	
	
	
	static void test1() {
		Member mem1 = new Member(); //인스턴스 생성 (class설계도를 통해 실체를 new생성하겠습니다)
									//-- ()로 생성자 호출
									// => mem1파일의 타입은 Member클래스 타입
//		mem1.memberNo = 10; //Member클래스 안에 속성들어있어서 사용 가능
//		mem1.memberName = "Hong";
//		mem1.phone = "010-1234-5678";
//		mem1.gender = "Men";
		
		mem1.setMemberNo(10); //위에는 private로 안해서 저렇게 값을 담을 수 있었으나 private로 속성 설정해서 setMemberNo()만든 메소드로 호출
		mem1.setMemberName("Hong");
		mem1.setPhone("010-1234-5678");
		mem1.setGender("Men");
		
		
		//- 기본생성자(매개값 하나도 없는)
		mem1.showInfo(); //Member 클래스에 void showInfo()로 메소드 생성해놓았기 때문에 기능실행
		
		
		
		//- 생성자 정의
		Member mem2 = new Member(11, "Hwang"); //초기값 가지고 필드의 값을 채워 줌
//		mem2.phone = "010-3333-4444";          //위에서 mem1에는 직접 값을 넣은 것
		mem2.setPhone("010-3333-4444");
		mem2.showInfo();
		
		Member mem3 = new Member(12, "Park", "010-5678-8765", "Women");
		mem3.showInfo(); //return타입(반환유형) : void -- 반환되는 값이 없습니다 라서 반환되는 구문도 없음
		String msg = mem3.showAllInfo(); // 반환유형: String으로 설정해놓아서 가능 --근데 위엔 void로 해놔서 만약 앞에 String msg = 적으면 오류
		                 //showAllInfo()에서 반환되는 문자열을 msg에 넣음
		System.out.println(msg);
			
		}//end of test1.
		
		
		
		
		
	
}//end class
