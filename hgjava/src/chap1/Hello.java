package chap1;

import java.io.IOException;
import java.util.Scanner;

public class Hello {

	public static void main(String[] args) throws IOException {
		System.out.println("hello java");
		
		int x = 5;
		int y = x + 10;
		System.out.println(y);
		
		double z = 3.5; //실수선언 --자바에선 데이터 타입에 맞는 변수들 사용
		System.out.println(z);
		System.out.println("y = " + y);
		
		//변수의 값 교환
		x = 3; //위에 이미 선언되어있어 int 빼고 값만
		y = 10;
		
		//값 교환
		int temp = y; //x를 y에 집어넣을 거니까 우선 y원래 값 보존을 위해서 피신
		y = x; // 그리고 x값을 y에 넣으면 '3'들어가고
		x = temp; //temp에 저장해 놓은 y 원래 값 '10'을 다시 x에 넣기
		
		//출력
		System.out.println("x = " + x + " y = "+ y);
		
		
		//<기본타입>
		//크기순서 : byte -> short -> char(음수표현X) -> int -> long
		char charData = 'a';
		int intData = charData;
		System.out.println("char: " + charData + ", int: " + intData); //(a의 코드값이 97임)
		
		char c1 = 'a';
		int c2 = c1 + 2; // 자동타입 변환 ----------c1이 'a'니까 c1+1 하면 b나오고 
		char c3 = (char)c2; // 강제타입 변환
		System.out.printf("c2값은 %d, c3값은 %s \n",c2,c3); //char타입은 문자로 출력되니 %s로 받아주면 됨 --("format",변수,변수...)
		
		x = 5;
		y = 2;
		double result = (double)x / y;  //87p 6번
		System.out.println(result);
		
		double v1 = 3.5;
		double v2 = 2.7;
		int result2 = (int)(v1 + v2); //87p 8번
		System.out.println(result2);
		
		long var1 = 2L; //88p 9번
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9"; //string이니까 실수로 벗기기
		int result3 = (int)(var1 + var2 + var3) + (int)(Double.parseDouble(var4)); 
		System.out.println(result3);		
		
		//표준입력 : 키보드 = > System.in.read()
		//한글자만 읽어들임
		
//		int keyCode;
//		while(true) {
//			keyCode = System.in.read(); //빨간줄 뜨는데 그럼 throws로 해서 IOException(7줄참고)
//			System.out.println("keyCode : " + keyCode);
//			if(keyCode == 113) { //콘솔창에서 q입력하면 keycode가 113이라 이제 입력종료됨
//				break;
//			}
//		}
//		System.out.println("종료"); //System.in을 여기서 사용했는데 밑에서 또 생성해서 주석처리해놓음
		
		//문자열 입력 -> Scanner 클래스 -> 객체를 생성해서 사용
		String scinput;
		Scanner sc = new Scanner(System.in); //ctrl + shift + O : scanner클래스 사용하기 위한 모듈을 불러오는 것 4행참조)
		while(true) {
			System.out.print("이름 입력 :"); //println하면 다음줄에 작성되니까 그냥 print로
			scinput = sc.nextLine();
			
			if(scinput.equals("q")) {
				break;
			}
			System.out.println("내 이름은 " + scinput);
		}
		System.out.println("종료");
		
		System.out.print("수 입력 : ");
		scinput = sc.nextLine();
		System.out.println(Integer.parseInt(scinput) + 10); //그냥 Scanner클래스라 scinput + 10하면 문자열로 1010나옴.그래서 숫자로 변형시키기
		
		
		sc.close();
		
		
		
		
		
		
		
	} // end main method

} //end class 닫히는 것(hello클래스)