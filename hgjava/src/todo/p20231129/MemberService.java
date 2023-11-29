package todo.p20231129;

public class MemberService {
	
//	private Mem[] members;
	
//	public MemberService() {
//		members = new Member[] { new Member("hong", "12345")
//	};
//	
//	
	boolean logIn(String id, String pw) {
		if(id.equals("hong") && pw.equals("12345")) {
			return true;
		}else {
			return false;
		}
	}
	
	void logout(String id) {
		System.out.println("로그아웃 되었습니다");
	}
	
	
	
}//end of class.
