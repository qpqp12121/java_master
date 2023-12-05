package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExe2{

	public static void main(String[] args) {
		
		Map<Member, String> map;
		map = new HashMap<>();
		
		map.put(new Member("M001", "홍길동", 100), "경기도 100번지");
		map.put(new Member("M002", "김민수", 90), "서울시 200번지");
		map.put(new Member("M003", "박씨", 80), "대전시 300번지");
		map.put(new Member("M001", "홍길동", 100), "경기도 200번지");
		
		map.remove(new Member("M001", "홍길동", 100));
		
		// 1) key를 set 컬렉션에 저장.
		Set<Member> set = map.keySet(); //중복된 값은 담아주지 않는게Set컬렉션 (위에 홍길동 값이 같은 것처럼 보이지만 인스턴스 만들어진거니 각각 다른 주소 참조)
		for(Member member : set) {
			System.out.println("key: " + member + ", value: " + map.get(member));
		}
		
		// 2) key, value => set에 저장.
		Set<Entry<Member,String>> entry = map.entrySet(); // =뒤에 map.entrySet()치고 마우스 올려보면 앞에 타입 나옴
		for(Entry<Member,String> ent : entry) {
			System.out.println("Key: " + ent.getKey() + ", Val: " + ent.getValue());
		}
		
		
		
		
	}//end of main.
}//end of class.
