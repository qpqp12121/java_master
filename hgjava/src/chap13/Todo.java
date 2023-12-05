package chap13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Todo {
	
	//<필드>
	private String todo;
	private Date dueDate;
	
	//<생성자>
	Todo(String todo){ //항목 todo만 넣으면 오늘까지 완료하는 걸로(오늘날짜 객체만들기
		this.todo = todo;
		this.dueDate = new Date(); //년,월,일 시:분:초 (호출되는 시점에 정보 다 있음
	}
	
	Todo(String todo, Date dueDate){
		this.todo = todo;
		this.dueDate = dueDate;
	}
	
	//값 따로 바꿀 목적 없어서 get set 생략
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return todo + "  " + sdf.format(dueDate);
	}
	
	
	
	
	
	
}//end of class.
