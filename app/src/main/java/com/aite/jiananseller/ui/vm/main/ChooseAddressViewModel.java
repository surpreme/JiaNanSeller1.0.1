package com.aite.jiananseller.ui.vm.main;

import android.app.Application;
import android.view.View;

import com.aite.jiananseller.ui.activity.main.AddAddressActivity;

import androidx.annotation.NonNull;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * @author:TQX
 * @Date: 2019/11/6
 * @description:
 */
public class ChooseAddressViewModel extends BaseViewModel {
    public ChooseAddressViewModel(@NonNull Application application) {
        super(application);
    }

    public View.OnClickListener returnOnclick = (v) -> {
      onBackPressed();
    };
    public View.OnClickListener addAddressOnclick = (v) -> {
     startActivity(AddAddressActivity.class);
    };
}
