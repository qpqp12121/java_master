package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe {

	public static void main(String[] args) {

		// <키, 값> 쌍으로 구성
		Map<String, Integer> map = new HashMap<String, Integer>(); // Map타입의 키를 String으로 value에 해당되는 건 Integer값

		// 추가기능
		map.put("홍길동", 80); // (key, value)
		map.put("김깅동", 85);
		map.put("박박박", 90);
		map.put("홍길동", 90); //key 중복X (그래서 중복되면 전에 값 없어짐)

		// 값 가져오기
		Integer result = map.get("홍길동"); // 키가 홍길동이라 괄호에 넣고-값이 Integer타입이라 int변수에 넣음 //ArrayList에선 .get(i) 인덱스가 키 역할

		// 전체 목록
		Set<String> set = map.keySet(); // -- Key Set만 빼옴
		for (String key : set) {
			System.out.println("key: " + key + ", value: " + map.get(key));
		}
		
		
		

	}// end of main.
}// end of class.
