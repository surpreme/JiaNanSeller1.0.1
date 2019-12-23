package com.aite.jiananseller.ui.activity.main;

import android.content.Intent;
import android.os.Bundle;

import com.aite.jiananseller.R;
import com.aite.jiananseller.app.Common;
import com.aite.jiananseller.databinding.ActivityShipmentsBinding;
import com.aite.jiananseller.ui.vm.main.ShipmentsViewModel;

import androidx.annotation.Nullable;
import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description: 发货
 */
public class ShipmentsActivity extends BaseActivity<ActivityShipmentsBinding, ShipmentsViewModel> {

    private String orderId;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_shipments;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        binding.title.tvTitle.setText("发货");
        orderId = getIntent().getStringExtra("order_id");
        viewModel.getOrderInfo(orderId);
        binding.tvChooseAddress.setOnClickListener(v -> {
            Intent intent = new Intent(ShipmentsActivity.this, ChooseAddressActivity.class);
            startActivityForResult(intent, Common.CHOOSE_ADDRESS);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Common.CHOOSE_ADDRESS:

                break;
        }
    }
}
