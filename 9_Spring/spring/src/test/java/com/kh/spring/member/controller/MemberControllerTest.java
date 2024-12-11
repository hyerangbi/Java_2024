package com.kh.spring.member.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class) // JUnit 을 사용하여 스프링 컨텍스트를 로드한다.
@WebAppConfiguration // Mockmvc 역할을 해준다
@ContextConfiguration(locations = {
		"file:src/test/resources/root-context.xml",
		"file:src/test/resources/servlet-context.xml",
		"file:src/test/resources/spring-sercurity.xml",
})
public class MemberControllerTest {
	
	@Autowired
	private WebApplicationContext wac; // 웹 어플리케이션 컨텍스트
	
	private MockMvc mockMvc; // 의존성 주입을 받는건 아니다. 
	/*
	 * MockMvc 가 context 를 mockmvc 가 감싸서 요청이 가는것처럼 진행해줄 것이다. 
	 */
	@Before // Test 메서드가 실행 되기 전에 실행하는 메서드 
	//junit 에서 받는 어노테이션
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		// mockMVC 에 저장해서 build 하는 것이다.
		log.info("================= mockMvc 준비 완료  (˵ •̀ ᴗ - ˵ ) ✧ ! ================");
	}
	
	@Test
	public void test() {
		try {
			mockMvc.perform(post("/login.me") // POST 메서드로 /login.me 로 요청한다.
					.param("userId", "admin") // 요청 파라미터 user 정보 세팅
					.param("userPwd", "123123"))
					.andDo(print()) // 요청한 정보에 대한 응답코드를 출력한다. 아마도 200 이 나올것이다 ?
					.andExpect(status().isFound()) // redirect 로 하는건 대부분 HTTP상태코드 302 (인지 확인해달라 !)   
					.andExpect(redirectedUrl("/"));
					//.andExpect(status().isOk())
		} catch(Exception e) {
			e.printStackTrace();
		}	
				
	}
	/*
	 * isFound : 302 | 리다이렉션
	 * isNotFound : 404 | 클라이언트 에러
	 * isOk() : 200 | 성공
	 */
	
	@Test
	public void testIdCheck() {
		MvcResult result; // 요쳥결과를 받아줄 result 객체
		
		try {
			result = mockMvc.perform(
					get("/idCheck.me")
					.param("checkId", "id000"))
					.andExpect(status().isOk())
					.andReturn(); // 요청결과를 반환한다.
			
			// 응답객체 내용확인
			String content = result.getResponse().getContentAsString();
			assertEquals("NNNNY", content); // 아이디 사용가능을 예상한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
		
	}
}
