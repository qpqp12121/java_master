package chap13;

import java.util.List;
import java.util.Scanner;

public class ProductApp {
	public static void main(String[] args) {

		InOutExe ioexe = new InOutExe();
		ProductExe exe = new ProductExe();
		Scanner scn = new Scanner(System.in);

		boolean run = true;

		while (run) {
			System.out.println("1.상품관리 2.입출고관리 3.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 상품관리( 1-1등록 / 1-2수정 / 1-3목록)
				System.out.println("1)등록 2)수정 3)목록");
				int menu2 = Integer.parseInt(scn.nextLine());

				switch (menu2) {
				case 1: // -등록
					System.out.print("상품코드 입력>> ");
					String code = scn.nextLine();
					System.out.print("상품명 입력>> ");
					String name = scn.nextLine();
					System.out.print("가격 입력>> ");
					int price = Integer.parseInt(scn.nextLine());

					Product prodata = new Product(code, name, price);

					if (exe.addPro(prodata)) {
						System.out.println("저장완료");
					} else {
						System.out.println("저장실패");
					}
					break;
				case 2: // -수정
					System.out.print("수정할 상품명 입력>> ");
					name = scn.nextLine();
					System.out.print("수정할 가격 입력>> ");
					price = Integer.parseInt(scn.nextLine());

					if (exe.modifyPro(name, price)) {
						System.out.println("수정완료");
					} else {
						System.out.println("수정실패");
					}
					break;
				case 3: // 목록
					System.out.println("상품코드 | 상품명 |  가격");
					System.out.println("===========================");

					List<Product> pdlist = exe.proList();
					for (Product pd : pdlist) {
						pd.showInfo();
					}
					break;
				}
				break;

			case 2: // 입출고관리( 2-1판매 2-2구매 2-3재고 )

				System.out.println("1)판매 2)구매 3)재고");
				menu2 = Integer.parseInt(scn.nextLine());

				switch (menu2) {
				case 1: // -판매
//					System.out.println("상품코드 | 처리날짜 | 수량 | 판(구)매");
//					System.out.println("=======================================");

					break;
				case 2:
					System.out.print("구매할 상품코드 입력>> ");

					break;
				case 3:
					System.out.println("상품코드  재고수량");
					break;

				}
				break;

			case 3: // 종료
				System.out.println("종료합니다");
				run = false;
			}// end 큰switch
		} // end while
		
		
	}// end main.
}// end class.
