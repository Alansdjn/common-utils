package com.kevin.common.utils.exception;
/**
 * VM Args: -Xss128k
 * ��JavaVMStackSOF.java��ʵ��������ģ�������ջ�ͱ��ط���ջ���
 * @author kevin.ww 2016��6��5�� ����1:44:46
 */
public class JavaVMStackSOF {

    private int stackLength = 1;
    
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
	        oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }
}


