package com.aite.jiananseller.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * @author:TQX
 * @Date: 2019/5/18
 * @description:
 */
public class GlideImageLoader extends ImageLoader {
    //显示轮播图片的可以自定义的Imageview控件

    public void displayImage(Context context, Object path, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        imageView.setAdjustViewBounds(true);
        Glide.with(context)
                .load(path)
                .into(imageView);
    }
}
