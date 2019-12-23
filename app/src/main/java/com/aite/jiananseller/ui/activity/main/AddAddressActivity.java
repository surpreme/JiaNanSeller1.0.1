package com.aite.jiananseller.ui.activity.main;

import android.os.Bundle;

import com.aite.jiananseller.R;
import com.aite.jiananseller.databinding.ActivityAddAddressBinding;
import com.aite.jiananseller.ui.vm.main.AddAddressViewModel;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * @author:TQX
 * @Date: 2019/11/6
 * @description:
 */
public class AddAddressActivity extends BaseActivity<ActivityAddAddressBinding, AddAddressViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_add_address;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {

    }
}
