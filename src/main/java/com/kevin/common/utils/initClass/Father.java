package com.kevin.common.utils.initclass;

public class Father {

    private static Member staticMember = new Member("父类静态成员变量初始化......");  
    
    private Member member = new Member("父类普通成员变量初始化......");  
  
    static {  
        System.out.println("父类静态代码块开始执行......");  
    }  
      
    Father() {  
        System.out.println("父类无参构造方法开始执行.......");  
    }  
      
    Father(String aa) {  
        System.out.println("父类有参构造方法开始执行......");  
    }  
}


