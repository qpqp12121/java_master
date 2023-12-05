package chap13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TodoExe {
	
	public static void main(String[] args) {
		
		// 순번, 할일(Todo) DueDate--복합적인 데이터면 String으로 안되니까 클래스를 만들어야됨(=>todo클래스 만듦ㄱ)
//		Map<Integer, String> todoList = new HashMap<>(); --순번, 할일까지만 했을 때
		Map<Integer, Todo> todoList = new HashMap<>(); //Todo클래스 만들어서
		
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("번호 할일 (기한) 입력>>");
			String input = scn.nextLine(); // 20 장보기 23-12-08
			String[] inpAry = input.split(" "); //구분자 들어가야 그 기준으로 잘림(공백하거나 - 하이픈하거나 등등)
			
			//걸러낼 조건.
			if(inpAry.length != 2 && inpAry.length != 3) {
				System.out.println("입력값을 확인하세요");
				continue;
			}
			
			String order = inpAry[0]; //순번.
			String title = inpAry[1]; //할일내용
			
			Todo todo = null;
			if(inpAry.length == 2) {
				todo = new Todo(title);				
			}else if(inpAry.length == 3) {
				String dueDate = inpAry[2]; //날짜(들어올때있고 아니면 당시시간)				
				//Date -> String으로 or String -> Date로 바꾸는 거 해야됨
				//2023-10-23 => 어떤 형식의 format인지 알려줘야됨
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					todo = new Todo(title, sdf.parse(dueDate));
				} catch (ParseException e) {
					e.printStackTrace();
				} //문자열을 .parse 라는 메소드로 date타입으로 바꿈 (반대는 format
			}//end of if.
			
//			todoList.put(Integer.parseInt(inpAry[0]),inpAry[1]); //todoList Map타입에 값 넣겠다 (입력받은거 번호랑 할일 나눠서 넣기)
			todoList.put(Integer.parseInt(order), todo); 

			if(todoList.size() == 3) {
				break;
			}
		}//end while
		//입력했던 번호와 할일을 출력(MapExe에 키 값 나눠서 출력할 수 있는
		System.out.println("번호    \t할일  \t기한");
		System.out.println("==================");
		//반복문 사용해서 목록 나오도록
//		Set<Integer> set = todoList.keySet();
//		for(Integer key : set) {
//			System.out.println(key +" "+ todoList.get(key));
//		}
		Set<Entry<Integer, Todo>> entry = todoList.entrySet();
		for(Entry<Integer,Todo> ent : entry) {
			System.out.println(ent.getKey() + " " + ent.getValue());
		}
		System.out.println("end of prog");
		
		
		
		
	}//end of main.

}//end of class.
