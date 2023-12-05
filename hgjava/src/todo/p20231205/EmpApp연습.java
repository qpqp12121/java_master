package todo.p20231205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EmpApp연습 {
	public static void main(String[] args) {
		
		Map<String, Emp> empDate = new HashMap<>();
		
		EmpExe exe = new EmpExe();
		Scanner scn = new Scanner(System.in);
		
		boolean run = true;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회 6.종료");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1:
				System.out.print("사번 입력>> ");
				String no = scn.nextLine();
				System.out.print("이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("연락처 입력>> ");
				String tel = scn.nextLine();
				System.out.print("입사날 입력>> ");
				String date = scn.nextLine(); //확인하기
				
//				if(date == null) {
//					Date date2 = new Date();
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//					System.out.println(sdf);
//				}
				
				System.out.print("급여 입력>> ");
				int pay = Integer.parseInt(scn.nextLine());
							
				Emp edt = new Emp(no, name, tel, date, pay);
	
				if(exe.addEmp(edt)) {
					System.out.println("저장완료");					
				}else {
					System.out.println("저장완료");					
				}
				break;
				
			case 2: //목록
				System.out.println("번호 \t 이름 \t 연락처 \t 입사날 \t 급여");
				List<Emp> empAry = exe.empList();
				for(Emp emp : empAry) {
					emp.showInfo();
				}
				break;
				
			case 3: //수정(급여)
				System.out.print("수정할 사원이름 입력>> ");
				name = scn.nextLine();
				System.out.print("수정급여 입력>> ");
				pay = Integer.parseInt(scn.nextLine());
				
				if(exe.modifyEmp(name, pay)) {
					System.out.println("수정완료");
				}else {
					System.out.println("처리실패");
				}
				break;
			case 4: //삭제
				System.out.println("삭제할 사원이름 입력>> ");
				name = scn.nextLine();
				
				if(exe.removeEmp(name)) {
					System.out.println("삭제완료");
				}else {
					System.out.println("삭제실패");
				}
				break;
			case 5: //조회(입사일로 해서 그 입사일 목록 다)
				System.out.println("입사일자 입력>> ");
				date = scn.nextLine();
				Emp empdt = exe.empInfo(date);
				if(empdt != null) {
					empdt.showInfo();
				}
				break;
			case 6: //종료
				System.out.println("종료합니다");
				run = false;

			}//end switch			
		}//end while
	}//end main.
}//end class.
