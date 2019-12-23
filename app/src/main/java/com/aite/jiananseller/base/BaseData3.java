package com.aite.jiananseller.base;

import com.aite.jiananseller.utils.MainUtil;

/**
 * @author:TQX
 * @Date: 2019/11/21
 * @description:
 */
public class BaseData3 <T>{

    /**
     * code : 200
     * hasmore : true
     * page_total : 12
     * datas : {}
     */

    private int code;
    private boolean hasmore;
    private int page_total;
    private T datas;
    private String login;
    private String token_expired;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken_expired() {
        return token_expired;
    }

    public void setToken_expired(String token_expired) {
        this.token_expired = token_expired;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isHasmore() {
        return hasmore;
    }

    public void setHasmore(boolean hasmore) {
        this.hasmore = hasmore;
    }

    public int getPage_total() {
        return page_total;
    }

    public void setPage_total(int page_total) {
        this.page_total = page_total;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public static class DatasBean {
    }

    public boolean isSuccess() {
        return getCode() == MainUtil.SUCCESS_CODE;
    }
}
