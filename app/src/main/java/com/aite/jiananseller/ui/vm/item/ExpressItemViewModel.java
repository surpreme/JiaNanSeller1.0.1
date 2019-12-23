package com.aite.jiananseller.ui.vm.item;

import android.view.View;

import com.aite.jiananseller.bean.ExpressInfoBean;
import com.aite.jiananseller.ui.vm.main.ExpressInfoViewModel;
import com.aite.jiananseller.utils.DateUtil;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.ItemViewModel;

/**
 * @author:TQX
 * @Date: 2019/11/15
 * @description:
 */
public class ExpressItemViewModel extends ItemViewModel<ExpressInfoViewModel> {

    public ExpressItemViewModel(@NonNull ExpressInfoViewModel viewModel, ExpressInfoBean.DeliverInfoBean infoBean , String position) {
        super(viewModel);
//        int position = viewModel.observableList.indexOf(ExpressItemViewModel.this);
        if (position.equals("first")) {
            line1Visi.set(View.GONE);
            line2Visi.set(View.VISIBLE);
        }else {
            line1Visi.set(View.VISIBLE);
            line2Visi.set(View.VISIBLE);
        }
        if (position.equals("last")) {
            line2Visi.set(View.GONE);
        }
        String dateString = DateUtil.timeStamp2Date(infoBean.getTime(),"MM.dd HH:mm");
        String[] dateArry=dateString.split(" ");
        time.set(dateArry[1]);
        date.set(dateArry[0]);
        content.set(infoBean.getContext());
        switch (infoBean.getStatus()) {
            case "0":
                tvstatus.set("已取消");
                break;
            case "10":
                tvstatus.set("未支付");
                break;
            case "20":
                tvstatus.set("已支付");
                break;
            case "30":
                tvstatus.set("已发货");
                break;
            case "40":
                tvstatus.set("已收货");
                break;
        }

    }

    public ObservableField<String> time = new ObservableField<>();
    public ObservableField<String> date = new ObservableField<>();
    public ObservableField<String> content = new ObservableField<>();
    public ObservableField<String> tvstatus = new ObservableField<>();
    public ObservableInt line1Visi = new ObservableInt();
    public ObservableInt line2Visi = new ObservableInt();
}
