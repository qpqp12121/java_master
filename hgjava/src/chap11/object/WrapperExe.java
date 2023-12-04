package chap11.object;

public class WrapperExe {

	public static void main(String[] args) {
		int num = 10;
		Integer num2 = new Integer(20); // Integer num2 = 20; 이렇게 해도 됨
		num = Integer.valueOf("100");
		num = Integer.parseInt("100");
		
		Double d2 = 10.0;
		d2 = Double.valueOf("10.2");
		d2 = Double.parseDouble("20.3");
		
	}//end of main.
	
	
}//end of class.
