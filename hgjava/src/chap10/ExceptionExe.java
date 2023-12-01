package chap10;

public class ExceptionExe {
	public static void main(String[] args) {
		
		//일반예외 : 예외를 처리
		try {
			Class.forName("java.lang.String"); //매개값에 들어있는 클래스가 있는지 체크하고 처리하는 forName메소드
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog.");
		
		

		
		
		
		
	}//end main.
	
}//end class.
