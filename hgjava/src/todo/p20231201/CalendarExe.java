package todo.p20231201;

import java.util.Calendar;

public class CalendarExe {

	public static void main(String[] args) {
//		//12월 달력 작성하기(숙제)
//		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
//		
//		for(String day : days) {
//			System.out.printf("%4s", day);
//		}
//		System.out.println();
//		
//		
//		//빈공백생성
//		
//		int blank = 0;
//		for(int i = 1; i <= 5; i++) {
//			System.out.printf("%4s", "");
//			blank = i;
//		}
//			
//		for(int i = 1; i <= 31; i++) {
//			System.out.printf("%4d", i);
//			if((i+blank) % 7 == 0) {
//				System.out.println();
//			}
//		}
//		System.out.println("\n\t== the end ==");
			
		
		Calendar today = Calendar.getInstance();
		//10월 달력
		today.set(Calendar.MONTH, 11);
		today.set(Calendar.DATE, 1);
		
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		
		//빈공백생성 (빈공백이 월에 따라 움직여야됨)
		
		
		for(int i = 1; i < today.get(Calendar.DAY_OF_WEEK); i++) {
			System.out.printf("%4s", "");
		}
		for(int i = 1; i <= today.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%4d", i);
			if(i == 2 || (i - 2) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n\t== the end ==");
		
		
//		for(int i = 0; i <= today.get(Calendar.DAY_OF_WEEK); i++) {
//			System.out.printf("%4s", "");
//		}
//			
//		for(int i = 1; i <= today.getActualMaximum(Calendar.DATE); i++) {
//			System.out.printf("%4d", i);
//			if(i % 7 == 0) {
//				System.out.println();
//			}
//		}
//		System.out.println("\n\t== the end ==");
		
		
		
		
		
		
		
		
		
	}//end main
}//end class
