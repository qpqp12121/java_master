package chap13;

import java.util.ArrayList;
import java.util.List;

public class InOutExe {
	ProductExe exe = new ProductExe();
	
	
	//<필드>
	List <InOut> inout;
	
	//<생성자>
	InOutExe(){
		inout = new ArrayList<InOut>();
	}
	
	//<메소드>
	//판매
	boolean sellProduct(String proCode) {
		for(int i = 0; i < exe.products.size(); i++) {
			if(exe.products.get(i).equals(proCode)) {
				exe.products.remove(i);
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	

}//end of class.
