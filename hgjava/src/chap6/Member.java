package chap6;
//Class만들기(필요한 정보들만 뽑아서 쓰면 됨)

// < 회원관리 앱 >
// 회원번호, 회원이름, 연락처, 성별 -- (속성들)

// public <-> private :public은 다른 class에서도 접근 가능
// 속성 앞에 private 붙이니까 MemberApp에서 접근하지 못하도록 에러 뜸

public class Member {
/*	< 클래스의 멤버들 > 
	 "필드, 생성자, 메소드"
 							*/

/* --------------------------------------------------
    1. 속성(=필드) - 없을 수도 있음 						
      : 회원번호, 회원이름, 연락처, 성별                         */
	
	private int memberNo;
	private String memberName;
	private String phone; // - 하이픈까지 가지고 있어서 String타입으로
	private String gender; // 왜 private 쓰냐? ex.Men or Women 쓰게 했는데 누가 M, W로 잘못된 값을 넣을 경우 에러뜨지 않고 넘어감
							// 그래서 private로 하고 값을 메소드로 넣게 만들 수 있음 => 속성들엔 대체적으로 private 사용 多

/* ----------------------------------------------------
	2. 생성자 - 무조건 존재한다! 정의 안하면 기본생성자로 생성 됨! ( 컴파일러가 생성해 줌 )	 
  	   : 필드의 초기값을 지정하는 역할                         */

//	  < 기본생성자 > - 매개값 X ( 정의하지 않으면 컴파일러가 생성 )
		Member() {
	
		}
	
//    < 생성자 정의하기 > - 매개값을 받는 것
		Member(int memberNo, String memberName) {
			this.memberNo = memberNo; // this.memberNo은 위의 속성을 = 뒤에 있는 memberNo은 Member 메소드에 들어갈 매개변수 가리키는 것
			this.memberName = memberName;
		}
	
		// ++ 오른쪽마우스 - source - Generate constructor usingFields 하면 저절로 만들어짐 (기능많이써서)
		public Member(int memberNo, String memberName, String phone, String gender) {
	
			this.memberNo = memberNo;
			this.memberName = memberName;
			this.phone = phone;
			this.gender = gender;
		}

		
/* ----------------------------------------------------------------
	 3. 기능(=메소드)
	 																*/
		
		void showInfo() {   // void는 반환되는 값이 없단 걸 의미
			System.out.println("이름은 " + memberName + "이고 연락처는 " + phone + "입니다.");
	
		}
	
		String showAllInfo() {
			String result = "이름은 " + memberName + "이고 번호는 " + memberNo + "이고, 연락처는 " + phone + "이고, 성별은 " + gender + "입니다.";
			return result; // * String은 반환되는 값 없으면 에러뜨니 return 꼭 해야 됨!
		}
	
		
//	   " set-() " - 값을 지정하는 메소드.
// 	     : private넣어서 채워줄 수 없는 상태이기 때문에 값 넣을 수 있도록 메소드 제공	
		
		void setMemberNo(int memberNo) { 
			this.memberNo = memberNo;
		}
	
		void setMemberName(String memberName) {
			this.memberName = memberName; // 이 기능도 많이 써서 source-Generate getters and setters-selectsetters로 넣으면 자동 채워짐
		}
	
		void setPhone(String phone) {
			this.phone = phone;
		}
	
		void setGender(String gender) {
			this.gender = gender;
		}
	
		
//     " get-() " - 값을 가지고 오기 위한 메소드
		
		int getMemberNo() { // int를 반환해주는 메소드 만들어야 됨
			return memberNo;
		}
	
		String getMemberName() {
			return memberName; // 이 기능도 많이 써서 source-Generate getters and setters-selectgetters로 넣으면 자동 채워짐
		}
	
		String getPhone() {
			return phone;
		}
	
		String getGender() {
			return gender;
		}

}// end class
