package com.yedam.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper { //구현클래스가 xml파일
	//한건조회                    
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw); 
	// mapper쪽에는 DB 사용한다는 것 알기 쉽게 select-()로 메서드명 지음 ( 그냥 login말고 )
	// service에서는 public MemberVO login()으로 그냥 주고
	
	public List<MemberVO> selectList();
	public MemberVO selectOne(String id);
	
	//입력,삭제(Ajax로)
	public int insertMember(MemberVO vo);
	public int deleteMember(String id);
	
	
	/* < DB에 여러개의 값을 보내줄 때 구분 >
		@Param으로 이게 DB어디에 매칭되는 값인지, 명시해 줘야 아래 mapper에 있는 #{ } 부분에 알맞은 값이 들어간다.
		ex. public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
										(String id, String pw); 에러
	*/
		
	
	
}
