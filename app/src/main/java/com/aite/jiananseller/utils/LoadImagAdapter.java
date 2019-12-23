package com.aite.jiananseller.utils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;

/**
 * @author:TQX
 * @Date: 2019/11/21
 * @description:
 */
public class LoadImagAdapter {
    @BindingAdapter(value = {"src"}, requireAll = false)
    public static void setImageUri(ImageView imageView, Drawable url) {
        if (url != null) {
            //使用Glide框架加载图片
            Glide.with(imageView.getContext())
                    .load(url)
                    .into(imageView);
        }
    }
}
