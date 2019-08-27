package org.pattern.statproxy;

public class CountProxy implements Count {

	private Count target;//代理的对象
	
	public CountProxy(Count countImpl) {
		
		this.target = countImpl;
		
	}
	
	@Override
	public void queryCount() {
		
		System.out.println("开始查询之前。。。");
		target.queryCount();
		System.out.println("查询之后。。。");
		
	}

	@Override
	public void updateCount() {
		
		System.out.println("开始操作之前。。。");
		target.updateCount();
		System.out.println("操作之后。。。");
		
	}

}
