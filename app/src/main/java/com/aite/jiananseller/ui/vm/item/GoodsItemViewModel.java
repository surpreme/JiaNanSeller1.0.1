package com.aite.jiananseller.ui.vm.item;

import android.os.Bundle;
import android.view.View;

import com.aite.jiananseller.bean.GoodsUpListBean;
import com.aite.jiananseller.ui.activity.main.EditGoodsActivity;
import com.blankj.rxbus.RxBus;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * @author:TQX
 * @Date: 2019/11/13
 * @description:
 */
public class GoodsItemViewModel<T extends BaseViewModel> extends ItemViewModel<T> {

    private int multiType;
    private int position;
    public ObservableField<String> goodsName = new ObservableField<>("");
    public ObservableField<String> goodsMoney = new ObservableField<>("");
    public ObservableField<String> goodsrepertory = new ObservableField<>("");
    public ObservableField<String> goodPhoto = new ObservableField<>("");
    public ObservableField<String> btText = new ObservableField<>("");
    public ObservableInt bt1Visible = new ObservableInt();
    public ObservableInt bt2Visible = new ObservableInt();
    public ObservableInt bt3Visible = new ObservableInt();
    public GoodsUpListBean.GoodsListBean goodsListBean;

    public GoodsItemViewModel(@NonNull T viewModel, GoodsUpListBean.GoodsListBean goodsListBean, int multiType, int position, String money) {
        super(viewModel);
//        this.goodsBean.set(goodsListBean);
        this.multiType = multiType;
        this.goodsListBean = goodsListBean;
        this.position = position;
        goodsName.set(goodsListBean.getGoods_name());
        goodsMoney.set(money + goodsListBean.getGoods_price());
        goodsrepertory.set(goodsListBean.getGoods_storage() + "库存");
        goodPhoto.set(goodsListBean.getGoods_image());
        switch (multiType) {
            case 0:
                bt1Visible.set(View.GONE);
                btText.set("下架");
                break;
            case 1:
                bt1Visible.set(View.GONE);
                bt3Visible.set(View.GONE);
                btText.set("下架");
                break;
            case 2:
                bt1Visible.set(View.GONE);
                bt2Visible.set(View.GONE);
                bt3Visible.set(View.GONE);
                break;
            case 3:
                bt1Visible.set(View.VISIBLE);
                bt2Visible.set(View.VISIBLE);
                bt3Visible.set(View.VISIBLE);
                btText.set("上架");
                break;
        }
    }

    public BindingCommand editOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            bundle.putString("goodsId", goodsListBean.getCommonid());
            viewModel.startActivity(EditGoodsActivity.class,bundle);
        }
    });

    public BindingCommand deleteOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            RxBus.getDefault().post(position, "deleteGoodsPosition");
        }
    });
    public BindingCommand showOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            if (btText.get().equals("下架")) {
                RxBus.getDefault().post(position, "unShowPosition");
            } else if (btText.get().equals("上架")) {
                RxBus.getDefault().post(position, "ShowPosition");
            }

        }
    });

}
