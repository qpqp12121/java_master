package todo.p20231205;

public class BookExe {

	// 배열필드
	private Book[] books;

	// 생성자
	public BookExe() {
		books = new Book[10];
		books[0] = new Book("B001", "이것이 자바다","신용권", 25000);
		books[1] = new Book("C003", "자바 기초", "김재원", 20000);
		books[2] = new Book("D001", "자바마스트", "박재민", 15000);
	}

	// 메소드

	// 1.등록
	public boolean addBook(Book bdt) { //한곳에 담았는 거 가져오기(bdt)
		for(int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				books[i] = bdt;
				return true;
			}
		}
		return false;
	}
	
	//2. 목록
	Book[] bookList() {
		return books;
	}
	
	//3.수정
	public boolean modifyBook(String code, int price) {
		for(int i = 0; i < books.length; i++) {
			if(books[i] != null && books[i].getBookCode().equals(code)) {
				books[i].setBookPrice(price);
				return true;
			}
		}
		return false;
	}
	
	//4.삭제
	public boolean removeBook(String code) {
		for(int i = 0; i < books.length; i++) {
			if(books[i] != null && books[i].getBookCode().equals(code)) {
				books[i] = null;
				return true;
			}
		}
		return false;
	}
	
	
	
	
	

}//end of class.
