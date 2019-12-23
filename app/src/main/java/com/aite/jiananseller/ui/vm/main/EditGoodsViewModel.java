package com.aite.jiananseller.ui.vm.main;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.aite.baselibrary.view.util.PopupWindows.PopupWindowsUtils;
import com.aite.baselibrary.window.ActivityManager;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.base.BaseObserver2;
import com.aite.jiananseller.net.ApiAddress;
import com.aite.jiananseller.net.OkGoUtil;
import com.aite.jiananseller.ui.activity.main.EditGoodsActivity;
import com.lzy.okgo.model.HttpParams;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description:
 */
public class EditGoodsViewModel extends BaseViewModel {
    public EditGoodsViewModel(@NonNull Application application) {
        super(application);
    }

    public View.OnClickListener onBackOnClick = (v) -> {
        onBackPressed();
    };

    public ObservableField<String> cache = new ObservableField<>();

    public CheckBox.OnCheckedChangeListener checkedChange;

    //获取物品分类
    public void getGoodsClass(BaseObserver2 baseObserver2) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        OkGoUtil.postRequest(ApiAddress.URL_POST_GET_GOODS_CLASS, params, baseObserver2);
    }

    //获取物品参数类型
    public void getGoodsType(String gcId, String typeId, BaseObserver2 baseObserver2) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("gc_id", gcId);
        params.put("type_id", typeId);
        OkGoUtil.getRequest(ApiAddress.URL_POST_GET_GOODS_TYPE, params, baseObserver2);
    }

    //上传商品图片
    public BindingCommand showChoiceImgAdviceDialogOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            PopupWindowsUtils.getmInstance().showAdviceDialogPopupWindow(
                    ActivityManager.getInstance().getCurrentActivity(),
                    "支持图片上传、从用户空间添加两种方式发布，支持jpg、jpeg、gif、png格式图片，建议上传尺寸300x300以上、大小4.00M内的图片，上传图片将会自动保存在用户 图片空间的预设分类中",
                    "确定", v -> {
                        PopupWindowsUtils.getmInstance().dismissPopWindow();
                    });
        }
    });
    //商品价格
    public BindingCommand showPriceAdviceDialogOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            PopupWindowsUtils.getmInstance().showAdviceDialogPopupWindow(
                    ActivityManager.getInstance().getCurrentActivity(),
                    "价格必须是0.01~9999999之间的数字，且不能高于市场价", "确定", v -> {
                        PopupWindowsUtils.getmInstance().dismissPopWindow();

                    });
        }
    });
    //商品仓库数量
    public BindingCommand showHouseNumberAdviceDialogOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            PopupWindowsUtils.getmInstance().showAdviceDialogPopupWindow(
                    ActivityManager.getInstance().getCurrentActivity(),
                    "商铺库存数量必须为0~~9999999之间的整数，若启用了库存配置，则系统自动计算商品的总数此处无需卖家填写",
                    "确定", v -> {
                        PopupWindowsUtils.getmInstance().dismissPopWindow();

                    });
        }
    });
    //商品仓库预警数量
    public BindingCommand showSosHouseNumberAdviceDialogOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            PopupWindowsUtils.getmInstance().showAdviceDialogPopupWindow(
                    ActivityManager.getInstance().getCurrentActivity(),
                    "设置最低库存预警值。当库存低于预警值时，商家中心商品类表爷库存列红字提醒", "确定", v -> {
                        PopupWindowsUtils.getmInstance().dismissPopWindow();

                    });

        }
    });
    //商品包裹号
    public BindingCommand showPackageNumberAdviceDialogOnClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            PopupWindowsUtils.getmInstance().showAdviceDialogPopupWindow(
                    ActivityManager.getInstance().getCurrentActivity(),
                    "商品货号是指商家管理商品的编号，买家不可见，最多可输入20个字符，支持输入中文字母数字、_、/、-和小数点",
                    "确定", v -> {
                        PopupWindowsUtils.getmInstance().dismissPopWindow();
                    });
        }
    });

    //添加物品参数类型
    public void addGoodsType(String gcId, int typeId, String name, BaseObserver baseObserver) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("gc_id", gcId);
        params.put("sp_id", typeId);
        params.put("name", name);
        OkGoUtil.getRequest(ApiAddress.URL_POST_ADD_GOODS_TYPE, params, baseObserver);
    }

    //获取区域信息
    public void getArea(BaseObserver baseObserver) {
        OkGoUtil.postRequest(ApiAddress.URL_POST_GET_AREA_BEAN, new HttpParams(), baseObserver);
    }

    //上传图片
    public void ImageUpload(File file, BaseObserver baseObserver) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("name", file);
        OkGoUtil.postRequest(ApiAddress.URL_POST_IMAGE_UPLOAD, params, baseObserver);
    }

    //提交总数据
    public void CommitData(HttpParams params, BaseObserver baseObserver) {
        params.put("key", App.getToken());
        OkGoUtil.postRequest(ApiAddress.URL_POST_SAVE_GOODS, params, baseObserver);
    }

    //编辑商品页面
    public void GetEditInfo(String commonid, BaseObserver baseObserver) {
        HttpParams params = new HttpParams();
        params.put("key", App.getToken());
        params.put("commonid", commonid);
        OkGoUtil.getRequest(ApiAddress.URL_POST_EDIT_GOODS_INFO, params, baseObserver);
    }

    //编辑商品
    public void EditGoodsCommit(HttpParams params, BaseObserver baseObserver) {
        params.put("key", App.getToken());
        OkGoUtil.postRequest(ApiAddress.URL_POST_EDIT_GOODS_COMMIT, params, baseObserver);
    }

}
