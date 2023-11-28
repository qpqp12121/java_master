package chap5;

public class Student {
	
	//메인메소드 없고 데이터만 사용 StudentApp2 30라인 참고
	String name;
	int score;
	String gender; // 남여 구분
}

/* StudentApp 파일에서  
   Q. 번호 선택하면 정보 출력되게 만들기
     < 1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.종료 > 프로그램 만들었으나 
      
      switch구문의 case4를 보면 if문 안에서 점수, 이름 각각 넣어 효율적이지 않다. 
      => 그래서 class에서 데이터만 넣고 StudentApp2에서 작업 다시 해 봄 */

	
	//아래는 StudentApp case4 코드 일부(참고)

	/*for(int i = 0; i < scores.length; i++) { 
	   sum += scores[i];
	   if(maxScore < scores[i]) {  //이름, 점수 각각 넣어 효율적인 코드 X 
	   maxScore = scores[i];   //이름,점수를 하나의 변수에 담고 싶으면 클래스 사용해야 된다 그래서 Student파일로 클래스 데이터 넣고 App2에서 작업한 것 확인하기!
	   maxName = names[i];
	  } */