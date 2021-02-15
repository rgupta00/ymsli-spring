package com.bookapp.model.service.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("@annotation(Loggable)")
	public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
		long start= System.currentTimeMillis();
		Object val = pjp.proceed();
		long end=System.currentTimeMillis();
		long timeTaken=end-start;
		logger.info("method "+pjp.getSignature().getName() +" take "+ timeTaken );
		return val;
	}
}


