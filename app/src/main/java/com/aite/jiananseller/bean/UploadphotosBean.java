package com.aite.jiananseller.bean;

import android.text.TextUtils;

import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/25
 * @description:
 */
public class UploadphotosBean {
    public UploadphotosBean() {
    }

    @Override
    public String toString() {
        return "UploadphotosBean{" +
                "sp_value_id='" + sp_value_id + '\'' +
                ", color_val=" + color_val +
                '}';
    }

    /**
     * sp_value_id : 859
     * color_val : [{"goods_image":"2019/11/25/32_06280085336813055.jpg","is_default":1,"goods_image_sort":0},{"goods_image":"2019/11/25/32_06280085336813055.jpg","is_default":0,"goods_image_sort":1},{"goods_image":"2019/11/25/32_06280085336813055.jpg","is_default":0,"goods_image_sort":1},{"goods_image":"2019/11/25/32_06280085336813055.jpg","is_default":0,"goods_image_sort":1},{"goods_image":"2019/11/25/32_06280085336813055.jpg","is_default":0,"goods_image_sort":1}]
     */

    private String sp_value_id;
    private List<ColorValBean> color_val;

    public String getSp_value_id() {
        return sp_value_id;
    }

    public void setSp_value_id(String sp_value_id) {
        this.sp_value_id = sp_value_id;
    }

    public List<ColorValBean> getColor_val() {
        return color_val;
    }

    public void setColor_val(List<ColorValBean> color_val) {
        this.color_val = color_val;
    }

    public static class ColorValBean {
        public ColorValBean() {
        }

        /**
         * goods_image : 2019/11/25/32_06280085336813055.jpg
         * is_default : 1
         * goods_image_sort : 0
         */

        private String goods_image;
        private String loadImage;
        private int is_default;
        private int goods_image_sort;
        private boolean isShow;

        public boolean isShow() {
            if (getLoadImage()!=null){
                if (getLoadImage().length()>0){
                    return true ;
                }else {
                    return false;
                }
            }
            return false;
        }

        public void setShow(boolean show) {
            isShow = show;
        }

        public String getLoadImage() {
            return loadImage;
        }

        public void setLoadImage(String loadImage) {
            this.loadImage = loadImage;
        }

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }

        public int getIs_default() {
            return is_default;
        }

        public void setIs_default(int is_default) {
            this.is_default = is_default;
        }

        public int getGoods_image_sort() {
            return goods_image_sort;
        }

        public void setGoods_image_sort(int goods_image_sort) {
            this.goods_image_sort = goods_image_sort;
        }

        @Override
        public String toString() {
            return "ColorValBean{" +
                    "goods_image='" + goods_image + '\'' +
                    ", is_default=" + is_default +
                    ", goods_image_sort=" + goods_image_sort +
                    '}';
        }
    }
}
