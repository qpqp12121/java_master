package chap13;

import java.util.ArrayList;
import java.util.List;

public class ListExe {

	public static void main(String[] args) {

		String[] strs = { "Mon", "Tue", "10" };
		strs[0] = "Wed"; // 배열에서 값 담을 때
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		//위는 배열
		
		
		List<String> list = new ArrayList<String>(); // 인터페이스
		
		//컬렉션에서 값가져올 땐 ___.get(i)
		
		// 값 담기
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");

		// 삭제
		list.remove(0); // (배열에선 strs[0] = null 삭제)
		// or list.remove("Apple")

		// 값 변경
		list.set(0, "바나나");
		// 전체요소 삭제
		list.clear();

		for (int i = 0; i < list.size(); i++) { // length아니고 size()로
			System.out.println(list.get(i)); // 위에서 글 다 지워서 결과값x
		}

	
		// 컬렉션의 크기 변경.(제한X)
		for (int i = 0; i < 100; i++) {
			list.add("" + i); //문자열로 넣으라고 해서 ""+i 합친거 (""이거랑 합쳐지면 문자열로 자동변환되니까)
		}
		for (int i = 0; i < list.size(); i++) { 
			System.out.println(list.get(i)); 
		}
		
		//이름 저장되어있는 컬렉션
		List<String> names = new ArrayList<String>();
		names.add("홍길동"); //0
		names.add("김길동"); //1
		names.add("박철수"); //2
		
		String search = "길동";
		int cnt = 0;
		for(int i = 0; i < names.size(); i++) {
			if(names.get(i).indexOf(search) != -1) { //equals하니까 출력 안 됨
				cnt ++;	
			}
		}
		System.out.println(search + "은 " + cnt + "명입니다");
		
		
		
		

	}// end main.

}// end class.
