package chap11.object;

//import lombok.EqualsAndHashCode;

public class Member {
	
	//필드
	private String name;
	private int age;
	
	//생성자
	Member(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	//equals 재정의 (각 클래스에서 필요에 따라 새로정의가능)
	public boolean equals(Object obj) {
		//이름과 나이가 같으면 논리적으로 동등한 객체로 보도록 만들겠다
		if(obj instanceof Member) {
			Member target = (Member)obj;
			if(this.name.equals(target.name) && this.age == target.age) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	

	
}//end of class.
