package com.yy.bookkeeping.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {
    private static SimpleDateFormat[] dateFormat;
    static {
        dateFormat = new SimpleDateFormat[]{
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
                new SimpleDateFormat("yyyy-MM-dd")
        };
    }
    public static String dateToString(Date date){
        for (int i = 0; i < dateFormat.length; i++) {
            try {
                return dateFormat[i].format(date);
            } catch (Exception e) {
                continue;
            }
        }
        return null;
    }
    public static Date stringToDate(String dateStr){
        for (int i = 0; i < dateFormat.length; i++) {
            try {
                return dateFormat[i].parse(dateStr);
            } catch (ParseException e) {
                continue;
            }
        }
        return null;
    }

}
