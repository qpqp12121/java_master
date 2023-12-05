package remind7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {

//		List<Student> students = new ArrayList<>();
		StudentExe exe = new StudentExe();
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1://등록
				System.out.print("학생번호 입력>> ");
				String stuNo = scn.nextLine();
				System.out.print("학생이름 입력>> ");
				String stuName = scn.nextLine();
				System.out.print("영어점수 입력>> ");
				int engScore = Integer.parseInt(scn.nextLine());
				System.out.print("수학점수 입력>> ");
				int mathScore = Integer.parseInt(scn.nextLine());

				// 하나의 인스턴스로 저장
				Student std = new Student(stuNo, stuName, engScore, mathScore);
				if(exe.addStudent(std)) {
					System.out.println("저장완료");
				}else {
					System.out.println("저장실패");
				}
				break;
			case 2://목록
				List<Student> stuAry = exe.stuList();
				for(Student stdt : stuAry) {
					stdt.showInfo();
				}
				break;
			case 3://단건조회
				System.out.print("학생번호 입력>> ");
				stuNo = scn.nextLine();
				Student stdt = exe.stuInfo(stuNo);
				if(stdt != null) {
					stdt.showInfo();
					}
				break;
			case 4: //수정
				System.out.print("수정할 학생번호 입력>> ");
				stuNo = scn.nextLine();
				System.out.print("변경할 영어점수>> ");
				engScore = Integer.parseInt(scn.nextLine());
				System.out.print("변경할 수학점수>> ");
				mathScore = Integer.parseInt(scn.nextLine());
				
				if (exe.modifyStudent(stuNo,engScore,mathScore)) {
					System.out.println("수정완료");
				}else {
					System.out.println("처리실패");
				}
			    break;  
			 case 5: //삭제
				 System.out.print("삭제할 학생이름 입력>> ");
			     stuName = scn.nextLine();
			     if(exe.removeStudent(stuName)) {
			    	 System.out.println("삭제완료");
			     }else {
			    	 System.out.println("처리실패");
			     }
			     break;
			 case 6:
				 System.out.println("프로그램 종료");
				 run = false;
			}// end switch

		} // end while

	}// end of main.
}// end of class.
