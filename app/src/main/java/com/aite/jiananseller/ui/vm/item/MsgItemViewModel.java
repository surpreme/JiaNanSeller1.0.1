package com.aite.jiananseller.ui.vm.item;


import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.aite.jiananseller.R;
import com.aite.jiananseller.bean.SystemMsgBean;
import com.aite.jiananseller.ui.vm.main.MsgCenterViewModel;
import com.aite.jiananseller.utils.DateUtil;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import me.goldze.mvvmhabit.base.ItemViewModel;

/**
 * @author:TQX
 * @Date: 2019/11/21
 * @description:
 */
public class MsgItemViewModel extends ItemViewModel<MsgCenterViewModel> {

    public MsgItemViewModel(@NonNull MsgCenterViewModel viewModel, SystemMsgBean.MessageArrayBean msgBean, int msgType) {
        super(viewModel);
        msgName.set(msgBean.getFrom_member_name());
        msgContent.set(msgBean.getMessage_body());
        String time = DateUtil.timeStamp2Date(msgBean.getMessage_time(), "yyyy.MM.dd HH:mm:ss");
        msgTime.set(time);
        if (msgType == 1) {
            msgIcon2.set(viewModel.getContext().getDrawable(R.drawable.msg_order));
        } else if (msgType == 2) {
            msgIcon2.set(viewModel.getContext().getDrawable(R.drawable.msg_system));
        } else if (msgType == 3) {

        }
    }


    public ObservableField<String> msgName = new ObservableField<>();
    public ObservableField<String> msgContent = new ObservableField<>();
    public ObservableField<String> msgIcon = new ObservableField<>();
    public ObservableField<String> msgTime = new ObservableField<>();
    public ObservableField<Drawable> msgIcon2 = new ObservableField();


}
