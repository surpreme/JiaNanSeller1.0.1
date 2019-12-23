package com.aite.jiananseller.base;


import com.aite.jiananseller.utils.MainUtil;

/**
 * @author:TQX
 * @Date: 2019/4/15
 * @description:
 */
public class BaseData<T> {


    /**
     * code : 10003
     * datas :
     */

    private int code;
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

    public boolean isSuccess() {
        return getCode() == MainUtil.SUCCESS_CODE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }


}
