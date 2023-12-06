package 시험;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpDAO {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	// 필드
	List<Employee> emps;

	// 생성자
	EmpDAO() {
		emps = new ArrayList<Employee>();
		try {
			emps.add(new Employee("23-01", "이이", "010-1111", sdf.parse("2023-12-01"), 100));
			emps.add(new Employee("23-02", "요요", "010-2222", sdf.parse("2023-12-01"), 200));
			emps.add(new Employee("23-03", "야야", "010-3333", sdf.parse("2023-12-02"), 300));
			emps.add(new Employee("23-04", "하하", "010-4444", sdf.parse("2023-12-06"), 400));
			emps.add(new Employee("23-05", "호호", "010-5555", sdf.parse("2023-12-07"), 500));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// <메소드>
	// 1.등록
	boolean addEmp(Employee emp) {
		return emps.add(emp);
	}

	// 2.목록
	List<Employee> empList() {
		return emps;
	}

	// 3.수정
	boolean modifyEmp(String no, int pay) {
		for (int i = 0; i < emps.size(); i++) {
			if (emps.get(i).getEmpNo().equals(no)) {
				emps.get(i).setEmpPay(pay);
				return true;
			}
		}
		return false;
	}

	// 4.삭제
	boolean removeEmp(String no) {
		for (int i = 0; i < emps.size(); i++) {
			if (emps.get(i).getEmpNo().indexOf(no) != -1) {
				emps.remove(i);
				return true;
			}
		}
		return false;
	}

	// 5.조회(입사일자)--이후 일자출력 못함
	List<Employee> searchEmp(Date empDate) {
		List<Employee> search = new ArrayList<Employee>();
		for (int i = 0; i < emps.size(); i++) {
			if (emps.get(i).getEmpDate().equals(empDate) || emps.get(i).getEmpDate().after(empDate)) {
				search.add(emps.get(i));
			}
		}
		return search;
	}

}
