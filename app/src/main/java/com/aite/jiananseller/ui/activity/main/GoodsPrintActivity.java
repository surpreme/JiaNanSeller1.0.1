package com.aite.jiananseller.ui.activity.main;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.aite.jiananseller.R;
import com.aite.jiananseller.databinding.ActivityGoodsPrintBinding;
import com.aite.jiananseller.databinding.ActivityShipmentsBinding;
import com.aite.jiananseller.ui.vm.main.GoodsPrintViewModel;
import com.aite.jiananseller.ui.vm.main.ShipmentsViewModel;
import com.aite.jiananseller.utils.QRCodeUtil;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description: 包裹详情
 */
public class GoodsPrintActivity extends BaseActivity<ActivityGoodsPrintBinding, GoodsPrintViewModel> {
    private String orderSn;
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_goods_print;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        binding.title.tvTitle.setText("包裹详情");
        binding.title.ivReturn.setOnClickListener((v)->onBackPressed());
        orderSn = getIntent().getStringExtra("orderSn");
        binding.tvOrderSn.setText(getIntent().getStringExtra("orderSn"));
        binding.tvSendName.setText(getIntent().getStringExtra("sendName"));
        binding.tvSendPhone.setText(getIntent().getStringExtra("sendPhone"));
        binding.tvSendAddress.setText(getIntent().getStringExtra("sendAddress"));
        binding.tvRecevieName.setText(getIntent().getStringExtra("recName"));
        binding.tvReceviePhone.setText(getIntent().getStringExtra("recPhone"));
        binding.tvRecevieAddress.setText(getIntent().getStringExtra("recAddress"));
        Bitmap mBitmap = QRCodeUtil.createQRCodeBitmap(orderSn, 480, 480);
        binding.ivQrCode.setImageBitmap(mBitmap);
    }


}
