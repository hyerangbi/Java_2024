package com.kh.spring.member.mode.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.spring.member.model.dao.MemberDao;
import com.kh.spring.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class) // JUnit 을 사용하여 스프링 컨텍스트를 로드한다.
@ContextConfiguration(locations = {
		"file:src/test/resources/root-context.xml",
		"file:src/test/resources/servlet-context.xml",
		"file:src/test/resources/spring-sercurity.xml",
})
public class MemberDaoTest {
	// @ContextConfiguration 을 통해 등록한 스프링컨텍스트의 빈목록 중에 
	// MemberDao 를 구한하는 객체를 찾아서 주입해준다.
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Test // 이 어노테이션이 붙어있으면 이 메소드를 test 할꺼야 라고 생각하면 된다.
	// junit 테스트 메소드를 지정한다. Main 처럼 단독으로 실행된다.
	public void testLoginMember() {
		// fail("Not yes implemented");
		Member m = new Member(); // Test 할 Member 객체 생성
		m.setUserId("admin");
		
		// 아이디로 member 찾아오는 것을 예상한다.
		m = memberDao.loginMember(sqlSession, m);
		log.info("member : {}", m);
		if(m != null) {
			
		} else {
			fail("test LoginMember fail");
		}
	}
}
