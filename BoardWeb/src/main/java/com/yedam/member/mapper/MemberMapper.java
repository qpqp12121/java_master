package com.yedam.member.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper {
	//한건조회
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw); //mapper쪽에는 데이터 사용한다는 의미?로 login말고 select로 줫음
	                             //Mapper.xml에 준 파라미터 이름(?
	
	
	
	
}
