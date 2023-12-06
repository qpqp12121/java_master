package 연습;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp {
	
	private String empNo;
	private String empName;
	private String empTel;
	private String empDate;
	private int empPay;
	
	Emp(){
		
	}
	Emp(String empNo, String empName, String empTel, int empPay){
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empPay = empPay;
		this.empDate = sdf.format(today);
	}
	Emp(String empNo, String empName, String empTel, String empDate,int empPay){
		this(empNo, empName, empTel, empPay);
		this.empDate = empDate;
	}
	
	//<메소드>
	
	void showInfo() {
		System.out.println(empNo + empName + empTel + empDate + empPay);
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
	
	
	
	

}
