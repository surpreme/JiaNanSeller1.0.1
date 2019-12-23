package com.aite.jiananseller.ui.activity.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;

import com.aite.jiananseller.R;
import com.aite.jiananseller.app.App;
import com.aite.jiananseller.app.Common;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.base.BaseObserver2;
import com.aite.jiananseller.bean.AreaBean;
import com.aite.jiananseller.bean.AreaJsonBean;
import com.aite.jiananseller.bean.CommonBean;
import com.aite.jiananseller.bean.EditGoodsInfoBean;
import com.aite.jiananseller.bean.GoodsTypeBean;
import com.aite.jiananseller.bean.GoosClassBean;
import com.aite.jiananseller.bean.JsonBean;
import com.aite.jiananseller.bean.SpecBean;
import com.aite.jiananseller.bean.SpecNameBean;
import com.aite.jiananseller.bean.SpecValBean;
import com.aite.jiananseller.bean.UploadBean;
import com.aite.jiananseller.databinding.ActivityEditGoodsBinding;
import com.aite.jiananseller.ui.adapter.GoodsTypeAdapter;
import com.aite.jiananseller.ui.adapter.NotePhotoAdapter;
import com.aite.jiananseller.ui.customview.MMAlertDialog;
import com.aite.jiananseller.ui.vm.main.EditGoodsViewModel;
import com.aite.jiananseller.utils.BeanConvertor;
import com.aite.jiananseller.utils.Bit2FileUtils;
import com.alibaba.fastjson.JSON;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.rxbus.RxBus;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.lzy.okgo.model.HttpParams;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * @author:TQX
 * @Date: 2019/11/7
 * @description: 设置
 */
public class EditGoodsActivity extends BaseActivity<ActivityEditGoodsBinding, EditGoodsViewModel> {

    private NotePhotoAdapter photoAdapter;
    private GoodsTypeAdapter goodsTypeAdapter;
    private List<File> showImageList = new ArrayList<>();
    private String parentFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "JHDIMage";
    private String receipt = parentFilePath + File.separator + "receipt";
    private List<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<List<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> allTypelist = new ArrayList<>();
    private ArrayList<String> newTypeList = new ArrayList<>();
    private List<GoosClassBean.GoodsClassBean> classBeanList = new ArrayList<>();
    private OptionsPickerView pvGoods;
    private String goodClass1, goodClass2, goodClass3, AreaId, CityId, commonid;
    private int type = 0;//0新增商品 1修改编辑商品
    private String gcId, typeId, className, cateId;
    private List<GoodsTypeBean.SpecListBean> specListBeans;
    private List<SpecBean> specBeanList = new ArrayList<>();
    private List<SpecNameBean> specNameBeanList = new ArrayList<>();
    private List<SpecValBean> specValList = new ArrayList<>();

    private OptionsPickerView pvArea;
    private List<AreaJsonBean> area1Items = new ArrayList<>();
    private List<List<String>> area2Items = new ArrayList<>();
    private List<String> FileUrlList = new ArrayList<>();

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_edit_goods;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        specListBeans = new ArrayList<>();
        commonid = getIntent().getStringExtra("goodsId");
        type = getIntent().getIntExtra("type", 0);
        setView();
        if (type == 1) {
            getEditInfo();
            binding.clEditBar.setVisibility(View.VISIBLE);
            binding.tvEditPhoto.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putInt("commonId", Integer.parseInt(commonid));
                startActivity(UploadGoodsTypsPhotoActivity.class, bundle);
            });
        } else {

        }
        getGoodClass();
        getAreaBean();
    }


    private void setView() {
        binding.title.tvTitle.setText("编辑商品");
        binding.title.tvTitle.setOnClickListener((v) -> {
            startActivity(SpacePhotoActivity.class);
            finish();
        });
        binding.title.ivReturn.setOnClickListener(viewModel.onBackOnClick);
        binding.tvAddPhone.setOnClickListener((v) -> showPhotoType());
        binding.tvProvince.setOnClickListener((v) -> pvArea.show());
        binding.tvCity.setOnClickListener((v) -> pvArea.show());
        binding.tvClassifyEdit.setOnClickListener((v) -> pvGoods.show());
        binding.btCommit.setOnClickListener((v) -> {
            if (type == 1) {
                commitEdit();
            } else {
                upLoadData();
            }
        });
        binding.tvEditRule.setOnClickListener(new View.OnClickListener() {//跳转参数编辑
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("AllList", allTypelist);
                Intent intent = new Intent(EditGoodsActivity.this, GroupListActivity.class);
                intent.putExtra("bundle", bundle);
                startActivityForResult(intent, 101);
            }
        });
//        binding.btCommit.setOnClickListener((v) -> commitData());
        photoAdapter = new NotePhotoAdapter(this, R.drawable.add_photo, showImageList);
        photoAdapter.setMaxSize(5);
        photoAdapter.setOnDeleltePhotoListner(new NotePhotoAdapter.OnDeleltePhotoListner() {
            @Override
            public void result(int position) {
                showImageList.remove(position);
                photoAdapter.notifyDataSetChanged();
                if (showImageList.size() == 0) {
                    binding.tvAddPhone.setVisibility(View.VISIBLE);
                    binding.gvPhoto.setVisibility(View.GONE);
                }
            }
        });
        binding.gvPhoto.setAdapter(photoAdapter);
        binding.gvPhoto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == showImageList.size()) {
                    showPhotoType();
                }
            }
        });
        //物品选择器
        pvGoods = new OptionsPickerBuilder(EditGoodsActivity.this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                String class1Name = classBeanList.get(options1).getGc_name_bak();
                if (options1Items.get(options1).getCityList() != null) {
                    String class2Name = classBeanList.get(options1).getClass2().get(option2).getGc_name_bak();
                    if (options2Items.get(option2).size() > 0) {
                        String class3Name = classBeanList.get(options1).getClass2().get(option2).getClass3().get(options3).getGc_name_bak();
                        gcId = classBeanList.get(options1).getClass2().get(option2).getClass3().get(options3).getGc_id();
                        typeId = classBeanList.get(options1).getClass2().get(option2).getClass3().get(options3).getType_id();
                        className = class1Name + ">" + class2Name + ">" + class3Name;

                    } else {
                        gcId = classBeanList.get(options1).getClass2().get(option2).getGc_id();
                        typeId = classBeanList.get(options1).getClass2().get(option2).getType_id();
                        className = class1Name + ">" + class2Name;
                    }
                } else {
                    gcId = classBeanList.get(options1).getGc_id();
                    typeId = classBeanList.get(options1).getType_id();
                    className = class1Name;
                }
                binding.tvGoodsClassify.setText(className);
                getGoodsType();
//                viewModel.getGoodsType();
                //返回的分别是三个级别的选中位置
            }
        }).setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
            @Override
            public void onOptionsSelectChanged(int options1, int options2, int options3) {
                String str = "options1: " + options1 + "\noptions2: " + options2 + "\noptions3: " + options3;
            }
        })
                .setSubmitText("确定")//确定按钮文字
                .setSubmitColor(getResources().getColor(R.color.colorMain))
                .setCancelText("取消")//取消按钮文字
                .setCancelColor(Color.parseColor("#ff222222"))
                .setDividerColor(Color.WHITE)
                .setTitleBgColor(Color.WHITE)
                .setTextColorCenter(Color.parseColor("#FFFF8400")) //设置选中项文字颜色
                .setTextColorOut(Color.parseColor("#33777777"))
                .setContentTextSize(20)
                .setSelectOptions(0, 0, 0)  //设置默认选中项
                .build();
        goodsTypeAdapter = new GoodsTypeAdapter(this, specListBeans);
        goodsTypeAdapter.setOnOnAddTypeListner(new GoodsTypeAdapter.OnAddTypeListner() {
            @Override
            public void result(int sp_id) {

                MMAlertDialog.showAddTypeDialog(EditGoodsActivity.this, "", "取消", "确定", true,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }, new MMAlertDialog.OnAddTypeListner() {
                            @Override
                            public void onClick(String name) {
                                addGoodsType(sp_id, name);

                            }
                        });
            }
        });
        binding.rvType.setLayoutManager(new LinearLayoutManager(this));
        binding.rvType.setAdapter(goodsTypeAdapter);
        goodsTypeAdapter.setOnReturnTypeListListner(new GoodsTypeAdapter.OnReturnTypeListListner() {
            @Override
            public void result(List<List<GoodsTypeBean.SpecListBean.ValueBeanX>> Alllist) {
                for (List<GoodsTypeBean.SpecListBean.ValueBeanX> stringList : Alllist) {
                    if (stringList.size() == 0) {
                        binding.tvEditRule.setVisibility(View.GONE);
                        return;
                    } else {
                        binding.tvEditRule.setVisibility(View.VISIBLE);
                        allTypelist.clear();
                        specValList.clear();
                        for (int i = 0; i < Alllist.size(); i++) {
                            allTypelist.add(new ArrayList<>());
                            SpecValBean specValBean = new SpecValBean();
                            specValBean.setSpec_id(specNameBeanList.get(i).getSpec_id() + "");
                            specValBean.setValue(new ArrayList<>());
                            for (int i1 = 0; i1 < Alllist.get(i).size(); i1++) {
                                specValBean.getValue().add(new SpecValBean.ValueBean(Alllist.get(i).get(i1).getSp_value_id(), Alllist.get(i).get(i1).getSp_value_name()));
                                allTypelist.get(i).add(Alllist.get(i).get(i1).getSp_value_name());
                            }
                            specValList.add(specValBean);
                        }
                    }
                }
            }
        });


        //地区选择器
        pvArea = new OptionsPickerBuilder(EditGoodsActivity.this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置

                AreaId = area1Items.get(options1).getId();
                CityId = area1Items.get(options1).getCityList().get(option2).getId();
                binding.tvProvince.setText(area1Items.get(options1).getName());
                binding.tvCity.setText(area1Items.get(options1).getCityList().get(option2).getName());
            }
        }).setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
            @Override
            public void onOptionsSelectChanged(int options1, int options2, int options3) {
                String str = "options1: " + options1 + "\noptions2: " + options2 + "\noptions3: " + options3;
            }
        })
                .setSubmitText("确定")//确定按钮文字
                .setTitleText("地区选择")
                .setSubmitColor(getResources().getColor(R.color.colorMain))
                .setCancelText("取消")//取消按钮文字
                .setCancelColor(Color.parseColor("#ff222222"))
                .setDividerColor(Color.WHITE)
                .setTitleBgColor(Color.WHITE)
                .setTextColorCenter(Color.parseColor("#FFFF8400")) //设置选中项文字颜色
                .setTextColorOut(Color.parseColor("#33777777"))
                .setContentTextSize(20)
                .setSelectOptions(0, 0, 0)  //设置默认选中项
                .build();
        RxBus.getDefault().subscribe(this, "spacePhoto", new RxBus.Callback<File>() {
            @Override
            public void onEvent(File file) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showImageList.add(file);
                        if (showImageList.size() > 0) {
                            binding.tvAddPhone.setVisibility(View.GONE);
                            binding.gvPhoto.setVisibility(View.VISIBLE);
                        } else {
                            binding.tvAddPhone.setVisibility(View.VISIBLE);
                            binding.gvPhoto.setVisibility(View.GONE);
                        }
                        photoAdapter.setList(showImageList);
                    }
                });

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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
                        binding.tvAddPhone.setVisibility(View.GONE);
                        binding.gvPhoto.setVisibility(View.VISIBLE);
                    } else {
                        binding.tvAddPhone.setVisibility(View.VISIBLE);
                        binding.gvPhoto.setVisibility(View.GONE);
                    }
                    for (LocalMedia localMedia : selectList) {
                        if (localMedia.isCompressed()) {
                            if (showImageList.size() < 5) {
                                showImageList.add(new File(localMedia.getCompressPath()));
                            } else {
                                ToastUtils.showShort("只能上传五张图片");
                            }
                        }
                    }
                    photoAdapter.setList(showImageList);
                    break;
                case 101:
                    specBeanList = BeanConvertor.convertList(data.getStringExtra("resultList"), SpecBean.class);
                    String name = "";
                    for (int i = 0; i < specBeanList.size(); i++) {
                        for (int i1 = 0; i1 < specBeanList.get(i).getValue().size(); i1++) {
                            for (int j = 0; j < specListBeans.size(); j++) {
//                                specBeanList.get(i).setSp_value_color(specListBeans.get(i).getValue().get(0).getSp_value_id());
                                specBeanList.get(i).setSp_value_color(specBeanList.get(i).getValue().get(0).getSp_value_id());
                                for (GoodsTypeBean.SpecListBean.ValueBeanX valueBeanX : specListBeans.get(j).getValue()) {
                                    if (valueBeanX.getSp_value_name().equals(specBeanList.get(i).getValue().get(i1).getSp_value_name())) {
                                        specBeanList.get(i).getValue().get(i1).setSp_value_id(valueBeanX.getSp_value_id());
                                    }
                                }
                            }
                        }
                    }
                    break;
                case Common.PORT_RESULT_PHOTO:
                    if (showImageList.size() < 5) {
                        String photourl = data.getStringExtra("PhotoUrl");
                        String photoName = data.getStringExtra("PhotoName");
                        saveUrlToFlie(photourl, photoName);
                    } else {
                        ToastUtils.showShort("只能上传五张图片");
                    }

                    break;
            }
        }
    }

    //保存网络照片显示
    private void saveUrlToFlie(String photourl, String photoName) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (!TextUtils.isEmpty(photourl)) {
                        File photo = Glide.with(EditGoodsActivity.this)
                                .load(photourl)
                                .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                                .get();
//获取到下载得到的图片，进行本地保存
                        File pictureFolder = Environment.getExternalStorageDirectory();
                        //第二个参数为你想要保存的目录名称
                        File appDir = new File(pictureFolder, "your_picture_save_path");
                        if (!appDir.exists()) {
                            appDir.mkdirs();
                        }
                        String fileName = "";
                        if (photoName.endsWith(".jpg")) {
                            photoName.replace(".jpg", "");
                        }
                        fileName = System.currentTimeMillis() + ".jpg";

                        File destFile = new File(appDir, fileName);
                        //把gilde下载得到图片复制到定义好的目录中去
                        Bit2FileUtils.copy(photo, destFile);
                        RxBus.getDefault().post(destFile, "spacePhoto");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //获取照片
    private void takePicture() {
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

    //获取物品分类
    private void getGoodClass() {
        viewModel.getGoodsClass(new BaseObserver2<GoosClassBean>() {
            @Override
            protected void onSuccees(GoosClassBean goosClassBean) throws Exception {
                classBeanList.clear();
                classBeanList = BeanConvertor.convertList(goosClassBean.getGoods_class(), GoosClassBean.GoodsClassBean.class);
                for (int i = 0; i < classBeanList.size(); i++) {
                    JsonBean jsonBean = new JsonBean();
                    jsonBean.setName(classBeanList.get(i).getGc_name_bak());
                    jsonBean.setCityList(new ArrayList<>());
                    if (classBeanList.get(i).getClass2().size() == 0) {
                        jsonBean.getCityList().add(new JsonBean.TowClassBean());
                    }
                    for (GoosClassBean.GoodsClassBean.Class2Bean class2Bean : classBeanList.get(i).getClass2()) {
                        JsonBean.TowClassBean towClassBean = new JsonBean.TowClassBean();
                        towClassBean.setTwoClass(class2Bean.getGc_name_bak());
                        towClassBean.setThreeClass(new ArrayList<>());
                        for (GoosClassBean.GoodsClassBean.Class2Bean.Class3Bean class3Bean : class2Bean.getClass3()) {
                            String threeClass = class3Bean.getGc_name_bak();
                            towClassBean.getThreeClass().add(threeClass);
                        }
                        jsonBean.getCityList().add(towClassBean);
                    }
                    options1Items.add(jsonBean);
                }
                for (JsonBean item : options1Items) {
                    ArrayList<String> cityList = new ArrayList<>();//该省的城市列表（第二级）
                    for (int i1 = 0; i1 < item.getCityList().size(); i1++) {
                        cityList.add(item.getCityList().get(i1).getTwoClass());
                    }
                    options2Items.add(cityList);
                }
                for (JsonBean item : options1Items) {
                    ArrayList<ArrayList<String>> threeClass = new ArrayList<>();
                    for (int i1 = 0; i1 < item.getCityList().size(); i1++) {
                        threeClass.add(new ArrayList<>());
                        if (item.getCityList().get(i1).getThreeClass() != null) {
                            for (int i = 0; i < item.getCityList().get(i1).getThreeClass().size(); i++) {
                                threeClass.get(i1).add(item.getCityList().get(i1).getThreeClass().get(i));
                            }
                        }

                    }
                    options3Items.add(threeClass);
                }
                pvGoods.setPicker(options1Items, options2Items, options3Items);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (type == 0) {
                            pvGoods.show();
                        }

                    }
                });
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

    //获取物品类型
    private void getGoodsType() {
        viewModel.getGoodsType(gcId, typeId, new BaseObserver2<GoodsTypeBean>() {
            @Override
            protected void onSuccees(GoodsTypeBean o) throws Exception {
                specListBeans.clear();
                specListBeans.addAll(o.getSpec_list());
                goodsTypeAdapter.setDate(specListBeans);
                goodsTypeAdapter.notifyDataSetChanged();
                for (int i = 0; i < specListBeans.size(); i++) {
                    specNameBeanList.add(new SpecNameBean(specListBeans.get(i).getSp_id(), specListBeans.get(i).getSp_name()));
                }
                if (type == 1) {

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

    //添加物品类型
    private void addGoodsType(int sp_id, String name) {
        viewModel.addGoodsType(gcId, sp_id, name, new BaseObserver<Object>() {
            @Override
            protected void onSuccees(Object o) throws Exception {
                ToastUtils.showShort("添加成功");
                getGoodsType();
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

    //获取区域数据
    private void getAreaBean() {
        viewModel.getArea(new BaseObserver<AreaBean>() {
            @Override
            protected void onSuccees(AreaBean bean) throws Exception {
                for (int i = 0; i < bean.getList().size(); i++) {
                    if (i == 0) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                binding.tvProvince.setText(bean.getList().get(0).getArea_name());
                                binding.tvCity.setText(bean.getList().get(0).getCitylist().get(0).getArea_name());
                            }
                        });
                        AreaId = bean.getList().get(0).getArea_id();
                        CityId = bean.getList().get(0).getCitylist().get(0).getArea_id();
                    }
                    AreaJsonBean Bean = new AreaJsonBean();
                    Bean.setName(bean.getList().get(i).getArea_name());
                    Bean.setId(bean.getList().get(i).getArea_id());
                    Bean.setCityList(new ArrayList<>());
                    for (int i1 = 0; i1 < bean.getList().get(i).getCitylist().size(); i1++) {
                        AreaJsonBean.CityBean cityBean = new AreaJsonBean.CityBean();
                        cityBean.setName(bean.getList().get(i).getCitylist().get(i1).getArea_name());
                        cityBean.setId(bean.getList().get(i).getCitylist().get(i1).getArea_id());
                        Bean.getCityList().add(cityBean);
                    }
                    area1Items.add(Bean);
                }

                for (int i = 0; i < area1Items.size(); i++) {
                    ArrayList<String> cityList = new ArrayList<>();//该省的城市列表（第二级）
                    for (int i1 = 0; i1 < area1Items.get(i).getCityList().size(); i1++) {
                        cityList.add(area1Items.get(i).getCityList().get(i1).getName());
                    }
                    area2Items.add(cityList);
                }
                pvArea.setPicker(area1Items, area2Items);


            }

            @Override
            protected void onIsError(String msg) throws Exception {

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }


        });
    }

    //点击提交
    private void upLoadData() {
        if (showImageList.size() < 1) {
            ToastUtils.showShort("请上传照片");
            return;
        }
        FileUrlList.clear();
        for (File file : showImageList) {
            upLoadImage(file);
        }
    }

    //上传图片
    private void upLoadImage(File file) {
        viewModel.ImageUpload(file, new BaseObserver<UploadBean>() {
            @Override
            protected void onSuccees(UploadBean uploadBean) throws Exception {

                FileUrlList.add(uploadBean.getThumb_name());
                if (FileUrlList.size() == showImageList.size()) {
                    commitData();
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

    //选择图片弹窗
    private void showPhotoType() {
        MMAlertDialog.showChoosePhotoDialog(this, true, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                takePicture();
                dialog.dismiss();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(EditGoodsActivity.this, SpacePhotoActivity.class);
                startActivityForResult(intent, Common.PORT_RESULT_PHOTO);
                dialog.dismiss();
            }
        });
    }

    //上传参数
    private void commitData() {
        HttpParams params = new HttpParams();
//        params.put("commonid");
        params.put("key", App.getToken());
        if (TextUtils.isEmpty(binding.etGoodsName.getText())) {//商品名称
            ToastUtils.showShort("请填写商品名称");
            return;
        } else {
            params.put("g_name", binding.etGoodsName.getText().toString());
        }
        if (TextUtils.isEmpty(binding.etGoodsPrice.getText())) {//商品价格
            ToastUtils.showShort("请填写商品价格");
            return;
        } else {
            params.put("g_price", binding.etGoodsPrice.getText().toString());
        }
        params.put("cate_id", gcId);//分类Id
        params.put("cate_name", className);//分类名称
        params.put("type_id", typeId);//商品类型iD
        params.put("image_path", FileUrlList.get(0));//商品主图
        if (TextUtils.isEmpty(binding.etGoodsSn.getText())) {//	商家货号
            ToastUtils.showShort("请填写商家货号");
            return;
        } else {
            params.put("g_serial", binding.etGoodsSn.getText().toString());
        }
        if (TextUtils.isEmpty(binding.etGoodsWarning.getText())) {//		库存预警值
            ToastUtils.showShort("请填写库存预警值");
            return;
        } else {
            params.put("g_alarm", binding.etGoodsWarning.getText().toString());
        }
        if (binding.cbNeed.isChecked()) {
            params.put("is_vat", 1);
        } else {
            params.put("is_vat", 0);
        }

        params.put("province_id", AreaId);
        params.put("city_id", CityId);
        params.put("sp_name", JSON.toJSONString(specNameBeanList));
        if (specValList.size() < 1) {
            ToastUtils.showShort("请选择商品参数编辑");
            return;
        } else {
            params.put("sp_val", JSON.toJSONString(specValList));
        }
        if (specBeanList.size() < 1) {
            ToastUtils.showShort("请编辑商品参数编辑");
            return;
        } else {
            params.put("spec", JSON.toJSONString(specBeanList));
        }
        if (TextUtils.isEmpty(binding.etGoodsInventory.getText())) {//		库存
            ToastUtils.showShort("请填写商品库存");
            return;
        } else {
            params.put("g_storage", binding.etGoodsInventory.getText().toString());
        }
        String mBody = "";
        for (int i = 0; i < FileUrlList.size(); i++) {
            if (i == 0) {
                mBody = mBody + FileUrlList.get(i);
            } else {
                mBody = mBody + "|" + FileUrlList.get(i);
            }
        }
        params.put("m_body", mBody);
        viewModel.CommitData(params, new BaseObserver<CommonBean>() {
            @Override
            protected void onSuccees(CommonBean o) throws Exception {
                Bundle bundle = new Bundle();
                bundle.putInt("commonId", o.getSuccess());
                startActivity(UploadGoodsTypsPhotoActivity.class, bundle);
                finish();
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

    private void commitEdit(){
        HttpParams params = new HttpParams();
//        params.put("commonid");
        params.put("key", App.getToken());
        if (TextUtils.isEmpty(binding.etGoodsName.getText())) {//商品名称
            ToastUtils.showShort("请填写商品名称");
            return;
        } else {
            params.put("g_name", binding.etGoodsName.getText().toString());
        }
        if (TextUtils.isEmpty(binding.etGoodsPrice.getText())) {//商品价格
            ToastUtils.showShort("请填写商品价格");
            return;
        } else {
            params.put("g_price", binding.etGoodsPrice.getText().toString());
        }
        params.put("cate_id", gcId);//分类Id
        params.put("cate_name", className);//分类名称
        params.put("type_id", typeId);//商品类型iD
        params.put("image_path", FileUrlList.get(0));//商品主图
        if (TextUtils.isEmpty(binding.etGoodsSn.getText())) {//	商家货号
            ToastUtils.showShort("请填写商家货号");
            return;
        } else {
            params.put("g_serial", binding.etGoodsSn.getText().toString());
        }
        if (TextUtils.isEmpty(binding.etGoodsWarning.getText())) {//		库存预警值
            ToastUtils.showShort("请填写库存预警值");
            return;
        } else {
            params.put("g_alarm", binding.etGoodsWarning.getText().toString());
        }
        if (binding.cbNeed.isChecked()) {
            params.put("is_vat", 1);
        } else {
            params.put("is_vat", 0);
        }

        params.put("province_id", AreaId);
        params.put("city_id", CityId);
        params.put("sp_name", JSON.toJSONString(specNameBeanList));
        if (specValList.size() >0) {
            params.put("sp_val", JSON.toJSONString(specValList));
        }
        if (specBeanList.size() >0) {
            params.put("spec", JSON.toJSONString(specBeanList));
        }
        if (TextUtils.isEmpty(binding.etGoodsInventory.getText())) {//		库存
            ToastUtils.showShort("请填写商品库存");
            return;
        } else {
            params.put("g_storage", binding.etGoodsInventory.getText().toString());
        }
        String mBody = "";
        for (int i = 0; i < FileUrlList.size(); i++) {
            if (i == 0) {
                mBody = mBody + FileUrlList.get(i);
            } else {
                mBody = mBody + "|" + FileUrlList.get(i);
            }
        }
        params.put("m_body", mBody);
        viewModel.EditGoodsCommit(params, new BaseObserver<CommonBean>() {
            @Override
            protected void onSuccees(CommonBean o) throws Exception {
                ToastUtils.showShort("保存成功");
                finish();
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


    //获取编辑物品信息
    private void getEditInfo() {
        viewModel.GetEditInfo(commonid, new BaseObserver<EditGoodsInfoBean>() {
            @Override
            protected void onSuccees(EditGoodsInfoBean o) throws Exception {
                gcId = o.getGoods().getGc_id();
                typeId = o.getGoods().getType_id();
                getGoodsType();
                saveUrlToFlie(o.getGoods().getGoods_fullimage(), o.getGoods().getGoods_image());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        binding.etGoodsName.setText(o.getGoods().getGoods_name());
                        binding.etGoodsPrice.setText(o.getGoods().getGoods_price());
                        binding.etGoodsSn.setText(o.getGoods().getGoods_serial());
                        binding.etGoodsWarning.setText(o.getGoods().getGoods_storage_alarm());
                        binding.etGoodsInventory.setText(o.getGoods().getG_storage());
                    }
                });

            }

            @Override
            protected void onIsError(String msg) throws Exception {

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }

        });
    }
}
