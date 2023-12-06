package 시험;

import java.util.ArrayList;
import java.util.List;

public class EmpDAO {

	List<Employee> emps;
	
	EmpDAO(){
		emps = new ArrayList<Employee>();
		emps.add(new Employee("23-11", "홍길동", "943-1234", "2023-10-01", 300));
	}
	
	//<메소드>
	//1.등록
	boolean addEmp(Employee emp) {
		return emps.add(emp);
	}
	//2.목록
	List<Employee> empList(){
		return emps;
	}
	//3.수정
	boolean modifyEmp(String no, int pay) {
		for(int i = 0; i < emps.size(); i++) {
			if(emps.get(i).getEmpNo().equals(no)) {
				emps.get(i).setEmpPay(pay);
				return true;
			}
		}
		return false;
	}
	//4.삭제
	boolean removeEmp(String no) {
		for(int i = 0; i < emps.size(); i++) {
			if(emps.get(i).getEmpNo().indexOf(no) != -1) {
				emps.remove(i);
				return true;
			}
		}
		return false;
	}
	//5.조회(입사일자)--이후 일자출력 못함
	List<Employee> searchEmp(String date){
		List<Employee> search = new ArrayList<Employee>();
		for(int i = 0; i < emps.size(); i++) {
			if(emps.get(i).getEmpDate().equals(date)) {
				search.add(emps.get(i));
			}
		}
		return search;
	}
	
}//end of class.

