package b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {

	static Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public static Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url,"dev","dev");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
	
}//end of class.
