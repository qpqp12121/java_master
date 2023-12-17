package com.yedam;

import java.sql.Date;

public class Lecture {

	private String lecCode;
	private String category;
	private String lecName;
	private String lecTarget;
	private String teacherName;
	private Date startDate;
	private Date endDate;
	private int tuitionFee;
	private int numberOfMem;
	private int minMem;
	
	//생성자
	Lecture(){
		
	}

	public Lecture(String lecCode, String category, String lecName, String lecTarget, String teacherName, Date startDate,
			Date endDate, int tuitionFee, int numberOfMem, int minMem) {
		super();
		this.lecCode = lecCode;
		this.category = category;
		this.lecName = lecName;
		this.lecTarget = lecTarget;
		this.teacherName = teacherName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tuitionFee = tuitionFee;
		this.numberOfMem = numberOfMem;
		this.minMem = minMem;
	}
	
	//메소드
	
	//showInfo
	void showInfo() {
		System.out.println(lecCode + ". " + lecName + "  | " + lecTarget + " | " + startDate + " ~ " + endDate);
//		System.out.printf();
	}
	
	//showCate
	void showCategory() {
		System.out.print(category+" | ");
	}
	
	//getter, setter
	public String getLecNo() {
		return lecCode;
	}

	public void setLecCode(String lecCode) {
		this.lecCode = lecCode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLecName() {
		return lecName;
	}

	public void setLecName(String lecName) {
		this.lecName = lecName;
	}

	public String getLecTarget() {
		return lecTarget;
	}

	public void setLecTarget(String lecTarget) {
		this.lecTarget = lecTarget;
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

	public int getNumberOfMem() {
		return numberOfMem;
	}

	public void setNumberOfMem(int numberOfMem) {
		this.numberOfMem = numberOfMem;
	}

	public int getMinMem() {
		return minMem;
	}

	public void setMinMem(int minMem) {
		this.minMem = minMem;
	}
	
	
	
	
}//end of class.
