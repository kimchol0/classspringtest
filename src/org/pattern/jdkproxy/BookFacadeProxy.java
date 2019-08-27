package org.pattern.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookFacadeProxy implements InvocationHandler {

	private Object target;
	
	//绑定委托对象返回一个代理类
		public Object bind(Object target) {
			this.target = target;
			
			return Proxy.newProxyInstance(target.getClass().getClassLoader(),
					target.getClass().getInterfaces(), this);
			
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Object result = null;
			System.out.println("****事务开始");
			
			result = method.invoke(target, args);
			
			System.out.println("*****事务完成");
			
			return result;
		}
}
