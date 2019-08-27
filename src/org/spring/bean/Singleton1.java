package org.spring.bean;

class Singleton { // 定义一个类
    private static Singleton instance ;
    private Singleton() {}   // 构造方法私有化
    public void print() {
              System.out.println("Hello World .") ;
    }
    public static Singleton getInstance() {
              if (instance == null) {   // 没有实例化
                       instance = new Singleton() ;  // 实例化
              }
              return instance ;
    }
}

public class Singleton1 {
    public static void main(String args[]) {
        Singleton inst = null ;   // 声明对象
        inst = Singleton.getInstance() ; // 实例化对象
        inst.print() ;         // 调用方法
    }
}

