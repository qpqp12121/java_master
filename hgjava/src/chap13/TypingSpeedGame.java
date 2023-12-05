package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TypingSpeedGame {

	public static void main(String[] args) {

// Q. 사용자 입력값과 컬렉션의 값과 비교해서 같은 단어 있으면 삭제.(반복
// 시작시점 ~ 종료시점까지 걸린 시간을 초단위로 계산해서 완료하는데 35초가 걸림

		String word = "but poor corporate oversight was hiding in plain sight";
		String[] words = word.split(" ");

		List<String> list = new ArrayList<>();
		// list목록에 데이터 추가
		for (String str : words) {
			list.add(str);
		}

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		

		long start = System.currentTimeMillis();

		while (run) {
			System.out.println(list);
			System.out.print("단어 입력>> ");
			String quiz = scn.nextLine();
			// 목록출력하고(컬렉션)
			for (int i = 0; i < list.size(); i++) {
				// 입력값과 목록값 비교해서 있으면 제거
				if (list.get(i).indexOf(quiz) != -1) {
					list.remove(i);
				}
				if (list.size() == 0) {
					run = false;
				}
			}
		}
		System.out.println("end of game");
		long end = System.currentTimeMillis();
		System.out.println("걸린시간: " + (end - start) / 1000 + "초");

	}// end of main

}// end of class.
