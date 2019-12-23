package com.aite.jiananseller.ui.vm.main;

import android.app.Application;
import android.util.Log;
import android.view.View;

import com.aite.jiananseller.R;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver2;
import com.aite.jiananseller.base.BaseObserver3;
import com.aite.jiananseller.bean.GoodsUpListBean;
import com.aite.jiananseller.bean.OrderBean;
import com.aite.jiananseller.bean.OrderListBean;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.aite.jiananseller.ui.vm.item.GoodsItemViewModel;
import com.aite.jiananseller.ui.vm.item.OrderItemViewModel;
import com.aite.jiananseller.utils.BeanConvertor;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzy.okgo.model.HttpParams;

import java.util.Iterator;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableInt;
import androidx.databinding.ObservableList;
import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description:
 */
public class SearchViewModel extends BaseViewModel {


    public SearchViewModel(@NonNull Application application) {
        super(application);
        bt1Visible.set(View.VISIBLE);
        bt2Visible.set(View.GONE);
        bt3Visible.set(View.GONE);
        bt4Visible.set(View.GONE);
    }

    public View.OnClickListener retrunOnclick = (v) -> {
        onBackPressed();
    };

    public ObservableInt bt1Visible = new ObservableInt();
    public ObservableInt bt2Visible = new ObservableInt();
    public ObservableInt bt3Visible = new ObservableInt();
    public ObservableInt bt4Visible = new ObservableInt();
    public boolean isGood = true;

    //给RecyclerView添加ObservableList
    public ObservableList<GoodsItemViewModel> observableList = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public ItemBinding<GoodsItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<GoodsItemViewModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, GoodsItemViewModel item) {
            //通过item的类型, 动态设置Item加载的布局
            itemBinding.set(BR.viewModel, R.layout.layout_goods_list);
        }
    });
    //给RecyclerView添加ObservableList
    public ObservableList<OrderItemViewModel> observableList2 = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public ItemBinding<OrderItemViewModel> itemBinding2 = ItemBinding.of(new OnItemBind<OrderItemViewModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, OrderItemViewModel item) {
            //通过item的类型, 动态设置Item加载的布局
            itemBinding.set(BR.viewModel, R.layout.layout_order_list);
        }
    });

    public void clearList() {
        observableList.clear();
        bt1Visible.set(View.VISIBLE);
        bt2Visible.set(View.GONE);
        bt3Visible.set(View.GONE);
        bt4Visible.set(View.GONE);
    }

    //获取搜索数据
    public void getGoodsList(String keyWord,int page) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
//        params.put("stc_id", App.getToken());
        params.put("search_type", 0);
        params.put("curpage", page);
        params.put("keyword", keyWord);
        OkGoUtil.getRequest(ApiAddress.URL_GET_GOOS_UP_LIST, params, new BaseObserver3<GoodsUpListBean>() {
            @Override
            protected void onSuccees(GoodsUpListBean o,boolean isHasMore,int page) throws Exception {
                if (page==1){
                    observableList.clear();
                }
                if (isHasMoreListner!=null){
                    isHasMoreListner.back(isHasMore);
                }
                if (o.getGoods_list().size() > 0) {
                    bt1Visible.set(View.GONE);
                    bt2Visible.set(View.VISIBLE);
                    bt3Visible.set(View.GONE);
                    bt4Visible.set(View.VISIBLE);
                } else {
                    bt1Visible.set(View.VISIBLE);
                    bt2Visible.set(View.GONE);
                    bt3Visible.set(View.GONE);
                    bt4Visible.set(View.GONE);
                }
                for (int i = 0; i < o.getGoods_list().size(); i++) {
                    GoodsItemViewModel goodsItemViewModel = new GoodsItemViewModel(SearchViewModel.this, o.getGoods_list().get(i), 0, i,o.getCurrency().getSymbol());
                    observableList.add(goodsItemViewModel);
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


    /**
     * 获取线下商品列表
     */
    public void getGoodsList(String type, String keyWord,int page) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("type", type);
        params.put("curpage", page);
        params.put("keyword", keyWord);
        OkGoUtil.getRequest(ApiAddress.URL_GET_GOOS_UP_LIST2, params, new BaseObserver3<GoodsUpListBean>() {
            @Override
            protected void onSuccees(GoodsUpListBean o,boolean isHasMore,int page) throws Exception {
                if (page==1){
                    observableList.clear();
                }
                if (isHasMoreListner!=null){
                    isHasMoreListner.back(isHasMore);
                }
                int minTypt =1;
                switch (type) {
                    case "lock_up":
                        minTypt = 1;
                        break;
                    case "wait_verify":
                        minTypt = 2;
                        break;
                    case "verified":
                        minTypt = 3;
                        break;
                }
                if (o.getGoods_list().size() > 0) {
                    bt1Visible.set(View.GONE);
                    bt2Visible.set(View.VISIBLE);
                    bt3Visible.set(View.GONE);
                    bt4Visible.set(View.VISIBLE);
                } else {
                    bt1Visible.set(View.VISIBLE);
                    bt2Visible.set(View.GONE);
                    bt3Visible.set(View.GONE);
                    bt4Visible.set(View.GONE);
                }
                for (int i = 0; i < o.getGoods_list().size(); i++) {
                    GoodsItemViewModel goodsItemViewModel = new GoodsItemViewModel(SearchViewModel.this, o.getGoods_list().get(i), minTypt, i,o.getCurrency().getSymbol());
                    observableList.add(goodsItemViewModel);
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

    /**
     * 获取搜索订单
     */
    public void getOrderList(String keyWord,int page) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("state_type", 0);//store_order：全部订单 state_new：新订单，state_pay：已支付订单，state_send：已发货订单，state_success：已完成订单，state_cancel：已取消订单
        params.put("order_sn", keyWord);
        params.put("curpage", page);
        OkGoUtil.getRequest(ApiAddress.URL_GET_ORDER_LIST, params, new BaseObserver3<OrderListBean>() {
            @Override
            protected void onSuccees(OrderListBean o,boolean isHasMore,int page) throws Exception {
                bt1Visible.set(View.GONE);
                bt2Visible.set(View.GONE);
                bt3Visible.set(View.VISIBLE);
                bt4Visible.set(View.VISIBLE);
                if (isHasMoreListner!=null){
                    isHasMoreListner.back(isHasMore);
                }
                Log.e("", "onSuccees: " + o);
                try {
                    JSONObject u = (JSONObject) JSON.toJSON(o.getOrder_list());

                    Iterator<String> it = u.keySet().iterator();
                    if (page==1){
                        observableList.clear();
                    }
                    while (it.hasNext()) {
                        String key = it.next();
                        OrderBean orderBean = BeanConvertor.convertBean(u.get(key), OrderBean.class);
                        OrderItemViewModel orderItemViewModel = new OrderItemViewModel(SearchViewModel.this, orderBean, 0);
                        observableList2.add(orderItemViewModel);
                    }
//
                } catch (ClassCastException e) {
                    observableList2.clear();
                    bt1Visible.set(View.VISIBLE);
                    bt2Visible.set(View.GONE);
                    bt3Visible.set(View.GONE);
                    bt4Visible.set(View.GONE);
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

    public void deleteGoods(int position) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("commonid", observableList.get(position).goodsListBean.getCommonid());//store_order：全部订单 state_new：新订单，state_pay：已支付订单，state_send：已发货订单，state_success：已完成订单，state_cancel：已取消订单
        OkGoUtil.postRequest(ApiAddress.URL_POST_DELETE_GOODS, params, new BaseObserver2<Object>() {
            @Override
            protected void onSuccees(Object o) throws Exception {

            }

            @Override
            protected void onIsError(String msg) throws Exception {

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
