package com.application.aop.practice1.chapter02_logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // Spring에 Bean으로 등록, 이 클래스를 Spring 컨텍스트에 빈(Bean)으로 등록함
@Aspect // 이 클래스가 AspectJ 어드바이스를 포함하는 클래스임을 나타냄
public class LoggerAdvice {

	// Logger 객체를 생성, LoggerAdvice 클래스에 대한 로거 생성
	private static final Logger logger = LoggerFactory.getLogger(LoggerAdvice.class); 

	// LoggerTestClass 클래스의 모든 public void 메서드에 대해 어드바이스를 적용
	@Around("execution(public void com.application.app.chapter02_logger.LoggerTestClass.*())")
	public void aroundLoggerTest(ProceedingJoinPoint pjp) throws Throwable {

		// 메서드가 시작되는 시점의 시스템 시간을 기록
		long startTime = System.currentTimeMillis();

		// 대상 메서드를 실제로 호출, 이 코드가 실행되어야 대상 메서드가 실행됨
		pjp.proceed();

		// 메서드가 종료된 시점의 시스템 시간을 기록
		long endTime = System.currentTimeMillis();

		// 메서드의 이름과 실행 시간을 초 단위로 콘솔에 출력
		System.out.println(pjp.getSignature().getName() + "메서드 동작시간 : " + (endTime - startTime) / 1000.0 + "초");

		// 다양한 로그 레벨(trace, debug, info, warn, error)로 실행 시간을 로그에 기록
		logger.trace(pjp.getSignature().getName() + "메서드 동작시간 : " + (endTime - startTime) / 1000.0 + "초");
		logger.debug(pjp.getSignature().getName() + "메서드 동작시간 : " + (endTime - startTime) / 1000.0 + "초");
		logger.info(pjp.getSignature().getName() + "메서드 동작시간 : " + (endTime - startTime) / 1000.0 + "초");
		logger.warn(pjp.getSignature().getName() + "메서드 동작시간 : " + (endTime - startTime) / 1000.0 + "초");
		logger.error(pjp.getSignature().getName() + "메서드 동작시간 : " + (endTime - startTime) / 1000.0 + "초");
	}
}

