package chap11.object;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
//   1: YEAR / 2: MONTH / DAY_OF_WEEK: 일(1) 월(2)... 토(7)
		
		//추상클래스라 정적메소드인 getInstance() 메소드 사용해서 생성
		Calendar cal = Calendar.getInstance(); //클래스이름.메소드호출 => 정적메소드 (연산자 newX getInstance메소드로 생성)
		
		//지정
		cal.set(1, 2022); //연도 지정  - 2022년
		cal.set(Calendar.MONTH, 4); //월 지정 (2,4)로 해도 됨 - 5월4일
		cal.set(Calendar.DATE, 1); //일 지정
		cal.set(0, 0);
		cal.set(2023, 2, 1);
		
		System.out.println("요일: " + cal.get(Calendar.DAY_OF_WEEK)); //상수값 직접 넣어도 되고 ( 숫자로 1 해도 됨 )
		System.out.println("막날: " + cal.getActualMaximum(Calendar.DATE));
		
		
		
		
		
	}//end main.
}//end class.
