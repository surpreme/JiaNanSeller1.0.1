package com.aite.jiananseller.ui.vm.main;

import android.app.Activity;
import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.aite.baselibrary.bean.BaseData;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.bean.LogOutBean;
import com.aite.jiananseller.bean.UserBean;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.aite.jiananseller.ui.activity.login.LoginActivity;
import com.aite.jiananseller.ui.activity.main.MainActivity;
import com.aite.jiananseller.utils.BeanConvertor;
import com.aite.jiananseller.utils.LogUtils;
import com.aite.jiananseller.utils.SystemFileUtil;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.tencent.qcloud.tim.uikit.utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description:
 */
public class SettingViewModel extends BaseViewModel {

    public SettingViewModel(@NonNull Application application) {
        super(application);
        try {
            cacheSize.set(SystemFileUtil.getTotalCacheSize(App.getContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableField<String> cacheSize = new ObservableField<>("");
    public View.OnClickListener logoutOnclick = (v) -> {
        postLogOut();
    };
    public View.OnClickListener onBackOnClick = (v) -> {
        onBackPressed();
    };

    private void postLogOut() {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("client", "android");
        params.put("username", App.getUserBean().getUsername());
        //退出登录
        OkGoUtil.postRequest(ApiAddress.URL_LOGINOUT, params, new BaseObserver<String>() {
            @Override
            protected void onSuccees(String o) throws Exception {
                LogUtils.e(o);
                startActivity(LoginActivity.class);
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
