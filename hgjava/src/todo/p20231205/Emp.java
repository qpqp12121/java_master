package todo.p20231205;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp {

	//Emp 사원정보: 사번/이름/전화번호/입사일자(오늘날짜)--입력안했을 경우 기본값으로 오늘날짜 나오도록 /급여
	
	//<필드>
	private String empNo;
	private String empName;
	private String empTel;
	private Date empDate;
	private String empDate2; //??
	private int empPay;
	
	//<생성자>
	Emp(){
		
	}

	
	Emp(String empNo, String empName, String empTel, int empPay){
		this.empNo = empNo;
		this.empName = empName;
		this.empTel = empTel;
		this.empPay = empPay;
		this.empDate = new Date();
	}
	Emp(String empNo, String empName, String empTel, String date, int empPay){
		this(empNo, empName, empTel, empPay);
		this.empDate2 = empDate2; //??
	}
	
	
	//<메소드>
	void showInfo() {
		System.out.println(empNo + "\t" + empName + "\t" + empTel + "\t" +  empDate + "\t" + empPay);
	}
	
	//getter setter
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

	public Date getEmpDate() {
		return empDate;
	}

	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}

	public int getEmpPay() {
		return empPay;
	}

	public void setEmpPay(int empPay) {
		this.empPay = empPay;
	}

	
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(empDate);
	}
	
	
	
}
