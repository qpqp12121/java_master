package 시험;

import java.util.List;
import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {

		EmpDAO exe = new EmpDAO();
		Scanner scn = new Scanner(System.in);

		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(입사일자) 6.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.print("사번 입력>> ");
				String no = scn.nextLine();
				System.out.print("이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("전화번호 입력>> ");
				String tel = scn.nextLine();
				System.out.print("입사일 입력>> ");
				String date = scn.nextLine();
				//예외처리
				int pay = 0;
				while (true) {
					System.out.print("급여 입력>> ");
					try {
						pay = Integer.parseInt(scn.nextLine());
						break;
					} catch (NumberFormatException e) {
						System.out.println("※ 숫자를 입력하세요 ※");
					}
				}

				Employee emp = new Employee(no, name, tel, date, pay);
				if (exe.addEmp(emp)) {
					System.out.println("등록 완료");
				} else {
					System.out.println("등록 실패");
				}
				break;
			case 2:
				System.out.println("사번 \t 이름 \t 전화번호   급여");
				List<Employee> emdt = exe.empList();
				for (Employee emd : emdt) {
					emd.showInfo();
				}
				break;
			case 3:
				System.out.print("수정할 사번 입력>> ");
				no = scn.nextLine();
				System.out.print("수정 급여 입력>> ");
				pay = Integer.parseInt(scn.nextLine());

				if (exe.modifyEmp(no, pay)) {
					System.out.println("수정 완료");
				} else {
					System.out.println("수정 실패");
				}
				break;
			case 4:
				System.out.println("삭제할 사번 입력>> ");
				no = scn.nextLine();
				if (exe.removeEmp(no)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 5:
				System.out.print("조회할 입사일자 입력>> ");
				date = scn.nextLine();
				List<Employee> empd = exe.searchEmp(date);
				for (Employee search : empd) {
					search.showInfo();
				}
				break;
			case 6:
				System.out.println("프로그램 종료");
				run = false;
			}
		}

	}// end of main.

}// end of class.
