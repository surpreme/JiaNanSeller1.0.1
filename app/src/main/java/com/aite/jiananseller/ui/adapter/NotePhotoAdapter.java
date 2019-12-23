package com.aite.jiananseller.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.aite.jiananseller.R;
import com.aite.jiananseller.utils.DisplayUtil;
import com.aite.jiananseller.utils.XImageLoader;
import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.aite.jiananseller.utils.ClutterUtils.getScreenWidth;

/**
 * @author:TQX
 * @Date: 2019/7/27
 * @description:
 */
public class NotePhotoAdapter extends ItemAdapter<File> {
    private List<File> fileList;

    private int maxSize;
    private int functionIcon;
    //每个item的宽度
    private int itemWidth;

    private Context context;

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setList(List<File> list) {
        this.fileList = list;
        notifyDataSetChanged();
    }

    public NotePhotoAdapter(Context context, int functionIcon, List<File> fileList) {
        super(context);
        this.functionIcon = functionIcon;
        this.context = context;
        this.fileList = fileList;
        //获取屏幕宽度

    }

    @Override
    public int getCount() {
        int dataSize = fileList == null ? 0 : fileList.size();
        if (dataSize == maxSize) {
            return dataSize;
        }
        return 1 + dataSize;
    }

    @Override
    public File getItem(int position) {
        int dataSize = fileList == null ? 0 : fileList.size();
        if (dataSize == maxSize) {
            return fileList.get(position);
        } else if (position < dataSize) {
            return fileList.get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    protected ItemAdapter.ViewHolder createHolder(int itemType) {
        View layout = LayoutInflater.from(context).inflate(R.layout.layout_order_photo, null);
        return new NoteViewHolder(layout);
    }

    @Override
    protected void bindView(File file, ViewHolder holder, int posiotn) {
        NoteViewHolder h = (NoteViewHolder) holder;
        if (posiotn ==fileList.size()) {// getCount()-1
            h.itemIcon.setImageResource(functionIcon);
            h.itemIcon.setVisibility(View.GONE);
            h.tvAddPhoto.setVisibility(View.VISIBLE);
        } else {
            h.tvAddPhoto.setVisibility(View.GONE);
            h.itemIcon.setVisibility(View.VISIBLE);
            XImageLoader.getInstance(context).showImage(file.getAbsolutePath(), h.itemIcon, functionIcon);
//            Glide.with(context).load(fileList.get(posiotn)).into(h.itemIcon);
        }
        h.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleltePhotoListner.result(posiotn);
            }
        });
    }

    class NoteViewHolder extends ViewHolder {
        @BindView(R.id.iv_photo)
        ImageView itemIcon;
        @BindView(R.id.iv_delete)
        ImageView ivDelete;
        @BindView(R.id.tv_add_phone)
        TextView tvAddPhoto;
        @BindView(R.id.layout)
        ConstraintLayout layout;

        NoteViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            //将屏幕的中间间距为设为10均分3等分
            itemWidth = (getScreenWidth(context) - DisplayUtil.dip2px(context, 20)) / 3;
//            ViewGroup.LayoutParams layoutParams = layout.getLayoutParams();
//            layoutParams.width = itemWidth;
//            layoutParams.height = itemWidth;

            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(itemWidth, itemWidth);
            view.setLayoutParams(lp);
        }
    }

    public interface OnDeleltePhotoListner {
        void result(int position);
    }

    public void setOnDeleltePhotoListner(OnDeleltePhotoListner onDeleltePhotoListner) {
        this.onDeleltePhotoListner = onDeleltePhotoListner;
    }

    public OnDeleltePhotoListner onDeleltePhotoListner = null;
}
