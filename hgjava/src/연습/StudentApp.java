package 연습;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {

		StudentExe exe = new StudentExe();
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.print("학생번호 입력>> ");
				String no = scn.nextLine();
				System.out.print("학생이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("영어점수 입력>> ");
				int eng = Integer.parseInt(scn.nextLine());
				System.out.print("수학점수 입력>> ");
				int math = Integer.parseInt(scn.nextLine());

				Student std = new Student(no, name, eng, math);

				if (exe.addStudent(std)) {
					System.out.println("저장되었습니다");
				} else {
					System.out.println("저장실패!");
				}
				break;
			case 2:
				for (Student stdt : exe.getStudentList()) {
					if (stdt != null) {
						stdt.showInfo();
					}
				}
				break;
			case 3:
				System.out.print("조회할 학생번호>> ");
				no = scn.nextLine();
				Student stdt = exe.getStudent(no);
				if(stdt != null) {
					stdt.showInfo();
				}else {
					System.out.println("존재하지 않는 정보");
				}
				break;
			case 4:
				System.out.print("수정할 학생번호>> ");
				no = scn.nextLine();
				System.out.print("변경할 영어점수>> ");
				eng = Integer.parseInt(scn.nextLine());
				System.out.print("변경할 수학점수>> ");
				math = Integer.parseInt(scn.nextLine());
				
				if(exe.modifyStudent(no, eng, math)) {
					System.out.println("수정완료.");
				}else {
					System.out.println("수정실패");
				}
				break;
			case 5:
				System.out.print("삭제할 학생이름>> ");
				name = scn.nextLine();
				
				if(exe.removeStudent(name)) {
					System.out.println("삭제완료");
				}else {
					System.out.println("삭제실패");
				}
				break;
			case 6:
				System.out.println("프로그램 종료");
				run = false;
			}
		} // end while
		System.out.println("end of prog.");

	}// end of main.

}// end of class.
