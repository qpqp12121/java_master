package todo.p20231205;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpExe연습 {

	// <필드>
	private List<Emp> emps;

	// <생성자>
	EmpExe연습() {
		emps = new ArrayList<Emp>();
		emps.add(new Emp("1", "이이", "010-1111", 5000));
		emps.add(new Emp("2", "요요", "010-2222", 8000));
	}

	// 1.등록
	boolean addEmp(Emp edt) {
		return emps.add(edt);
	}

//	// 입사일?///////////////////////////
//	boolean dateEmp(Date date) {
//		if (date == null) {
//			date.toString();
//			return true;
//		}
//		return false;
//	}

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

	// 5.조회(입사일)
	Emp empInfo(String date) {
		for (int i = 0; i < emps.size(); i++) {
			if (emps.get(i).getEmpDate().equals(date)) {
				return emps.get(i);
			}
		}
		return null;
	}

}
