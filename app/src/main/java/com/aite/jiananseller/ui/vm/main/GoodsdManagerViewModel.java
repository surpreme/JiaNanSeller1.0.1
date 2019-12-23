package com.aite.jiananseller.ui.vm.main;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;

import com.aite.baselibrary.view.util.PopupWindows.PopupWindowsUtils;
import com.aite.baselibrary.window.ActivityManager;
import com.aite.jiananseller.R;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver2;
import com.aite.jiananseller.base.BaseObserver3;
import com.aite.jiananseller.bean.GoodsUpListBean;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.aite.jiananseller.ui.vm.item.GoodsItemViewModel;
import com.lzy.okgo.model.HttpParams;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.bus.Messenger;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * @author:TQX
 * @Date: 2019/10/23
 * @description:
 */
public class GoodsdManagerViewModel extends BaseViewModel {
    public static final String TOKEN_NODATA_REFRESH = "TOKEN_NODATA_REFRESH";
    private int minTypt = 1;

    public GoodsdManagerViewModel(@NonNull Application application) {
        super(application);
        getGoodsList(1);
    }

    public View.OnClickListener retrunOnclick = (v) -> {
        onBackPressed();
    };

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

    /**
     * 获取线上商品列表
     */
    public void getGoodsList(int page) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("curpage", page);
//        params.put("stc_id", App.getToken());
//        params.put("search_type", App.getToken());
//        params.put("keyword", App.getToken());
        OkGoUtil.getRequest(ApiAddress.URL_GET_GOOS_UP_LIST, params, new BaseObserver3<GoodsUpListBean>() {
            @Override
            protected void onSuccees(GoodsUpListBean o, boolean isHasMore, int AllPage) throws Exception {
                if (page == 1) {
                    observableList.clear();
                }
                if (isHasMoreListner != null) {
                    isHasMoreListner.back(isHasMore);
                }
                for (int i = 0; i < o.getGoods_list().size(); i++) {
                    GoodsItemViewModel goodsItemViewModel = new GoodsItemViewModel(GoodsdManagerViewModel.this, o.getGoods_list().get(i), 0, i, o.getCurrency().getSymbol());
                    observableList.add(goodsItemViewModel);
                }
                Messenger.getDefault().send(observableList.size() == 0 ? "NODATA" : "HAVEDATA", GoodsdManagerViewModel.TOKEN_NODATA_REFRESH);
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
    public void getGoodsList(String type, int page) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("curpage", page);
        params.put("type", type);
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
        OkGoUtil.getRequest(ApiAddress.URL_GET_GOOS_UP_LIST2, params, new BaseObserver3<GoodsUpListBean>() {
            @Override
            protected void onSuccees(GoodsUpListBean o, boolean isHasMore, int AllPage) throws Exception {
                if (page == 1) {
                    observableList.clear();
                }
                if (isHasMoreListner != null) {
                    isHasMoreListner.back(isHasMore);
                }
                for (int i = 0; i < o.getGoods_list().size(); i++) {
                    GoodsItemViewModel goodsItemViewModel = new GoodsItemViewModel(GoodsdManagerViewModel.this, o.getGoods_list().get(i), minTypt, i, o.getCurrency().getSymbol());
                    observableList.add(goodsItemViewModel);
                }
                Messenger.getDefault().send(observableList.size() == 0 ? "NODATA" : "HAVEDATA", GoodsdManagerViewModel.TOKEN_NODATA_REFRESH);

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

    //删除商品
    public void deleteGoods(int position) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("commonid", observableList.get(position).goodsListBean.getCommonid());//store_order：全部订单 state_new：新订单，state_pay：已支付订单，state_send：已发货订单，state_success：已完成订单，state_cancel：已取消订单
        OkGoUtil.postRequest(ApiAddress.URL_POST_DELETE_GOODS, params, new BaseObserver2<String>() {
            @Override
            protected void onSuccees(String o) throws Exception {
                if (o.equals("1")) {
                    getGoodsList("verified", 1);
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

    //下架商品
    public void unShowGoods(int position) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("commonid", observableList.get(position).goodsListBean.getCommonid());//store_order：全部订单 state_new：新订单，state_pay：已支付订单，state_send：已发货订单，state_success：已完成订单，state_cancel：已取消订单
        OkGoUtil.postRequest(ApiAddress.URL_POST_GOODS_UNSHOW, params, new BaseObserver2<String>() {
            @Override
            protected void onSuccees(String o) throws Exception {
                if (o.equals("1")) {
                    getGoodsList(1);
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

    //上架商品
    public void ShowGoods(int position) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("commonid", observableList.get(position).goodsListBean.getCommonid());//store_order：全部订单 state_new：新订单，state_pay：已支付订单，state_send：已发货订单，state_success：已完成订单，state_cancel：已取消订单
        OkGoUtil.postRequest(ApiAddress.URL_POST_GOODS_SHOW, params, new BaseObserver2<String>() {
            @Override
            protected void onSuccees(String o) throws Exception {
                if (o.equals("1")) {
                    getGoodsList("verified", 1);
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

    public interface IsHasMoreListner {
        void back(boolean isHasMore);
    }

    public void setIsHasMoreListner(IsHasMoreListner isHasMoreListner) {
        this.isHasMoreListner = isHasMoreListner;
    }

    public IsHasMoreListner isHasMoreListner = null;
}
