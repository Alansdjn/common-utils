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
 * ��LongToDate.java��ʵ��������TODO ��ʵ������ 
 * @author kevin.ww 2016��3��7�� ����9:20:00
 */
public class LongToDate {

    public static void main(String[] args) {
        Date date = new Date(1460711013439L);
        System.out.println("GMT_CREATE: " + date);
        date = new Date(1466255086315L);
        System.out.println("GMT_MODIFIED: " + date);
        date = new Date(1460711013432L);
        System.out.println("CONSIGN_CREATE_TIME: " + date);
    }
}


