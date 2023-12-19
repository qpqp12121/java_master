package com.yedam;

import java.util.Date;

public class MyPage {

	private String memId;
	private String lecNo;
	private String lecName;
	private String teacherName;
	private Date startDate ;
	private Date endDate;
	private int tuitionFee;
	private Date registDate;


	public MyPage() {
		
	}


	public MyPage(String memId, String lecNo, String lecName, String teacherName, 
			Date startDate, Date endDate,int tuitionFee, Date registDate) {
		this.memId = memId;
		this.lecNo = lecNo;
		this.lecName = lecName;
		this.teacherName = teacherName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tuitionFee = tuitionFee;
		this.registDate = registDate;
	}


	
	
	//메서드
	
	void showInfo() {
//		System.out.print(memId+" | " + lecNo + "  | " + lecName + " | " + startDate + " ~ " + endDate + " | ");
		System.out.printf(" %-4s %-15s %s   %-10s ~ %-10s  %,d원   %-10s\n", lecNo, lecName, teacherName, startDate, endDate, tuitionFee, registDate);
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


	public String getLecName() {
		return lecName;
	}


	public void setLecName(String lecName) {
		this.lecName = lecName;
	}


	public String getTeacherName() {
		return teacherName;
	}


	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getTuitionFee() {
		return tuitionFee;
	}


	public void setTuitionFee(int tuitionFee) {
		this.tuitionFee = tuitionFee;
	}
	
	public Date getRegistDate() {
		return registDate;
	}


	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	
	
	

	
}//end of class.
