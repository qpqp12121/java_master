package chap13;

public class Member {
	
	//<필드>
	private String memberNo;
	private String memberName;
	private int point;
	
	//<생성자>
//	public Member() {
//		
//	}
	public Member(String memberNo, String memberName, int point) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.point = point;
	}

	
	//getter, setter 메소드
	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
////	//showInfo
//	public String showInfo() {
//		return "회원번호: " + memberNo + ", 이름: " + memberName + ", 포인트: " + point;
//	}
	
	
	
	
}
