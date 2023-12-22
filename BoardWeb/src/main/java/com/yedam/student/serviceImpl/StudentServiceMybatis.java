package com.yedam.student.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.student.mapper.StudentMapper;
import com.yedam.student.service.StudentService;
import com.yedam.student.vo.Student;

public class StudentServiceMybatis implements StudentService {
	//jdbc vs mybatis (mybatis로 사용해봄 - jdbc는 StudentServiceImpl
	SqlSessionFactory factory = DataSource.getInstance();
	SqlSession session = factory.openSession(true);
	
	StudentMapper mapper = session.getMapper(StudentMapper.class); //인터페이스 = 구현객체(StudentMapper.class)
	
	
	
	
	@Override
	public List<Student> studentList() {
		return mapper.studentList();
	}

	@Override
	public boolean addStudent(Student std) {
		return mapper.addStudent(std) == 1; //mapper가가지고있ㅅ는메서드 처리된건수가한건인지 보고
	}

	@Override
	public boolean modStudent(String sno, int escore, int mscore) {
		return false;
	}

	@Override
	public boolean remStudent(String sno) {
		return mapper.remStudent(sno) == 1;
	}

	@Override
	public Student getStudent(String sno) {
		return null;
	}//jdbc말고 mybatis로 사용 (
	
	

}
