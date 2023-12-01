package chap7.abstracts;

public abstract class Animal {
	private String name;
	
	public Animal() {
		
	}
	
	public void setName(){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	//추상 메소드 -- 위는 동일한데 추상메소드를 통해서 규칙을 지정할 때 필요 // //추상클래스를 상속하는 자식클래스는 추상메소드를 반드시 구현해줘야 된다
	public abstract void sound(); 

	
}//end of class.
