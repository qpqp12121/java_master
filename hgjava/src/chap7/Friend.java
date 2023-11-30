package chap7;

//부모역할 클래스 : 이름, 연락처, showInfo()

public class Friend {
	//필드
	private String name;
	private String phone;
	
	
	//기본생성자.
//	public Friend(){
//		
//	}
	public Friend() {
		super();
	}//이클립스 기능으로 만듦(source - generate constructor using field
	
	
	//생성자(매개값 가지는
	public Friend(String name, String phone) { //규칙: 클래스 이름과 같아야 됨
		this.name = name;
		this.phone = phone;		
	}
	
	


	@Override  //(source - generate toString이 만든 showInfo()형식
	public String toString() { //showInfo()랑 시작점이 다르다는 게 차이?( 이건 Object부터
		return "Friend [name=" + name + ", phone=" + phone + "]";
	}
	
	public String showInfo() { //이건 FriendApp에서부터 사용???
		return "이름: " + name + " 연락처: " + phone;
	}
	
	
	//getter setter메소드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

	
}//end of class
