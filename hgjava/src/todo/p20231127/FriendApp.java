package todo.p20231127;

import java.util.Scanner;

public class FriendApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		Friend[] friends = null;
		boolean run = true;
		int friendNum = 0;

		while (run) {
			System.out.println("1.친구수  2.입력  3.목록  4.수정  5.종료");
//			int menu = scn.nextInt(); -- int로 숫자 받기만 되고
//			scn.nextLine(); -- 이거까지 적어야 Enter까지 반영
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.print("친구 수>> ");
				friendNum = Integer.parseInt(scn.nextLine());
				friends = new Friend[friendNum];
				break;
			case 2:
				System.out.println("친구정보 입력>> ");
				for (int i = 0; i < friends.length; i++) {
					Friend friend = new Friend();
					System.out.print("- 이름: ");
					friend.name = scn.nextLine();
					System.out.print("- 연락처: ");
					friend.tel = scn.nextLine();
					System.out.print("- 혈액형: ");
					friend.blType = scn.nextLine();

					friends[i] = friend;
				} // end for
				break;
			case 3:
				System.out.println("목록 출력>> ");
				for (Friend list : friends) {
					System.out.println("이름: " + list.name + " / 전화번호: " + list.tel + " / 혈액형: " + list.blType);
				}
				break;
			case 4:
				System.out.print("친구이름 입력>> ");
				String name = scn.nextLine();
				boolean exists = false;

				for (int i = 0; i < friends.length; i++) {

					if (name.equals(friends[i].name)) {
						System.out.print("변경할 전화번호 입력: ");
						friends[i].tel = scn.nextLine();
						exists = true;
					}
				}
				if (!exists) {
					System.out.println("찾는 이름이 없습니다.");
				}
				break;

			case 5:
				System.out.println("종료합니다.");
				run = false;

			}// end switch

		}

	}// end main

}// end class
