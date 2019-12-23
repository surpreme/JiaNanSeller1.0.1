package com.aite.jiananseller.bean;

import com.aite.baselibrary.bean.ErrorBean;

import java.io.Serializable;

/**
 * @author:lzy
 * @Date: 2019/12/20
 * @description:
 */
public class LogOutBean extends ErrorBean implements Serializable {


    /**
     * code : 200
     * datas : 1
     */

    private int code;
    private String datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDatas() {
        return datas;
    }

    public void setDatas(String datas) {
        this.datas = datas;
    }
}
