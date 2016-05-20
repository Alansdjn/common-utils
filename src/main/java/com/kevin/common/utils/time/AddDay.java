package com.kevin.common.utils.time;

import java.util.Calendar;

public class AddDay {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 10);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        System.out.println(c.getTime());
    }
}


