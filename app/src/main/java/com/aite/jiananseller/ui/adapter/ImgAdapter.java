package com.aite.jiananseller.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.aite.jiananseller.R;
import com.aite.jiananseller.bean.CheckPhotoBean;
import com.aite.jiananseller.bean.SpacePhotoBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author:TQX
 * @Date: 2019/11/26
 * @description:
 */
public class ImgAdapter extends BaseAdapter {
    private List<SpacePhotoBean.PicListBean> pic_list;
    private Context context;
    private ViewHolder holder;

    public List<CheckPhotoBean> getCheckPhotoBeanList() {
        return checkPhotoBeanList;
    }

    public void setCheckPhotoBeanList(List<CheckPhotoBean> checkPhotoBeanList) {
        this.checkPhotoBeanList = checkPhotoBeanList;
    }

    private List<CheckPhotoBean> checkPhotoBeanList = new ArrayList<>();

    public void setPage(int page) {
        this.page = page;
    }

    private int page;

    public ImgAdapter(Context context, List<SpacePhotoBean.PicListBean> piclist) {
        pic_list = piclist;
        this.context = context;
        for (int i = 0; i < pic_list.size(); i++) {
            pic_list.get(i).setCheck(false);
        }
    }

    public void setNotify() {
        for (int i = 0; i < pic_list.size(); i++) {
            pic_list.get(i).setCheck(false);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return pic_list.size();
    }

    @Override
    public Object getItem(int position) {
        return pic_list == null ? null : pic_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_imgspace, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (pic_list.get(position).isCheck()) {
            holder.ckChooes.setChecked(true);
        } else {
            holder.ckChooes.setChecked(false);
        }
        Glide.with(context).load(pic_list.get(position).getFull_path()).into(holder.ivImg);
//        for (int i = 0; i < checkPhotoBeanList.size(); i++) {
//            if (position == checkPhotoBeanList.get(i).getPosition() && page == checkPhotoBeanList.get(i).getPage()) {
//                holder.ckChooes.setChecked(true);
//            } else {
//                holder.ckChooes.setChecked(false);
//            }
//        }
//        for (CheckPhotoBean checkPhotoBean : checkPhotoBeanList) {
//            if (position == checkPhotoBean.getPosition() && page == checkPhotoBean.getPage()) {
//                holder.ckChooes.setChecked(true);
//            }else {
//                holder.ckChooes.setChecked(false);
//            }
//        }

        holder.ckChooes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    for (int i = 0; i < pic_list.size(); i++) {
                        pic_list.get(i).setCheck(false);
                    }
                    pic_list.get(position).setCheck(true);
                    CheckPhotoBean checkPhotoBean = new CheckPhotoBean();
                    checkPhotoBean.setPage(page);
                    checkPhotoBean.setPosition(position);
                    checkPhotoBean.setName(pic_list.get(position).getApic_name());
                    checkPhotoBean.setUrl(pic_list.get(position).getFull_path());
                    checkPhotoBeanList.add(checkPhotoBean);
                    notifyDataSetChanged();
                } else {
                    for (int i = 0; i < checkPhotoBeanList.size(); i++) {
                        if (position == checkPhotoBeanList.get(i).getPosition()) {
                            checkPhotoBeanList.remove(i);
                            break;
                        }
                    }
                }

            }
        });
//        holder.ivImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //选择图片
//                if (holder.ckChooes.isChecked()) {
//                    holder.ckChooes.setChecked(false);
//                } else {
//                    holder.ckChooes.setChecked(true);
//                }
//            }
//        });
        return convertView;
    }


    static
    class ViewHolder {
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.ck_chooes)
        CheckBox ckChooes;
        @BindView(R.id.item)
        ConstraintLayout item;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
