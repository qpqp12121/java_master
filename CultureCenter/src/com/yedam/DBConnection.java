package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	static Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public Connection getConn() {
		String url = "jdbc:oracle:thin:@192.168.0.40:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url,"dev","dev");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//연결접속해제.
	public void disconn() {
		try {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
}//end of class.
