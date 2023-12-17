package b;

//Model클래스(Value Object)

public class Member {

	private int memNo;
	private String memId;
	private String memPw;
	private String memName;
	private String memBirth;
	private String memPhone;
	
	
	//생성자
	Member(){
		
	}

	
	public Member(String memId, String memPw, String memName, String memBirth, String memPhone) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memBirth = memBirth;
		this.memPhone = memPhone;
	}


	//메소드
	public int getMemNo() {
		return memNo;
	}


	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}


	public String getMemId() {
		return memId;
	}


	public void setMemId(String memId) {
		this.memId = memId;
	}


	public String getMemPw() {
		return memPw;
	}


	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}


	public String getMemName() {
		return memName;
	}


	public void setMemName(String memName) {
		this.memName = memName;
	}


	public String getMemBirth() {
		return memBirth;
	}


	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
	}


	public String getMemPhone() {
		return memPhone;
	}


	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	
	
	
	
	
}//end of class.
