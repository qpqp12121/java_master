package a;

import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		
		JDBC jdbc = new JDBC();
		XmasDAO dao = new XmasDAO(jdbc);
		
		List<XmasClass> ls = dao.getXmasList();
		
		for(XmasClass xc : ls) {
			System.out.println(ls);
		}
		
		
		
	}//end of main.
	
	
}//end of class.
