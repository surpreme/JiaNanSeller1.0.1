package com.aite.jiananseller.ui.vm.main;

import android.app.Application;
import android.content.Context;
import android.renderscript.ScriptGroup;
import android.view.View;

import com.aite.jiananseller.R;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.base.BaseObserver3;
import com.aite.jiananseller.bean.AllUnReadMsgLessBean;
import com.aite.jiananseller.bean.SystemMsgBean;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.aite.jiananseller.ui.vm.item.MsgItemViewModel;
import com.aite.jiananseller.utils.ClutterUtils;
import com.aite.jiananseller.utils.LogUtils;
import com.lzy.okgo.model.HttpParams;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.bus.Messenger;
import me.goldze.mvvmhabit.bus.RxBus;
import me.goldze.mvvmhabit.bus.RxSubscriptions;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description:
 */
public class MsgCenterViewModel extends BaseViewModel {
    public static final String TOKEN_UNREADMSG_REFRESH = "TOKEN_UNREADMSG_REFRESH";
    public static final String TOKEN_NODATA_REFRESH = "TOKEN_NODATA_REFRESH";

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context context;

    public MsgCenterViewModel(@NonNull Application application) {
        super(application);
        getPersonalMsg(1);
        getUnReadMsgBean();

    }

    public View.OnClickListener onBackOnClick = (v) -> {
        onBackPressed();
    };

    public ObservableList<MsgItemViewModel> observableList = new ObservableArrayList<>();
    public ItemBinding<MsgItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<MsgItemViewModel>() {

        @Override
        public void onItemBind(ItemBinding itemBinding, int position, MsgItemViewModel item) {
            itemBinding.set(BR.viewModel, R.layout.layout_msg_list);
        }
    });

    public void getSystemMsg(int page) {
        clearDatas(page);
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("curpage", page);
        OkGoUtil.postRequest(ApiAddress.URL_POST_SYSTEM_MSG, params, new BaseObserver3<SystemMsgBean>() {

            @Override
            protected void onSuccees(SystemMsgBean systemMsgBean, boolean isHasMore, int mpage) throws Exception {
                if (isHasMoreListner != null) {
                    isHasMoreListner.back(isHasMore && page < mpage);
                }
                for (SystemMsgBean.MessageArrayBean messageArrayBean : systemMsgBean.getMessage_array()) {
                    observableList.add(new MsgItemViewModel(MsgCenterViewModel.this, messageArrayBean, 2));
                }
                Messenger.getDefault().send(observableList.size() == 0 ? "NODATA" : "HAVEDATA", MsgCenterViewModel.TOKEN_NODATA_REFRESH);
            }

            @Override
            protected void onIsError(String msg) throws Exception {
                ToastUtils.showShort(msg);
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        });
//        sureNoData();
    }

    public void getPersonalMsg(int page) {
        clearDatas(page);
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("curpage", page);
        OkGoUtil.postRequest(ApiAddress.URL_POST_PERSONAL_MSG, params, new BaseObserver3<SystemMsgBean>() {
            @Override
            protected void onSuccees(SystemMsgBean systemMsgBean, boolean isHasMore, int mpage) throws Exception {
                if (isHasMoreListner != null) {
                    isHasMoreListner.back(isHasMore && page < mpage);
                }
                for (SystemMsgBean.MessageArrayBean messageArrayBean : systemMsgBean.getMessage_array()) {
                    observableList.add(new MsgItemViewModel(MsgCenterViewModel.this, messageArrayBean, 1));
                }
                Messenger.getDefault().send(observableList.size() == 0 ? "NODATA" : "HAVEDATA", MsgCenterViewModel.TOKEN_NODATA_REFRESH);


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

    private void clearDatas(int page) {
        if (page == 1) {
            observableList.clear();
        }
    }


    /**
     * 返回字段	类型	说明
     * datas.total_num	整型	新接收到的总消息数量
     * datas.newcommon	整型	新接收到的普通消息数量
     * datas.newsystem	整型	新接收到的系统消息数量
     * datas.newpersonal	整型	新接收到的站内消息
     */
    private void getUnReadMsgBean() {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("login_role", App.getLogInRole());
        OkGoUtil.postRequest(ApiAddress.URL_POST_UNREADMSGNUMBER_INFO, params, new BaseObserver<AllUnReadMsgLessBean>() {
            @Override
            protected void onSuccees(AllUnReadMsgLessBean allUnReadMsgLessBean) throws Exception {
                Messenger.getDefault().send(allUnReadMsgLessBean, MsgCenterViewModel.TOKEN_UNREADMSG_REFRESH);

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


    public interface IsHasMoreListner {
        void back(boolean isHasMore);
    }

    public void setIsHasMoreListner(IsHasMoreListner isHasMoreListner) {
        this.isHasMoreListner = isHasMoreListner;
    }

    public IsHasMoreListner isHasMoreListner = null;
}
