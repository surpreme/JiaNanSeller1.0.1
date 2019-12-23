package com.aite.jiananseller.ui.vm.main;

import android.app.Application;
import android.os.Bundle;

import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver2;
import com.aite.jiananseller.bean.SendInfoBean;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.aite.jiananseller.ui.activity.main.GoodsPrintActivity;
import com.lzy.okgo.model.HttpParams;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description:
 */
public class ShipmentsViewModel extends BaseViewModel {

    public ShipmentsViewModel(@NonNull Application application) {
        super(application);
    }

    public ObservableField<String> sendName = new ObservableField<>("");
    public ObservableField<String> sendPhone = new ObservableField<>("");
    public ObservableField<String> sendAddress = new ObservableField<>("");
    public ObservableField<String> recName = new ObservableField<>("");
    public ObservableField<String> recPhone = new ObservableField<>("");
    public ObservableField<String> recAddress = new ObservableField<>("");
    public ObservableField<String> orderSn = new ObservableField<>("");
    private String orderId;
    private SendInfoBean mOrderInfoBean;


    //获取订单信息
    public void getOrderInfo(String orderId) {
        this.orderId = orderId;
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("order_id", orderId);
        OkGoUtil.postRequest(ApiAddress.URL_POST_ORDER_SEND_INFO, params, new BaseObserver2<SendInfoBean>() {
            @Override
            protected void onSuccees(SendInfoBean orderInfoBean) throws Exception {
                mOrderInfoBean =orderInfoBean;
                orderSn.set(orderInfoBean.getOrder_info().getOrder_sn());
                sendName.set(orderInfoBean.getDaddress_info().getSeller_name());
                sendPhone.set(orderInfoBean.getDaddress_info().getTelphone());
                sendAddress.set(orderInfoBean.getDaddress_info().getArea_info()+orderInfoBean.getDaddress_info().getAddress());
                recName.set(orderInfoBean.getOrder_info().getBuyer_name());
                recPhone.set(orderInfoBean.getOrder_info().getExtend_order_common().getReciver_info().getPhone());
                recAddress.set(orderInfoBean.getOrder_info().getExtend_order_common().getReciver_info().getAddress());
            }

            @Override
            protected void onIsError(String msg) throws Exception {

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        });
    }

    public void saveSend(){
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("order_id", mOrderInfoBean.getOrder_info().getOrder_id());
        params.put("reciver_area", mOrderInfoBean.getOrder_info().getExtend_order_common().getReciver_info().getArea());
        params.put("reciver_street", mOrderInfoBean.getOrder_info().getExtend_order_common().getReciver_info().getAddress());
        params.put("reciver_mob_phone", mOrderInfoBean.getOrder_info().getExtend_order_common().getReciver_info().getMob_phone());
        params.put("reciver_tel_phone", mOrderInfoBean.getOrder_info().getExtend_order_common().getReciver_info().getTel_phone());
//        params.put("reciver_dlyp", mOrderInfoBean.getOrder_info().getExtend_order_common().getReciver_info().get);
        params.put("reciver_name", mOrderInfoBean.getOrder_info().getBuyer_name());
        params.put("deliver_explain", null==mOrderInfoBean.getOrder_info().getExtend_order_common().getDeliver_explain()?"":mOrderInfoBean.getOrder_info().getExtend_order_common().getDeliver_explain().toString());
        params.put("daddress_id",  mOrderInfoBean.getOrder_info().getExtend_order_common().getDaddress_id());
        params.put("shipping_express_id", mOrderInfoBean.getOrder_info().getExtend_order_common().getShipping_express_id());
        params.put("shipping_code", mOrderInfoBean.getOrder_info().getShipping_code());
        OkGoUtil.postRequest(ApiAddress.URL_POST_SAVE_SEND, params, new BaseObserver2<SendInfoBean>() {
            @Override
            protected void onSuccees(SendInfoBean orderInfoBean) throws Exception {
                ToastUtils.showShort("操作成功");
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


    public BindingCommand onPrintOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            Bundle bundle = new Bundle();
            bundle.putString("sendName",sendName.get());
            bundle.putString("sendPhone",sendPhone.get());
            bundle.putString("sendAddress",sendAddress.get());
            bundle.putString("recName",recName.get());
            bundle.putString("recPhone",recPhone.get());
            bundle.putString("recAddress",recAddress.get());
            bundle.putString("orderSn",orderSn.get());
            startActivity(GoodsPrintActivity.class,bundle);
        }
    });
    public BindingCommand onSendOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            saveSend();
        }
    });

}
