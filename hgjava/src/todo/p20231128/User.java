package todo.p20231128;

//User파일은 데이터 한 건에 대한 값을 넣고 매개역할하는 곳(?)

public class User {

	//필드(속성)	
	private String userId;
	private String passwd;
	private String userName;
	
	//생성자
	 //위 3개 필드 다 받는 생성자
	public User(String userId, String passwd, String userName) {
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
	}
	
	
	//getter
	public String getUserId() {
		return userId;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public String getUserName() {
		return userName;
	}
	

	
	
}//end of class.
