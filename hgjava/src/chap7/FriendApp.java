package chap7;

import java.util.Scanner;

public class FriendApp {
	// Scanner클래스 main메소드 밖의 addFriend메소드 등에도 사용해야 되기때문에 밖에 선언
	static Scanner scn = new Scanner(System.in); // 정적필드

	static Friend[] storage = new Friend[10]; // Friend 인스턴스를 담을 수 있는 배열 storage

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.조회 4.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 등록
				addFriend();
				break;
			case 2: // 목록
				friendList();
				break;
			case 3: // 조회
				getFriend();
				break;
			default: // 종료
				System.out.println("종료합니다.");
				run = false;
			}// end switch.
		} // end while.

	}// end of main.

	// 등록하기 위한 메소드
	private static void addFriend() {
		System.out.println("1.친구 2.학교 3.회사"); // 1번 누르면 학교친구인지 뭔지 물어보기
		int subMenu = Integer.parseInt(scn.nextLine());

		Friend friend = null; // Friend 클래스는 부모라 자식들 UnivFriend 등 변수에 담을 수 있으니
								// 여기에 new생성한 인스턴스 다 담을 거임 => 위에 배열에다가

		// case 1: 이름, 연락처 (는 다 공통이라 밖에 선언)
		System.out.print("이름>> ");
		String name = scn.nextLine();
		System.out.print("연락처>> ");
		String phone = scn.nextLine();
		
		
		if (subMenu == 1) {
			friend = new Friend(name, phone); // Friend클래스의 인스턴스 생성
		} else if (subMenu == 2) {
		// case2 : 이름,연락처,학교,전공
			System.out.print("학교>> ");
			String univ = scn.nextLine();
			System.out.print("전공>> ");
			String major = scn.nextLine();
			friend = new UnivFriend(name, phone, univ, major); // Friend friend = null;여기 담을거라 앞에 friend= 붙여줌

		} else if (subMenu == 3) {
		// case3 : 이름,연락처,회사,부서
			System.out.print("회사>> ");
			String comp = scn.nextLine();
			System.out.print("부서>> ");
			String dept = scn.nextLine();
			friend = new CompFriend(name, phone, comp, dept); // Friend friend = null;여기 담을거라 앞에 friend= 붙여줌
		}
		// 배열에 담기
//		for (int i = 0; i < storage[i].length; i++) {
//			if (storage[i] == null) {
//				storage[i] = friend;
//				break;
//			}
//		}
//		System.out.println("저장완료!");
		
		if(FriendExe.addFriend(friend)) {
			System.out.println("입력 성공!");
		}else {
			System.out.println("처리 실패!");
		}

		

	}// end addFriend - 1.등록메뉴

// 2.목록보기
	private static void friendList() {
		for (Friend fnd : FriendExe.friendList()) {
			if (fnd != null) {
				System.out.println(fnd.showInfo());
			}
		}
	}// end 목록보기

// 3.조회
	private static void getFriend() {
		// 이름조회, 연락처조회
		System.out.println("1.이름 2.연락처");
		int subMenu = Integer.parseInt(scn.nextLine());
		String searchCond = "";

		if (subMenu == 1) {
			searchCond = scn.nextLine();
			for (Friend fnd : storage) {
				if (fnd != null && fnd.getName().equals(searchCond)) {
					System.out.println(fnd.showInfo());
				}
			}
		} else if (subMenu == 2) {
			searchCond = scn.nextLine();
			for (Friend fnd : storage) {
				if (fnd != null && fnd.getPhone().equals(searchCond)) {
					System.out.println(fnd.showInfo());
				}
			}
		} else {
			System.out.println("1번 또는 2번을 선택하세요");
		}

		
		//조회하기기기기ㅓ
///////////////////////////////////////////////////////////////////		
		Friend result = FriendExe.searchPhone(searchCond); //---!
		if(result != null) {
			System.out.println(result.showInfo());
		}else {
			System.out.println("조회된 내용이 없습니다");
		}
		
		

	}// end 조회

//--백업자료-----------------------------------------------------------------------------------------------	
	void backup() { // 이런 기능 있다는 거 볼라고 위에 main에서 해서 지워도 됨(그래서 main밖으로 옮김)
		Object obj = new Object();
		obj.equals(obj);

		Friend parent = new Friend();
		parent.setName("홍길동"); // Friend에서 롬복이 만들어줌
		parent.setPhone("010-1111");
		System.out.println(parent.toString()); // 원래 parent.showInfo()로 했는데 이클립스 기능으로 사용해서 새로 만든 toString 넣음

		UnivFriend child = new UnivFriend(); // UnivFriend에는 아무것도 없지만 부모인 Friend에 있기때문에 상속받아서 사용
		child.setName("김철수");
		child.setPhone("010-2222");
		child.setUniv("구미대");
		child.setMajor("컴퓨터공학과");
		System.out.println(child.showInfo());

		Friend[] friends = new Friend[10]; // Friend 클래스만 담을 수 있는 배열생성
		friends[0] = parent; // 근데 상속받아서 UnivFriend 클래스요소도 받고 할 수 있는 것
		friends[1] = child; // d
	}// end backup

}// end of class.
