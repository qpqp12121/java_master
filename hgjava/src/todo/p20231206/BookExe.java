package todo.p20231206;

import java.util.ArrayList;
import java.util.List;

public class BookExe {
	
	//필드
	private List<Book> books;
	
	//생성자
	BookExe(){
		books = new ArrayList<Book>();
		books.add(new Book("B001", "이것이 자바다","신용권", 25000));
		books.add(new Book("C003", "자바 기초", "김재원", 20000));
		books.add(new Book("D001", "자바마스트", "박재민", 15000));
	}
	
	
	//메소드
	
	//1.등록
	boolean addBook(Book bdt) {
		return books.add(bdt);
	}
	
	//2.목록
	List<Book> bookList(){    //타입 ArrayList<Book>해도 됨
		return books;
	}
	
	//+단건조회
	Book getBook(String code) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getBookCode().indexOf(code) != -1) { //.getBookCode().equals(code)로 해도 되고
				return books.get(i); //books컬렉션에서 get(i)한건가지고오면 Book타입 가져오는
			}
		}
		return null; //돌았는데 없으면 null반환
	}
	
	
	
	//3.수정
	boolean modifyBook(String code, int price) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getBookCode().indexOf(code) != -1) {
				books.get(i).setBookPrice(price);
				return true;
			}
		}
		return false;
	}
	
	//4.삭제
	boolean removeBook(String code) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getBookCode().indexOf(code) != -1) {
			  books.remove(i);
			  return true;
			}
		}
		return false;
	}
	
	

}//end of class.
