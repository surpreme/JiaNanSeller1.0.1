package com.aite.jiananseller.ui.activity.main;

import android.os.Bundle;

import com.aite.jiananseller.R;
import com.aite.jiananseller.databinding.ActivityExpressInfoBinding;
import com.aite.jiananseller.ui.vm.main.ExpressInfoViewModel;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * @author:TQX
 * @Date: 2019/11/15
 * @description:
 */
public class ExpressInfoActivity extends BaseActivity<ActivityExpressInfoBinding, ExpressInfoViewModel> {
    private String orderId;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_express_info;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        orderId = getIntent().getStringExtra("orderId");
        viewModel.getExpressInfo(orderId);
        binding.title.ivReturn.setOnClickListener(viewModel.retrunOnclick);
        binding.title.tvTitle.setText("查看物流");
    }
}
