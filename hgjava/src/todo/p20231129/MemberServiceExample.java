package todo.p20231129;

public class MemberServiceExample {
	
	public static void main(String[] args) {
		//268p 문제 3번을 구현하세요
		
		MemberService memberService = new MemberService();
		
		boolean result = memberService.logIn("hong", "12345");
		if(result) {
			System.out.println("로그인 되었습니다");
			memberService.logout("hong");
		}else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
		
		
		
		
	}
}
