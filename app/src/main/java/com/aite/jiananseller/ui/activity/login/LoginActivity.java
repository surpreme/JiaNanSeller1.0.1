package com.aite.jiananseller.ui.activity.login;

import android.os.Bundle;
import android.view.View;

import com.aite.jiananseller.BR;
import com.aite.jiananseller.R;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.bean.AreaCodeBean;
import com.aite.jiananseller.databinding.ActivityLoginBinding;
import com.aite.jiananseller.ui.customview.Nearpopu;
import com.aite.jiananseller.ui.vm.login.LoginViewModel;
import com.aite.jiananseller.utils.SharePreferencesHelper;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.ViewModelProviders;

import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.bus.RxBus;

/**
 * @author:TQX
 * @Date: 2019/10/23
 * @description:
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {

    private int type = 1;//1 手机号登录 2账号邮箱登录
    private List<AreaCodeBean.ListBean> areaListBean;
    private Nearpopu nearpopu;
    private SharePreferencesHelper sharePreferencesUtils = new SharePreferencesHelper(App.getContext(), "USER_INFO");


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public LoginViewModel initViewModel() {
        //View持有ViewModel的引用，如果没有特殊业务处理，这个方法可以不重写
        return ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    @Override
    public void initData() {
        areaListBean = new ArrayList<>();
        viewModel.type.set(type);
        viewModel.isRememberPassword.set(false);
        binding.cbRemenberPw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            viewModel.isRememberPassword.set(isChecked);

        });
        if (type == 1) {
            initPhoneRemember();
        }
        binding.tvLoginWay.setOnClickListener(v -> {
            if (type == 2) {
                type = 1;
                binding.clInput1.setVisibility(View.GONE);
                binding.clInput2.setVisibility(View.VISIBLE);
                viewModel.type.set(type);
                viewModel.loginAway.set("账号/邮箱登录");
            } else {
                type = 2;
                binding.clInput1.setVisibility(View.VISIBLE);
                binding.clInput2.setVisibility(View.GONE);
                viewModel.type.set(type);
                initAcountRemember();
                viewModel.loginAway.set("手机号登录");
            }

        });
        nearpopu = new Nearpopu(this, areaListBean);
        nearpopu.setOnItemClickListner(new Nearpopu.OnItemClickListner() {
            @Override
            public void result(int position) {
                binding.tvCountry.setText(areaListBean.get(position).getArea_name());
                binding.tvAreaNum.setText(areaListBean.get(position).getCode());
                RxBus.getDefault().post(areaListBean.get(position).getArea_code());
                nearpopu.dismiss();
            }
        });
        binding.tvAreaNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nearpopu.showAsDropDown(binding.view1);
            }
        });
        binding.ivChooseArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nearpopu.showAsDropDown(binding.view1);
            }
        });
        viewModel.getAreaCode(new BaseObserver<AreaCodeBean>() {
            @Override
            protected void onSuccees(AreaCodeBean o) throws Exception {
                areaListBean.addAll(o.getList());
                binding.tvCountry.setText(areaListBean.get(0).getArea_name());
                binding.tvAreaNum.setText(areaListBean.get(0).getCode());
                RxBus.getDefault().post(areaListBean.get(0).getArea_code());
                Glide.with(LoginActivity.this).load(areaListBean.get(0).getIcon()).into(binding.ivCountry);
            }

            @Override
            protected void onIsError(String msg) throws Exception {

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }

        });

    }

    private void initAcountRemember() {
        if (sharePreferencesUtils.contain("USERNAME_ACOUNT") && sharePreferencesUtils.contain("USER_PASSWORD_ACOUNT")) {
            viewModel.userName1.set(String.valueOf(sharePreferencesUtils.getSharePreference("USERNAME_ACOUNT", "aite")));
            viewModel.passWord1.set(String.valueOf(sharePreferencesUtils.getSharePreference("USER_PASSWORD_ACOUNT", "aite")));
            viewModel.isRememberPassword.set(true);
        } else {
            viewModel.isRememberPassword.set(false);
        }
    }

    private void initPhoneRemember() {
        if (sharePreferencesUtils.contain("USERNAME_PHONE") && sharePreferencesUtils.contain("USER_PASSWORD_PHONE")) {
            viewModel.userName.set(String.valueOf(sharePreferencesUtils.getSharePreference("USERNAME_PHONE", "aite")));
            viewModel.passWord.set(String.valueOf(sharePreferencesUtils.getSharePreference("USER_PASSWORD_PHONE", "aite")));
            viewModel.isRememberPassword.set(true);
        } else {
            viewModel.isRememberPassword.set(false);
        }
    }
}
