package chap5;

import java.util.Scanner;

public class 연습창_SA2 {

 // StudentApp2. 여러 메소드들 만들기 전 코드		
			
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		Student[] students = null;
		boolean run = true;
		int studentNum = 0; 
	
		while(run) {
			System.out.println(" 1.학생수 2.학생이름,점수입력 3.조회 4.분석(평균) 5.수정 6.종료");
			int menu = scn.nextInt(); 
			scn.nextLine();   
			
			switch(menu) {
			case 1 :
				System.out.print("학생수 입력>> ");
				studentNum = Integer.parseInt(scn.nextLine()); 
				students = new Student[studentNum]; //배열 크기 지정하기
				break;
				
			case 2 :
				System.out.println("학생정보 입력>> ");
				for(int i = 0; i < students.length; i++) {
					Student student = new Student(); 
					
					System.out.print("- 이름: ");
					student.name = scn.nextLine();
					System.out.print("- 점수: ");
					student.score = Integer.parseInt(scn.nextLine());
					System.out.print("- 남/여: ");
					student.gender = scn.nextLine(); 
					
					students[i] = student; //students 변수에 .name이랑.score담은 것 배열에 들어가게
				}	
				break;
				
			case 3 : // " 학생이름 - 점수 " 형태로 출력
				System.out.print("조회할 이름입력>> ");
				String name = scn.nextLine();
				boolean exists = false;
				
				for(Student stdn : students) { 	                           
					if(name.equals(stdn.name)) {
						System.out.println(" : 이름은 " + stdn.name + ", 점수는 " + stdn.score +"점");	
						exists = true;
					}
											
				}//for문 끝
				
				if(!exists) {
					System.out.println("찾는 이름이 없습니다.");
				}
				break;
				
			 case 4 :
				 System.out.println("분석>> ");
				 int sumOfMen = 0, cntOfMen = 0;  
				 int sumOfWomen = 0, cntOfWomen = 0;
					
				 for(Student stn : students) {
					if(stn.gender.equals("남")) {
					   sumOfMen += stn.score;
					   cntOfMen ++;
					}
					else if(stn.gender.equals("여")) {
						 sumOfWomen += stn.score;
						 cntOfWomen ++;
					}
				 }
				 System.out.println("남학생의 평균: " + (sumOfMen * 1.0 / cntOfMen)); 
				 System.out.println("여학생의 평균: " + (sumOfWomen * 1.0 / cntOfWomen));
				 break;
			 case 5 :
				 System.out.print("조회할 이름입력>> ");
				 String name = scn.nextLine();
				 boolean exists = false;
					
				 for(int i = 0; i < students.length; i++) {
					// 이름 가지고 있으면 변경점수 입력
				   if(name.equals(students[i].name)) {
					 System.out.print("변경할 점수 입력: ");
					 students[i].score = Integer.parseInt(scn.nextLine());
					 exists = true;
					}
						
				   if(!exists) {
					 System.out.println("찾는 이름이 없습니다.");
				   }
				 }
				 break;
				 
			 case 6 :
				 System.out.println("종료합니다.");
				 run = false;				
			}// end of switch.
		}// end of while.
	  }//end main
}//end class
	
	
	
