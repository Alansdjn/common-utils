package com.kevin.common.utils.clazz;

import java.util.ArrayList;
import java.util.List;

class OutterTest {
    private int age = 12;
    class Inner {
        private int age = 13;
        public void print() {
            int age = 14;
            System.out.println("�ֲ�������" + age);
            System.out.println("�ڲ��������" + this.age);
            System.out.println("�ⲿ�������" + OutterTest.this.age);
        }
    }
}
public class Outter {
    public static void main(String[] args) {
        OutterTest out = new OutterTest();
        OutterTest.Inner in = out.new Inner();
        in.print();
        
        String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(1393308906000L));
        System.out.println(date);
        ThreadLocal<String> threadLocal = new ThreadLocal<String>() {

            /* (non-Javadoc)
             * @see java.lang.ThreadLocal#initialValue()
             */
            @Override
            protected String initialValue() {
                // TODO Auto-generated method stub
                return super.initialValue();
            }
            
        };
    }
}
