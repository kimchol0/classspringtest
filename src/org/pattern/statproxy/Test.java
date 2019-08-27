package org.pattern.statproxy;

public class Test {
	
	public static void main(String[]args) {
		
		Count count = new CountImpl();//真实对象
		Count countProxy = new CountProxy(count);//代理对象
		countProxy.queryCount();//代理对象做操作
		countProxy.updateCount();
		
	}

}
