package chap5;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int studentNum = 0;
		int[] scores= null; //점수 배열 선언만 int[] scores; 했을 때 오류 떴음 => int[] scores = null;값 넣어줌
		String[] names = null; //2번 점수입력하고 누구 점수인지 모르기 때문에 따로 방 만들어서 이름까지(점수 배열수만큼 넣기)
		
		
		// 1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.종료
		
		boolean run = true;
		while(run) {
			System.out.println(" 1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.종료");
			int menu = scn.nextInt(); //사용자가 3 입력 후 Enter 치면 입력한 3을 받아들이는게 int
			scn.nextLine();    //근데 enter는 아직 안 받아들여서 기다리지 않고 연달아 나옴--그래서 enter까지 받아들이게
			
			switch(menu) {
			case 1 :
				System.out.print("학생수입력>> ");
				studentNum = scn.nextInt();
				scores = new int[studentNum];
				names = new String[studentNum]; //점수 입력받는 크기만큼 똑같이 해줘야 되니까
				break;	
			case 2 :
				System.out.println("점수입력>> ");
				for(int i = 0; i < scores.length; i++) {
					System.out.println("names[ " + i + " ]>> "); //몇번째 위치의 이름
					names[i] = scn.nextLine();
					System.out.println("scores[ " + i + " ]>> "); //몇번째 위치의 점수
					scores[i] = scn.nextInt();
					scn.nextLine(); //nextInt 숫자만 처리하니까 enter값 처리하게 nextLine 연달아 넣어주기
				}
				break;
			case 3 :
				System.out.print("목록출력>> ");
				for(int i = 0; i < scores.length; i++) {
					System.out.println("이름은 " + names[i] + ", 점수는 " + scores[i] + "\n");
				}
				break;	
			case 4 :
				System.out.print("분석>> ");
				//최고점수 출력. 구현
				int maxScore = 0;
				int sum = 0;
				double avg = 0; //avg = sum * 1.0 / scores.length;
				String maxName = "";
				
//				for(int num : scores) { //이걸로 했을 땐 maxScore값만 출력하고 maxName의 값을 못 출력해서? 아래 반복문으로
//				 sum += num;
//				 if(maxScore < num) {
//					 maxScore = num;
//				 }
				
				for(int i = 0; i < scores.length; i++) { 
					sum += scores[i];
					if(maxScore < scores[i]) { //이름,점수를 하나의 변수에 담고 싶으면 클래스 사용해야 된다 그래서 class파일 확인하기!
						maxScore = scores[i];
						maxName = names[i];
					}
				}	avg = sum * 1.0  / scores.length;  // 수 하나 실수로 바꿔줘야 double에 들어가서			
		
				System.out.println("최고점수는 " + maxName + " => 점수: " + maxScore + ", 평균: " + avg);
				break;
			case 5 :
				System.out.print("종료");
				run = false;
				
			}//end of switch.
			
		}//end of while.
		System.out.println("end of prog.");
		
		
		
		
	}//end main
}//end class
