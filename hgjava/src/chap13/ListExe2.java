package chap13;

import java.util.ArrayList;
import java.util.List;

public class ListExe2 {
	public static void main(String[] args) {
		List<Member> members = new ArrayList<>(); // <>안에 알아서 앞에 걸로 읽음
		
		members.add(new Member("M-001", "홍길동", 1000));
		members.add(new Member("M-002", "김길동", 1500));
		members.add(new Member("M-003", "최인수", 2000));
		
		String search = "길동";
		int cnt = 0;
		for(int i = 0; i < members.size(); i++) { //이름이 길동이고 점수가 1500점 이상인 사람은?
			if(members.get(i).getMemberName().indexOf(search) != -1 && members.get(i).getPoint() >= 1500) {  //members.get(i) 이렇게 가져오면 Member유형
				cnt++;
				members.remove(i);
			}
		}
		System.out.println("조건에 해당하는 " + search + "은 " + cnt + "명 입니다.");
		for(Member mem : members) {
			System.out.println(mem);
		}
		
		
		
		
		
		
	}//end of main
	
	
}//end of class.
