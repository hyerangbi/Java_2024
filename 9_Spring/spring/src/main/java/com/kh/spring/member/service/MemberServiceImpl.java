package com.kh.spring.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.MemberDao;
import com.kh.spring.member.model.vo.Member;

@Service //@Component 보다 더 구체화해서 service 객체에 알맞게 been에 등록
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member loginMember(Member m) {
		//SqlSessionTemplate Bean 등록 후  @Autowired 해서 사용한다.
		// 스프링이 사용 후 자동으로 반납 시켜주기 때문에 close 메소드를 작성하지 않아도 된다.
		
		return memberDao.loginMember(sqlSession, m);
	}

	@Override
	public int idCheck(String checkId) {		
		return memberDao.idCheck(sqlSession, checkId);
		
	}

	@Override
	public int insertMember(Member m) {		
		return memberDao.insertMember(sqlSession, m);
	}

	@Override
	public int updateMember(Member m) {	
		return memberDao.updateMember(sqlSession, m);
	}

	@Override
	public int deleteMember(String userId) {
		return memberDao.deleteMember(sqlSession, userId);
	}

}
