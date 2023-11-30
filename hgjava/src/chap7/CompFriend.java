package chap7;

//Friend상속 + 회사, 부서

public class CompFriend extends Friend { // extends붙여서 상속
	//필드
	private String company;
	private String dept;

	
	public CompFriend(String name, String phone, String company, String dept) {
		super(name,phone);   // super 사용! name이랑 phone은 부모클래스에서 가져와야돼서
		this.company = company;
		this.dept = dept;
	}
	
//	@Override --source 기능으로 만들었음
//	public String toString() {
//		return "CompFriend [company=" + company + ", dept=" + dept + "]";
//	}
	public String showInfo() { //이름이랑 연락처는 부모Friend에만 있어서 거기서 getter함수 가져와야 되는 거임
		return "이름: " + getName() + " 연락처: " + getPhone() + " 회사: " + company + " 부서: " + dept;
	}


	//getter setter 메소드
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}// end of class.
