package com.aite.jiananseller.ui.activity.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;

import com.aite.jiananseller.R;
import com.aite.jiananseller.app.Common;
import com.aite.jiananseller.base.BaseObserver3;
import com.aite.jiananseller.bean.SpacePhotoBean;
import com.aite.jiananseller.databinding.ActivitySpacePhotoBinding;
import com.aite.jiananseller.ui.adapter.ImgAdapter;
import com.aite.jiananseller.ui.adapter.SpinnerAdapter;
import com.aite.jiananseller.ui.vm.main.SpacePhotoViewModel;
import com.aite.jiananseller.utils.Bit2FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cc.shinichi.library.ImagePreview;
import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @author:TQX
 * @Date: 2019/11/26
 * @description:
 */
public class SpacePhotoActivity extends BaseActivity<ActivitySpacePhotoBinding, SpacePhotoViewModel> {
    private List<SpacePhotoBean.PicListBean> pic_list;
    private ImgAdapter imgAdapter;
    private int pages = 1;
    private int maxPage;
    private List<String> showPhotoList;
    private String chooseid;
    private List<SpacePhotoBean.ClassListBean> classListBeans;
    private SpinnerAdapter spinnerAdapter;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_space_photo;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        pic_list = new ArrayList<>();
        showPhotoList = new ArrayList<>();
        classListBeans = new ArrayList<>();
        imgAdapter = new ImgAdapter(this, pic_list);
        binding.title.tvTitle.setText("空间相册");
        binding.title.ivReturn.setOnClickListener(v->{onBackPressed();});
        binding.btCommit.setOnClickListener(v->{returnPhoto();});
        binding.gvPhoto.setAdapter(imgAdapter);
        binding.gvPhoto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImagePreview
                        .getInstance()
                        // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                        .setContext(SpacePhotoActivity.this)
                        // 设置从第几张开始看（索引从0开始）
                        .setIndex(position)
                        //=================================================================================================
                        // 有三种设置数据集合的方式，根据自己的需求进行三选一：
//                        // 1：第一步生成的imageInfo List
//                        .setImageInfoList(shoeLmageList)
                        // 2：直接传url List
                        .setImageList(showPhotoList)
                        // 3：只有一张图片的情况，可以直接传入这张图片的url
                        //.setImage(String image)
                        //=================================================================================================
                        // 开启预览
                        .start();
            }
        });
        getSpacePhto(pages);
        binding.tvPagerbtn1.setOnClickListener((v) -> {
            pages = 1;
            getSpacePhto(pages);
        });
        binding.tvPagerbtn2.setOnClickListener((v) -> {
            pages--;
            if (pages < 1) {
                pages = 1;
            }
            getSpacePhto(pages);
        });
        binding.tvPagerbtn4.setOnClickListener((v) -> {
            pages++;
            if (pages > maxPage) {
                pages = maxPage;
            }
            getSpacePhto(pages);

        });
        binding.tvPagerbtn5.setOnClickListener((v) -> {
            pages = maxPage;
            getSpacePhto(pages);
        });
        spinnerAdapter = new SpinnerAdapter(SpacePhotoActivity.this,
                android.R.layout.simple_spinner_item, classListBeans);
        binding.spAlbum.setAdapter(spinnerAdapter);
        binding.spAlbum.setSelection(0, true);
        binding.spAlbum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                binding.tvYpsm.setText("用户相册>"+classListBeans.get(position).getAclass_name());
                chooseid = classListBeans.get(position).getAclass_id();
                pages = 1;
                getSpacePhto(pages);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void returnPhoto(){
        if (imgAdapter.getCheckPhotoBeanList().size()>0){
            Intent intent = new Intent();
            intent.putExtra("PhotoUrl",imgAdapter.getCheckPhotoBeanList().get(0).getUrl());
            intent.putExtra("PhotoName",imgAdapter.getCheckPhotoBeanList().get(0).getName());
//            String filePath = Bit2FileUtils.getRealFilePath(this,Uri.parse(imgAdapter.getCheckPhotoBeanList().get(0).getUrl()));
//            intent.putExtra("PhotoFile",filePath);
            setResult(RESULT_OK,intent);
            finish();
        }else {
            ToastUtils.showShort("请选择图片");
        }

    }

    private void getSpacePhto(int page) {
        binding.tvPagerbtn3.setText(pages + "");
        viewModel.getSpacePhoto(page + "", chooseid, new BaseObserver3<SpacePhotoBean>() {
            @Override
            protected void onSuccees(SpacePhotoBean o, boolean hasmore, int page) throws Exception {
                pic_list.clear();
                pic_list.addAll(o.getPic_list());
                imgAdapter.setPage(pages);
                imgAdapter.setNotify();
                maxPage = page;
                showPhotoList.clear();
                for (SpacePhotoBean.PicListBean picListBean : o.getPic_list()) {
                    showPhotoList.add(picListBean.getFull_path());
                }
                if (TextUtils.isEmpty(chooseid)) {
                    classListBeans.addAll(o.getClass_list());
                    chooseid = o.getClass_list().get(0).getAclass_id();
                    spinnerAdapter.notifyDataSetChanged();
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
}
