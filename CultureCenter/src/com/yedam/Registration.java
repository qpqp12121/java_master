package com.yedam;

import java.sql.Date;

public class Registration {

	private int registNo;
	private String memId;
	private String lec_no;
	private String teacher_name;
	private Date registDate;
	
	//생성자
	Registration(){
		
	}

	public Registration(int registNo, String memId, String lec_no, String teacher_name, Date registDate) {
		super();
		this.registNo = registNo;
		this.memId = memId;
		this.lec_no = lec_no;
		this.teacher_name = teacher_name;
		this.registDate = registDate;
	}

	
	//메소드
	public int getRegistNo() {
		return registNo;
	}

	public void setRegistNo(int registNo) {
		this.registNo = registNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getLec_no() {
		return lec_no;
	}

	public void setLec_no(String lec_no) {
		this.lec_no = lec_no;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	
	
	
	
	
}//end of class.
