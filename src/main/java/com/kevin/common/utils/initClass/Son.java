package com.kevin.common.utils.initClass;

/**
 *   1 �̳���ϵ�����о�̬��Ա��ʼ�����ȸ��࣬�����ࣩ 
 *   2 �����ʼ����ɣ���ͨ��Ա�ĳ�ʼ��-->���캯���ĵ��ã� 
 *   3 �����ʼ������ͨ��Ա-->���캯���� 
 *   
 * ��Son.java��ʵ��������TODO ��ʵ������ 
 * @author kevin.ww 2016��5��9�� ����7:56:36
 */
public class Son extends Father {

    private static Member staticMember = new Member("���ྲ̬��Ա������ʼ��");  
    
    private Member member = new Member("������ͨ��Ա������ʼ��......");  
  
    static {  
        System.out.println("���ྲ̬�����һ....��ʼִ��......");  
    }  
      
    Son(String aa) {  
        System.out.println("���๹�췽����ʼִ��......");  
    }  
      
    static {  
        System.out.println("���ྲ̬������....��ʼִ��......");  
    }  
      
      
    public static void main(String[] args) {  
        new Son("aa");  
    }  
}


