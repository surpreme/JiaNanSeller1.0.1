package com.aite.jiananseller.ui.activity.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import com.aite.baselibrary.view.util.PopupWindows.PopupWindowsUtils;
import com.aite.jiananseller.R;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.bean.CommonBean;
import com.aite.jiananseller.bean.GetTypeArrayBean;
import com.aite.jiananseller.bean.UploadBean;
import com.aite.jiananseller.bean.UploadphotosBean;
import com.aite.jiananseller.databinding.ActivityUploadGoodstypesPhotoBinding;
import com.aite.jiananseller.ui.adapter.GoodsPhotoTypeAdapter;
import com.aite.jiananseller.ui.vm.main.UploadGoodsTypsPhotoViewModel;
import com.alibaba.fastjson.JSON;
import com.blankj.rxbus.RxBus;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @author:TQX
 * @Date: 2019/11/25
 * @description:
 */
public class UploadGoodsTypsPhotoActivity extends BaseActivity<ActivityUploadGoodstypesPhotoBinding, UploadGoodsTypsPhotoViewModel> {
    private List<GetTypeArrayBean.ValueArrayBean> valueArrayBeans;
    private GoodsPhotoTypeAdapter goodsPhotoTypeAdapter;
    private int position, ChildPosition;
    private String parentFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "JHDIMage";
    private String receipt = parentFilePath + File.separator + "receipt";

    private int commonId;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_upload_goodstypes_photo;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        binding.title.tvTitle.setText("上传商品图片");
        binding.title.ivReturn.setOnClickListener(v -> {
            onBackPressed();
        });
        WaitAdvicePopSplash splash = new WaitAdvicePopSplash();
        splash.execute();
        commonId = getIntent().getIntExtra("commonId", 0);
        valueArrayBeans = new ArrayList<>();
        goodsPhotoTypeAdapter = new GoodsPhotoTypeAdapter(this, valueArrayBeans);
        binding.rvGoodsPhoto.setLayoutManager(new LinearLayoutManager(this));
        binding.rvGoodsPhoto.setAdapter(goodsPhotoTypeAdapter);
        binding.tvCommit.setOnClickListener(v -> {
            saveCommitPhoto();
        });
        viewModel.getTypeArrary(commonId, new BaseObserver<GetTypeArrayBean>() {
            @Override
            protected void onSuccees(GetTypeArrayBean o) throws Exception {
                for (int i = 0; i < o.getValue_array().size(); i++) {
                    o.getValue_array().get(i).setGoods_image(o.getImage_array().get(i).getColor_val().get(0).getGoods_image());
                }
                valueArrayBeans.addAll(o.getValue_array());
                goodsPhotoTypeAdapter.notifyDataSetChanged();
            }

            @Override
            protected void onIsError(String msg) throws Exception {
                ToastUtils.showShort(msg);
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        });
        goodsPhotoTypeAdapter.setOnUpDataListner(new GoodsPhotoTypeAdapter.OnUpDataListner() {
            @Override
            public void result(int position1, int childPositon2) {
                position = position1;
                ChildPosition = childPositon2;
                takePicture();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        RxBus.getDefault().unregister(this);
    }

    public void takePicture() {
        // 进入相册 以下是例子：用不到的api可以不写
        new File(receipt).mkdirs();
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .maxSelectNum(5)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(3)// 每行显示个数 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                .enableCrop(false)// 是否裁剪 true or false
                .compress(true)// 是否压缩 true or false
                .hideBottomControls(false)// 是否显示uCrop工具栏，默认不显示 true or false
                .isGif(false)// 是否显示gif图片 true or false
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(false)// 是否圆形裁剪 true or false
                .showCropFrame(true)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .showCropGrid(true)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                .openClickSound(false)// 是否开启点击声音 true or false
                .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
                .cropCompressQuality(90)// 裁剪压缩质量 默认90 int
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .rotateEnabled(false) // 裁剪是否可旋转图片 true or false
                .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
                .isDragFrame(true)// 是否可拖动裁剪框(固定)
                .compressSavePath(receipt)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    if (selectList.size() > 0) {
                        for (LocalMedia localMedia : selectList) {
                            if (localMedia.isCompressed()) {
                                upLoadPhoto(new File(localMedia.getCompressPath()));
                            }
                        }
                    }

                    break;
            }
        }
    }

    private void upLoadPhoto(File file) {
        viewModel.ImageUpload(file, new BaseObserver<UploadBean>() {
            @Override
            protected void onSuccees(UploadBean o) throws Exception {
                List<UploadphotosBean> UpLoadList = goodsPhotoTypeAdapter.getUpLoadList();
                UpLoadList.get(position).getColor_val().get(ChildPosition).setLoadImage(o.getThumb_name());
                UpLoadList.get(position).getColor_val().get(ChildPosition).setGoods_image(o.getImg_path());
                UpLoadList.get(position).getColor_val().get(ChildPosition).setShow(true);
                goodsPhotoTypeAdapter.setUpLoadList(UpLoadList);
            }

            @Override
            protected void onIsError(String msg) throws Exception {

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }

        });
    }

    private void saveCommitPhoto() {
        viewModel.SaveColorPhoto(commonId, JSON.toJSONString(goodsPhotoTypeAdapter.getUpLoadList()), new BaseObserver<CommonBean>() {
            @Override
            protected void onSuccees(CommonBean o) throws Exception {
                if (o.getSuccess() == 1) {
                    ToastUtils.showShort("上传成功");
                    finish();
                }
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

    /**
     * 弹窗要在界面显示以后才能显示 必须页面先初始化
     */
    private class WaitAdvicePopSplash extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            PopupWindowsUtils.getmInstance().showTwoAdviceDialogPopupWindow(
                    UploadGoodsTypsPhotoActivity.this,
                    R.string.adviceDialogpopinformation,
                    R.string.adviceDialogpopSecondinformation,
                    "确定",
                    v -> {
                        PopupWindowsUtils.getmInstance().dismissPopWindow();

                    }
            );
        }
    }
}