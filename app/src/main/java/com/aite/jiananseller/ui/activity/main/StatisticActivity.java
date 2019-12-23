package com.aite.jiananseller.ui.activity.main;

import android.os.Bundle;

import com.aite.jiananseller.R;
import com.aite.jiananseller.databinding.ActivityShipmentsBinding;
import com.aite.jiananseller.databinding.ActivityStatisticBinding;
import com.aite.jiananseller.ui.vm.main.ShipmentsViewModel;
import com.aite.jiananseller.ui.vm.main.StatisticViewModel;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description: 发货
 */
public class StatisticActivity extends BaseActivity<ActivityStatisticBinding, StatisticViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_statistic;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        binding.title.tvTitle.setText("统计分析");
        binding.title.ivReturn.setOnClickListener(viewModel.onBackOnClick);
    }
}
