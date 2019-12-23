package com.aite.jiananseller.ui.vm.login;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;

import com.aite.jiananseller.R;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.aite.jiananseller.ui.activity.main.MainActivity;
import com.alibaba.fastjson.JSON;
import com.lzy.okgo.model.HttpParams;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @author:TQX
 * @Date: 2019/10/23
 * @description:
 */
public class ChangePWViewModel extends BaseViewModel {
    public ChangePWViewModel(@NonNull Application application) {
        super(application);
        cl2Visible.set(View.INVISIBLE);
        bt2Visible.set(View.GONE);
        isTitleClick.set(false);
    }

    public ObservableField<String> userName = new ObservableField<>();
    public ObservableField<String> code = new ObservableField<>();
    public ObservableField<String> newPassWord = new ObservableField<>();
    public ObservableField<String> confimPassWord = new ObservableField<>();
    //    public SingleLiveEvent<Boolean> isTitleClick = new SingleLiveEvent<>();
    public ObservableField<Boolean> isTitleClick = new ObservableField<>();
    public ObservableInt cl1Visible = new ObservableInt();
    public ObservableInt cl2Visible = new ObservableInt();
    public ObservableInt bt1Visible = new ObservableInt();
    public ObservableInt bt2Visible = new ObservableInt();
    public ObservableInt checkBt = new ObservableInt();


    public BindingCommand nextOnClick = new BindingCommand<>(new BindingAction() {
        @Override
        public void call() {
            cl1Visible.set(View.INVISIBLE);
            cl2Visible.set(View.VISIBLE);
            bt1Visible.set(View.INVISIBLE);
            bt2Visible.set(View.VISIBLE);
            isTitleClick.set(true);
            checkBt.set(R.id.rb_step_2);
        }
    });

    public BindingCommand changePWOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            changePW();
        }
    });

    /**
     * 获取验证码
     *
     * @param baseObserver
     */
    public void getAuthCode(BaseObserver baseObserver) {
        if (TextUtils.isEmpty(userName.get())) {
            ToastUtils.showShort("请输入账号！");
            return;
        }
        HttpParams params = new HttpParams();
        params.put("mobile_phone", userName.get());
        OkGoUtil.postRequest(ApiAddress.URL_GET_AUTH_CODE, params, baseObserver);
    }

    public void changePW() {
        if (TextUtils.isEmpty(userName.get())) {
            ToastUtils.showShort("请输入账号！");
            return;
        }
        if (TextUtils.isEmpty(code.get())) {
            ToastUtils.showShort("请输入验证码！");
            return;
        }
        if (TextUtils.isEmpty(newPassWord.get())) {
            ToastUtils.showShort("请输入密码！");
            return;
        }
        if (!confimPassWord.get().equals(newPassWord.get())) {
            ToastUtils.showShort("两次密码输入不一致！");
            return;
        }
        HttpParams params = new HttpParams();
        params.put("mobile_phone", userName.get());
        params.put("secret", code.get());
        params.put("password ", newPassWord.get());
        params.put("password_confirm", confimPassWord.get());
        OkGoUtil.postRequest(ApiAddress.URL_POST_UPDATE_PW, params, new BaseObserver<Object>() {
            @Override
            protected void onSuccees(Object o) throws Exception {
                finish();
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
