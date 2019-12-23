package com.aite.jiananseller.ui.vm.item;

import android.os.Bundle;
import android.view.View;

import com.aite.jiananseller.R;
import com.aite.jiananseller.bean.GoodsUpListBean;
import com.aite.jiananseller.bean.OrderBean;
import com.aite.jiananseller.ui.activity.main.ExpressInfoActivity;
import com.aite.jiananseller.ui.activity.main.ShipmentsActivity;
import com.aite.jiananseller.ui.vm.main.GoodsdManagerViewModel;
import com.aite.jiananseller.ui.vm.main.OrderdManagerViewModel;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.RecyclerView;
import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * @author:TQX
 * @Date: 2019/11/13
 * @description:
 */
public class OrderItemViewModel<T extends BaseViewModel> extends ItemViewModel<T> {

    private int multiType;
    public ObservableField<String> orderId = new ObservableField<>("");
    public ObservableField<String> orderState = new ObservableField<>("");
    public ObservableField<String> orderAmount = new ObservableField<>("");
    public ObservableField<String> goodPhoto = new ObservableField<>("");
    public ObservableField<String> btText = new ObservableField<>("");
    public ObservableInt bt1Visible = new ObservableInt();
    public ObservableInt bt2Visible = new ObservableInt();
    private OrderBean goodsBean ;

    public OrderItemViewModel(@NonNull T viewModel, OrderBean orderBean, int multiType) {
        super(viewModel);
        this.multiType = multiType;
        orderId.set(orderBean.getOrder_sn());
        orderState.set(orderBean.getState_desc());
        orderAmount.set(orderBean.getOrder_amount());
        this.goodsBean = orderBean;
        switch (orderBean.getOrder_state()) {
            case "0":
                bt1Visible.set(View.GONE);
                bt2Visible.set(View.GONE);
                break;
            case "10"://未付款
                btText.set("调整费用");
                break;
            case "20"://已付款
                bt1Visible.set(View.GONE);
                btText.set("确认发货");
                break;
            case "30"://已发货
            case "40"://已完成
                bt1Visible.set(View.GONE);
                btText.set("查看物流");
                break;
        }
        for (int i = 0; i < orderBean.getGoods_list().size(); i++) {
            OrderInfoItemViewModel goodsItemViewModel = new OrderInfoItemViewModel(viewModel, orderBean.getGoods_list().get(i));
            observableList.add(goodsItemViewModel);
        }
    }

    //给RecyclerView添加ObservableList
    public ObservableList<OrderInfoItemViewModel> observableList = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public ItemBinding<OrderInfoItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<OrderInfoItemViewModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, OrderInfoItemViewModel item) {
            //通过item的类型, 动态设置Item加载的布局
            itemBinding.set(BR.viewModel, R.layout.layout_order_info);
        }
    });
    public BindingCommand onWorkOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (btText.get().equals("确认发货")) {
                Bundle bundle = new Bundle();
                bundle.putString("order_id",goodsBean.getOrder_id());
                viewModel.startActivity(ShipmentsActivity.class,bundle);
            } else if (btText.get().equals("查看物流")) {
                Bundle bundle = new Bundle();
                bundle.putString("orderId",goodsBean.getOrder_id());
                viewModel.startActivity(ExpressInfoActivity.class,bundle);
            }
        }
    });

}
