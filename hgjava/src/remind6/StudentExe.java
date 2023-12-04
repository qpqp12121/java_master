package remind6;

/* 저장공간: 배열
 
 < 추가/수정/삭제/목록/단건조회 > 프로그램 (StudentApp에서 한 거
 
  제일 적은 기능으로 사용하려고 클래스 만들어서 따로 나눴음(객체지향프로그램의 특징?)	
  
  클래스엔 기능만 구현 // StudentApp에는 출력하는 메시지가 많음
  */

public class StudentExe {
// < 배열 > 
	private Student[] students; // 필드라 private 써 줌 -- 배열필드임

// < 생성자 >
	StudentExe() { // 메소드는 반환타입 있어야 되는데 생성자는 없음
		students = new Student[100];
		students[0] = new Student("23-001", "홍길동", 77, 88); // 원래 StudentApp에 있었는데 옮김
		students[1] = new Student("23-002", "김철수", 77, 88);
	}

	
	
//  < 추가 > //StudentApp case1 참고
	boolean addStudent(Student std) { // Student타입 students배열에다 std를 담을것 (매개변수
		for (int i = 0; i < students.length; i++) { // void는 반환되는 값 없어서 값이 들어가있는지 모르니 boolean으로
			if (students[i] == null) {
				students[i] = std;
//				break; //void였을 때 사용함
				return true; // 메소드 안에서 return문 마주치면 반환 후 종료됨(=메소드의 끝)
			}
		}
		return false;
	}

// < 목록 > //StudentApp case 2 if문부터 사용 참고	
	Student[] getStudentList() { // Student타입의 배열을 반환하겠다
		return students; // return문 안 쓰니까 getStudent오류떴음 --8번 배열 주소값이 반환
	}

// < 단건조회 >
	Student getStudent(String no) { // 학생번호 문자열타입이니
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStuNo().equals(no)) {
				return students[i]; // return문 쓰기 전에 Student getStudent에 오류
			}
		}
		return null;
	}

// < 수정 >	//case 4
	boolean modifyStudent(String no, int eng, int math) { // 학생번호, 영어점수, 수학점수 알아야되니까
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStuNo().equals(no)) {
				students[i].setEngScore(eng);
				students[i].setMathScore(math); // 값 바꿔줄 땐 "set메소드"사용
				return true; // void를 boolean으로 바꿔서 잘 바꼈는지 확인할 수 있게
			}
		}
		return false;
	}

// < 삭제 > //case5
	boolean removeStudent(String name) { // 매개값으로 이름 받을거(타입쓰고 변수명)
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStuName().equals(name)) {
				students[i] = null; // null값 넣어주면 삭제되는 것!!
				return true; // void를 boolean으로 바꿔서 잘 바꼈는지 확인할 수 있게
			}
		}
		return false;

	}

}// end of class
