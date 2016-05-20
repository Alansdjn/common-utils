/*
 * Copyright 2016 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.kevin.common.utils.time;

import java.util.Date;

/**
 * 类LongToDate.java的实现描述：TODO 类实现描述 
 * @author kevin.ww 2016年3月7日 下午9:20:00
 */
public class LongToDate {

    public static void main(String[] args) {
        Date date = new Date(1461403687200L);
        System.out.println("GMT_CREATE: " + date);
//        date = new Date(1458523356869L);
//        System.out.println("GMT_MODIFIED: " + date);
//        date = new Date(1458096164925L);
//        System.out.println("CONSIGN_CREATE_TIME: " + date);
    }
}


