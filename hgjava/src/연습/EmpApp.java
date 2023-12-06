package 연습;

import java.util.List;
import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		EmpExe exe = new EmpExe();
		Scanner scn = new Scanner(System.in);
		
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1://등록
				System.out.print("사원번호 입력>> ");
				String no = scn.nextLine();
				System.out.print("이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("연락처 입력>> ");
				String tel = scn.nextLine();
				System.out.print("입사날 입력>> ");
				String date = scn.nextLine(); // 확인하기
				System.out.print("급여 입력>> ");
				int pay = Integer.parseInt(scn.nextLine());
				
				Emp edt = null;
				if(date.equals("")) {
					edt = new Emp(no, name, tel, pay);
				}else {
					edt = new Emp(no, name, tel, date, pay);
				}
				
				if(exe.addEmp(edt)) {
					System.out.println("저장완료");
				}else {
					System.out.println("저장실패");
				}
				break;
			case 2:
				System.out.println("번호  이름  연락처 \t  입사날\t\t 급여");
				List<Emp> empAry = exe.empList();
				for(Emp emp : empAry) {
					emp.showInfo();
				}
				break;
			case 3:
				System.out.print("수정할 사원이름 입력>> ");
				name = scn.nextLine();
				System.out.print("수정급여 입력>> ");
				pay = Integer.parseInt(scn.nextLine());
				
				if(exe.modifyEmp(name, pay)) {
					System.out.println("수정완료");
				}else{
					System.out.println("수정실패");
				}
				break;
				
				
			}//end switch.
		}//end while.
		
		
		
		
	}//end of main.

}//end of class.
