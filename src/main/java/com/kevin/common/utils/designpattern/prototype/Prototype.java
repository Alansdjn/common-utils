/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.kevin.common.utils.designpattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * 类Prototype.java的实现描述：原型设计模式
 * @author kevin.ww 2016年5月23日 下午11:02:01
 */
public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 8713116711453791905L;
    private String name;
    
    private SerializableObject so;
    
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public Object deepClone() throws IOException, ClassNotFoundException {
        
        /* 写入当前对象的二进制流 */  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        ObjectOutputStream oos = new ObjectOutputStream(bos);  
        oos.writeObject(this);  
  
        /* 读出二进制流产生的新对象 */  
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
        ObjectInputStream ois = new ObjectInputStream(bis);  
        return ois.readObject();  
    }

    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * @return the so
     */
    public SerializableObject getSo() {
        return so;
    }

    
    /**
     * @param so the so to set
     */
    public void setSo(SerializableObject so) {
        this.so = so;
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Prototype prototype = new Prototype();
        prototype.setName("wang wei");
        prototype.setSo(new SerializableObject());
        System.out.println(prototype);
        System.out.println(prototype.deepClone());
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
//    @Override
//    public String toString() {
//        return String.valueOf(this.hashCode());
//    }
}

class SerializableObject implements Serializable {

    private static final long serialVersionUID = 4661043701627268133L;
    
}


