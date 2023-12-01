package chap7.casting;

public class MainExe {
	public static void main(String[] args) {
		
	

//	자동형변환(promotion)
		Parent p1 = new Child(); //자바에서 오른쪽이랑 왼쪽 타입 같아야 되는데 ㅇㅕ기서 오류 안뜸 왜?자동으로 자식클래스가 부모클래스로 알아서 자동형변환 (Parent) Child식으로
		
//  강제형변환(casting) --무조건적 X 예외있음
		//Child c1 = (Child)new Parent(); // 부모가 자식한테 들어가려면 강제로 바꿔줘야 됨
	
		//강제형변환
		//자식인스턴스는 강제형변환 OK /근데 부모인스턴스는 강제형변환 에러
		Parent p2 = new Parent();
		Child c2 = new Child();
		
		p2 = c2;
		//형변환 전에 인스턴스 유형을 체크해야 된다
		if(p2 instanceof Child) {
			Child c3 = (Child) p2;
		}
		System.out.println("end of prog");
		
		
	}//end of main.
	
}//end of class.
