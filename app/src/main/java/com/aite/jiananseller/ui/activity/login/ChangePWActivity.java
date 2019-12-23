package com.aite.jiananseller.ui.activity.login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.aite.jiananseller.R;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.databinding.ActivityChangePwBinding;
import com.aite.jiananseller.ui.vm.login.ChangePWViewModel;
import com.aite.jiananseller.ui.vm.login.LoginViewModel;
import com.aite.jiananseller.utils.CountDownTimerUtils;
import com.alibaba.fastjson.JSON;

import androidx.lifecycle.ViewModelProviders;
import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @author:TQX
 * @Date: 2019/11/6
 * @description:
 */
public class ChangePWActivity extends BaseActivity<ActivityChangePwBinding, ChangePWViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_change_pw;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public ChangePWViewModel initViewModel() {
        //View持有ViewModel的引用，如果没有特殊业务处理，这个方法可以不重写
        return ViewModelProviders.of(this).get(ChangePWViewModel.class);
    }

    @Override
    public void initData() {
        binding.title.tvTitle.setVisibility(View.GONE);
        binding.title.ivReturn.setOnClickListener((i -> {
            onBackPressed();
        }));
        binding.etUserPhone.addTextChangedListener(watcher);
        binding.etAuthCode.addTextChangedListener(watcher);
        binding.etNewPw.addTextChangedListener(watcher2);
        binding.etNewPw2.addTextChangedListener(watcher2);
        binding.rbStep1.setChecked(true);
        binding.rbStep1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.cl1.setVisibility(View.VISIBLE);
                binding.cl2.setVisibility(View.INVISIBLE);
                binding.btNext.setVisibility(View.VISIBLE);
                binding.btCommit.setVisibility(View.INVISIBLE);
            }
        });
        binding.rbStep2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.cl1.setVisibility(View.INVISIBLE);
                binding.cl2.setVisibility(View.VISIBLE);
                binding.btNext.setVisibility(View.INVISIBLE);
                binding.btCommit.setVisibility(View.VISIBLE);
            }
        });
        binding.btSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getAuthCode(new BaseObserver<Object>() {
                    @Override
                    protected void onSuccees(Object o) throws Exception {
                        String msg = JSON.parseObject(o.toString()).getString("msg");
                        ToastUtils.showShort(msg);
                        CountDownTimerUtils countDownTimerUtils = new CountDownTimerUtils(binding.btSendCode, 60000, 1000);
                        countDownTimerUtils.start();
                    }

                    @Override
                    protected void onIsError(String msg) throws Exception {
                        ToastUtils.showShort(msg);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                    }
                });

            }
        });

    }


    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(binding.etUserPhone.getText()) && !TextUtils.isEmpty(binding.etAuthCode.getText())) {
                binding.btNext.setEnabled(true);
            } else {
                binding.btNext.setEnabled(false);
            }
        }
    };
    private TextWatcher watcher2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(binding.etNewPw.getText()) && !TextUtils.isEmpty(binding.etNewPw2.getText())) {
                binding.btCommit.setEnabled(true);
            } else {
                binding.btCommit.setEnabled(false);
            }
        }
    };
}
