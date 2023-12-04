package todo.p20231201;

import java.util.Calendar;

public class CalendarExe2 {
	public static void main(String[] args) {

		int year = 2023;
		int month = 12; // 여기서 월 바꿔서 입력하면 됨
		
		System.out.println(year + "년 " + month + "월 달력");

		Calendar today = Calendar.getInstance();
		// 10월 달력작성
		today.set(Calendar.YEAR, year);
		today.set(Calendar.MONTH, (month - 1));
		today.set(Calendar.DATE, 1);

		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };

		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();

		// 빈공백생성 (빈공백이 월에 따라 움직여야됨)

		int spaces = today.get(Calendar.DAY_OF_WEEK)-1;
		for (int i = 0; i < spaces ; i++) {
			System.out.printf("%4s", "");
		}
		int lastDate = today.getActualMaximum(Calendar.DATE);
		for (int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if((i+spaces) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n\t== the end ==");

	}

}
