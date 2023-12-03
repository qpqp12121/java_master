package 연습;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		Student student = new Student();
		//배열필드 사용하려고 (StudentExe에 있음)
		StudentExe exe = new StudentExe();
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1: //등록
				System.out.println("학생번호 입력>> ");
				String num = scn.nextLine();
				System.out.println("학생이름 입력>> ");
				String name = scn.nextLine();
				System.out.println("영어점수 입력>> ");
				int eng = Integer.parseInt(scn.nextLine());
				System.out.println("수학점수 입력>> ");
				int math = Integer.parseInt(scn.nextLine());
				
				Student std = new Student(num,name,eng,math);
				
				if(exe.addStudent(std)) {
					System.out.println("저장되었습니다");
				}else {
					System.out.println("저장 오류 발생!");
				}
				break;
			case 2: //목록	
				for(Student std2 : exe.getStudentList()) {
					if(std2 != null) {
						std2.showInfo(); //showInfo void타입이라 
					}
				}
				break;
			case 3: //단건조회
				System.out.println("조회할 학생번호 입력>> ");
				num = scn.nextLine();
				Student stn = exe.getStudent(num);
				if(stn != null) {
					stn.showInfo();
				}else {
					System.out.println("존재하지 않는 정보.");
				}
				break;
			case 4: //수정
				System.out.println("수정할 학생번호 입력>> ");
				num = scn.nextLine();
				System.out.println("변경할 영어점수 입력>> ");
				eng = Integer.parseInt(scn.nextLine());
				System.out.println("변경할 수학점수 입력>> ");
				math = Integer.parseInt(scn.nextLine());
				
				if(exe.modifyStudent(num, eng, math)) {
					System.out.println("수정 완료.");
				}else {
					System.out.println("수정 실패.");
				}
				break;
			case 5: //삭제	
				System.out.println("삭제할 학생이름 입력>> ");
				name = scn.nextLine();
				
				if(exe.removeStudent(name)) {
					System.out.println("삭제 완료.");
				}else {
					System.out.println("삭제 실패");
				}
				break;
				
			case 6: //종료
				System.out.println("프로그램을 종료합니다");
				run = false;
	
			}//end switch
		}//end while
		
		
		
	}//end main.

}//end class.
