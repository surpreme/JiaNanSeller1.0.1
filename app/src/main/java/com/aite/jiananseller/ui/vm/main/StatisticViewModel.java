package com.aite.jiananseller.ui.vm.main;

import android.app.Application;
import android.view.View;

import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver2;
import com.aite.jiananseller.bean.BusinessBean;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.lzy.okgo.model.HttpParams;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description:
 */
public class StatisticViewModel extends BaseViewModel {
    public StatisticViewModel(@NonNull Application application) {
        super(application);
        getStoreInfo();
    }

    public View.OnClickListener onBackOnClick = (v) -> {
        onBackPressed();
    };

    public ObservableField<String> storeName = new ObservableField<>();
    public ObservableField<String> photo = new ObservableField<>();
    public ObservableField<String> AllGoodsCount = new ObservableField<>();
    public ObservableField<String> storeCollect = new ObservableField<>();
    public ObservableField<String> storeCreditPercent = new ObservableField<>();
    public ObservableField<String> dailySales = new ObservableField<>();
    public ObservableField<String> storeSales = new ObservableField<>();
    public ObservableField<String> todaySales = new ObservableField<>();
    public ObservableField<String> todayMoney = new ObservableField<>();
    public ObservableField<String> yesToadayMoney = new ObservableField<>();

    private void getStoreInfo() {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        OkGoUtil.postRequest(ApiAddress.URL_POST_STORE_INFO, params, new BaseObserver2<BusinessBean>() {
            @Override
            protected void onSuccees(BusinessBean businessBean) throws Exception {
                storeName.set(businessBean.getStore_name());
                photo.set(businessBean.getStore_avatar());
                AllGoodsCount.set(businessBean.getAll_goods_count());
                storeCollect.set(businessBean.getStore_collect());
                storeCreditPercent.set(businessBean.getStore_credit_percent()+"%");
                dailySales.set(businessBean.getDaily_sales());
                storeSales.set(businessBean.getStore_sales());
                todaySales.set(businessBean.getToday_sales());
                todayMoney.set(businessBean.getTotal_money()+"");
                yesToadayMoney.set(businessBean.getYesterday_money()+"");
            }

            @Override
            protected void onIsError(String msg) throws Exception {

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        });
    }
}
