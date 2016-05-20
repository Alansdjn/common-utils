package com.kevin.common.utils.time;

import java.util.Calendar;

public class GetToday {

    public static void main(String[] args) {
        Calendar time = Calendar.getInstance();
        time.set(Calendar.HOUR_OF_DAY, 0);
        time.set(Calendar.MINUTE, 0);
        time.set(Calendar.SECOND, 0);
        System.out.println(time.getTime());
    }
}


