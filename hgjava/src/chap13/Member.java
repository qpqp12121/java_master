package chap13;

import java.util.Objects;

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

////////////////////////////////////////////////////////////////////////////@Data없음
	@Override
	public int hashCode() {
		return Objects.hash(memberName, memberNo, point);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(memberName, other.memberName) && Objects.equals(memberNo, other.memberNo)
				&& point == other.point;
	}


	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberName=" + memberName + ", point=" + point + "]";
	}
	
	
	//hashCode, equals() 메소드를 재정의해서 동등 객체가 될 조건을 정해야 된다
//	@Override
//	public int hashCode() {
//		return super.hashCode(); //Member가 가지고 있는 부모클래스 정의된 거 없으니 부모클래스 Object임
//	}
	
	
	
}
