package a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XmasDAO {

	private JDBC jdbc;
	
	public XmasDAO(JDBC jdbc) {
		this.jdbc = jdbc;
	}
	
	//select
	public List<XmasClass> getXmasList(){
		String sql = "select * from xmas_oneday";
		Connection conn = jdbc.getConn();
		PreparedStatement psmt;
		ResultSet rs;
		
		List<XmasClass> result = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				XmasClass xc = new XmasClass(
						rs.getInt("xmas_no"),
						rs.getString("lec_name"),
						rs.getInt("vote"));
				result.add(xc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
}//end of class.
