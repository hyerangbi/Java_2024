package com.kh.spring.common.Intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginIntercepter implements HandlerInterceptor{
	/*
	 * HandlerInterceptor
	 * 
	 *  	◾ Controller 가 실행되지 전/후 에 낚아채서 실행된다
	 *  	◾ 로그인 유/무 판단, 회원권한체크
	 *  
	 *  preHandle(전 처리) : DispatcherServlet이 컨트롤러를 호출하기 전에 낚아채는 영역
	 *  postHandle(후 처리) : 컨트롤러에서 요청 후 DispatcherServlet 으로 view 정보를 리턴하는 순간 낚아채는 영역
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		  ◾ return : true -> 기존 요청 흐름대로 진행 (Controller로 이동)
		  ◾ return : false -> 요청 중단 후 반환
		 */
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") != null) {
			return true;
		}else {
			session.setAttribute("alertMsg", "로그인 후 이용 가능한 서비스입니다.");
			response.sendRedirect(request.getContextPath());
			return false;
		}
	}

}
 
