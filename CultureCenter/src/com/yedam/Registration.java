package com.yedam;


import java.sql.*;

public class Registration {

	private int registNo;
	private String lecNo;
	private String memId;
	private Date registDate;
	
	//생성자
	Registration(){
		
	}
	
	public Registration(String lecNo, String memId, Date registDate) {
		super();
		this.lecNo = lecNo;
		this.memId = memId;
		this.registDate = registDate;
	}
	public Registration(String lecNo, String memId) {
		this.lecNo = lecNo;
		this.memId = memId;
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

	public String getLecNo() {
		return lecNo;
	}

	public void setLecNo(String lecNo) {
		this.lecNo = lecNo;
	}


	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	
	
	
	
	
}//end of class.
