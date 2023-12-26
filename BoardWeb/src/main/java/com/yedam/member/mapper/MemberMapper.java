package com.yedam.member.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper {
	//한건조회                      //Mapper.xml에 준 파라미터 이름(?
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw); 
	//mapper쪽에는 데이터 사용한다는 의미?로 login말고 select-로 메서드명 지음 / xml에서 parameterType안 줬고 두 개라서 여기서(?   
	//Service에서는 public MemberVO login(String id, String pw); 로 그냥 주고
	
	
	
}
