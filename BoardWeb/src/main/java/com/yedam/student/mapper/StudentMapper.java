package com.yedam.student.mapper;

import java.util.List;

import com.yedam.student.vo.Student;

public interface StudentMapper {

	//CRUD
	List<Student> studentList(); //목록가져오기
	int addStudent(Student std); //등록하기 --StudentMapper에 sql문 정의 //#{Student에 저장한 필드명 넣었음}
	int remStudent(String sno); //삭제하기 --                          //#{sno}로 넣기
	
	
	
}
