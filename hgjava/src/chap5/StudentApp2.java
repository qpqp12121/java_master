package chap5;

import java.util.Scanner;

public class StudentApp2 {
	
	//addStudent메소드에도 변수 내용 사용해야 되니까 main 메소드에 있던 거 중 밖에서도 사용해야 되는 건 옮기기
	static Scanner scn = new Scanner(System.in); // static타입이 되어야 사용 가능해서 static붙임
	static Student[] students = null;
	
	//switch case 2 : 코드 너무 길어서 addStudent 메소드() 만들어서 안에 넣음
	//break 앞 코드까지
	public static void addStudent() {
		System.out.println("학생정보 입력>> ");
		for(int i = 0; i < students.length; i++) {
			Student student = new Student(); //학생정보 입력할 변수 // Student 컨트롤 누르고 클릭하면 student데이터 들어있는 방으로 옮겨짐
			// Student : 데이터 타입 -- int num = 60; 형태랑 같음 ( 데이터 추가하고 싶으면 Student클래스 방 가서 입력)
			System.out.print("- 이름: ");
			student.name = scn.nextLine();
			System.out.print("- 점수: ");
			student.score = Integer.parseInt(scn.nextLine());
			System.out.print("- 남/여: ");
			student.gender = scn.nextLine(); //Student클래스 안에 name, score, gender 속성가지고 있음
			
			students[i] = student; //students 변수에 .name이랑.score담은 것 배열에 들어가게
		}
	}//end of addStudent()
	
	//case3
	public static void searchStudent() {
		System.out.print("조회할 이름입력>> ");
		String name = scn.nextLine();
		boolean exists = false;
		
		for(Student stdn : students) { // Student클래스(데이터 들어있는 방) //students방에 student입력받은 거 넣어놨으니까
			                           // students배열에 저장된 값을 매 반복마다 하나씩 순서대로 읽고 변수에 저장해라 
			if(name.equals(stdn.name)) {
				System.out.println(" : 이름은 " + stdn.name + ", 점수는 " + stdn.score +"점");	
				exists = true;
			}
									
		}//for문 끝
		if(!exists) {
			System.out.println("찾는 이름이 없습니다.");
		}
	}//end of searchStudent
	
	//case4
	public static void analysis() {
		System.out.println("분석>> ");
		int sumOfMen = 0, cntOfMen = 0;  //남학생 여학생 점수 따로 누적// 남녀명수도 알아야 평균 구할 수 있으니 cout방 만들고
		int sumOfWomen = 0, cntOfWomen = 0;
		
		// 인덱스 값 필요하면 for문 사용하고, 인덱스값 필요없으면 확장for 사용이 편함
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
		System.out.println("남학생의 평균: " + (sumOfMen * 1.0 / cntOfMen)); // 소수점까지 보려면 *1.0 소수점 하나 만들어 주면 됨
		System.out.println("여학생의 평균: " + (sumOfWomen * 1.0 / cntOfWomen));
	}//end of analysis
	
	
	public static void modify() { //이름입력 하고 - 있으면 (앞에서 잘못 넣은)점수 변경해서 넣기
		                          //확장for쓰면 인덱스 값 못 찾아서 for문으로

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
		}//end for
		
		
		
	}//end of modify()
	
	
	
	
	public static void main(String[] args) {
		//StudentApp에서 이름,점수를 따로 처리했는데 비효율적이라 다시 한번에 넣게
		//61번 라인 참고
		
		boolean run = true;
		int studentNum = 0; //배열의 크기를 지정하기 위한 용도로 방 만듦
		
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
				addStudent();
				
				break;
			case 3 : // " 학생이름 - 점수 " 형태로 출력
				searchStudent();
				break;
			 case 4 :
				analysis();
				break;
			 case 5 :
				 modify();
				 break;
			 case 6 :
				 System.out.println("종료합니다.");
				 run = false;				
			}// end of switch.
		}// end of while.

		
		
	}//end main
	
	
}//end class
