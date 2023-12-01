package chap10;

public class NullExceptionExe {
	public static void main(String[] args) {
		//Null 값을 참조할 경우 *주의!
		
		String name = "Hong";
		
		name = null;
		String menu = "2"; //--알수없는 오류보려고
		int[] numary = {1,2};
		
		//예외처리.
		try {
			name = ""; //알 수 없는 예외발생 확인하기 위해서 null값 없앰
			System.out.println(name.toString()); //null값에 toString()을 실행하라니까 예외발생
			int num = Integer.parseInt(menu);
			System.out.println("입력값은 " + num);
			System.out.println(numary[3]);
			
			//만약 다른 예외들이 발생했을 때 처리 방법이 같다면 | 로 연결시켜줘서 사용가능
		} catch(NullPointerException | NumberFormatException e) { //catch()괄호 안에 어떤 예외 발생했는지 넣기
			System.out.println("Null 예외발생. 010-1111-2222로 전화"); //System.out.println(name.toString()); - null값에 toString()을 실행하라니까 예외발생
//		} catch(NumberFormatException ne) {
//			System.out.println("숫자값을 입력하세요."); // int num = Integer.parseInt(menu); 이거 예외발생했을 때
		} catch(Exception ee) {
			System.out.println("알 수 없는 예외 발생.");
		}
		System.out.println("end of prog.");
		
		
		
	}//end main.
	
}//end class.
