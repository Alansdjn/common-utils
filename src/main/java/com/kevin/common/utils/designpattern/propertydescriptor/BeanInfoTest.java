package com.kevin.common.utils.designpattern.propertydescriptor;

import java.util.Date;

/**
 * 类 BeanInfoTest.java 的实现描述：
 * @author kevin.ww 2015年8月23日 上午11:53:40
 */
public class BeanInfoTest {

	public static void main(String[] args) {
		String SPLIT = new Character((char) 6).toString();
		System.out.println("split:" + SPLIT);
		Date date = new Date();
		date.getTime();
		UserInfo userInfo=new UserInfo();
        userInfo.setUserName("peida");
        try {
            BeanInfoUtil.getProperty(userInfo, "userName");
            
            BeanInfoUtil.setProperty(userInfo, "userName");
            
            BeanInfoUtil.getProperty(userInfo, "userName");
            
            BeanInfoUtil.setPropertyByIntrospector(userInfo, "userName");            
            
            BeanInfoUtil.getPropertyByIntrospector(userInfo, "userName");
            
//            BeanInfoUtil.setProperty(userInfo, "age");
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
