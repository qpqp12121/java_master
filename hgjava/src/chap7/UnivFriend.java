package chap7;


//자식클래스 역할 : UnivFrined -> Friend(부모)

public class UnivFriend extends Friend{ //Friend한테 상속받음
	private String univ;
	private String major;

	public UnivFriend() {
		
	}
	
	public UnivFriend (String name, String phone, String univ, String major) {
		super(name, phone);
		this.univ = univ;
		this.major = major;
	}
	
	

	@Override
	public String showInfo() { //ctrl엔터 showInfo()선택 - 부모가 가지고 있는 메소드를 자식이 물려받아, 자기 상황에 맞게 다시 재정의해서 사용하겠다는 거
		return "이름: " + getName() + " 연락처: " + getPhone() + " 학교: " + univ + " 전공: " + major; //setUniv 등 요소 부모는 없어서
	}      //super.name 부모가 가지고있는 name 속성 =>근데 private이라 getName 값가져오기 (super로 말고 this.getName 자기거이기도 해서 this해도 되나 생략가능
	
	public String getUniv() {
		return univ;
	}
	public void setUniv(String univ) {
		this.univ = univ;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
}//end of class
