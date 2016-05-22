package com.kevin.common.utils.initClass;

/**
 *   1 继承体系的所有静态成员初始化（先父类，后子类） 
 *   2 父类初始化完成（普通成员的初始化-->构造函数的调用） 
 *   3 子类初始化（普通成员-->构造函数） 
 *   
 * 类Son.java的实现描述：TODO 类实现描述 
 * @author kevin.ww 2016年5月9日 下午7:56:36
 */
public class Son extends Father {

    private static Member staticMember = new Member("子类静态成员变量初始化");  
    
    private Member member = new Member("子类普通成员变量初始化......");  
  
    static {  
        System.out.println("子类静态代码块一....开始执行......");  
    }  
      
    Son(String aa) {  
        System.out.println("子类构造方法开始执行......");  
    }  
      
    static {  
        System.out.println("子类静态代码块二....开始执行......");  
    }  
      
      
    public static void main(String[] args) {  
        new Son("aa");  
    }  
}


