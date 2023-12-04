package 연습;

public class Student {
	
	//필드
	private String stuNo;  //번호 23-001 형태로 넣을 거임
	private String stuName;
	private int engScore;
	private int mathScore;
	
	//생성자
	Student(){
		
	}
	
	public Student(String stuNo, String stuName, int engScore, int mathScore){
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	//메소드
	
	//showInfo()
	void showInfo() {
		System.out.println("이름: " + stuName + ", 영어점수: " + engScore + ", 수학점수: " + mathScore);
	}
	
	//setter
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	//getter
	public String getStuNo() {
		return stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public int getEngScore() {
		return engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	
	
	
	
	
	
}//end of class.
