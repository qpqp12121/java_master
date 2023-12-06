package chap13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InOut {
	
	//<필드>
	private String proCode;
	private String proDate;
	private int proCount;
	private String proSellBuy;
	
	//생성자
	InOut(){
		
	}
	
	InOut(String proCode, int proCount, String proSellBuy){
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.proCode = proCode;
		this.proCount = proCount;
		this.proSellBuy = proSellBuy;
		this.proDate = sdf.format(today);
	}
	
	//메소드
	
	
	

}
