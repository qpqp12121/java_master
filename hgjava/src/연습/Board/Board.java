package 연습.Board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	
	//속성 (게시글번호 / 제목 / 작성자 / 내용 / 작성일시)
	private int boardNum;
	private String boardHead;
	private String boardWho;
	private String boardCon;
	private String boardDt;
	
	//생성자
	public Board(){
		
	}
	
	public Board(int boardNum, String boardHead, String boardWho, String boardCon) {
		//작성일시는 작성당시 시스템시간을 기준으로 생성하려고 함
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		this.boardNum = boardNum;
		this.boardHead = boardHead;
		this.boardWho = boardWho;
		this.boardCon = boardCon;
		this.boardDt = sdf.format(today);
	}
	
	public Board(int boardNum, String boardHead, String boardWho, String boardCon, String boardDt) {
		this(boardNum, boardHead, boardWho, boardCon);
		this.boardDt = boardDt;
	}
	
	
	//메소드
	
//	String showInfo() {
//		return boardNum + ". " + boardHead + " (" + boardWho + ") " + boardDt;
//	}
	void showInfo() {
		System.out.println(boardNum + ". " + boardHead + " (" + boardWho + ") " + boardDt);
	}

	
	
	
	
	

}//end class.
