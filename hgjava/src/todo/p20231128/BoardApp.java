package todo.p20231128;

//BoardApp 파일은 사용자가 입력하는 기능 위주

import java.util.Scanner;
//M V C (Model View Control) 로 나눔
//M : Board등  / V : html / C : 사용자 요청 들어오면 실행할 수 있도록 - 이걸 MainExe에 만들거임

public class BoardApp {
	// static BoardExe exe = new BoardExe(); //페이징기능 사용 main메소드 밖에 만들어서 이것도 밖에 빼서 선언
	// (이건 한번만 적으면 계속 사용가능)
	// --- BoardExe 정적 static으로 바꿔서 위에 new로 인스턴스 만들 필요없어지고 주석처리함/ 이것도 exe기능 실행 그러 ㅁ
	// 안되기때문에 BoardExe.으로 다 바꿔줌
	// 데이터마다 다른 정보를 담을 필요가 없는 클래스는 static멤버 선언
	private Scanner scn = new Scanner(System.in);
	private String id = null; // 위에 두개는 필드

	// 싱글톤 방식의 인스턴스 생성. --싱글톤2
	private static BoardApp instance = new BoardApp();

	// 생성자. ---279p 싱글톤 연습)1
	private BoardApp() {

	}

	public static BoardApp getInstance() { // 타입은 위에 instance 반환해줄 거니까 BoardApp으로
		return instance; // 싱글톤3
	}

	// 외부에서 다 필요없어서 private으로 한거임
	private void boardAdd() {
		System.out.print("제목 입력 >> ");
		String head = scn.nextLine();
		System.out.print("내용 입력>> ");
		String contents = scn.nextLine();
		System.out.print("작성일시 입력>> ");
		String dateTime = scn.nextLine();

		// 위에서 입력받은 정보들 담아서 하나의 인스턴스로(생성자)
		Board board = new Board(BoardExe.getSequence(), head, id, contents, dateTime); // 사용할때마다 계속 생성되어야됨(그래서while구무 ㄴ
																						// 안에있음)
		// -> 값 boards 배열에 담기

		if (BoardExe.addBoard(board)) {
			System.out.println("입력 성공!");
		} else {
			System.out.println("처리 실패!");
		}
	}// end of boardAdd.

//----------------------------------------
	private void boardList() {
		Board[] boardAry = BoardExe.boardList();
		showList(boardAry, 1); // --처음엔 첫페이지 보여지도록 (main메소드 밖에서 만든 메소드 여기 호출)
		while (true) { // 사용자가 그만 쓸 때까지 반복되도록(0누르면 페이지 빠져나오도록 처리할 것
			int page = Integer.parseInt(scn.nextLine()); // 사용자가 페이지 선택할 수 있도록
			if (page == 0) {
				break;
			}
			showList(boardAry, page); // 위에 사용자가 선택한 페이지 매개값으로 받아서 실행 또 되도록
		}
	}// end of boardList.
	
//------------------------------------------
	private void getBoard() {
		int no = 0;
		while (true) { // 아래 예외처리 하려니까 loop밖에선 사용못한다해서 넣음
			System.out.print("글번호 입력>> ");
//		int no = Integer.parseInt(scn.nextLine());
		// 예외
			try {
				no = Integer.parseInt(scn.nextLine());
				break;//넣어야 값 잘 입력했을 때 나올 수 있음
			} catch (NumberFormatException e) {
				System.out.println("글 번호를 잘못 선택했습니다.");
			}//예외처리
		}
			Board result = BoardExe.getBoard(no);
			if (result != null) {
				System.out.println(result.showDetailInfo());
			} else {
				System.out.println("조회된 내용이 없습니다.");
			}
		
	}// end of getBoard.
//------------------------------------
	private void boardEdit() {
		System.out.print("수정할 글번호>> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.print("수정할 글내용>> ");
		String contents = scn.nextLine();

		// 권한체크...
		if (!BoardExe.checkResponsibility(id, no)) {
			System.out.println("수정권한이 없습니다.");
//			continue; //권한없으면 아래부분 실행되지 않고 위로 올라가도록
			return;
		}

		// 위 내용을 사용하기 위해 exe파일의 modBoard()메소드를 가져와서 실행하고 메시지 출력
		if (BoardExe.modBoard(no, contents)) {
			System.out.println("변경 성공!");
		} else {
			System.out.println("처리 실패!");
		}
	}// end of boardEdit.

	private void boardDel() {
		System.out.print("삭제할 글번호>> ");
		int no = Integer.parseInt(scn.nextLine());

		// 권한체크...
		if (!BoardExe.checkResponsibility(id, no)) {
			System.out.println("삭제권한이 없습니다.");
//			continue; //권한없으면 아래부분 실행되지 않고 위로 올라가도록
			return;
		}

		if (BoardExe.remBoard(no)) {
			System.out.println("삭제 성공!");
		} else {
			System.out.println("처리 실패! (없는 글번호)");
		}
	}// end of boardDel.

//원래 메인이었던 부분(MainExe에 만듦)	
	public void start() {

		boolean run = true;

		UserExe uexe = new UserExe(); // --이거 넣어서 아이디,패스워드 확인하고 로그인할 수 있게 기능 넣음 -패키지가 달라서 import해줌

		while (true) {
			System.out.print("id를 입력>>> ");
			id = scn.nextLine(); // id case1에 작성자 직접 입력하는 것이 아닌 아이디쳐서 쓸 수 있도록 밖에서 String id 선언 먼저함
			System.out.print("pw를 입력>>> ");
			String pw = scn.nextLine();
			User user = uexe.logIn(id, pw);

			// if(uexe.logIn(id,pw)) { ------*** UserExe에서 boolean앞에 public붙이라 함 ((UserExe
			// 19번확인
			if (user != null) { // 처음엔 boolean으로 적었음 -근데 t/f가 아닌 users[i]의 값을 return 반환하려고 UserExe파일에서
								// boolean타입을 - User로 타입 바꿔서 위에 User user = uexe.logIn(id, pw);값 추가하고 if괄호 안에 조건
								// 바꿈
				System.out.println(user.getUserName() + "님 환영합니다.");
				break;
			} else {
				System.out.println("로그인 실패! id, pw 확인하세요");
			}
		} // 로그인 처리. ----- UserExe파일에서 User배열에 넣어둔 값으로 실행되는지 테스트해보기

		// 메인메소드 밖으로 옮김
//		BoardExe exe = new BoardExe(); //------이 기능 쓰려면 반드시 UserExe의 boolean logIn 조건을 통과해야 됨!(위에 선언

		// 초기값 생성 불러오기
//		exe.initData(); 
		BoardExe.initData();

		while (run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.수정 5.삭제 6.종료");
//			int menu = Integer.parseInt(scn.nextLine()); ---12/01다시 살리기 (예외 연습한다고 없앰
			// 예외
			int menu = 0;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("정확한 메뉴를 선택하세요.");
				continue;
			}
			// 여기까지 예외연습

			switch (menu) {

			case 1: // 정보등록
				boardAdd();
				break;
			case 2: // 목록출력
				boardList();
				break;
			case 3: // 상세조회
				getBoard();
				break;
			case 4: // 수정
				boardEdit();
				break;
			case 5: // 삭제
				boardDel();
				break;
			case 6: // 종료
				System.out.println("프로그램을 종료합니다.");
				run = false;

			}// end switch
		} // end while
		System.out.println("end of prog");

	}// end of main

	private void showList(Board[] boardAry, int page) {
		// 페이징처리
		Board[] pageAry = BoardExe.pageList(boardAry, page); // boardAry 배열(전체건수)에서, 위에서 사용자가 입력한 페이지로 이동
		System.out.print("번호--제목-----작성자---작성일시");
		System.out.println("---------------");
		for (Board brd : pageAry) { // exe.pageList(boardAry, page)->여기서 받아온 page ex.5면 for문에서 5번반복되는
			if (brd != null)
				System.out.println(brd.showInfo());
		}

		// 전체페이지 계산하고 출력. (배열의단점:크기 한번 정해지면 줄이거나 늘리거나 할 수 X)
		// 새로 배열 선언해서 기존에 있던 걸 옮기고 새로 추가해야됨. 우리는 아직 컬렉션이라는 거 안해서 배열로 사용하고 있음. 배열은 항상 기본값
		// null이라는 것 알기
		// 대체적으로 배열 잘 안쓰고 컬렉션씀 (방 안에 값 없어지면 알아서 사라져서 null값 생각할필요X
		// 100개크기에서 30개만 값들어있어도 30개가 들어있는지 알 수 없음.(배열의크기로는할수없고 메소드를 하나 또 만들어야 됨 BoardExe
		int cnt = BoardExe.getBoardCount();
		int totalPage = (int) Math.ceil(cnt / 5.0); // 올림 -- 근데 (Math.ceil괄호 안에 더블타입 들어가야 됨)

		for (int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\n페이지를 선택하세요>> ");
		System.out.println("\n*종료하려면 \"0\"을 입력하세요*");
	}

}// end of class
