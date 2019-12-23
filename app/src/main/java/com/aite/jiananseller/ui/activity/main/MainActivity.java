package com.aite.jiananseller.ui.activity.main;

import androidx.lifecycle.ViewModelProviders;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.binding.command.BindingConsumer;
import me.goldze.mvvmhabit.bus.Messenger;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.aite.jiananseller.R;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.databinding.ActivityMainBinding;
import com.aite.jiananseller.ui.vm.main.MainViewModel;
import com.aite.jiananseller.utils.StatusBarUtils;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {
    private Badge bookBadge;


    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public MainViewModel initViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public void initData() {
        StatusBarUtils.setColor(this, getResources().getColor(R.color.colorMain));
        initMsgAcount();
    }

    /**
     * TOKEN_CHATNOTIFY_REFRESH 消息总未读数 现在是数量为0 不显示
     * TOKEN_BOOKFIXERNOTIFY_REFRESH 订单总未读数
     */
    private void initMsgAcount() {
        Messenger.getDefault().register(this, MainViewModel.TOKEN_CHATNOTIFY_REFRESH, String.class, s -> {
            if (s.equals("0")) {
                binding.tvMsgCount.setVisibility(View.GONE);
            }
        });
        Messenger.getDefault().register(this, MainViewModel.TOKEN_BOOKFIXERNOTIFY_REFRESH, String.class, s -> {
            bookBadge = new QBadgeView(App.getContext()).
                    bindTarget(binding.ivItem2).
                    setBadgeText(s).
                    setBadgeBackgroundColor(getResources().getColor(R.color.btn_red_hover));
            bookBadge.setBadgeTextSize(15, true);
            //距离上右的距离
            bookBadge.setGravityOffset(1, 4, true);
            //中心向外的间距
            bookBadge.setBadgePadding(4, true);

        });
    }

}
