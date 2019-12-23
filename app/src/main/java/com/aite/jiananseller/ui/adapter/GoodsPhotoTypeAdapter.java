package com.aite.jiananseller.ui.adapter;

import android.content.Context;
import android.content.Intent;

import com.aite.jiananseller.R;
import com.aite.jiananseller.base.BaseRecyclerViewAdapter;
import com.aite.jiananseller.bean.GetTypeArrayBean;
import com.aite.jiananseller.bean.UploadphotosBean;
import com.blankj.rxbus.RxBus;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author:TQX
 * @Date: 2019/11/25
 * @description:
 */
public class GoodsPhotoTypeAdapter extends BaseRecyclerViewAdapter<GetTypeArrayBean.ValueArrayBean> {
    public List<UploadphotosBean> getUpLoadList() {
        return upLoadList;
    }

    public void setUpLoadList(List<UploadphotosBean> UpLoadList) {
        this.upLoadList=UpLoadList;
//        this.upLoadList.addAll(UpLoadList);
        notifyDataSetChanged();
        itemAdapter.notifyDataSetChanged();
    }

    private List<UploadphotosBean> upLoadList;
    private PhotoManageItemAdapter itemAdapter;
    private Context context;

    public GoodsPhotoTypeAdapter(Context context, List<GetTypeArrayBean.ValueArrayBean> datas) {
        super(datas);
        this.context = context;
        upLoadList = new ArrayList<>();

    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.layout_upload_goodstypes_photo_list;
    }

    @Override
    public void convert(VH holder, GetTypeArrayBean.ValueArrayBean data, int position) {
        holder.setText(R.id.tv_type, data.getSp_value_name());
        RecyclerView rvItemPhoto = holder.getView(R.id.rv_photo_manager);
            if (upLoadList.size()==position){
                upLoadList.add(new UploadphotosBean());
                UploadphotosBean.ColorValBean colorValBean = new UploadphotosBean.ColorValBean();
                colorValBean.setShow(true);
                colorValBean.setLoadImage(data.getGoods_image());
                colorValBean.setIs_default(1);
                upLoadList.get(position).setColor_val(new ArrayList<>());
                upLoadList.get(position).getColor_val().add(colorValBean);
                upLoadList.get(position).setSp_value_id(data.getSp_value_id());
                for (int i = 0; i < 4; i++) {
                    upLoadList.get(position).getColor_val().add(new UploadphotosBean.ColorValBean());
                    upLoadList.get(position).getColor_val().get(i + 1).setIs_default(0);
                }
            }

        itemAdapter = new PhotoManageItemAdapter(context, upLoadList.get(position).getColor_val(), position);
        itemAdapter.setOnCleanPhotoListner(new PhotoManageItemAdapter.OnCleanPhotoListner() {
            @Override
            public void result(int childPosition) {
                upLoadList.get(position).getColor_val().get(childPosition).setLoadImage("");
                upLoadList.get(position).getColor_val().get(childPosition).setGoods_image("");
                itemAdapter.setDatas( upLoadList.get(position).getColor_val());
            }
        });
        itemAdapter.setOnUpDataListner(new PhotoManageItemAdapter.OnUpDataListner() {
            @Override
            public void result(int position, int childPositon) {
                onUpDataListner.result(position,childPositon);
            }
        });
        rvItemPhoto.setLayoutManager(new GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false));
        rvItemPhoto.setAdapter(itemAdapter);
    }

    public interface OnUpDataListner{
        void result(int position ,int childPositon);
    }

    public void setOnUpDataListner(OnUpDataListner onUpDataListner) {
        this.onUpDataListner = onUpDataListner;
    }

    public OnUpDataListner onUpDataListner = null;
}
