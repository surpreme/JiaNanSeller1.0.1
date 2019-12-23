package com.aite.jiananseller.ui.vm.item;

import android.view.View;

import com.aite.jiananseller.R;
import com.aite.jiananseller.bean.OrderBean;
import com.aite.jiananseller.ui.vm.main.OrderdManagerViewModel;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ObservableList;
import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.ItemViewModel;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * @author:TQX
 * @Date: 2019/11/13
 * @description:
 */
public class OrderInfoItemViewModel<T extends BaseViewModel> extends ItemViewModel<T> {

    public ObservableField<String> goodsName = new ObservableField<>("");
    public ObservableField<String> goodsPrice = new ObservableField<>("");
    public ObservableField<String> goodsCount = new ObservableField<>("");
    public ObservableField<String> goodPhoto = new ObservableField<>("");
    public ObservableField<String> goodsType = new ObservableField<>("");

    public OrderInfoItemViewModel(@NonNull T viewModel, OrderBean.GoodsListBean orderBean) {
        super(viewModel);
        goodsName.set(orderBean.getGoods_name());
        goodsPrice.set("￥"+orderBean.getGoods_pay_price());
        goodsCount.set("x"+orderBean.getGoods_num());
        goodPhoto.set(orderBean.getImage_240_url());
        goodsType.set(orderBean.getGoods_type());

    }


}
