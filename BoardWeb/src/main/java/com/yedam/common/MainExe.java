package com.yedam.common;

import com.yedam.member.service.MemberService;
import com.yedam.member.service.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MainExe {
//만든 것 실행테스트
	public static void main(String[] args) {
//		StudentService svc = new StudentServiceMybatis();
//		String sno = "23-001";
//		//StudentMapper.xml => 추가
//		//
//		if(svc.remStudent(sno)) {
//			System.out.println("삭제O");
//		}else {
//			System.out.println("삭제X");
//		}
//		
		
//		SqlSessionFactory factory = DataSource.getInstance();
//		SqlSession session = factory.openSession(true);
//		
//		BoardMapper mapper = session.getMapper(BoardMapper.class);
//		BoardVO vo = new BoardVO(); 
//		
//
//		//1.목록
////		List<BoardVO> list = mapper.selectList();
////		for(BoardVO vo1 : list) {
////			System.out.println(vo1.toString());
////		}
//
//		//2.단건조회
//		BoardVO vo1 = mapper.selectOne(4);
//		System.out.println(vo1.toString());
//		
//		System.out.println(mapper.selectOne(4));

		
		
		//3.등록
//		vo.setTitle("tttt");
//		vo.setContent("dddd");
//		vo.setWriter("www");
//
//		mapper.insertBoard(vo);
		
		//4.수정
//		vo.setBoardNo(4);
//		vo.setContent("cdcd"); //위에 삽입한 content 수정
//	
//		mapper.updateBoard(vo);
		
		//5.삭제

		
//		if(mapper.deleteBoard(3) == 1) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
			
		//6.조회수증가
//		if(mapper.updateCnt(2) == 1) {
//			System.out.println("증가");
//		}else {
//			System.out.println("실패");
//		}
		
		//////////////MemberSErvice테스트
		MemberService svc = new MemberServiceImpl();
		MemberVO vo = svc.login("user1", "1111");
		
		if(vo != null) {
			System.out.println(vo);
			System.out.println("환영" + vo.getName()+"님 권한은 " + vo.getResponsibility());
		}else {
			System.out.println("id,pw 확인.");
		}
		
		
		
		
		
		
		
		
		
	
	}//end of main.
	
}//end of class.
