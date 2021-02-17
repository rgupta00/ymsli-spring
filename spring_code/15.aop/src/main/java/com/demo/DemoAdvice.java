package com.demo;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAdvice {
	//any visisbiity but package should be com.demo any class .. put method name should start with
	//get and it should take any parameter
	
	
	@Pointcut("args(com.demo.Circle)")
	public void allMethodsTakeCircleAsArguemnt() {}
	
	@Before("allMethodsTakeCircleAsArguemnt()")
	public void applyAdviceCircle(JoinPoint joinPoint) {
		System.out.println("applying adv to all methods that take circle obj as parameter:"+joinPoint.getSignature().getName());
	}
	
	
//	
//	@Pointcut("execution(* com.demo.*.get*())")
//	public void addGettersOfComDemoPacakge() {}
//	
//	@Before("addGettersOfComDemoPacakge()")
//	public void applyAdvice(JoinPoint pointcut) {
//		System.out.println("adv1:"+pointcut.getSignature().getName());
//	}
//	
//	@Before("addGettersOfComDemoPacakge()")
//	public void applyAdvice2(JoinPoint pointcut) {
//		System.out.println("adv2:"+pointcut.getSignature().getName());
//	}
}

