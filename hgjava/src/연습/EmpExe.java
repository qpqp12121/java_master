package 연습;

import java.util.ArrayList;
import java.util.List;

public class EmpExe {
	
	List<Emp> emps;
	
	EmpExe(){
		emps = new ArrayList<Emp>();
		emps.add(new Emp("1", "이이", "010-1111", 5000));
		emps.add(new Emp("2", "요요", "010-2222", 8000));
	}
	
	//메소드
	
	boolean addEmp(Emp edt) {
		return emps.add(edt);
	}
	
	List<Emp> empList(){
		return emps;
	}
	
	boolean modifyEmp(String name, int pay) {
		for(int i = 0; i < emps.size(); i++) {
			if(emps.get(i).getEmpName().equals(name)) {
				emps.get(i).setEmpPay(pay);
				return true;
			}
		}
		return false;
	}
	
	

}//end of class.
