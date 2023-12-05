package remind7;

import java.util.ArrayList;
import java.util.List;

//컬렉션
public class StudentExe {

	//필드
	List<Student> students;
	
	
	//생성자
	StudentExe(){
		students = new ArrayList<Student>();
		students.add(new Student("23-001", "홍길동", 77, 88)); // 원래 StudentApp에 있었는데 옮김
		students.add(new Student("23-002", "김철수", 77, 88));
	}
	
	//메소드
	
	//1.등록
	boolean addStudent(Student std) {
		return students.add(std);
	}
	
	//2.목록
	List<Student> stuList(){
		return students;
	}
	
	//3.단건조회
	Student stuInfo(String stuNo) {
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getStuNo().equals(stuNo)) {
			 return students.get(i);
			}
		}
		return null;
	}
	
	//4.수정
	boolean modifyStudent(String stuNo, int engScore, int mathScore) {
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getStuNo().equals(stuNo)) {
				students.get(i).setEngScore(engScore);
				students.get(i).setMathScore(mathScore);
				return true;
			}
		}
		return false;
	}
	
	//5.삭제
	boolean removeStudent(String stuName) {
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getStuName().equals(stuName)) {
				students.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	
	
}//end of class.
	

