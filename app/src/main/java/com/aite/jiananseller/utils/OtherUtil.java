package com.aite.jiananseller.utils;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:TQX
 * @Date: 2019/4/19
 * @description:
 */
public class OtherUtil {
    public static String getTime(Date date, String type) {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = null;
        if (type.equals("分")) {
            format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        } else {
            format = new SimpleDateFormat("yyyy-MM-dd ");
        }

        return format.format(date);
    }
}
