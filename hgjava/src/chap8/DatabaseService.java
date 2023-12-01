package chap8;

//추상클래스처럼 추상메소드
// Oracle: insert(), update() / MySQL: add(), modify() 

public interface DatabaseService {
	//interface는 상수만 사용가능! (변수로 사용 X)-왜? 값을 바꾸는 게 아닌 규칙만 제시하는 거라서
	public static final String name = "";
	
	//입력, 수정, 삭제 기능(메소드)
	public void add();
	public void modify();
	public void remove();
	
	
	
}//end interface.
