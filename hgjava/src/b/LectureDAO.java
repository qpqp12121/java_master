package b;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LectureDAO {


		
		DBConnection dbc = new DBConnection();
		Connection conn;
		PreparedStatement psmt;
		ResultSet rs;
		
		//카테고리별 목록
		List<Lecture> lecture;
		
		List<Lecture> getLectureList(){
			lecture = new ArrayList<Lecture>();
			String sql = "select * from lecture order by 1";
			try {
				conn = dbc.getConn();
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					Lecture lec = new Lecture();
					lec.setLecNo(rs.getInt("lec_no"));
					lec.setCategory(rs.getString("lec_category"));
					lec.setLecName(rs.getString("lec_name"));
					lec.setLecTarget(rs.getString("lec_target"));
					lec.setStartDate(rs.getDate("start_date"));
					lec.setEndDate(rs.getDate("end_date"));
					lec.setTuitionFee(rs.getInt("tuition_fee"));
					
					lecture.add(lec);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lecture;
		}
		
//		//페이징
//		
//		public static List<Lecture> pageList(List<Lecture> ary, int page) {
//			List<Lecture> resultAry = new ArrayList<>();
//			int start = (page - 1) *5;
//			int end = page * 5;
//	
//			for(int i = 0; i < ary.size(); i++) {
//				if(i >= start && i < end) {
//					resultAry.add(ary.get(i));
//				}
//			}
//			return resultAry;
//		}
//		
//		//
//		public void showList(int page) {
//			List<Lecture> pageAry = 
//		}
		
		
		
		
		
		

}// end of class.
