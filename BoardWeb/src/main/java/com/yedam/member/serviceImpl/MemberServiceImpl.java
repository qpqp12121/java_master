package com.yedam.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.member.mapper.MemberMapper;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{ //MemberService 인터페이스 구현하는 클래스

	SqlSession session = DataSource.getInstance().openSession(true);
	MemberMapper mapper = session.getMapper(MemberMapper.class);
	
	@Override
	public MemberVO login(String id, String pw) {   //BoardServiceMybatis참고
		return mapper.selectMember(id, pw);
	} //만들고 common-MainExe에서 테스트도 해보기
	
	public List<MemberVO> memberList(){
		return mapper.selectList();
	}
	
	public MemberVO getMember(String id) {
		return mapper.selectOne(id);
	}

}
