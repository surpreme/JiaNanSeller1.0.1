package com.aite.jiananseller.base;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import com.aite.baselibrary.constant.BaseConstant;
import com.aite.baselibrary.view.util.PopupWindows.PopupWindowsUtils;
import com.aite.baselibrary.window.ActivityManager;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.bean.UserBean;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.aite.jiananseller.ui.activity.login.LoginActivity;
import com.aite.jiananseller.ui.activity.main.MainActivity;
import com.aite.jiananseller.utils.BeanConvertor;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.lzy.okgo.model.HttpParams;
import com.tencent.qcloud.tim.uikit.utils.PopWindowUtil;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import java.lang.reflect.ParameterizedType;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @author:TQX
 * @Date: 2019/4/15
 * @description:
 */
public abstract class BaseObserver<T> implements Observer<BaseData<T>> {

    protected Context context;
    private String labelTxt;

    public BaseObserver(Context mContext, String labelTxt) {
        this.context = mContext;
        this.labelTxt = labelTxt;
    }

    public BaseObserver() {
    }

    public BaseObserver(Context mContext) {
        this.context = mContext;
    }

    //开始
    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }

    //获取数据
    @Override
    public void onNext(BaseData<T> value) {

        try {
            if (value.isSuccess()) {
                Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
                T ordersListBean = BeanConvertor.convertBean(value.getDatas(), tClass);
                onSuccees(ordersListBean);
            } else {
                String errorMsg = JSON.parseObject(value.getDatas().toString()).getString("error");
                onIsError(errorMsg);
                ToastUtils.showShort(errorMsg);
                if (value.getLogin() != null && value.getLogin().equals("0") || value.getToken_expired() != null && value.getToken_expired().equals("true")) {
                    PopupWindowsUtils.getmInstance().showDialogPopupWindow(
                            ActivityManager.getInstance().getCurrentActivity(), "下线通知",
                            "您的账号在另一台手机登录了该账号，如非本人操作，则密码可能已经泄露，建议修改密码",
                            "重新登录",
                            "退出",
                            v ->
                                    againLogIn()
                            , v ->
                                    App.getContext().startActivity(new Intent(App.getContext(), LoginActivity.class))
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //失败
    @Override
    public void onError(Throwable e) {
        Log.e("m_tag", "onError: " + e.toString());
        onRequestEnd();
        try {
            if (e instanceof ConnectException
                    || e instanceof TimeoutException
                    || e instanceof NetworkErrorException
                    || e instanceof UnknownHostException) {
                onFailure(e, true);  //网络错误
            } else {
                onFailure(e, false);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void onComplete() {
        onRequestEnd();
    }

    /**
     * 返回成功
     *
     * @param t
     * @throws Exception
     */
    protected abstract void onSuccees(T t) throws Exception;

    protected abstract void onIsError(String msg) throws Exception;


    /**
     * 返回失败
     *
     * @param e
     * @param isNetWorkError 是否是网络错误
     * @throws Exception
     */
    protected abstract void onFailure(Throwable e, boolean isNetWorkError) throws Exception;

    protected void onRequestStart() {
    }

    protected void onRequestEnd() {
    }

    /**
     * 重新登录
     */
    private void againLogIn() {
        HttpParams httpParams = new HttpParams();
        if (BaseConstant.LOGINAWAY == null) return;
        if (BaseConstant.USERNAME == null) return;
        if (BaseConstant.USERPASSWORD == null) return;
        if (BaseConstant.DEVICEID == null) return;

        if (BaseConstant.LOGINAWAY.equals("isMobile")) {
            if (BaseConstant.AREACODE != null) httpParams.put("code", BaseConstant.AREACODE);
        }
        httpParams.put("loginType", BaseConstant.LOGINAWAY);
        httpParams.put("username", BaseConstant.USERNAME);
        httpParams.put("password", BaseConstant.USERPASSWORD);
        httpParams.put("device_id", BaseConstant.DEVICEID);
        httpParams.put("login_role", BaseConstant.USERTYPE);
        httpParams.put("client", BaseConstant.CLIENT);

        //登录
        OkGoUtil.postRequest(ApiAddress.URL_POST_LOGIN, httpParams, new BaseObserver<UserBean>() {
            @Override
            protected void onSuccees(UserBean o) throws Exception {
                App.setUserBean(o);
                App.setToken(o.getKey());
            }

            @Override
            protected void onIsError(String msg) throws Exception {
                ToastUtils.showShort(msg);
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        });
    }
}
