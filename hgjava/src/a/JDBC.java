package a;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {

	Connection conn;
	
	Connection getConn() {
		String url =  "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}//end of class.
