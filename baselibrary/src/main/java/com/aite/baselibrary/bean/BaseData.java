package com.aite.baselibrary.bean;

import java.io.Serializable;


/**
 * @author:lzy
 * @Date: 2019/4/15
 * @description:
 */
public class BaseData<T extends ErrorBean> implements Serializable {
    /**
     * login : 0 需要重新登录
     * token_expired : true  expired是否已过期
     * code : 0
     * datas : {"error":"token已失效，您已在其他客户端登录"}
     */

    private String login;
    private boolean token_expired;
    private int code;


    private T datas;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isToken_expired() {
        return token_expired;
    }

    public void setToken_expired(boolean token_expired) {
        this.token_expired = token_expired;
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
