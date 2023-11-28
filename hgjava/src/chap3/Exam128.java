package chap3;

import java.util.Scanner; //나중에 여러 유틸 사용할 때 많아서 import java.util.* (전체로 바꾸면 편함)

public class Exam128 {

	public static void main(String[] args) {
	 // < 문제4 >
		int penNum = 534;
		int stuNum = 30;
		
		//학생1명 가지는 연필 개수
		int ppsNum = penNum / stuNum; //나누어서 그 값을 정수만 받기 (아니면 소수까지 나오니까)
		//남아있는 연필 수
		int rempNum = penNum % stuNum;
		
		System.out.printf("학생당 연필 수 : %d, 남은 연필 수 : %d \n", ppsNum, rempNum); //println으로 하면 두개값 받기 복잡하니
		
	 // < 문제5 > 강제타입변환
		
		
     // < 문제6 >
		int value = 356;
		System.out.println(value/100*100);
	
	/* < 문제7 > 부동소수점 표혖ㄴ방식때문 
	    : (0.1은 0.1보다 큰 값 나오니까 강제타입변환 --> (float)0.1 */
	
   // <문제8> 사다리꼴 너비 = ( 윗변 + 아랫변 ) * 높이 / 2 ----->소수 자릿수까지 나올 수 있도록
		int lenTop = 5;
		int lenBottom = 10;
		int height = 7;
		double area = ((lenTop+lenBottom) * height / 2.0); // 값 하나를 실수로 넣어야 되니까
		System.out.println(area);
		
	// <문제9>
		 // System.out.println(); 자동완성 : syso + ctrl + space 
		//복사 : ctrl + alt + 방향키아래
		//한 줄 지우기 : ctrl + d
		
		Scanner sc = new Scanner(System.in); //유틸모듈에 있어서 ctrl + shift + O
		
		System.out.print("첫번째 수 : ");
		double num1 = sc.nextDouble(); //원래 Scanner String으로 받는데 받는 수 실수니까 double로 받는걸로햇음
		
		System.out.print("두번째 수 : ");
		double num2 = sc.nextDouble();
		
		if(num2 == 0) { //num2가 더블이니까 알아서 0.0으로 받는다 (그래서 굳이 num2 == 0 || num2 ==0.0)으로 할 필요 없음 같기때문에 int로 들어가도 double만나서 자동형변환되니까
			System.out.print("결과: 무한대");
		}else {
			System.out.println("결과: "+ (num1 / num2));
		}
	
		//<문제10번>
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("원의 넓이 : " + var4);
		
		//<문제11번>
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("아이디: ");
		String name = scanner.nextLine();
		
		System.out.print("패스워드: ");
		String strPassword = scanner.nextLine();
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")) {
			if(password == 12345) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패: 패스워드가 틀림");
			}
		}else {
			System.out.println("로그인 실패: 아이디 존재하지 않음");
		}
		

	} //end main

} //end class
