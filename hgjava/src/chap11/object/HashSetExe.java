package chap11.object;

import java.util.HashSet;

public class HashSetExe {

	public static void main(String[] args) {
		//배열의 단점때문에 "컬렉션"사용 ( List, Set, Map ) - Set클래스는 중복되지 않은 값만 담아줌(중복된 값 알아서 걸러줌)
		HashSet<String> set = new HashSet<String>(); //HashSet컬렉션 안에는 문자열만 받겠습니다 (타입지정해줘야됨)
		set.add("Hong"); // set변수에다 값을 담는 것(메서드사용) //배열은 인덱스사용
		set.add("Hwang");
		set.add("Park");
		set.add("Hong");
//		set.add(new Member("Hong", 20)); //문자열이 아니라 담을 수 없다고 오류메시지뜸
		
		for(Object name : set) {
			System.out.println(name); //=> Hong 중복이라 한번만 나옴
		}
		
		
		HashSet<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 20));
		members.add(new Member("김길동", 21));
		members.add(new Member("박길동", 21));
		members.add(new Member("홍길동", 20));
		
		for(Member mem : members) {
			System.out.println(mem.toString());
		}
		
		
	}//end of main.	
	
}//end of class.
