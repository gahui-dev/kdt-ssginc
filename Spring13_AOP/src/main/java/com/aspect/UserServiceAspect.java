package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// UserService에 부가 기능을 추가하는 빈
// https://docs.spring.io/spring-framework/docs/5.2.25.RELEASE/spring-framework-reference/core.html#aop-advice

@Aspect
public class UserServiceAspect {
	@Pointcut("execution(public String sayHello())")
	public void xxx() {
		
	}
	
	@Pointcut("execution(public String callHello())")
	public void xxx2() {
		
	}
	
	// Before Advice
	@Before("xxx()")
	public void method() {
		System.out.println("UserServiceAspect.Before advice");
	}
	
	// After Advice
	@After("execution(public String say*())")
	public void method2(JoinPoint point) {
		System.out.println("호출 메서드 : " + point.getSignature().getName());
		System.out.println("UserServiceAspect.After advice");
	}
	
	// AfterReturning Advice
	// 핵심 메서드가 실행되어 정상적으로 실행 결과값을 리턴했을 때 위빙
	// Aspect에서 핵심 메서드가 리턴하는 리턴값을 얻을 수 있음
	// 무엇을 return 는지 알 수 있
	
//	@AfterReturning("execution(public String callHello())", 리턴값 저장)
	@AfterReturning(pointcut = "execution(public String callHello())", returning = "yyy")
	public void method3(Object yyy) {
		System.out.println("UserServiceAspect.AfterReturning advice" + yyy);
	}
	
	// AfterThrowing
	// 핵심 메서드가 실행되어 예외 발생 시 위빙
	// Aspect에서 핵심 메서드가 리턴하는 예외를 얻을 수 있음
	
//	@AfterThrowing(pointcut = "execution(public String echoHello())", throwing = "yyy")
	@AfterThrowing(pointcut = "execution(public String xxx())", throwing = "yyy")
	public void method4(Exception yyy) {
		System.out.println("UserServiceAspect.AfterReturning advice" + yyy.getMessage());
	}
	
	// AroundAdvice
	// 핵심 메서드가 실행되기 전, 후, 정상적으로 반환, 예외발생 시 모두 위빙 
	// Aspect에서 핵심메서드가 리턴하는 리턴값 및 예외정보를 얻을 수 있음 
	@Around("execution(public String echoHello())")
	public Object method5(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Before Advice >>> ");
		
		// 기준을 세워놓고 기준보다 앞이면 before 뒤면 after
		// 기준 잡기 
		Object retVal = pjp.proceed(); // Object가 핵심 메서드의 반환값
		
		System.out.println("@After Advice >>> ");
		System.out.println("@AfterReturning Advice >>> " + retVal); // 리턴값 출력 
		
		return retVal;
	}
	
}