package remind6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainExe {
	static Connection conn; //메인메소드 밖에서도 사용할 수 있도록 선언
	
	public static void main(String[] args) {
		
		//jdbc library가 제대로 연결되었는지 확인

		String url = "jdbc:oracle:thin:@localhost:1521:xe";                                                     //접속할 url (오라클 url패턴) --이거 주의해서 정확하게 적기
		try {
			Class.forName("oracle.jdbc.OracleDriver");                                                         //예외처리 해야됨 (Surround-)	//Referenced libraries에 보면 ojdbc들어있음  ---경로적기OracleDriver
			conn = DriverManager.getConnection(url,"dev", "dev");                                            //예외처리 세번째거 누르기 -- url, "사용자이름", "비번"(oracle에서 만든
			System.out.println("연결성공!!");   
			//select(); //메인메소드 밖에 select() 메소드에서 오류가 생기면 여기 호출한 쪽에서 예외처리 되도록
			                                                                                                
			String sql = "insert into student(stu_no, stu_name, eng_score, math_score) "                    //\r\n은 엔터키임(지우고 싶으면 space 하나로 바꾸기)
					+ "values(?, ?, ?, ?)";                                                                 //사용자가 입력한 값으로 넣을 수 있도록 
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, "23-003"); // parameter
			psmt.setString(2, "박씨");
			psmt.setInt(3, 80);
			psmt.setInt(4, 85);                                                                             //여기서 입력한 값 -oracle에서 테이블조회하면 들어있음 (실행 또 시켜버리면 기본키값 중복되니까 오류생김 unique-)
			
			//입력, 수정, 삭제 => executeUpdate() 메소드 사용;
			int r = psmt.executeUpdate(); //update 처리 된 건수 반환해줌
			if(r == 1) {
				System.out.println("입력성공.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();                                                                            //어디서 에러 났ㅅ는지 볼 수 있음
  			//System.out.println("Driver 없음.");                                                               //없으면 없다고 표시되도록 
		}
		
		

		
	}//end of main.
	
	public static void select() throws Exception {
		String sql = "select * from student";
		PreparedStatement psmt = conn.prepareStatement(sql);  //Add throw 예외처리로                                             //쿼리연결?(만들기)
		ResultSet rs = psmt.executeQuery();   //조회할 땐 executeQuery()메소드 사용 --처리된 정보를 ResultSet에 담아줌                                                           //쿼리조회 (쿼리:select * from student //타입 .exe-에 마우스 올려보면 알 수 있음(반복루핑돌면서 값 반환
		while(rs.next()) {                                                                               //while문 쓸 수 있도록 .next()메소드 제공해줌 (값 하나하나 다 읽고나면 false값 반환해줌
			System.out.println("번호: " + rs.getString("stu_no")  /*목록가져오기*/
								+ ", 이름: " + rs.getString("stu_name")                                   //데이터 컬럼이름 괄호에(문자라 getString
							    + ", 영어: " + rs.getInt("eng_score")
							    + ", 수학: " + rs.getInt("math_score"));   
		}
	}

}//end of class
