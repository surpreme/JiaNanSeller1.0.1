package com.aite.jiananseller.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author:TQX
 * @Date:2019/3/5 000518:12
 * @description:
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.VH> {
    private List<T> mDatas;
    private Class<T> mClass;

    public BaseRecyclerViewAdapter(List<T> datas) {
        this.mDatas = datas;
    }

    public abstract int getLayoutId(int viewType);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return VH.get(parent, getLayoutId(viewType));
    }


    @Override
    public void onBindViewHolder(VH holder, int position) {
        convert(holder, mDatas.get(position), position);
        //通过为条目设置点击事件触发回调

    }

    @Override
    public int getItemCount() {
        return null == mDatas ? 0 : mDatas.size();
    }

    public abstract void convert(VH holder, T data, int position);


    protected static class VH extends RecyclerView.ViewHolder {
        private SparseArray<View> mViews;
        private View mConvertView;

        private VH(View v) {
            super(v);
            mConvertView = v;
            mViews = new SparseArray<>();
        }

        public static VH get(ViewGroup parent, int layoutId) {
            View convertView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
            return new VH(convertView);
        }

        public <T extends View> T getView(int id) {
            View v = mViews.get(id);
            if (v == null) {
                v = mConvertView.findViewById(id);
                mViews.put(id, v);
            }
            return (T) v;
        }

        public void setVisible(int id, int style) {
            View view = getView(id);
            view.setVisibility(style);
        }

        public void setText(int id, String value) {
            TextView view = getView(id);
            view.setText(value);
        }

        public void setImage(int id, String url, Context context) {
            ImageView view = getView(id);
//            XImageLoader.getInstance(context).showImage(String.valueOf(url), view, R.drawable.ic_launcher_background);
        }

        public void onClick(int id, View.OnClickListener clickListener) {
            View view = getView(id);
            view.setOnClickListener(clickListener);
        }

        public void setChecked(int id, boolean isChecked) {
            CheckBox view = getView(id);
            view.setChecked(isChecked);
        }

        public void setLayoutParams(int id, ViewGroup.LayoutParams layoutParams) {
            View view = getView(id);
            view.setLayoutParams(layoutParams);
        }
    }

}
