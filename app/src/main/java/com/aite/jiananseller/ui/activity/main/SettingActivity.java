package com.aite.jiananseller.ui.activity.main;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.aite.baselibrary.adapter.BaseTextViewRecyAdapter;
import com.aite.baselibrary.view.util.PopupWindows.PopupWindowsUtils;
import com.aite.jiananseller.R;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.databinding.ActivitySettingBinding;
import com.aite.jiananseller.databinding.ActivityStatisticBinding;
import com.aite.jiananseller.ui.vm.main.SettingViewModel;
import com.aite.jiananseller.ui.vm.main.StatisticViewModel;
import com.aite.jiananseller.utils.DataCleanManager;
import com.aite.jiananseller.utils.SystemFileUtil;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description: 设置
 */
public class SettingActivity extends BaseActivity<ActivitySettingBinding, SettingViewModel> {
    private BaseTextViewRecyAdapter baseTextViewRecyAdapter;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_setting;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        binding.title.tvTitle.setText("设置");
        binding.title.ivReturn.setOnClickListener(viewModel.onBackOnClick);
        binding.clCache.setOnClickListener(v -> {
            List<String> messages = new ArrayList<>();
            messages.add("确认清除缓存");
            baseTextViewRecyAdapter = new BaseTextViewRecyAdapter(this, messages);
            baseTextViewRecyAdapter.setClickInterface(position -> {
                SystemFileUtil.clearAllCache(App.getContext());

                PopupWindowsUtils.getmInstance().dismissPopWindow();
                try {
                    if (SystemFileUtil.getTotalCacheSize(this).equals("0") || SystemFileUtil.getTotalCacheSize(this).equals("0M") || SystemFileUtil.getTotalCacheSize(this).equals("0.00K"))
                        viewModel.cacheSize.set("0.00K");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            PopupWindowsUtils.getmInstance().showBottomRecyAndCancelPopupWindow(this, baseTextViewRecyAdapter, new LinearLayoutManager(App.getContext(), LinearLayoutManager.VERTICAL, false));


     });

    }
}
