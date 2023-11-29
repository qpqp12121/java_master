package todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

//Board는 데이터 한 건에 대한 값을 넣고 매개역할?
public class Board {
	// 속성
	private int boardNum;
	private String boardHead;
	private String boardWho;
	private String boardCon;
	private String boardDt;



	public Board(int boardNum, String boardHead, String boardWho, String boardCon){
		Date today = new Date(); //ctrl+shift+o -> java.util선택해서
		 //위는 시스템시간을 기준으로 생성.
		
		//Date값을 -> String문자열로 바꿔서 -> (String을 다시)Date로도 바꿀 수 있다
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //연도월일을 문자값으로 넣어주면
		                                           //"yyyy-MM-dd HH:mm:ss" - 시간까지HH하면 24시간 기준(대문자)
		this.boardNum = boardNum;
		this.boardHead = boardHead;
		this.boardWho = boardWho;
		this.boardCon = boardCon;
		this.boardDt = sdf.format(today);    
	}
	

	public Board(int boardNum, String boardHead, String boardWho, String boardCon, String boardDt) {
		this.boardNum = boardNum;
		this.boardHead = boardHead;
		this.boardWho = boardWho;
		this.boardCon = boardCon;
		this.boardDt = boardDt;
	}


	// showInfo()메소드 --목록보기에 사용 
	String showInfo() {
//		System.out.println(boardNum + ". " + boardHead + " (작성자:" + boardWho + ")");
		return boardNum + ". " + boardHead + " (" + boardWho + ")" + boardDt;
	}

	String showDetailInfo() {
		String result = "번호: " + boardNum +"번\n" + "제목: " + boardHead;
		result += "\n작성자: " + boardWho;
		result += "\n내용: " + boardCon;
		result += "\n일시: " + boardDt;
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

		public String getBW() { //BoardExe파일에서 접근하여 사용해서 public 붙임
			return boardWho;
		}

		String getBC() {
			return boardCon;
		}
		
		String getBDT() {
			return boardDt;
		}
		
	
	
	

}// end of class

