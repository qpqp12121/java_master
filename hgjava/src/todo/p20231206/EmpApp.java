package todo.p20231206;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {

		EmpExe exe = new EmpExe();
		Scanner scn = new Scanner(System.in);

		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회 6.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.print("사번 입력>> ");
				String no = scn.nextLine();
				System.out.print("이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("연락처 입력>> ");
				String tel = scn.nextLine();

				System.out.print("입사날 입력>> ");
				String date = scn.nextLine(); // 확인하기
				System.out.print("급여 입력>> ");
				int pay = Integer.parseInt(scn.nextLine());

				// 위에 입력받은 값 인스턴스 생성 ---> 원래 Emp edt = new Emp(no,name,tel,...);
				// 근데 아래에서 조건 확인하고 날짜없으면 없는 생성자 호출, 있으면 있는 생성자 호출해야되니
				// 우선 아래서 기본값으로 선언먼저하고
				Emp edt = null;
				if (date.equals("")) { // String이니까 null아니고 입력안하면 ""로
					edt = new Emp(no, name, tel, pay); // 날짜확인
				} else {
					edt = new Emp(no, name, tel, date, pay); // 날짜확인
				}

				if (exe.addEmp(edt)) {
					System.out.println("저장완료");
				} else {
					System.out.println("저장완료");
				}
				break;

			case 2: // 목록
				System.out.println("번호  이름  연락처 \t  입사날\t\t 급여");
				List<Emp> empAry = exe.empList();
				for (Emp emp : empAry) {
					emp.showInfo();
				}
				break;

			case 3: // 수정(급여)
				System.out.print("수정할 사원이름 입력>> ");
				name = scn.nextLine();
				System.out.print("수정급여 입력>> ");
				pay = Integer.parseInt(scn.nextLine());

				if (exe.modifyEmp(name, pay)) {
					System.out.println("수정완료");
				} else {
					System.out.println("처리실패");
				}
				break;
			case 4: // 삭제
				System.out.println("삭제할 사원이름 입력>> ");
				name = scn.nextLine();

				if (exe.removeEmp(name)) {
					System.out.println("삭제완료");
				} else {
					System.out.println("삭제실패");
				}
				break;
			case 5: // 조회(입사일로 해서 그 입사일 목록 다)
				System.out.print("입사일자 입력>> ");
				date = scn.nextLine();
				List<Emp> empdt = exe.empInfo(date); // 목록 여러건 조회하려니까 타입 List<Emp>해야됐고 for문으로 하나씩 넣고
				for(Emp empd : empdt) {
					empd.showInfo();
				}
//				for (int i = 0; i < empdt.size(); i++) {
//					empdt.get(i).showInfo();
//				}
				break;
			case 6: // 종료
				System.out.println("종료합니다");
				run = false;

			}// end switch
		} // end while
	}// end main.
}// end class.
