package chap6;

//MainExe파일은 페이징 연습

public class MainExe {
	

	public static void main(String[] args) {
		
		String[] strs = {"1.df","2.dfdf","3.sfdf","4.ㅇㄹㄴfdf","5.sfdf","6.eeee","7.dd","8.sfddfd"};
		int page = 1; //매개값
		int start = (page - 1) * 5;
		int end = page * 5;
		
		for (int i = 0; i < strs.length; i++) {
			if(i >= start && i < end) { //한페이지당 5건씩 보여질 수 있도록(배열이라 0부터 5보다 작을때까지) i>= 0 && i <5
				                        //근데 위에서 start와 end변수에 계산식 넣어놓고 page 값바꾸면 저절로 계산되도록 가능하게 함
				System.out.println(strs[i]);
			}
		}
		
		int cnt = 36; //전체건수 36건 -- 한페이지당 5건씩 보여지게 할 거 (나머지도 페이지 새로 만들어야되니까 Math.ceil()함수 사용하기
		
		int totalPage = (int)Math.ceil(cnt/5.0); //올림 -- 근데 (안에 더블타입 들어가야 됨)
			System.out.println(totalPage); //전체페이지
			
			for(int i = 1; i <= totalPage; i++) {
				System.out.print(i + " ");
			}
	
	
	
	}//end of main.

}//end of class.
