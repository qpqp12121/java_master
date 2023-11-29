package chap6;

//배열 순서 뒤바꾸기  -(글번호)
 
public class ArraySortExe {
	public static void main(String[] args) {
		int[] numAry = { 2, 1, 5, 4, 3 };
		
		//정렬작업.
		int temp = 0; //앞뒤 비교해서 뒤에가 작으면 앞방으로 들어올 거라 앞방 값 미리 다른 곳에 담아둬야됨
		for(int j = 0; j < numAry.length - 1; j++) { //위치변경 작업(총 또 4번돌기)
			for(int i = 0; i < numAry.length - 1; i++) { //앞뒤 방번호 비교 - 값이 5개인데 비교는 총 4번만 해야되니까 length-1 해야됨
				if(numAry[i] > numAry[i+1]) { //i=0이면 뒤에는 i+1로 0번방 > 1번방 비교해서 0번방이 작으면 순서 바꾸기
					temp = numAry[i]; //앞방 애 빈방에 옮기고
					numAry[i] = numAry[i+1]; //뒷방애를 앞방으로 옮기고
					numAry[i+1] = temp; //빈방애(첫앞방값)를 다시 뒤로
				}
			}	
		}
		
		for(int num: numAry) {
		System.out.println(numAry);
		}

 }//end main
	
	
}//end class
