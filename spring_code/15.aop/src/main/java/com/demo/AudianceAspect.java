package com.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
//AOP : aspect: advice + pointcut
//@Component
//@Aspect
public class AudianceAspect {

//	@Before("execution(public void doMagic())")
//	public void doClapping(JoinPoint jp) {
//		System.out.println(jp.getSignature().getName());
//		System.out.println("maza aa gaya....clapping");
//	}
//	
	
	//@After will run wheter method successfully exectued or not.
//	@After("execution(public void doMagic())")
//	public void doClapping(JoinPoint jp) {
//		System.out.println("maza aa gaya....clapping @After");
//	}
	
//	//@AfterReturning will run iff method successfully exectued
//	@AfterReturning("execution(public void doMagic())")
//	public void doClappingAfterReturing(JoinPoint jp) {
//		System.out.println("maza aa gaya....clapping  ..@AfterReturning");
//	}
	
//	@RestControllerAdvice : handle ex handilng in aop way
//	@AfterThrowing("execution(public void doMagic())")
//	public void callDr(JoinPoint jp) {
//		System.out.println("pl call Dr. its urgent...");
//	}
//	
}
