package org.spring.bean;

class Singleton { // 定义一个类
    private static final Singleton INSTANCE = new Singleton() ;
    private Singleton() {}   // 构造方法私有化
    public void print() {
    	System.out.println("Hello World .") ;
    }
    public static Singleton getInstance() {
    	return INSTANCE ;
    }
}
public class Singleton1 {
    public static void main(String args[]) {
        Singleton inst = null ;   // 声明对象
        inst = Singleton.getInstance() ; // 实例化对象
        inst.print() ;         // 调用方法
    }
}

