package todo.p20231128;

public class Board {
	// 속성
	private int boardNum;
	private String boardHead;
	private String boardWho;
	private String boardCon;
	private String boardDt;

	private Board[] boards;
	

	
	//기본생성자
	Board(){
		
	}
	
	// 생성자 정의
	public Board(int boardNum, String boardHead, String boardWho, String boardCon, String boardDt) {
		this.boardNum = boardNum;
		this.boardHead = boardHead;
		this.boardWho = boardWho;
		this.boardCon = boardCon;
		this.boardDt = boardDt;
	}
	
	//이 부분이 변경되었습니다.
	
	
	boolean addBoard(Board bd) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = bd;
				return true;
			}
		
			return false;
		}
	}

	// showInfo()메소드 --목록보기에 사용 
	void showInfo() {
		System.out.println(boardNum + ". " + boardHead + " (작성자:" + boardWho + ")");
	}

	String showAllInfo() {
		String result = "번호: " + boardNum +"번\n" + "제목: " + boardHead + "\n" + boardWho + "\n" + boardCon + "\n" + boardDt + "\n";
		return result;
	}
	
	
	// set()메소드 (위에 private으로 설정했기 때문에 접근해 "값 넣을 수 있도록)
		void setBN(int boardNum) {
			this.boardNum = boardNum;
		}

		void setBH(String boardHead) {
			this.boardHead = boardHead;
		}

		void setBW(String boardWho) {
			this.boardWho = boardWho;
		}

		void setBC(String boardCon) {
			this.boardCon = boardCon;
		}
		
		void setBDT(String boardDt) {
			this.boardDt = boardDt;
		}
		
		
	// get()메소드 (위에 private으로 설정했기 때문에 접근해 "값 가져올 수 있도록)
		int getBN() {
			return boardNum;
		}

		String getBH() {
			return boardHead;
		}

		String getBW() {
			return boardWho;
		}

		String getBC() {
			return boardCon;
		}
		
		String getBDT() {
			return boardDt;
		}
		
		Board[] getBoardAllList() {
			return boards;
		}
	
	
	

}// end of class
