package chap11.object;

public class StringExe {

	public static void main(String[] args) {

		// 486p
		// 바이트 배열 전체를 String 객체로 생성

		byte[] b1 = "Hello".getBytes(); // 메소드까지 치고 마우스 올리면 어떤 타입인지 나옴
		for (byte b : b1) {
			System.out.println(b);
		}

		String name = new String(new byte[] { 65, 66, 67, 68, 69 });
		System.out.println(name);

		char c1 = name.charAt(0); // charAt() 몇번째에 있는 문자를 가지고 오겠습니다
		System.out.println(c1);

		name = new String(b1);
		System.out.println(name);

		// 주민
		String[] numbers = { "980304-1234567", "980304-2234567", "020101-3456789", "020104-4456789", "0301053545678" };

		for (String no : numbers) {
			System.out.println(findGender(no));
		}
		// 파일명 (끝에있는 파일이름반환)
		String[] fileNames = { "c:/images/prod/sample.jpg", "d:/test/sample/americano.png",
				"d:/goods/test/2023/moka.jpg" };
		for (String file : fileNames) {
			System.out.println(findFileName(file)); // 밑에서 매개값 받아서 file명만 반환되도록
		}

	}// end main
//메인메소드 밖에 메소드 선언

	// 성별을 반환.
	static String findGender(String ssn) {
		// 생년월일 - 1,3 / 2,4
		char gender = ssn.charAt(7);
		String result = "";

		if (ssn.indexOf("-") == -1) {
			gender = ssn.charAt(6);
		}

		switch (gender) {
		case '1':
		case '3':
			result = "남";
			break;
		case '2':
		case '4':
			result = "여";
			break;
		}
		return result;
	}// end of findGender.

	// 다른방법
//	static String findGender(String ssn) {
//		int pos = ssn.length() - 7;
//		switch(ssn.charAt(pos)) {
//		case '1':
//		case '3':
//			return "남";
//		case '2':
//		case '4':
//			return "여";
//		}
//		return "오류";
//	}

	// 파일명을 가져오기
	static String findFileName(String file) { //매개값에 file경로까지 포함된 전체 들어오면 뒤에 파일명만 보여지도록
		String cut = file.substring(file.lastIndexOf("/"));
		String cut2 = cut.substring(1);
		return cut2;
	}
//	//교수님하싱ㄴ거
//	static String findFileName(String file) { //매개값에 file경로까지 포함된 전체 들어오면 뒤에 파일명만 보여지도록
//		int pos = 0;
//		while(true) {
//			int pos2 = file.indexOf("/", pos);
//			if(pos2 == -1) {
//				break;
//			}
//			pos2++;
//			pos = pos2;
//		}
//		return file.substring(pos);
//	}

	// split사용해서도 해보기

//	static String findFileName(String file) { // 매개값에 file경로까지 포함된 전체 들어오면 뒤에 파일명만 보여지도록
//		String[] cut = file.split("/");
//		
//		return 
//	}

}// end class.
