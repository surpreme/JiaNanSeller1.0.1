package com.aite.jiananseller.ui.vm.main;

import android.app.Application;
import android.os.Bundle;
import android.view.View;

import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.bean.AllUnReadMsgLessBean;
import com.aite.jiananseller.bean.SellerBean;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.aite.jiananseller.ui.activity.main.EditGoodsActivity;
import com.aite.jiananseller.ui.activity.main.GoodsManagerActivity;
import com.aite.jiananseller.ui.activity.main.MsgCenterActivity;
import com.aite.jiananseller.ui.activity.main.OrderManagerActivity;
import com.aite.jiananseller.ui.activity.main.SettingActivity;
import com.aite.jiananseller.ui.activity.main.StatisticActivity;
import com.aite.jiananseller.ui.vm.login.LoginViewModel;
import com.aite.jiananseller.utils.ClutterUtils;
import com.aite.jiananseller.utils.LogUtils;
import com.lzy.okgo.model.HttpParams;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.bus.Messenger;
import me.goldze.mvvmhabit.utils.StringUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @author:TQX
 * @Date: 2019/10/23
 * @description:
 */
public class MainViewModel extends BaseViewModel {
    public static final String TOKEN_BOOKFIXERNOTIFY_REFRESH = "TOKEN_BOOKFIXERNOTIFY_REFRESH";
    public static final String TOKEN_CHATNOTIFY_REFRESH = "TOKEN_CHATNOTIFY_REFRESH";

    public MainViewModel(@NonNull Application application) {
        super(application);
        getSellerBean();
        getUnReadMsgBean();
    }

    public ObservableField<String> msgNumber = new ObservableField<>("");
    public ObservableField<String> userName = new ObservableField<>("");
    public ObservableField<String> storeAddress = new ObservableField<>("");
    public ObservableField<String> onSell = new ObservableField<>("");
    public ObservableField<String> soldOut = new ObservableField<>("");
    public ObservableField<String> daily_sales = new ObservableField<>("");
    public ObservableField<String> monthly_sales = new ObservableField<>("");
    public ObservableField<String> todayMoney = new ObservableField<>("");
    public ObservableField<String> YestodayMoney = new ObservableField<>("");
    public ObservableField<String> sellerUrl = new ObservableField<>("");

    public View.OnClickListener goodsOnclick = (v) -> {
        startActivity(GoodsManagerActivity.class);
    };
    public View.OnClickListener orderOnclick = (v) -> {
        startActivity(OrderManagerActivity.class);
    };
    public View.OnClickListener statisticOnclick = (v) -> {
        startActivity(StatisticActivity.class);
    };
    public View.OnClickListener msgOnclick = (v) -> {
        startActivity(MsgCenterActivity.class);
    };
    public View.OnClickListener settingOnclick = (v) -> {
        startActivity(SettingActivity.class);
    };
    public View.OnClickListener goodsEditOnclick = (v) -> {
        Bundle bundle = new Bundle();
        bundle.putInt("type", 0);
        startActivity(EditGoodsActivity.class, bundle);
    };

    private void getSellerBean() {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        OkGoUtil.postRequest(ApiAddress.URL_GET_SELLER_INFO, params, new BaseObserver<SellerBean>() {
            @Override
            protected void onSuccees(SellerBean o) throws Exception {
                userName.set(o.getStore_info().getStore_name());
                storeAddress.set(": " + o.getStore_info().getArea_info());
                onSell.set(o.getOnsell());
                soldOut.set(o.getSold_out());
                daily_sales.set(o.getDaily_sales());
                monthly_sales.set(o.getMonthly_sales());
                todayMoney.set(o.getCurrency().getSymbol() + o.getTotal_money());
                YestodayMoney.set(o.getCurrency().getSymbol() + o.getYesterday_total());
                sellerUrl.set(o.getStore_info().getStore_avatar());
                if (o.getNo_delivery() != null && !o.getNo_delivery().equals("0")) {
                    Messenger.getDefault().send(o.getNo_delivery(), MainViewModel.TOKEN_BOOKFIXERNOTIFY_REFRESH);
                }
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

    private void getUnReadMsgBean() {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("login_role", App.getLogInRole());
        OkGoUtil.postRequest(ApiAddress.URL_POST_UNREADMSGNUMBER_INFO, params, new BaseObserver<AllUnReadMsgLessBean>() {
            @Override
            protected void onSuccees(AllUnReadMsgLessBean allUnReadMsgLessBean) throws Exception {
                if (allUnReadMsgLessBean.getTotal_num() != null && !allUnReadMsgLessBean.getTotal_num().equals("0")) {
                    try {
                        if (ClutterUtils.isInteger(allUnReadMsgLessBean.getTotal_num())) {
                            if (Integer.valueOf(allUnReadMsgLessBean.getTotal_num()) > 99)
                                msgNumber.set("99+");
                            else if (Integer.valueOf(allUnReadMsgLessBean.getTotal_num()) == 0)
                                Messenger.getDefault().send(allUnReadMsgLessBean.getTotal_num(), MainViewModel.TOKEN_CHATNOTIFY_REFRESH);
                            else
                                msgNumber.set(allUnReadMsgLessBean.getTotal_num());
                        }
                    } catch (Exception e) {
                        LogUtils.e(e);
                    }
                }
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
