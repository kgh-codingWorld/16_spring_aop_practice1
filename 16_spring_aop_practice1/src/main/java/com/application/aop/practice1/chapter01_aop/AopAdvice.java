package com.application.aop.practice1.chapter01_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAdvice {
	
	@Before("execution(public void com.application.aop.practice1.chapter01_aop.*.work())")
	public void beforeWork() {
		System.out.println("(공통기능 , Before) 출근한다.");
	}
	
	@After("execution(public void com.application.aop.practice1.chapter01_aop.*.work())")
	public void afterWork() {
		System.out.println("공통기능 , After) 퇴근한다. \n");
	}
	
	@Around("execution(public void com.application.aop.chapter01_aop.*.getWorkingTime())")
	public void aroundGetWorkingTime(ProceedingJoinPoint pjp) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		
		pjp.proceed();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("업무 소요(메서드 실행)시간 : " + (endTime - startTime) / 1000.0 + "초");
	}
	
	@AfterReturning(value="execution(public String com.application.aop.chapter01_aop.*.getInfo(String,int))", returning="returnObj")
	public void afterReturningGetInfo(JoinPoint jp, Object returnObj) {
		
	}
}
