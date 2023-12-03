package 연습;

public class StudentExe {
	// 배열필드
	private Student[] students;

	// 생성자
	// 매번 등록해야돼서 기본값 넣어놓으려고
	StudentExe() {
		students = new Student[100];
		students[0] = new Student("23-001", "홍길동", 77, 88);
		students[1] = new Student("23-002", "김철수", 77, 88);
	}

	// 메소드 (기능 위주)
	/* 1.등록 */
	boolean addStudent(Student std) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = std;
				return true;
			}
		}
		return false;
	}

	/* 2.목록보기 */
	// 배열에 담아놓은 정보 꺼내야되니 (위에 있는 Student타입의 배열을 반환값으로)
	Student[] getStudentList() {
		return students;
	}

	/* 3.단건조회 */
	Student getStudent(String num) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStuNum().equals(num)) {
				return students[i];
			}
		}
		return null;
	}

	/* 4.수정 */
	boolean modifyStudent(String num, int eng, int math) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null & students[i].getStuNum().equals(num)) {
				students[i].setEngScore(eng);
				students[i].setMathScore(math);
				return true;
			}
		}
		return false;
	}

	/* 5.삭제 */
	boolean removeStudent(String name) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStuName().equals(name)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}

}// end class.
