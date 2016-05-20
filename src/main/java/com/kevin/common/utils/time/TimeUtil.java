package com.kevin.common.utils.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    public static void main(String[] args) {
        Date date = getEndTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日24点");
        String dateStr = format.format(date);
        System.out.println(dateStr);
        
    }
    
    public static Date getEndTime() {
        Calendar time = Calendar.getInstance();
        time.set(Calendar.DAY_OF_MONTH, time.get(Calendar.DAY_OF_MONTH) + 15);
        time.set(Calendar.HOUR_OF_DAY, 23);
        time.set(Calendar.MINUTE, 59);
        time.set(Calendar.SECOND, 59);
        return time.getTime();
    }
}
