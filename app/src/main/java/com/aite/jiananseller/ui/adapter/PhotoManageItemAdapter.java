package com.aite.jiananseller.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.aite.jiananseller.R;
import com.aite.jiananseller.base.BaseRecyclerViewAdapter;
import com.aite.jiananseller.bean.UploadphotosBean;
import com.aite.jiananseller.utils.DisplayUtil;
import com.blankj.rxbus.RxBus;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;

import static com.aite.jiananseller.utils.ClutterUtils.getScreenWidth;

/**
 * @author:TQX
 * @Date: 2019/11/25
 * @description:
 */
public class PhotoManageItemAdapter extends BaseRecyclerViewAdapter<UploadphotosBean.ColorValBean> {
    private Context context;
    private int parentPosition;
    private int itemWidth;
    private  Intent intent;

    public void setDatas(List<UploadphotosBean.ColorValBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    private List<UploadphotosBean.ColorValBean> datas;

    public PhotoManageItemAdapter(Context context, List<UploadphotosBean.ColorValBean> datas, int parentPosition) {
        super(datas);
        this.datas = datas;
        this.context = context;
        this.parentPosition = parentPosition;
    }


    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_rv_photo_manager;
    }

    @Override
    public void convert(VH holder, UploadphotosBean.ColorValBean data, int position) {
        ConstraintLayout item = holder.getView(R.id.item);
        itemWidth = (getScreenWidth(context) - DisplayUtil.dip2px(context, 20)) / 2;
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(itemWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
        item.setLayoutParams(lp);
        ImageView ivPhoto = holder.getView(R.id.iv_photo);
        if (datas.get(position).isShow()) {
            Glide.with(context).load(datas.get(position).getLoadImage()).into(ivPhoto);
            holder.getView(R.id.iv_clean_photo).setVisibility(View.VISIBLE);
        } else {
            Glide.with(context).load(R.drawable.release_noimg).into(ivPhoto);
            holder.getView(R.id.iv_clean_photo).setVisibility(View.GONE);
        }
        TextView tvUpdata =  holder.getView(R.id.tv_updata);
        tvUpdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onUpDataListner!=null){
                    onUpDataListner.result(parentPosition,position);
                }
                if (intent==null){
                    intent = new Intent();
                }
//                intent.putExtra("parentPosition", parentPosition);
//                intent.putExtra("position", position);
//                RxBus.getDefault().post(intent, "updataPhoto");
            }
        });
        if (datas.get(position).getIs_default() == 1) {

        } else {

        }
        holder.getView(R.id.iv_clean_photo).setOnClickListener(v -> {
            if (onCleanPhotoListner != null) {
                onCleanPhotoListner.result(position);
            }
        });

    }

    public interface OnCleanPhotoListner {
        void result(int position);
    }

    public void setOnCleanPhotoListner(OnCleanPhotoListner onCleanPhotoListner) {
        this.onCleanPhotoListner = onCleanPhotoListner;
    }

    public OnCleanPhotoListner onCleanPhotoListner = null;


    public interface OnUpDataListner{
        void result(int position ,int childPositon);
    }

    public void setOnUpDataListner(OnUpDataListner onUpDataListner) {
        this.onUpDataListner = onUpDataListner;
    }

    public OnUpDataListner onUpDataListner = null;


}
