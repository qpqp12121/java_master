package chap7.casting;

public class Child extends Parent {
	private String phone;
	
	@Override
	String showInfo() {
		return super.showInfo()	+ " - " + phone; //앞에는 부모Parent가 가지고 있는 name, age보여줌
		}
	
	
}//end of class.
