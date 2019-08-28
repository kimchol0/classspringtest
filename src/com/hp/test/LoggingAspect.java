package com.hp.test;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class LoggingAspect {
	
	/*
	 * 定义一个方法，用于声明切入点表达式，一般该方法中再不需要添加其他代码
	 * 使用@Pointcut来声明切入点表达式
	 * 后面的其他通知直接使用方法名来引用当前的切入点表达式
	 * */
	public void declareJoinPointExpression() {}
	
	//前置通知
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		
		Object args[] = joinPoint.getArgs();
		
		System.out.println("前置通知---method begin....."+methodName+",args:"+Arrays.asList(args));
	}
	
	//后置通知，在方法执行之后执行的代码，无论该方法是否出现异常
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("后置通知---method:"+methodName+" ends.");
	}
	
	//返回通知，在方法正常结束后执行的代码，返回通知是可以访问到方法的返回值的
	public void afterReturning(JoinPoint joinPoint,Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("返回通知---the method:"+methodName+" end with result:"+result);
	}

	//异常通知，在目标方法出现异常时会执行的代码
	//可以访问到异常对象，且可以指定出现特定异常时在执行通知代码
	public void afterThrowing(JoinPoint joinPoint,Exception e) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("异常通知---the method:"+methodName+" occurs exception:"+ e);
		
	}
		
}
