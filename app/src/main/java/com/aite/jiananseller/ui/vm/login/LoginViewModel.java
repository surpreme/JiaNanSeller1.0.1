package com.aite.jiananseller.ui.vm.login;

import android.app.Application;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;

import com.aite.baselibrary.constant.BaseConstant;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.bean.UserBean;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.aite.jiananseller.ui.activity.login.ChangePWActivity;
import com.aite.jiananseller.ui.activity.main.MainActivity;
import com.aite.jiananseller.utils.SharePreferencesHelper;
import com.lzy.okgo.model.HttpParams;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.bus.RxBus;
import me.goldze.mvvmhabit.bus.RxSubscriptions;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @author:TQX
 * @Date: 2019/10/23
 * @description:
 */
public class LoginViewModel extends BaseViewModel {
    //手机区号：如00086、00855、00066
    private String mAreacode = "00855";
    //订阅者
    private Disposable mSubscription;
    private SharePreferencesHelper sharePreferencesUtils = new SharePreferencesHelper(App.getContext(), "USER_INFO");

    public LoginViewModel(@NonNull Application application) {
        super(application);
//        userName1.set("aite666");
//        passWord1.set("123456");
        loginAway.set("邮箱/账号登录");


    }

    public ObservableInt type = new ObservableInt();
    public ObservableField<String> loginAway = new ObservableField<>("");
    public ObservableField<Boolean> isRememberPassword = new ObservableField<>(false);

    //手机号登录
    public ObservableField<String> userName = new ObservableField<>("");
    public ObservableField<String> passWord = new ObservableField<>("");

    //用户名的绑定 账号邮箱登录
    public ObservableField<String> userName1 = new ObservableField<>("");
    public ObservableField<String> passWord1 = new ObservableField<>("");

    //登录按钮的点击事件
    public BindingCommand loginOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (type.get() == 2) {
                if (TextUtils.isEmpty(userName1.get())) {
                    ToastUtils.showShort("请输入账号！");
                    return;
                }
                if (TextUtils.isEmpty(passWord1.get())) {
                    ToastUtils.showShort("请输入密码！");
                    return;
                }
            } else if (type.get() == 1) {
                if (TextUtils.isEmpty(userName.get())) {
                    ToastUtils.showShort("请输入账号！");
                    return;
                }
                if (TextUtils.isEmpty(passWord.get())) {
                    ToastUtils.showShort("请输入密码！");
                    return;
                }
            }
            initRememberPassword();
            Login();
        }
    });

    private void initRememberPassword() {
        if (isRememberPassword.get()) {
            if (type.get() == 1) {
                sharePreferencesUtils.put("USERNAME_PHONE", userName.get());
                sharePreferencesUtils.put("USER_PASSWORD_PHONE", passWord.get());
            } else if (type.get() == 2) {
                sharePreferencesUtils.put("USERNAME_ACOUNT", userName1.get());
                sharePreferencesUtils.put("USER_PASSWORD_ACOUNT", passWord1.get());
            }


        }
    }

    //修改密码按钮的点击事件
    public View.OnClickListener changePWOnClick = v -> startActivity(ChangePWActivity.class);

    /**
     * //1 手机号登录 2账号邮箱登录
     * 参数名字	提交方式	类型	是否必须	默认值	其他	说明	test
     * username	post	字符串	必须			用户名/手机号/邮箱
     * password	post	字符串	必须			登录密码
     * client	post	字符串	必须			来源端口 wap ios android
     * device_id	post	字符串	必须			设备id
     * loginType	post	字符串	必须			登陆方式:isMobile、isEmail、isAccount
     * code	post	字符串	可选			手机区号：如00086、00855、00066
     * login_role	post	整型	必须			登录角色 1会员登录 2商户登录 3仓库员登录 4配送
     */
    public void Login() {
        //登录
        OkGoUtil.postRequest(ApiAddress.URL_POST_LOGIN, initHttpParams(), new BaseObserver<UserBean>() {
            @Override
            protected void onSuccees(UserBean o) throws Exception {
                App.setUserBean(o);
                App.setToken(o.getKey());
                startActivity(MainActivity.class);
            }

            @Override
            protected void onIsError(String msg) throws Exception {
                ToastUtils.showShort(msg);
                initDeleteSharePreference();
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        });
    }

    private void initDeleteSharePreference() {
        if (type.get() == 1) {
            if (sharePreferencesUtils.contain("USERNAME_PHONE") && sharePreferencesUtils.contain("USER_PASSWORD_PHONE")) {
                if (sharePreferencesUtils.getSharePreference("USERNAME_PHONE", "aite").equals(userName.get())) {
                    sharePreferencesUtils.remove("USERNAME_PHONE");
                    sharePreferencesUtils.remove("USER_PASSWORD_PHONE");
                }
            }
        } else if (type.get() == 2) {
            if (sharePreferencesUtils.contain("USERNAME_ACOUNT") && sharePreferencesUtils.contain("USER_PASSWORD_ACOUNT")) {
                if (sharePreferencesUtils.getSharePreference("USERNAME_ACOUNT", "aite").equals(userName.get())) {
                    sharePreferencesUtils.remove("USERNAME_ACOUNT");
                    sharePreferencesUtils.remove("USER_PASSWORD_ACOUNT");
                }
            }
        }

    }

    private HttpParams initHttpParams() {
        HttpParams params = new HttpParams();
        if (type.get() == 1) {
            params.put("code", mAreacode);
            params.put("username", userName.get());
            params.put("password", passWord.get());
            params.put("loginType", "isMobile");
            BaseConstant.AREACODE = mAreacode;
            BaseConstant.USERNAME = userName.get();
            BaseConstant.USERPASSWORD = passWord.get();
        } else if (type.get() == 2) {
            params.put("username", userName1.get());
            params.put("password", passWord1.get());
            params.put("loginType", "isAccount");
            BaseConstant.USERNAME = userName1.get();
            BaseConstant.USERPASSWORD = passWord1.get();
        }
        String diviceID = Settings.System.getString(App.getContext().getContentResolver(), Settings.System.ANDROID_ID);
        BaseConstant.LOGINAWAY = type.get() == 1 ? "isMobile" : "isAccount";
        BaseConstant.DEVICEID = !TextUtils.isEmpty(diviceID) ? diviceID : "123456";
        params.put("device_id", !TextUtils.isEmpty(diviceID) ? diviceID : "123456");
        params.put("login_role", BaseConstant.USERTYPE);
        params.put("client", BaseConstant.CLIENT);
        return params;
    }

    //注册RxBus
    @Override
    public void registerRxBus() {
        super.registerRxBus();
        mSubscription = RxBus.getDefault().toObservable(String.class)
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        mAreacode = s;

                    }
                });
        //将订阅者加入管理站
        RxSubscriptions.add(mSubscription);
    }

    //移除RxBus
    @Override
    public void removeRxBus() {
        super.removeRxBus();
        //将订阅者从管理站中移除
        RxSubscriptions.remove(mSubscription);
    }

    //获取地区编号
    public void getAreaCode(BaseObserver baseObserver) {
        OkGoUtil.getRequest(ApiAddress.URL_POST_GET_AREA_CODE, new HttpParams(), baseObserver);
    }

}
