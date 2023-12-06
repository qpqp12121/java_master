package todo.p20231206;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EmpExe {

	// <필드>
	private List<Emp> emps;

	// <생성자>
	EmpExe() {
		emps = new ArrayList<Emp>();
		emps.add(new Emp("1", "이이", "010-1111", 5000));
		emps.add(new Emp("2", "요요", "010-2222", 8000));
	}

	// 1.등록
	boolean addEmp(Emp edt) {
		return emps.add(edt);
	}


	// 2.목록
	List<Emp> empList() {
		return emps;
	}

	// 3.수정
	boolean modifyEmp(String name, int pay) {
		for (int i = 0; i < emps.size(); i++) {
			if (emps.get(i).getEmpName().equals(name)) {
				emps.get(i).setEmpPay(pay);
				return true;
			}
		}
		return false;
	}

	// 4.삭제
	boolean removeEmp(String name) {
		for (int i = 0; i < emps.size(); i++) {
			if (emps.get(i).getEmpName().equals(name)) {
				emps.remove(i);
				return true;
			}
		}
		return false;
	}

	// 5.조회(입사일) ---단건조회는 그냥 Emp타입으로 하면 되는데 여러건은 배열로 담아야되니까
	List<Emp> empInfo(String date) {
		ArrayList<Emp> emp1 = new ArrayList<Emp>();
		for (int i = 0; i < emps.size(); i++) {
			if (emps.get(i).getEmpDate().equals(date)) {
				emp1.add(emps.get(i));
			}
		}
		return emp1;
	}

}//end of class.
