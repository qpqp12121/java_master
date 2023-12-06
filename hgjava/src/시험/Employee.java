package 시험;

public class Employee {

	private String empNo;
	private String empName;
	private String empTel;
	private String empDate;
	private int empPay;
	
	Employee(){
		
	}
	
	Employee(String empNo, String empName, String empTel, String empDate, int empPay){
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empDate = empDate;
		this.empPay = empPay;
	}

	
	//<메소드>
	
	void showInfo() {
		System.out.println(empNo + "\t" + empName + "\t" + empTel + "   " + empPay);
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpTel() {
		return empTel;
	}

	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}

	public String getEmpDate() {
		return empDate;
	}

	public void setEmpDate(String empDate) {
		this.empDate = empDate;
	}

	public int getEmpPay() {
		return empPay;
	}

	public void setEmpPay(int empPay) {
		this.empPay = empPay;
	}
	

	
}//end of class.
