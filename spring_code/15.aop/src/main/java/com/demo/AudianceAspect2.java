package com.demo;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
public class AudianceAspect2 {

		//  access specifier full qualifed name of class . method name
	@Around("execution(public * com.demo.Magician.*(..))")
	public Object aroundDemo(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("before calling method :"+pjp.getSignature().getName());
		Object val=pjp.proceed();
		System.out.println("after calling method :"+pjp.getSignature().getName());
		return val;
	}
	
//	@After("execution(public void doMagic())")
//	public void afterDoMagic(JoinPoint joinpoint) {
//		System.out.println("after is called....");
//	}
//	
//	//@After will run wheter method successfully exectued or not.
//	@After("execution(public void doMagic())")
//	public void doClapping(JoinPoint jp) {
//		System.out.println("maza aa gaya....clapping @After");
//	}

}
