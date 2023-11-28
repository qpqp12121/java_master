package chap6;

public class Student {
	private String stuNo;
	private String stuName;
	private int engScore;
	private int mathScore;

	// 기본생성자
	Student() {

	}

	// 생성자 정의하기
	Student(String stuNo, String stuName, int engScore, int mathScore) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	// showInfo()메소드
	void showInfo() {
		System.out.println("이름은 " + stuName + ", 영어점수는 " + engScore + ", 수학점수는 " + mathScore);
	}

	
	// set()메소드 (위에 private으로 설정했기 때문에 접근할 수 있도록)
	void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	void setStuName(String stuName) {
		this.stuName = stuName;
	}

	void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	// get메소드 (위에 private으로 설정했기 때문에 접근할 수 있도록)
	String getStuNo() {
		return stuNo;
	}

	String getStuName() {
		return stuName;
	}

	int getEngScore() {
		return engScore;
	}

	int getMathScore() {
		return mathScore;
	}

}// end of class
