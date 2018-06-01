package com.appgradingtechnology.labyalo_android.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by BCTI 3 on 1/31/2018.
 */

public class DateFormatter {

    public static final String DEFAULT_FORMAT  = "yyyy-MM-dd HH:mm:ss";

    public static String format(Date date){
        return format(date, DEFAULT_FORMAT);
    }

    public static String format(Date date, String format){
        if(date == null){
            return "";
        }
        return getSimpleDateFormat(format).format(date.getTime());
    }

    public static String format(String timestamp, String format){
        return format(timestamp, DEFAULT_FORMAT, format);
    }

    public static String format(String timestamp, String timestampFormat, String format){

        if(StringFormatter.isEmpty(timestamp)){
            return "";
        }

        SimpleDateFormat dayFormat = getSimpleDateFormat(timestampFormat);
        try {
            Date date = dayFormat.parse(timestamp);
            return getSimpleDateFormat(format).format(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static String formatTimePassed(String timestamp){
        return formatTimePassed(timestamp, new Date());
    }

    public static String formatTimePassed(String timestamp, Date currentDate){
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(getSimpleDateFormat(DEFAULT_FORMAT).parse(timestamp));

            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.setTime(currentDate);

            long time = calendar.getTime().getTime()  / 1000;
            long currentTime = currentDate.getTime() / 1000;

            long secondsAgo = currentTime - time;
            double period;

            if (secondsAgo < 60){
                if(secondsAgo < 30){
                    return "Just Now.";
                }else{
                    return secondsAgo == 1 ? "1 sec ago"     : secondsAgo + " secs ago";
                }
            } else if(secondsAgo < 3600){
                period = Math.floor(secondsAgo / 60);
                return  (int) period == 1 ? "1 min ago" : (int) period + " mins ago";
            }else if(secondsAgo < 86400){
                period = Math.floor(secondsAgo / 3600);
                return  (int) period == 1 ? "1 hr ago" : (int) period + " hrs ago";
            }else if(secondsAgo < 432000){
                period = Math.floor(secondsAgo / 86400);
                return  (int) period == 1 ? "1 day ago" : (int) period + " days ago";
            }else{
                if(calendar.get(Calendar.YEAR) == currentCalendar.get(Calendar.YEAR)){
                    return getSimpleDateFormat("MMMM dd").format(calendar.getTime());
                }else{
                    return getSimpleDateFormat("MMMM dd yyyy").format(calendar.getTime());
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return "--";
        }
    }

    public static Date parseDate(String date){
        return parseDate(date, DEFAULT_FORMAT);
    }

    public static Date parseDate(String date, String format){
        if(StringFormatter.isEmpty(date)){
            return new Date();
        }
        try {
            return getSimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static SimpleDateFormat getSimpleDateFormat(String format){
        return new SimpleDateFormat(format, Locale.getDefault());
    }
}
