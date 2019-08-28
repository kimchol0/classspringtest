package com.hp.test;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class LoggingAspect {

	@Before("execution(public int com.hp.test.ArithmeticCalculator.*(int,int))")
	public void beforeMethod(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		
		Object args[] = joinPoint.getArgs();
		
		System.out.println("method begin....."+methodName+",args:"+Arrays.asList(args));
	}
	
	@After("execution(* com.hp.test.*.*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("method:"+methodName+" ends.");
	}
	
	@AfterReturning(pointcut="execution(* com.hp.test.*.*(..))",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result) {
		
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("返回通知---the method:"+methodName+" end with result:"+result);
	
	}
	
	@AfterThrowing(pointcut="execution(* com.hp.test.*.*(..))",throwing="e")
	public void afterThrowing(JoinPoint joinPoint,Exception e) {
		
		String methodName = joinPoint.getSignature().getName();
		
		System.out.println("异常通知---the method:"+methodName+" occurs exception:"+ e);
		
	}
	
	@Around("execution(* com.hp.test.*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjd) {
		Object result = null;
		String methodName = pjd.getSignature().getName();
		
		try {
			System.out.println("*前置通知---method begin....."+methodName+",args:"+Arrays.asList(pjd.getArgs()));
			
			result = pjd.proceed();
			
			System.out.println("*返回通知---the method:"+methodName+" end with result:"+result);
		} catch (Throwable e) {
			
			System.out.println("*异常通知---the method:"+methodName+" occurs exception:"+ e);
//			throw new RuntimeException(e);
		}
		
		System.out.println("*后置通知---method:"+methodName+" ends.");
		
		return result;
	}
}
