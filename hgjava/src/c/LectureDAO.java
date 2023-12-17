package c;

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
					lec.setLecCode(rs.getString("lec_no"));
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
		
		//카테고리만 가져오기

		
		public List<Lecture> getCategory(){
			List<Lecture> list = new ArrayList<Lecture>();
			String sql = "select distinct lec_category from lecture order by 1";
			try {
				conn = dbc.getConn();
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					Lecture lec = new Lecture();
					lec.setCategory(rs.getString("lec_category"));
					
					list.add(lec);	
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
			
			
			
		
		
		//2.수강신청(초과인원시 신청X
		
		
		
		
		
		

}// end of class.
