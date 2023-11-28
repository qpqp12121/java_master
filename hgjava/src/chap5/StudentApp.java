package chap5;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		
/*	Q. 번호 선택하면 정보 출력되게 만들기
	  < 1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.종료 > */
		
		Scanner scn = new Scanner(System.in);
		int studentNum = 0;
		int[] scores= null; //점수 배열 선언만 int[] scores; 했을 때 오류 떴음 => int[] scores = null;값 넣어줌
		String[] names = null; //2번 점수입력하고 누구 점수인지 모르기 때문에 따로 방 만들어서 이름까지(점수 배열수만큼 넣기)
		
		
		
		boolean run = true;
		while(run) {
			System.out.println(" 1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.종료 ");
			int menu = scn.nextInt(); //사용자가 3 입력 후 Enter 치면 입력한 3을 받아들이는게 int
			scn.nextLine();    //근데 enter는 아직 안 받아들여서 기다리지 않고 연달아 나옴--그래서 enter까지 받아들이게
			
			switch(menu) {
			case 1 :
				System.out.print("학생수입력>> ");
				studentNum = scn.nextInt();   //위에서 studentNum, scores 변수명을 int방으로 만듦
				scores = new int[studentNum]; //입력받은 학생 수 길이만큼 scores방 길이를 만들어야 되니까
				names = new String[studentNum]; //학생 수 길이만큼 방크기 만들어야 되니 [studentNum]
				break;	
			case 2 :
				System.out.println("점수입력>> "); // 점수입력 문구뜨면 누구점수인지, 몇점인지 각각 입력해야되니 아래서 설정
				for(int i = 0; i < scores.length; i++) {   //names,scores 변수의 [i] 인덱스 값에 접근하려면 일반 for문 사용
					System.out.println("names[ " + i + " ]>> "); //0번째 위치에 넣을 이름부터~ 계속 => 출력: 점수입력>> names[0]>>
					names[i] = scn.nextLine();
					System.out.println("scores[ " + i + " ]>> "); //0번째 위치에 넣을 점수부터~ 계속 => 출력: scores[0]>>
					scores[i] = scn.nextInt();
					scn.nextLine(); //위에 점수 nextInt로 받아 숫자만 처리하니까 enter값 처리하게 nextLine 연달아 넣어주기
				}
				break;
			case 3 :
				System.out.print("목록출력>> ");
				for(int i = 0; i < scores.length; i++) {
					System.out.println("이름은 " + names[i] + ", 점수는 " + scores[i] + "\n");
				}
				break;	
			case 4 :
				System.out.print("분석>> "); //분석 결과로 "최고점수와 평균" 나오게
				int maxScore = 0;
				int sum = 0;
				double avg = 0;  // avg = sum * 1.0 / scores.length;
				String maxName = "";				
				
				for(int i = 0; i < scores.length; i++) { 
					sum += scores[i];
					if(maxScore < scores[i]) {  //이름, 점수 각각 넣어 효율적인 코드 X 
						maxScore = scores[i];   //이름,점수를 하나의 변수에 담고 싶으면 클래스 사용해야 된다 그래서 Student파일로 클래스 데이터 넣고 App2에서 작업한 것 확인하기!
						maxName = names[i];
					}
				}	
				avg = sum * 1.0  / scores.length;  // 수 하나 실수로 바꿔줘야 double에 들어가서			
		
				System.out.println("최고점수를 받은 " + maxName + " => 점수: " + maxScore + ", 평균: " + avg);
				break;
			case 5 :
				System.out.print("종료");
				run = false;	
			}//end of switch.
			
		}//end of while.
		System.out.println("end of prog.");
		
		
		
		
	}//end main
}//end class
