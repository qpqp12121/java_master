package 연습;

public class StudentExe {

	// 배열필드
	private Student[] students;

	// 생성자
	StudentExe() { // 초기값 넣어둠
		students = new Student[100];
		students[0] = new Student("23-001", "홍길동", 77, 88);
		students[1] = new Student("23-002", "김철수", 77, 88);
	}

	// 메소드

	// 1.등록
	boolean addStudent(Student std) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = std;
				return true;
			}

		}
		return false;
	}
	
	// 2.목록보기
	Student[] getStudentList() {
		return students;
	}
	
	// 3.단건조회
	Student getStudent(String no) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuNo().equals(no)) {
				return students[i];
			}
		}
		return null;
	}
	
	// 4.수정
	boolean modifyStudent(String no, int engScore, int mathScore) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuNo().equals(no)) {
				students[i].setEngScore(engScore);
				students[i].setMathScore(mathScore);
				return true;
			}
		}
		return false;
	}
	
	// 5.삭제
	boolean removeStudent(String name) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuName().equals(name)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
	
	
	
	

}//end of class.
