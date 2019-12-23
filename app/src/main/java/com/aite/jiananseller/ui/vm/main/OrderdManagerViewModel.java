package com.aite.jiananseller.ui.vm.main;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.aite.jiananseller.R;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver3;
import com.aite.jiananseller.bean.OrderBean;
import com.aite.jiananseller.bean.OrderListBean;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.aite.jiananseller.ui.activity.main.SearchActivity;
import com.aite.jiananseller.ui.vm.item.OrderItemViewModel;
import com.aite.jiananseller.utils.BeanConvertor;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzy.okgo.model.HttpParams;


import java.util.Iterator;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * @author:TQX
 * @Date: 2019/10/23
 * @description:
 */
public class OrderdManagerViewModel extends BaseViewModel {
    private int type = 0;
    public OrderdManagerViewModel(@NonNull Application application) {
        super(application);
        getOrderList("store_order",1);

    }

    public View.OnClickListener retrunOnclick = (v) -> {
        onBackPressed();
    };

    public View.OnClickListener searchOnclick = (v) -> {
        Bundle bundle = new Bundle();
        bundle.putInt("type", 3);
        startActivity(SearchActivity.class, bundle);
    };

    //给RecyclerView添加ObservableList
    public ObservableList<OrderItemViewModel> observableList = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public ItemBinding<OrderItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<OrderItemViewModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, OrderItemViewModel item) {
            //通过item的类型, 动态设置Item加载的布局
            itemBinding.set(BR.viewModel, R.layout.layout_order_list);
        }
    });

    public void getOrderList(String orderType,int page) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("curpage", page);
        params.put("state_type", orderType);//store_order：全部订单 state_new：新订单，state_pay：已支付订单，state_send：已发货订单，state_success：已完成订单，state_cancel：已取消订单
        switch (orderType) {
            case "store_order":
                type = 0;
                break;
            case "state_new":
                type = 1;
                break;
            case "state_pay":
                type = 2;
                break;
            case "state_send":
                type = 3;
                break;
            case "state_success":
                type = 4;
                break;
        }
        OkGoUtil.getRequest(ApiAddress.URL_GET_ORDER_LIST, params, new BaseObserver3<OrderListBean>() {
            @Override
            protected void onSuccees(OrderListBean o,boolean isHasMore,int AllPage) throws Exception {
                Log.e("", "onSuccees: " + o);
                try {
                    JSONObject u = (JSONObject) JSON.toJSON(o.getOrder_list());
                    Iterator<String> it = u.keySet().iterator();
                    if (isHasMoreListner!=null){
                        isHasMoreListner.back(isHasMore);
                    }
                    if (page==1){
                        observableList.clear();
                    }
                    while (it.hasNext()) {
                        String key = it.next();
                        OrderBean orderBean = BeanConvertor.convertBean(u.get(key), OrderBean.class);
                        OrderItemViewModel orderItemViewModel = new OrderItemViewModel(OrderdManagerViewModel.this, orderBean, type);
                        observableList.add(orderItemViewModel);
                    }
                }catch (ClassCastException e){
                    observableList.clear();
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

    public interface  IsHasMoreListner{
        void back(boolean isHasMore);
    }

    public void setIsHasMoreListner(IsHasMoreListner isHasMoreListner) {
        this.isHasMoreListner = isHasMoreListner;
    }

    public IsHasMoreListner isHasMoreListner = null;
}
