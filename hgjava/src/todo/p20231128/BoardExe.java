package todo.p20231128;

//Board를 이용해서 기능을 부여하고 싶다하면 BoardExe 파일에 기능넣고

import java.text.SimpleDateFormat;
import java.util.Date;


//저장소: boards
public class BoardExe {

	static Board[] boards;
	
	BoardExe(){  //인스턴스를 만들겠습니다 라는 의미라 바꿔서
//		boards = new Board[100];
	}
	
	//정적 실행블록에 넣음 (위에서 static으로 만들어서
	static {
		boards = new Board[100];
	}
	
	//초기값 생성.할때마다 등록하고 테스트해야되니까
	public static void initData() { //혹시나 다른 패키지에 있음 public까지 붙이기
		boards[0] = new Board(1, "첫번째 글", "user01", "첫번째 글 입력중입니다.", "23-11-27");
		boards[1] = new Board(2, "두번째 글", "user02", "두번째 글 입력중입니다.", "23-11-28"); //3번은 삭제된 걸로
		//boards[2] <-----5번글 새로 등록하면 비어있는 이 위치에 들어갈 것
		boards[3] = new Board(4, "네번째 글", "user04", "네번째 글 입력중입니다.", "23-11-29");
		boards[2] = new Board(3, "세번째 글", "user03", "세번째 글 입력중입니다."); //위처럼 넣어도 되고 여기는 Date사용
		
		boards[4] = new Board(5, "다섯번째 글", "user03", "세번째 글 입력중입니다."); 
		boards[5] = new Board(6, "여섯번째 글", "user03", "세번째 글 입력중입니다."); 
		boards[6] = new Board(7, "일곱번째 글", "user03", "세번째 글 입력중입니다.");
		boards[7] = new Board(8, "여덟번째 글", "user03", "세번째 글 입력중입니다."); 
	}
	
	
	
//	등록. 글번호/제목/작성자/내용/작성일자 => 반환값: boolean타입
	//case 1
	public static boolean addBoard(Board board) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = board;
				return true;
			}
		}
		return false;
	}
	
// 	목록. 반환값: 배열
	//case 2
	public static Board[] boardList() {
		//원본대상인 boards를 가져와 => 새로운 배열에 정렬된 값으로 반환
		Board temp = null; //Board타입이니까
		for(int j = 0; j < boards.length - 1; j++) {
			for(int i = 0; i < boards.length -1; i++) {
				if(boards[i] != null && boards[i+1] != null) {
				if(boards[i].getBN() > boards[i+1].getBN()) {
					temp = boards[i];
					boards[i] = boards[i+1];
					boards[i+1]= temp;
					}
				}
			}
		}
		return boards;	
	}//end of boardList().
	
	
	//배열,페이지 (매개값받기) => 페이지의 5건을 반환. --- 이 배열의 몇번째 페이지를 보여주세요 (ㅠㅔ이징
	public static Board[] pageList(Board[] ary, int page) { // --- ary배열에서 page몇페이지인지 매개값 넣어주면 밑에 식대로 알아서 계산해서 ---resultAry배열에 담아줄 거임
		Board[] resultAry = new Board[5]; //5개씩만 반환할 거라 크기만 만들어둠
		
		int start = (page - 1) * 5;
		int end = page * 5;
		int j =0; //0부터 시작하는 새로운 배열(??)
		
		for (int i = 0; i < ary.length; i++) {
			if(i >= start && i < end) { //한페이지당 5건씩 보여질 수 있도록(배열이라 0부터 5보다 작을때까지) i>= 0 && i <5
				                        //근데 위에서 start와 end변수에 계산식 넣어놓고 page 값바꾸면 저절로 계산되도록 가능하게 함
				resultAry[j++] = ary[i];
			}
		}
		return resultAry;
	}
	
	
//  단건조회. 매개변수: 글번호, 반환값: Board --(글번호 똑같으면 게시글 반환되게)
	public static Board getBoard(int boardNo) { //이 안에서 쓰는 거라 위에서 정한 변수이름이랑 상관X
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBN() == boardNo) {
				return boards[i];
			}
		}
		return null;
	}
	
// 신규번호: 현재글 번호 + 1  --- 사용자가 글번호 입력하는 게 아니라 순차적으로 만들어지도록	
	
	public static int getSequence() {
		int seqNo = 1;
		//배열에서 글번호의 max값 가져오기.
		int max = 0;
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBN() > max) {
				max = boards[i].getBN();
			}
		}
		seqNo = max + 1;
		return seqNo;
	}
	
// case 4) 수정. 매개값(글번호,내용) => boolean	- 글번호 받아서 내용수정하기/ 수정되었는지 알 수 있게
	public static boolean modBoard(int no, String content) {
		Date today = new Date(); //case4에서 수정하면 오늘날짜로 바뀜
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBN() == no) {
				boards[i].setBC(content);
				boards[i].setBDT(sdf.format(today));
				return true;
			}
		}
		return false;
	}
	
	
	
// case 5) 삭제. 매개값(글번호) => boolean 으로 반환해서 잘 처리되어ㅆ는지 볼 수 있게 (ㅂㅐ열값 null로 바꾸면 삭제)	
	public static boolean remBoard(int no) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBN() == no) {
				boards[i] = null;
				return true;
			}	
		}
		return false;
	}
	
// 사용자가 해당글 번호의 수정or 삭제 권한이 있는지 체크 => boolean타입. 권한있으면 true,없으면 false (본인이 아니면 글 수정삭제하지 못하도록)	
	public static boolean checkResponsibility(String id, int no) { //해당글번호에 가서 id를 봤더니 같은 사람이면 true
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBN() == no && boards[i].getBW().equals(id)) { //getBW 오류떠서 public앞에 붙이니까 됐음.
				return true;
			}
		}
		return false;
	}//end of checkResponsibility.
	
	//게시글을 담고 있는 배열에서 값이 있는 건수를 반환
	public static int getBoardCount() { //임의로 방크기 100으로 정했으나 값 들어있는 건 몇건인지 모르니 메소드 만들어서 계산하는 것임.
		int realCnt = 0;  //나중엔 컬렉션으로 할 거임 (BoardApp case2번 설명 읽어보기)
		for(int i = 0; i < boards.length; i++) { //null이 아닌것만카운트해야됨
			if(boards[i] != null) {
				realCnt++;
			}
		}
		return realCnt;
	}
	
	
	
}//end of class
