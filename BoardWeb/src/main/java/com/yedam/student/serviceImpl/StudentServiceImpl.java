package com.yedam.student.serviceImpl;

import java.util.List;

import com.yedam.student.mapper.StudentDAO;
import com.yedam.student.service.StudentService;
import com.yedam.student.vo.Student;

public class StudentServiceImpl implements StudentService{

	StudentDAO dao = new StudentDAO();
	
	@Override
	public List<Student> studentList() {
//		dao.getStudent(""); //조회한 후 목록보겠다하면 이거추가해주고 조합해서사용ㅇ
		return dao.getStudentList();
	}

	@Override
	public boolean addStudent(Student std) {
		return dao.addStudent(std);
	}

	@Override
	public boolean modStudent(String sno, int escore, int mscore) {
		return dao.modifyStudent(sno, escore, mscore);
	}

	@Override
	public boolean remStudent(String sno) {
		return dao.removeStudent(sno);
	}

	@Override
	public Student getStudent(String sno) {
		return dao.getStudent(sno);
	}
	
	
	
	
}
