package 연습;

public class Student {
	
	//필드
	private String stuNum;
	private String stuName;
	private int engScore;
	private int mathScore;
	
	//기본생성자
	Student(){
		
	}
	
	//생성자 정의 - 초기값 StudentApp 1.등록기능에서 값 받아서 배열에 넣을 거임
	public Student(String stuNum, String stuName, int engScore, int mathScore){
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	//메소드
	//showInfo() --목록보기 기능에 사용
	void showInfo() {
		System.out.println("이름은 " + stuName + ", 영어점수는 " + engScore + ", 수학점수는 " + mathScore);
	}
	
	//setter
	public void setStuNum(String stuNum){
		this.stuNum = stuNum;
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
	public String getStuNum() {
		return stuNum;
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
	
	
	
	

}//end class.
