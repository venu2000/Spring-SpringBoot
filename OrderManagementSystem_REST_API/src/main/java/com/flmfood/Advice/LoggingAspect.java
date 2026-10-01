package com.flmfood.Advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	public static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	
	/*
	 * @Before("execution(* com.flmfood.Controller.ItemsController.getAllItems(..))"
	 * ) 
	 * public void beforeLog() { 
	 * 
	 * log.info("Entered into Method");
	 * 
	 * }
	 */
	
	//to get method name dynamically
	
	@Before("execution(* com.flmfood.Controller.ItemsController.*(..))")
	public void beforeLog(JoinPoint joinPoint) {
		log.info("Entered into Method:{}", joinPoint.getSignature().getName());
		
	}
	
	
	
	@After("execution(* com.flmfood.Controller.ItemsController.*(..))")
	public void afterLog(JoinPoint joinPoint) {
		
		log.info("Exited from Method: {}", joinPoint.getSignature().getName());
		
	}
	
	
	
     
	@AfterThrowing(	
			pointcut = "execution(* com.flmfood.ServiceImpl.*.*(..))",
			throwing = "ex"
			)
	
	public void handleException(Exception ex) {
		
		log.error("Encountered Exception : {}", ex.getMessage());	
	}
	
	
	
	
	
	@Around("execution(* com.flmfood.ServiceImpl.ItemServiceImpl.*(..))")
	public Object logAroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		
		log.info("Entered into Method : {}", pjp.getSignature().getName() + "this is from @Around - LogAroundMethod");
		
		Object proceed = pjp.proceed();
		
		log.info("Returned from method :{}", pjp.getSignature().getName() + "this is from @Around - LogAroundMethod");
		
		return proceed;
	}
	
	
	

}
