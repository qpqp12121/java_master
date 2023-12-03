package 연습.Board;


public class BoardExe {

// < 배열필드 >
	static Board[] boards;
	
// < 생성자 >
	BoardExe(){
		
	}
	
	static{
		boards = new Board[100];
	}
	
	
// < 메소드 >
	static void initData() {
		boards[0] = new Board(1, "첫번째 글", "user01", "첫번째 글 입력중입니다.", "23-11-27");
		boards[1] = new Board(2, "두번째 글", "user02", "두번째 글 입력중입니다.", "23-11-28"); 
		boards[3] = new Board(4, "네번째 글", "user04", "네번째 글 입력중입니다.", "23-11-29");
		boards[2] = new Board(3, "세번째 글", "user03", "세번째 글 입력중입니다."); 
		boards[4] = new Board(5, "다섯번째 글", "user03", "세번째 글 입력중입니다."); 
		boards[5] = new Board(6, "여섯번째 글", "user03", "세번째 글 입력중입니다."); 
		boards[6] = new Board(7, "일곱번째 글", "user03", "세번째 글 입력중입니다.");
		boards[7] = new Board(8, "여덟번째 글", "user03", "세번째 글 입력중입니다.");
	}

	
	//1.등록기능
	static boolean addBoard(Board board) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] == null) {
				boards[i] = board;
				return true;
			}
		}
		return false;
	}
	
	//2.목록기능
	static Board[] getBoardList() {
		return boards;
	}
	
	
	
	
}//end class.
