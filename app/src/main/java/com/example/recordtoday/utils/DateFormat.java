package com.example.recordtoday.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormat {
    public final static String HEADER = "yyyy년 MM월";

    public static String getDate(long date, String pattern) {
        try {
            Date d = new Date(date);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.KOREA);
            return simpleDateFormat.format(d).toUpperCase();
        } catch (Exception e) {
            return " ";
        }
    }
}
