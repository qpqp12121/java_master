package remind6;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		
		boolean run = true;

		Scanner scn = new Scanner(System.in);
		StudentExe exe = new StudentExe(); // StudentExe에 배열 넣어놨음 (그래서 그 클래스 사용하려면 생성)

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

				// 위에서 입력받은 정보들을 담아 하나의 인스턴스로 만들기(생성자)
				Student std = new Student(no, name, eng, math); // 클래스 사용할 거라 생성자 만들기
				// students 배열에 한 건 저장.
				// 15열 참고
				if (exe.addStudent(std)) { // 원래 다르게 다 적었는데 없애고 클래스 호출
					System.out.println("저장되었습니다."); // addStudent boolean타입이라 if문 안에 사용
				} else {
					System.out.println("저장 중 오류.");
				}

				break;

			case 2: // 2.목록보기 기능
//				Student[] stdAry = exe.getStudentList(); //밑에 for문 안에 들어있는 걸 여기서 선언하고 적어도 됨
//				for(Student stdnt : stdAry) {}
				for (Student stdnt : exe.getStudentList()) { // Student[] 타입 반환
					if (stdnt != null) {
						stdnt.showInfo();
					}
				}
				break;

			case 3: // 단건조회 (사용자가 학생번호를 넣으면 조회할 수 있도록)
				System.out.print("조회할 학생번호 입력>> ");
				no = scn.nextLine(); // 똑같은 번호 있는지 돌면서 볼 것
				Student stnt = exe.getStudent(no);
				if (stnt != null) {
					stnt.showInfo();
				} else {
					System.out.println("존재하지 않는 정보.");
				}

				break;

			case 4: // 수정 (학생번호 넣고 영어,수학 점수 입력)
				System.out.print("수정할 학생번호 입력>> ");
				no = scn.nextLine();
				System.out.print("변경할 영어점수 입력: ");
				eng = Integer.parseInt(scn.nextLine());
				System.out.print("변경할 수학점수 입력: ");
				math = Integer.parseInt(scn.nextLine());

				if (exe.modifyStudent(no, eng, math)) {
					System.out.println("수정 완료.");
				} else {
					System.out.println("수정 실패.");
				}
				break;

			case 5: // 삭제(학생 이름 받고, 해당되는 것의 값을 null로 하면 삭제 됨
				System.out.print("삭제할 학생이름 입력>> ");
				name = scn.nextLine();

				if (exe.removeStudent(name)) {
					System.out.println("삭제 완료.");
				} else {
					System.out.println("삭제 실패.");
				}
				break;

			case 6:
				System.out.println("프로그램을 종료합니다");
				run = false;
			}

		} // end of while.
		System.out.println("end of prog.");

	}// end of main.

}// end of class.
