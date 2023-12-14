package todo.p20231214;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {

	Connection conn; //DB와 연결하기 위한 인터페이스
	PreparedStatement psmt; //sql을 보내기 위한 통로(인자값으로 SQL을 받기때문에 특정한 SQL에 대한 통로라고 생각)
	ResultSet rs; // SQL문의 결과를 저장하는 객체
	
	//각 기능마다 DB연결 ( 각 메소드에서 호출하기 )
	Connection getConn() {   
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //1.DBMS와 연결하기 위한 url
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //2. JDBC드라이버 로드(DBMS에 맞는 드라이버 로딩)
			conn = DriverManager.getConnection(url, "dev", "dev"); //3.Connection객체생성하여 DB서버 연결
			System.out.println("연결성공!");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	//1.등록
	boolean addBook(Book book) {
		getConn(); //DB연결메소드 호출
		String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?)";//SQL문 수행(실행요청)
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookCode()); //매개값으로 들어온 정보들로 쿼리 만들기
			psmt.setString(2, book.getBookTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setString(4, book.getPress());
			psmt.setInt(5, book.getPrice());
			
			int r = psmt.executeUpdate(); //db의 처리된 건수가 반환 됨 - Insert, Update, Delete문 실행할 때 사용, 수정한 레코드 수를 int형으로 반환
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}//end of addBook().
	
	
	//2.목록
	ArrayList<Book> books;
	
	ArrayList<Book> getBookList(){
		getConn();
		books = new ArrayList<Book>();
		String sql = "select * from book order by 1"; //목록보여주는 쿼리 생성
		try {
			psmt = conn.prepareStatement(sql);  //SQL실행요청 및 결과 받기
			rs = psmt.executeQuery(); //select조회문 전송할 때 사용하는 메서드로, ResultSet 데이터를 반환(select문 실행하여 테이블로부터 얻은 결과를 저장하고 있는 저장소)
		
			while(rs.next()) { //next()함수: ResultSet에 저장된 select문 실행 결과를 행 단위로 1행씩 넘겨서 만약 다음 행이 있으면 true, 없으면 false
				               //  => while(rs.next()) : 한 루프 돌아갈 때마다 1행씩 넘겨주다가 더이상 행이 없으면 while문 끝 
				Book book = new Book();
				book.setBookCode(rs.getString("book_code"));
				book.setBookTitle(rs.getString("book_title"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getInt("price"));
				
				//컬렉션에 저장
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;                             
	}//end of getBookList().
	
	
	//3.단건조회 (책코드입력받아서)
	Book getBook(String bookCode) {
		getConn();
		String sql = "select * from book where book_code = ?"; //* 한건조회 쿼리만들기
		try {
			psmt = conn.prepareStatement(sql); //원래 new로 해서 인스턴스 만든걸 connection객체가 가지고 있는 메소드 활용해서 preparestatement객체 만든 것
			psmt.setString(1, bookCode);//매개값 받은걸 prepareStatement(psmt변수)에 넘겨받아
			rs = psmt.executeQuery(); // executeQuery메서드로 
			
			if(rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getString("book_code"));
				book.setBookTitle(rs.getString("book_title"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getInt("price"));
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; //조회된 값 없으면 null값 반환
	}//end of getBook();
	
	
	//4.수정
	boolean modifyBook(String bookCode, int price) {
		getConn();
		String sql = "update book set price = ? where book_code = ?"; //수정쿼리 만들기
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, price);
			psmt.setString(2, bookCode);
			
			int r = psmt.executeUpdate(); //executeUpdate 는 결과값담는 타입 int rs하니까 타입 int로 바꾸라고 함
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//end of modify;
	
	
	//5.삭제
	boolean removeBook(String bookCode) {
		getConn();
		String sql = "Delete from book where book_code =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			int r = psmt.executeUpdate(); 
			
			if (r > 0) {
				for(int i =0; i > books.size(); i++) {
					if(books.get(i) != null && books.get(i).getBookCode().equals(bookCode)) {
						books.remove(i);
						break;
					}
				}
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}//end of class.
