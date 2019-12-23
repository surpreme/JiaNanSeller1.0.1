package com.aite.jiananseller.ui.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.aite.jiananseller.bean.SpacePhotoBean;

import java.util.ArrayList;
import java.util.List;

import static com.aite.jiananseller.utils.DisplayUtil.dip2px;

/**
 * @author:TQX
 * @Date: 2019/11/27
 * @description:
 */
public class SpinnerAdapter extends ArrayAdapter<SpacePhotoBean.ClassListBean> {
    Context context;
    List<SpacePhotoBean.ClassListBean> items = new ArrayList<>();

    public SpinnerAdapter(final Context context,
                          final int textViewResourceId, final List<SpacePhotoBean.ClassListBean> items) {
        super(context, textViewResourceId, items);
        this.items = items;
        this.context = context;
    }

    @Override
    public View getDropDownView(final int position, View convertView,
                                ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(
                    android.R.layout.simple_spinner_item, parent, false);
        }
        TextView tv = (TextView) convertView
                .findViewById(android.R.id.text1);
        tv.setText(items.get(position).getAclass_name());
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(12);
        int px2dip = dip2px(context, 7);
        int px2dip2 = dip2px(context, 10);
        tv.setPadding(px2dip2, px2dip, px2dip2, px2dip);
        return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(
                    android.R.layout.simple_spinner_item, parent, false);
        }
        TextView tv = (TextView) convertView
                .findViewById(android.R.id.text1);
        tv.setText(items.get(position).getAclass_name());
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(12);
        return convertView;
    }
}


