package b;

import java.sql.Date;

public class Lecture {

	private int lecNo;
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

	public Lecture(int lecNo, String category, String lecName, String lecTarget, String teacherName, Date startDate,
			Date endDate, int tuitionFee, int numberOfMem, int minMem) {
		super();
		this.lecNo = lecNo;
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
		System.out.println(lecNo + ". " + lecName + "  | " + lecTarget + " | " + startDate + " ~ " + endDate);
//		System.out.printf();
	}
	
	//getter, setter
	public int getLecNo() {
		return lecNo;
	}

	public void setLecNo(int lecNo) {
		this.lecNo = lecNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String lecCategory) {
		this.category = lecCategory;
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
