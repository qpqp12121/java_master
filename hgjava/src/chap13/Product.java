package chap13;

public class Product {
	
	//<필드>
	private String proCode;
	private String proName;
	private int proPrice;
	
	//<생성자>
	Product(){
		
	}
	
	Product(String proCode, String proName, int proPrice){
		this.proCode = proCode;
		this.proName = proName;
		this.proPrice = proPrice;
	}
	
	//<메소드>
	void showInfo() {
		System.out.println(proCode+ "\t" + proName+ "\t" + proPrice+ "\t");
	}
	
	void setProCode(String proCode) {
		this.proCode = proCode;
	}
	void setProName(String proName) {
		this.proName = proName;
	}
	void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	
	String getproCode() {
		return proCode;
	}
	String getproName() {
		return proName;
	}
	int getproPrice() {
		return proPrice;
	}
	
	
	
	
	
	

}//end of class.
