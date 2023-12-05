package 연습.Board;

public class Book {

		// 필드
		private String bookCode;
		private String bookName;
		private String bookWriter;
		private String bookComp;
		private int bookPrice;

		// 생성자
		public Book() {

		}

		public Book(String bookCode, String bookName, String bookWriter, int bookPrice) {
			this.bookCode = bookCode;
			this.bookName = bookName;
			this.bookWriter = bookWriter;
			this.bookPrice = bookPrice;
		}

		public Book(String bookCode, String bookName, String bookWriter, String bookComp, int bookPrice) {
			this(bookCode, bookName, bookWriter, bookPrice);
			this.bookPrice = bookPrice;
		}

		// 메소드
		// setter
		public void setBookCode(String bookCode) {
			this.bookCode = bookCode;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public void setBookWriter(String bookWriter) {
			this.bookWriter = bookWriter;
		}

		public void setBookComp(String bookComp) {
			this.bookComp = bookComp;
		}

		public void setBookPrice(int bookPrice) {
			this.bookPrice = bookPrice;
		}

		// getter
		public String getBookCode() {
			return bookCode;
		}

		public String getBookName() {
			return bookName;
		}

		public String getBookWriter() {
			return bookWriter;
		}

		public String getBookComp() {
			return bookComp;
		}

		public int getBookPrice() {
			return bookPrice;
		}

		public void showInfo() {
			System.out.println(bookCode + "\t" + bookName + "\t\t" + bookWriter + "\t" + bookPrice);
		}

	}


