package chap5;

import java.util.Scanner;

import chap6.Student;

public class 연습창 {
	public static void main(String[] args) {

// ArrayExe2.
		
		//배열 생성하고 10-100까지 수 중 10단위의 값을 배열에 할당
		int[] array = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = (i + 1) * 10;
		}
		
		//배열 중 50보다 큰 수들의 합계와 평균
		int sum = 0;
		double avg = 0;
		int count = 0;
		
		for( int num : array) {
			if( num > 50 ) {
				sum += num;
				count++;
			}
		 
		}
		avg = sum * 1.0 / count; //지금은 80으로 딱 맞아 떨어져 상관없지만
		     // 실수로 표현되려면 지금은 sum,count 둘 다 int형태라 하나를 실수로 바꿔주기 -> sum * 1.0
		System.out.println("50보다 큰 수의 합계: " + sum);
		System.out.println("50보다 큰 수의 평균: " + avg);
		
		
// ArrayExe3.		
		
	// Q. "홍길동" 이 총 몇 명인지 구하라	
		
		String[] nameAry = { "홍길동", "김길동", "박길동", "홍길동", "황길동"};
		
		String search = "홍길동";
		int cnt = 0;
		
		for(String name : nameAry) {
			if(name.equals(search)) {
				cnt++;
			}
		}
		System.out.println(search + "은 총 " + cnt + "명 입니다");
	
		
    // Q. 제일 높은 점수 구하기	
		
		int[] scores = {88, 68, 72, 89, 92, 70};
		
		int max = 0;
		
		//향상for문
		for(int num : scores) {
			if(num > max) {
				max = num;
			}
		}
		System.out.println("향상for문> 제일 높은 점수: " + max + "점");
		
		//일반for문
		for(int i = 0; i < scores.length; i++) {
			if(scores[i] > max) {
				max = scores[i];
			}
		}
		System.out.println("일반for문> 제일 높은 점수: " + max + "점");

		
		
// WhileExe.		

	//Q. 문자를 입력받아라. 만약 quit 문자를 만나면 종료해라
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.print("문자 값 입력>> ");
			
			String txt = scn.nextLine();
			if(txt.equals("quit")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			System.out.println("입력값: " + txt);
		}

// ReferenceExe.		
	//Q.
		
		
		//위에서 입력받은 정보들을 담아 하나의 인스턴스로 만들기(생성자)
		Student std = new Student(no, name, eng, math); //클래스 사용할 거라 생성자 만들기

		//값을 students배열에 담기 (한 건만)
		for(int i = 0; i < students.length; i++) { //일단 몇 개인지 모르니까 길이만큼 다 돌게
			if(students[i] == null) { //비어있는 공간 찾아서 거기에 값 넣기 위해서(이걸 길이만큼 반복)
				students[i] = std; //인스턴스 내용을 배열요소로 넣기

			break; //처음엔 값 다 null이라 break하고 빠져나와야 됨(아니면 다른 공간도 다 첫번째 값으로 채워져 버림)
			}

		}
		System.out.println("저장되었습니다.");
		break;
		
	case 2 : //2.목록보기 기능
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null) { //위와 달리 값이 들어있는 곳 목록만 출력할거니까 (*꼭 [i]요소의 값이 들어있는지 확인해야되니까 까먹지 말기!)	
				students[i].showInfo();
			}
		}
		break;

	case 3 : //단건조회 (사용자가 학생번호를 넣으면 조회할 수 있도록)

		System.out.print("조회할 학생번호 입력>> ");
		no = scn.nextLine(); //똑같은 번호 있는지 돌면서 볼 것

		boolean exists = false;​
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuNo().equals(no)) { //getStuNo이랑 사용자가 입력한 no값이랑 비교
				students[i].showInfo();
			exists = true;
			}
		}

		if(!exists) { //학생번호 없으면 조회할 학생번호가 없습니다 출력하게
			System.out.println("조회할 학생번호가 없습니다.");
		}
		break;

	case 4 : //학생번호 넣고 영어,수학 점수 수정
		System.out.print("수정할 학생번호 입력>> ");
		no = scn.nextLine();

		boolean exists2 = false;
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuNo().equals(no)){
				System.out.print("변경할 영어점수 입력: ");
				students[i].setEngScore(Integer.parseInt(scn.nextLine()));
				System.out.print("변경할 수학점수 입력: ");
				students[i].setMathScore(Integer.parseInt(scn.nextLine()));
				
				exists = true;
			}
		}

		if(!exists2) {
			System.out.println("찾는 학생번호가 없습니다.");

		}
		break;

	​

	case 5 : //학생 이름 넣어서 삭제(해당되는 것의 값을 null로 하면 삭제 됨
		System.out.print("삭제할 학생이름 입력>> ");
		name = scn.nextLine();

		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStuName().equals(name)){
				students[i] = null;
			}
		}	
		System.out.println("삭제 되었습니다.");
		break;

	case 6 :
		System.out.println("프로그램을 종료합니다");
		run = false;
		}
}//end of while.

System.out.println("end of prog.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}//end of main
}//end of class		