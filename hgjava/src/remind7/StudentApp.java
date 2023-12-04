package remind7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {

		List<Student> students = new ArrayList<>();

		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.print("학생번호 입력>> ");
				String stuNo = scn.nextLine();
				System.out.print("학생이름 입력>> ");
				String stuName = scn.nextLine();
				System.out.print("영어점수 입력>> ");
				int engScore = Integer.parseInt(scn.nextLine());
				System.out.print("수학점수 입력>> ");
				int mathScore = Integer.parseInt(scn.nextLine());

				// 하나의 인스턴스로 저장
				students.add(new Student(stuNo, stuName, engScore, mathScore));
				break;

			case 2:
				for (Student std : students) {
					std.studentList();
	
				}
				break;
			case 3:
				System.out.print("학생번호 입력>> ");
				stuNo = scn.nextLine();
				for (Student std : students) {
					if (std.getStuNo().indexOf(stuNo) != -1) {
						std.studentList();
					}
				}
				System.out.println("존재하지 않는 학생번호"); //---확인
				break;
			case 4:
				System.out.print("수정할 학생번호 입력>> ");
				stuNo = scn.nextLine();
				for (int i = 0; i < students.size(); i++) {
					Student modify = students.get(i);
					if (modify.getStuNo().indexOf(stuNo) != -1) {
						System.out.println("변경할 영어점수>> ");
						engScore = Integer.parseInt(scn.nextLine());
						System.out.println("변경할 수학점수>> ");
						mathScore = Integer.parseInt(scn.nextLine());

						modify.setEngScore(engScore);
						modify.setMathScore(mathScore);
					}//존재하지않습니다 넣기
				}
			    break;
			        
			 case 5:
				 System.out.print("삭제할 학생이름 입력>> ");
			     stuName = scn.nextLine();
			     for(int i = 0; i < students.size(); i++) {
			    	
			    	 if(students.get(i).getStuName().indexOf(stuName) != -1) {
			    		 students.remove(i);
			    	 }
			     }
			     break;
			     
			 case 6:
				 System.out.println("프로그램 종료");
				 run = false;
			
			}// end switch

		} // end while

	}// end of main.
}// end of class.
