package a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XmasSurvey {

	public static void main(String[] args) {
		
		JDBC jd= new JDBC();
		
		Connection conn = jd.getConn();
		String sql = "select * from xmas_oneday";
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
		
		for(XmasClass xc : result) {
			System.out.println(xc);
		}
		
		
		//추가
		String sql = "insert into xmas_oneday(xmas_no, lec_name)
				values(xmas_oneday_seq.nextval, '크리스마스 미니트리 캔들')
		
		
		
		
		
	}//end of main.
}//end of class.
