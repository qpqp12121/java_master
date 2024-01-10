package com.yedam.book.vo;



public class BookVO {

	private String bookCode;
	private String bookName;
	private String bookAuthor;
	private String bookPress;
	private int bookPrice;
	
	
	
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPress() {
		return bookPress;
	}
	public void setBookPress(String bookPress) {
		this.bookPress = bookPress;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "BookVO [bookCode=" + bookCode + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookPress="
				+ bookPress + ", bookPrice=" + bookPrice + "]";
	}








}
