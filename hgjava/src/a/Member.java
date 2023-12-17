package a;

public class Member {

	private String memId;
	private String memPw;
	private String memName;
	private String memPhone;
	private String response;
	
	public Member() {
		
	}
	
	public Member(String memId, String memPw, String memName, String memPhone, String response) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memPhone = memPhone;
		this.response = response;
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
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}
