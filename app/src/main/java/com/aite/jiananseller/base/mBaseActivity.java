package com.aite.jiananseller.base;

import android.os.Bundle;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * @Auther: valy
 * @datetime: 2019-12-20
 * @desc:
 */
public abstract class mBaseActivity extends BaseActivity {
    protected abstract int getLayoutResId();
    protected abstract void initViews();
    protected abstract int initDatas();
    protected abstract int initMsg();

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return getLayoutResId();
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        initViews();
        initDatas();
        initMsg();
    }
}
