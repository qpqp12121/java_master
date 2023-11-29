package chap6;

// login기능 넣은 것 (BoardApp에서 사용)

public class UserExe {

	private User[] users; //user담는 배열 필드 (아래에 초기화함-값할당)
	
	
	public UserExe() {
		users = new User[]{new User("user01", "1111", "홍길동") // 위에 따로 선언하고 초기화할 땐 앞에 new User[]붙여야됨
						   ,new User("user02", "2222", "김철수")
						   ,new User("user03", "3333", "박씨")
		};
	}// -> 생성자에 값 넣기
	
	
	/* users가 가지고 있는 id와 pw를 찾아봐서 있으면 true,없으면 false반환
	   " public > default > private "  */
	
	
	 public User logIn(String id, String pw) { //---------BoardApp파일이랑 UserExe파일이 다른 패키지에 있어서 public붙여줘야 접근되어서 
		for(int i = 0; i < users.length; i++) {
			if(users[i] != null && users[i].getUserId().equals(id) && users[i].getPasswd().equals(pw)){
				return users[i];      //if조건에 배열은 항상 null값 있는 걸 염두해 두고 null이 아니면 조건 넣기!
			}
		}
		return null;
	}//end of login.
	
	
	
	
	
	
	
	
	
}//end of class
