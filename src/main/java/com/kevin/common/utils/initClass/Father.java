package com.kevin.common.utils.initclass;

public class Father {

    private static Member staticMember = new Member("���ྲ̬��Ա������ʼ��......");  
    
    private Member member = new Member("������ͨ��Ա������ʼ��......");  
  
    static {  
        System.out.println("���ྲ̬����鿪ʼִ��......");  
    }  
      
    Father() {  
        System.out.println("�����޲ι��췽����ʼִ��.......");  
    }  
      
    Father(String aa) {  
        System.out.println("�����вι��췽����ʼִ��......");  
    }  
}


