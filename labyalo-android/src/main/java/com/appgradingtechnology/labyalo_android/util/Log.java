package com.appgradingtechnology.labyalo_android.util;

/**
 * Created by Labyalo 3 on 10/6/2017.
 */

public class Log {

    public static void log(String tag, Object message){
        int maxLogSize = 2000;

        String msg = String.valueOf(message);

        if(msg.length() > maxLogSize){
            for(int i = 0; i <= msg.length() / maxLogSize; i++) {
                int start = i * maxLogSize;
                int end = (i+1) * maxLogSize;
                end = end > msg.length() ? msg.length() : end;
                d(tag, msg.substring(start, end));
            }
        }else{
            d(tag, "<<<log>>>" + msg);
        }
    }

    public static void v(String tag, Object message){
//        if(!App.production){
            android.util.Log.v(tag, "<<<log>>>" + String.valueOf(message));
//        }
    }

    public static void d(String tag, Object message){
//        if(!App.production){
            android.util.Log.d(tag, "<<<log>>>" + String.valueOf(message));
//        }
    }

    public static void i(String tag, Object message){
//        if(!App.production){
            android.util.Log.i(tag, "<<<log>>>" + String.valueOf(message));
//        }
    }

    public static void w(String tag, Object message){
//        if(!App.production){
            android.util.Log.w(tag, "<<<log>>>" +  String.valueOf(message));
//        }
    }

    public static void e(String tag, Object message){
//        if(!App.production){
            android.util.Log.e(tag, "<<<log>>>" +  String.valueOf(message));
//        }
    }
}
