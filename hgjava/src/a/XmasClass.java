package a;

public class XmasClass {

	private int xmasNo;
	private String lecName;
	private int vote;
	
	
	
	//생성자
	XmasClass(){
		
	}
	
	XmasClass(int xmasNo, String lecName, int vote){
		this.xmasNo = xmasNo;
		this.lecName = lecName;
		this.vote = vote;
	}
	
	
	//메소드
	public int getXmasNo() {
		return xmasNo;
	}

	public void setXmasNo(int xmasNo) {
		this.xmasNo = xmasNo;
	}

	public String getLecName() {
		return lecName;
	}

	public void setLecName(String lecName) {
		this.lecName = lecName;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	@Override
	public String toString() {
		return "XmasClass [xmasNo=" + xmasNo + ", lecName=" + lecName + ", vote=" + vote + "]";
	}
	
	
	
	
	
}//end of class.
