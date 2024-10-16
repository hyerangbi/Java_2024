package com.kh.spring.aspect;


import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/*
 * - Asepct : 해당 클래스가 Aspect (aop객체) 라는 것을 선언
 * - Component : Spring  이 해당 빈을 서칭할 수 있도록 선언 (Bean 등록)
 */

@Slf4j
@Aspect
@Component
public class LoggingAOP {
	
	/*
	 * <시점>
	 * @Bofore : 대상메소드 실행 전에 Advice(추가 기능)이 실행된다.
	 * 
	 * @After : 대상메소드 실행 후에 Advice(추가 기능)이 실행된다.
	 * 
	 * @AfterReturning : 대상 메소드가 정상적으로 반환된 후에 Advice(추가 기능)이 실행된다. *정상일 때
	 * 
	 * @AfterThrowing : 대상 메소드가 예외를 던진 후에 Advice(추가 기능)이 실행된다.
	 * 
	 * @Around : 대상 메소드를 감싸서 메소드 호출 전 후에 Advice(추가 기능)를 실행할 수 있다.
	 */
	
	/*
	 * <대상>
	 * target : 특정 인터페이스와 그 자식클래스
	 * within : 특정 패키지 또는 클래스
	 * execution : 표현식으로 형태지정
	 */
	
	// 특정 메소드나 패키지 등의 join point
	// com.kh 아래 모든 controller 패키지 하위 클래스의 모든 메소드에 전부 적용하겠다고 지점 설정
	@Pointcut("execution(* com.kh.kh.spring..controller.*.*(..) )") // kh 로부터 모든 객체
	private void cut() {};
	
	// cut 메소드가 실행되는 지점 이전에 before() 메소드 실행
	// JoinPoint : pointcut 지점에 대한 정보가 들어있다.
	// 메소드의 실행이 가장 일반적인 joinpoint 다
	@Before("cut()")
	public void before(JoinPoint joinPoint) {
		
		// 실행되는 메소드의 이름 가져오기
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		
		Object[] args = joinPoint.getArgs();
		
		log.info("===================== START =========================");
		log.info("---------------------------API Cotroller-----------------");
		log.info("Information    :    " + methodSignature);
		log.info("Method Name    :    " + method);
		log.info("Parameter      :    " + Arrays.toString(args));
	}
	
	@AfterReturning(value="cut()", returning="obj")
	public void afterReturn(JoinPoint joinPoint, Object obj) {
		log.info("======================== END ======================");
		log.info("Object        :    " + obj);
	}
	
	
	// api 시간 측정
	@Around("cut()")
	public Object displayLogInfo(ProceedingJoinPoint joinPoint) throws Throwable {
		// 실행 전 서버 시간
		long start = System.currentTimeMillis(); // 0
		
		// 실행하려던 joinpoint 메소드 실행
		Object result = joinPoint.proceed(); // 원래 하려고 했던(진행중이던) 작업 진행
		
		long end = System.currentTimeMillis(); // ex) 1000
		
		long runTime = end - start; // 실행 시간
		
		log.info("----------------------------------------------------------");
		log.info("Information        :    " + joinPoint.getSignature());
		log.info("Processing         :    " + runTime + "ms");
		
		return result;
	}
}
