package com.aite.jiananseller.bean;

import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/25
 * @description:
 */
public class GetTypeArrayBean {

    private List<ImageArrayBean> image_array;
    private List<ValueArrayBean> value_array;

    public List<ImageArrayBean> getImage_array() {
        return image_array;
    }

    public void setImage_array(List<ImageArrayBean> image_array) {
        this.image_array = image_array;
    }

    public List<ValueArrayBean> getValue_array() {
        return value_array;
    }

    public void setValue_array(List<ValueArrayBean> value_array) {
        this.value_array = value_array;
    }

    public static class ImageArrayBean {
        /**
         * color_id : 859
         * color_val : [{"goods_image":"https://aitecc.com/data/upload/shop/store/goods/32/2019/11/25/32_06280085336813055_240.jpg","bdimg":"2019/11/25/32_06280085336813055.jpg","is_default":1,"goods_image_id":0,"goods_commonid":1820,"store_id":"32","color_id":"859","goods_image_sort":0}]
         */

        private String color_id;
        private List<ColorValBean> color_val;

        public String getColor_id() {
            return color_id;
        }

        public void setColor_id(String color_id) {
            this.color_id = color_id;
        }

        public List<ColorValBean> getColor_val() {
            return color_val;
        }

        public void setColor_val(List<ColorValBean> color_val) {
            this.color_val = color_val;
        }

        public static class ColorValBean {
            /**
             * goods_image : https://aitecc.com/data/upload/shop/store/goods/32/2019/11/25/32_06280085336813055_240.jpg
             * bdimg : 2019/11/25/32_06280085336813055.jpg
             * is_default : 1
             * goods_image_id : 0
             * goods_commonid : 1820
             * store_id : 32
             * color_id : 859
             * goods_image_sort : 0
             */

            private String goods_image;
            private String bdimg;
            private int is_default;
            private int goods_image_id;
            private int goods_commonid;
            private String store_id;
            private String color_id;
            private int goods_image_sort;

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getBdimg() {
                return bdimg;
            }

            public void setBdimg(String bdimg) {
                this.bdimg = bdimg;
            }

            public int getIs_default() {
                return is_default;
            }

            public void setIs_default(int is_default) {
                this.is_default = is_default;
            }

            public int getGoods_image_id() {
                return goods_image_id;
            }

            public void setGoods_image_id(int goods_image_id) {
                this.goods_image_id = goods_image_id;
            }

            public int getGoods_commonid() {
                return goods_commonid;
            }

            public void setGoods_commonid(int goods_commonid) {
                this.goods_commonid = goods_commonid;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getColor_id() {
                return color_id;
            }

            public void setColor_id(String color_id) {
                this.color_id = color_id;
            }

            public int getGoods_image_sort() {
                return goods_image_sort;
            }

            public void setGoods_image_sort(int goods_image_sort) {
                this.goods_image_sort = goods_image_sort;
            }
        }
    }

    public static class ValueArrayBean {
        /**
         * sp_value_id : 859
         * sp_value_name : 带宽1
         */

        private String sp_value_id;
        private String sp_value_name;
        private String goods_image;

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }

        public String getSp_value_id() {
            return sp_value_id;
        }

        public void setSp_value_id(String sp_value_id) {
            this.sp_value_id = sp_value_id;
        }

        public String getSp_value_name() {
            return sp_value_name;
        }

        public void setSp_value_name(String sp_value_name) {
            this.sp_value_name = sp_value_name;
        }
    }
}
