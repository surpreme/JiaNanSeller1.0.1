package com.aite.jiananseller.utils;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author:TQX
 * @Date:2019/3/2 17:50
 * @description:
 */
public class ResponseCodeUtil {

    public static boolean getSuccessStatus(Object value) {
        JSONObject respons = JSON.parseObject(JSONObject.toJSONString(value));
        boolean status = (boolean) respons.get("success");
        Log.e("codeUtils", "getSuccessStatus: " + status);
        return status;
    }

    /**
     * 获取code状态
     */
    public static int getCode(Object value) {
        JSONObject respons = JSON.parseObject(JSONObject.toJSONString(value));
        int code = (int) respons.get("code");
        Log.e("codeUtils", "getCode: " + code);
        return code;
    }

    /**
     * 获取数据data
     *
     * @param value
     * @return
     */
    public static JSONObject getData(Object value) {
        JSONObject respons = JSON.parseObject(JSONObject.toJSONString(value));
        JSONObject data = respons.getJSONObject("datas");
        Log.e("codeUtils", "getData: " + JSONObject.toJSONString(data));
        return data;
    }


}
