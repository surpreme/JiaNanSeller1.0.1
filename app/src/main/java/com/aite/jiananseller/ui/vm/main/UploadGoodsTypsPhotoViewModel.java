package com.aite.jiananseller.ui.vm.main;

import android.app.Application;

import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.lzy.okgo.model.HttpParams;

import java.io.File;

import androidx.annotation.NonNull;
import me.goldze.mvvmhabit.base.BaseViewModel;

/**
 * @author:TQX
 * @Date: 2019/11/25
 * @description:
 */
public class UploadGoodsTypsPhotoViewModel extends BaseViewModel {
    public UploadGoodsTypsPhotoViewModel(@NonNull Application application) {
        super(application);
    }

    //获取图片类型数组
    public void getTypeArrary(int commonid, BaseObserver baseObserver){
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("commonid", commonid);
        OkGoUtil.postRequest(ApiAddress.URL_POST_GET_PHOTO_TYPE,params,baseObserver);
    }

    //上传图片
    public void ImageUpload(File file, BaseObserver baseObserver) {
        HttpParams params =  new HttpParams();
        params.put("key", App.getToken());
        params.put("name",file);
        OkGoUtil.postRequest(ApiAddress.URL_POST_IMAGE_UPLOAD,params, baseObserver);
    }

    //保存商品颜色图片
    public void SaveColorPhoto(int commonid,String img, BaseObserver baseObserver) {
        HttpParams params =  new HttpParams();
        params.put("key", App.getToken());
        params.put("commonid", commonid);
        params.put("img", img);
        OkGoUtil.postRequest(ApiAddress.URL_POST_SAVE_COLOR_PHOTO, params, baseObserver);
    }
}
