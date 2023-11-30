package todo.p20231128;

//BoardApp을 놔둬도 되는데 main메소드 너무 길어서 여기에 간단하게 만들어줌
//여기서 실행하면 작동되는 거임

public class MainExe {
	

	public static void main(String[] args) {
		
		BoardApp app = BoardApp.getInstance();	
		app.start();   // BoardApp에서 main 메소드 지우고 => public void start() {} 여기서부터 시작할 수 있도록 적어줌
		
		
		

	}//end of main.

}//end of class.
