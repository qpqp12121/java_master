package chap13;

import java.util.ArrayList;
import java.util.List;

public class ProductExe {
	
	//<필드>
	List<Product> products;
	
	//<생성자>
	ProductExe(){
		products = new ArrayList<Product>();
		products.add(new Product("P001", "볼펜", 1000));
		products.add(new Product("P002", "연필", 1200));
		products.add(new Product("N001", "노트100", 1000));
		products.add(new Product("N002", "다이어리", 3000));
	}
	
	//<메소드>
	
	//1-1등록
	boolean addPro(Product prodata) {
		return products.add(prodata);
	}
	//1-2수정
	boolean modifyPro(String name, int price) {
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getproName().equals(name)) {
				products.get(i).setProPrice(price);
				return true;
			}
		}
		return false;
	}
	//1-3목록
	List<Product> proList() {
		return products;
	}
	
	
	
	
	
	

}
