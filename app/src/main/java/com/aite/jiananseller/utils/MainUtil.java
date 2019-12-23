package com.aite.jiananseller.utils;

import android.util.Log;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class MainUtil {
    public static String logger = "logger";
    private static boolean isPrintLog = true; //是否打开日志打印

    //日志打印
    public static void printLogger(String logTxt) {
        if (isPrintLog) {
            Log.e(logger, logTxt);
        }
    }


    public static final int SUCCESS_CODE = 200;//成功的code
    public static final int SUCCESS_CODE2 = 0;//解析第二种数据结构成功的code

    public static final String loadTxt = "正在加载";
    public static final String loadLogin = "正在登录";
    public static final String loadGetCode = "正在获取";
    public static final String loadSignIn = "正在签到";
    public static final String loadUpdate = "正在上传";

    /*******支付方面字段******/
    // appId
    public static final String WeChatPayId = "wx039947bee3c6c735";
    //商户号
    public static final String partnerid = "1514710031";
    //微信签名
    public static final String WXsign = "e531de6c5647d59cfffce765f4a8bcf1";
// 6d930604270a370a80e4da599f3fe542

}
