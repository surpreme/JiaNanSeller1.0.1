package com.aite.jiananseller.ui.vm.main;

import android.app.Application;
import android.view.View;

import com.aite.jiananseller.R;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.bean.ExpressInfoBean;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.aite.jiananseller.ui.vm.item.ExpressItemViewModel;
import com.lzy.okgo.model.HttpParams;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * @author:TQX
 * @Date: 2019/11/15
 * @description:
 */
public class ExpressInfoViewModel extends BaseViewModel {
    public ExpressInfoViewModel(@NonNull Application application) {
        super(application);
    }

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> phone = new ObservableField<>();
    public View.OnClickListener retrunOnclick = (v) -> {
        onBackPressed();
    };
    //给RecyclerView添加ObservableList
    public ObservableList<ExpressItemViewModel> observableList = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public ItemBinding<ExpressItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<ExpressItemViewModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, ExpressItemViewModel item) {
            //通过item的类型, 动态设置Item加载的布局
            itemBinding.set(BR.viewModel, R.layout.layout_express_info);
        }
    });


    public void getExpressInfo(String orderId) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("order_id", orderId);
        OkGoUtil.postRequest(ApiAddress.URL_POST_EXPRESS_INFO, params, new BaseObserver<ExpressInfoBean>() {
            @Override
            protected void onSuccees(ExpressInfoBean o) throws Exception {
                name.set(o.getDelivery_staff_info().getStaff_name());
                phone.set(o.getDelivery_staff_info().getStaff_phone());
                observableList.clear();
                String index = "first";
                for (int i = 0; i < o.getDeliver_info().size(); i++) {
                    if (i==0){
                        index = "first";
                    }else if (i==o.getDeliver_info().size()-1){
                        index = "last";
                    }else {
                        index ="";
                    }
                    ExpressItemViewModel goodsItemViewModel = new ExpressItemViewModel(ExpressInfoViewModel.this, o.getDeliver_info().get(i),index);
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
}
