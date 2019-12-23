package com.aite.jiananseller.base;


import com.aite.jiananseller.utils.MainUtil;

/**
 * @author:TQX
 * @Date: 2019/4/15
 * @description:
 */
public class BaseData2<T> {

    /**
     * error_code : 10003
     * datas
     */

    private int error_code;
    private String message;
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
        return getError_code() == MainUtil.SUCCESS_CODE2;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }


}
