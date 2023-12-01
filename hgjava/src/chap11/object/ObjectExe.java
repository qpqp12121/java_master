package chap11.object;

public class ObjectExe {

	public static void main(String[] args) {
//   < equals >
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		//객체의 주소값을 비교해서 항상 false
		System.out.println(obj1.equals(obj2));
		
		//String클래스는 예외로 안에 있는 문자열을 비교하기때문에 true
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		System.out.println(str1.equals(str2));
		
		Member mem1 = new Member("홍길동", 22);
		Member mem2 = new Member("홍길동", 22); //원래는 객체의 주소값을 비교해서 false인데 Member클래스에서 equals 재정의하여 true로
		System.out.println(mem1.equals(mem2));
		
	}//end of main.
	
}//end of class.
