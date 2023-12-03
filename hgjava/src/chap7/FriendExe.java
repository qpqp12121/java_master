package chap7;

//데이터 저장하는 공간 ( FriendApp 컨트롤역할만 할 거라 Friend[] storage = new Friend[10] 만든 거 여기서 할 거

public class FriendExe {

	static Friend[] storage = new Friend[10]; //----이거 Exe파일에서 만드는 걸로 바꿔서 나중에 없앨 거임
	
	// < 1.등록 2.목록 3.조회 > 기능
	
// 1.등록	
	public static boolean addFriend(Friend friend) { //입력받은 어떤 값 넘겨받아서(매개변수) Friend[]storage에 저장할 수 있음 ->  
		                         //Friend앱에서 입력받은 값을 addFriend()로 넘겨받음(매개역할) => 그래서 다시 다른곳에서 호출해서 사용
		for(int i = 0; i < storage.length; i++) {
			if(storage[i] == null) { //빈방에 등록을 할 거니까 null인지 찾고 비어있으면 (friend)변수에 담아라
				storage[i] = friend;
				return true;
			}
		}
		return false;	
	}

	
// 2.목록
	public static Friend[] friendList() { //목록 (전체목록가져오면 되는 거라 Friend[] 배열로)
		//for문돌려서 null이 아닐때도 추가해야되는지 생각해보기
		return storage; //-----반환받는 값 넣기
	}


	
// 3.조회 (한 건말고목록)
	
	//결과값이 null인지 여부로 체크 못 함
	public static Friend[] searchFriend(String name) { //(동명이인 있을 수 있으니 Friend[] 배열로) //storage는 전체 배열이라 새로운 변수 만들어서
												//반환유형이 정해져 있음.(result)
		Friend[] result = new Friend[10]; //이건 Friendapp에서 null인지 아닌지로 조건 넣으면 안됨 (이미 null이 아니라)
		
		for (Friend fnd : result) {
			if (fnd.getName().equals(name)) {
				System.out.println(fnd.showInfo());
				 //이름 넣어서 조회
			}
		}
		return result;
		
	}
	
	
	
	//결과값 null여부로 체크
	public static Friend searchPhone(String phone) { //전화번호는 겹치지 않으니 Friend 
		for(int i = 0; i < storage.length; i++) {  //값이 있으면 그걸 반환할 거고, 값이 없으면 null반환
			if(storage[i] != null && storage[i].getPhone().equals(phone)) {
				return storage[i];
			}
		}
		return null;
	}
	
	
	
}//end of class.

