package com.aite.jiananseller.ui.activity.main;

import android.os.Bundle;

import com.aite.jiananseller.R;
import com.aite.jiananseller.databinding.ActivityChooseAddressBinding;
import com.aite.jiananseller.ui.vm.main.ChooseAddressViewModel;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * @author:TQX
 * @Date: 2019/11/6
 * @description:
 */
public class ChooseAddressActivity extends BaseActivity<ActivityChooseAddressBinding, ChooseAddressViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_choose_address;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        binding.title.ivReturn.setOnClickListener(viewModel.returnOnclick);
        binding.tvAddAddress.setOnClickListener(viewModel.addAddressOnclick);
    }
}
