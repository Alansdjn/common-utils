package com.kevin.common.utils.exception;
/**
 * VM Args: -Xss128k
 * 类JavaVMStackSOF.java的实现描述：模拟虚拟机栈和本地方法栈溢出
 * @author kevin.ww 2016年6月5日 上午1:44:46
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


