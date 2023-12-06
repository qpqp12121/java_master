package todo.p20231206;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp {
	//Emp 사원정보: 사번/이름/전화번호/입사일자(오늘날짜)--입력안했을 경우 기본값으로 오늘날짜 나오도록 /급여
	
		//<필드>
		private String empNo;
		private String empName;
		private String empTel;
		private String empDate;
		private int empPay;
		
		//<생성자>
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
		
		Emp(String empNo, String empName, String empTel, String empDate, int empPay){
			this(empNo, empName, empTel, empPay);
			this.empDate = empDate;
		}
		
		
		//<메소드>
		void showInfo() {
			System.out.println(empNo + "    " + empName + "  " + empTel + "  " +  empDate + "  " + empPay);
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

		
		
//		@Override
//		public String toString() {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			return sdf.format(empDate);
//		}

}
