package com.aite.jiananseller.ui.vm.main;

import android.app.Application;

import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver3;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.lzy.okgo.model.HttpParams;

import androidx.annotation.NonNull;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * @author:TQX
 * @Date: 2019/11/26
 * @description:
 */
public class SpacePhotoViewModel extends BaseViewModel {
    public SpacePhotoViewModel(@NonNull Application application) {
        super(application);
    }

    public void getSpacePhoto(String curpage,String id, BaseObserver3 baseObserver3){
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("curpage", curpage);
        params.put("id", id);
        OkGoUtil.getRequest(ApiAddress.URL_POST_GET_SPACE_PHOTO, params, baseObserver3);
    }
}
