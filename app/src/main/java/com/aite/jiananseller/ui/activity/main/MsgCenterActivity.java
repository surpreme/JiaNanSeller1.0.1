package com.aite.jiananseller.ui.activity.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.aite.jiananseller.R;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.bean.AllUnReadMsgLessBean;
import com.aite.jiananseller.databinding.ActivityMsgCenterBinding;
import com.aite.jiananseller.ui.vm.main.MsgCenterViewModel;
import com.aite.jiananseller.utils.TableLineLengthUtils;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tencent.imsdk.TIMCallBack;
import com.tencent.imsdk.TIMConversation;
import com.tencent.imsdk.TIMConversationType;
import com.tencent.imsdk.TIMElem;
import com.tencent.imsdk.TIMElemType;
import com.tencent.imsdk.TIMGroupManager;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMMessage;
import com.tencent.imsdk.TIMMessageListener;
import com.tencent.imsdk.TIMTextElem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.bus.Messenger;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description: 发货
 */
public class MsgCenterActivity extends BaseActivity<ActivityMsgCenterBinding, MsgCenterViewModel> {
    private ArrayList<String> tab_title_list = new ArrayList<>();//存放标签页标题
    private int page = 1;
    private int msgType = 1;//1站内信 2系统消息 3互动消息
    private TIMConversation conversation;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_msg_center;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        binding.title.tvTitle.setText("消息中心");
        binding.title.ivReturn.setOnClickListener(viewModel.onBackOnClick);
        viewModel.setContext(this);
        initTabLayout();
        initSmart();
        Drawable drawable = getDrawable(R.drawable.msg_order);
        initTxIm();
        initMsgAcount();

    }

    private void initSmart() {
        binding.refreshLayout.setEnableAutoLoadMore(true);//开启自动加载功能（非必须）
        binding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 1;
                        if (msgType == 1) {
                            viewModel.getPersonalMsg(page);
                        } else if (msgType == 2) {
                            viewModel.getSystemMsg(page);
                        }
                        refreshLayout.finishRefresh();
                        refreshLayout.resetNoMoreData();//setNoMoreData(false);
                    }
                }, 500);
            }
        });
        binding.refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        if (msgType == 1) {
                            viewModel.getPersonalMsg(page);
                        } else if (msgType == 2) {
                            viewModel.getSystemMsg(page);
                        }
                        refreshLayout.finishLoadMore();
                    }
                }, 500);
            }
        });
        viewModel.setIsHasMoreListner(isHasMore -> {
            if (isHasMore) {
                binding.refreshLayout.setNoMoreData(false);
            } else {
                binding.refreshLayout.finishLoadMoreWithNoMoreData();
            }
        });
    }

    private void initTabLayout() {
        tab_title_list.add("站内信息");
        tab_title_list.add("系统消息");
        tab_title_list.add("互动消息");
        for (int i = 0; i < tab_title_list.size(); i++) {
            binding.tlPositionChoose.addTab(binding.tlPositionChoose.newTab().setText(tab_title_list.get(i)));
        }
        binding.tlPositionChoose.post(new Runnable() {
            @Override
            public void run() {
                TableLineLengthUtils.setIndicator(binding.tlPositionChoose, 15, 15);
            }
        });

        binding.tlPositionChoose.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                page = 1;
                switch (tab.getPosition()) {
                    case 0:
                        msgType = 1;
                        viewModel.getPersonalMsg(page);
                        break;
                    case 1:
                        msgType = 2;
                        viewModel.getSystemMsg(page);
                        break;
                    case 2:
                        msgType = 3;
                        viewModel.observableList.clear();
                        break;
                }
                Messenger.getDefault().send(viewModel.observableList.size() == 0 ? "NODATA" : "HAVEDATA", MsgCenterViewModel.TOKEN_NODATA_REFRESH);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initTxIm() {
        //加入聊天房间
        TIMGroupManager.getInstance().applyJoinGroup("000", "some reason", new TIMCallBack() {
            @java.lang.Override
            public void onError(int code, String desc) {
                //接口返回了错误码 code 和错误描述 desc，可用于原因
                //错误码 code 列表请参见错误码表
                Log.e("m_tag", "applyJoinGroup err code = " + code + ", desc = " + desc);
            }

            @java.lang.Override
            public void onSuccess() {
                Log.e("m_tag", "applyJoinGroup success");
            }
        });
        conversation = TIMManager.getInstance().getConversation(
                TIMConversationType.Group, "000"  //会话类型：群组
        );
        //腾讯云消息监听
        TIMManager.getInstance().addMessageListener(new TIMMessageListener() {//消息监听器
            @Override
            public boolean onNewMessages(List<TIMMessage> msgs) {//收到新消息
                Log.e("m_tag", "onNewMessages: ");
                //消息的内容解析请参考消息收发文档中的消息解析说明
                if (msgs.get(0).getElementCount() > 0) {
                    for (int i = 0; i < msgs.get(0).getElementCount(); i++) {
                        TIMElem elem = msgs.get(0).getElement(i);
                        //获取当前元素的类型
                        TIMElemType elemType = elem.getType();
                        if (elemType == TIMElemType.Text) {
                            TIMTextElem txtEle = (TIMTextElem) elem;
                            Log.d("m_tag", "elem type: " + elemType.name() + "cotnet" + txtEle.getText());
                            //处理文本消息
                        } else if (elemType == TIMElemType.Image) {
                            //处理图片消息
                        }//...处理更多消息
                    }
                }

                return true; //返回true将终止回调链，不再调用下一个新消息监听器
            }
        });
    }


    /**
     * 1站内信 2系统消息 3互动消息
     */
    private void initMsgAcount() {
        Messenger.getDefault().register(this, MsgCenterViewModel.TOKEN_NODATA_REFRESH, String.class, s -> {
            binding.nodataIv.setVisibility(s.equals("NODATA") ? View.VISIBLE : View.GONE);
        });
        Messenger.getDefault().register(this, MsgCenterViewModel.TOKEN_UNREADMSG_REFRESH, AllUnReadMsgLessBean.class, allUnReadMsgLessBean -> {
            if (binding.tlPositionChoose.getTabAt(0) != null && !allUnReadMsgLessBean.getNewpersonal().equals("0")) {
                new QBadgeView(App.getContext()).
                        bindTarget(Objects.requireNonNull(binding.tlPositionChoose.getTabAt(0)).view).
                        setBadgeText(allUnReadMsgLessBean.getNewpersonal()).
                        setBadgeBackgroundColor(getResources().getColor(R.color.btn_red_hover));
            }
            if (binding.tlPositionChoose.getTabAt(1) != null && !allUnReadMsgLessBean.getNewsystem().equals("0")) {
                new QBadgeView(App.getContext()).
                        bindTarget(Objects.requireNonNull(binding.tlPositionChoose.getTabAt(1)).view).
                        setBadgeText(allUnReadMsgLessBean.getNewsystem()).
                        setBadgeBackgroundColor(getResources().getColor(R.color.btn_red_hover));
            }
            if (binding.tlPositionChoose.getTabAt(2) != null && !allUnReadMsgLessBean.getNewcommon().equals("0")) {
                new QBadgeView(App.getContext()).
                        bindTarget(Objects.requireNonNull(binding.tlPositionChoose.getTabAt(2)).view).
                        setBadgeText(allUnReadMsgLessBean.getNewcommon()).
                        setBadgeBackgroundColor(getResources().getColor(R.color.btn_red_hover));
            }

        });
    }
}
