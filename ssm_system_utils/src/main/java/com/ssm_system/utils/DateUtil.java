package com.ssm_system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date String2Date(String date, String strr) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(strr);
        Date d = df.parse(date);
        return d;
    }

    public static String Date2String(Date date,String strr){
        SimpleDateFormat df = new SimpleDateFormat(strr);
        String d = df.format(date);
        return d;
    }
}
