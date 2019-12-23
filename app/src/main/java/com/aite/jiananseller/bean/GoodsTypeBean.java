package com.aite.jiananseller.bean;

import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/22
 * @description:
 */
public class GoodsTypeBean {

    private List<PlateListBean> plate_list;
    private List<StoreGoodsClassBean> store_goods_class;
    private List<BrandListBean> brand_list;
    private List<AttrListBean> attr_list;
    private List<SpecListBean> spec_list;

    public List<PlateListBean> getPlate_list() {
        return plate_list;
    }

    public void setPlate_list(List<PlateListBean> plate_list) {
        this.plate_list = plate_list;
    }

    public List<StoreGoodsClassBean> getStore_goods_class() {
        return store_goods_class;
    }

    public void setStore_goods_class(List<StoreGoodsClassBean> store_goods_class) {
        this.store_goods_class = store_goods_class;
    }

    public List<BrandListBean> getBrand_list() {
        return brand_list;
    }

    public void setBrand_list(List<BrandListBean> brand_list) {
        this.brand_list = brand_list;
    }

    public List<AttrListBean> getAttr_list() {
        return attr_list;
    }

    public void setAttr_list(List<AttrListBean> attr_list) {
        this.attr_list = attr_list;
    }

    public List<SpecListBean> getSpec_list() {
        return spec_list;
    }

    public void setSpec_list(List<SpecListBean> spec_list) {
        this.spec_list = spec_list;
    }

    public static class PlateListBean {
        /**
         * plate_id : 11
         * plate_name : 底部1
         * plate_position : 0
         */

        private String plate_id;
        private String plate_name;
        private String plate_position;

        public String getPlate_id() {
            return plate_id;
        }

        public void setPlate_id(String plate_id) {
            this.plate_id = plate_id;
        }

        public String getPlate_name() {
            return plate_name;
        }

        public void setPlate_name(String plate_name) {
            this.plate_name = plate_name;
        }

        public String getPlate_position() {
            return plate_position;
        }

        public void setPlate_position(String plate_position) {
            this.plate_position = plate_position;
        }
    }

    public static class StoreGoodsClassBean {
        /**
         * stc_id : 66
         * stc_name : 女装
         * child : [{"stc_id":"67","stc_name_bak":"风衣","stc_parent_id":"66","stc_state":"1","store_id":"32","stc_sort":"0","stc_image":null,"language_id":"2","stc_name":"风衣"},{"stc_id":"88","stc_name_bak":"","stc_parent_id":"66","stc_state":"1","store_id":"32","stc_sort":"0","stc_image":"","language_id":"2","stc_name":"棉衣"}]
         */

        private String stc_id;
        private String stc_name;
        private List<ChildBean> child;

        public String getStc_id() {
            return stc_id;
        }

        public void setStc_id(String stc_id) {
            this.stc_id = stc_id;
        }

        public String getStc_name() {
            return stc_name;
        }

        public void setStc_name(String stc_name) {
            this.stc_name = stc_name;
        }

        public List<ChildBean> getChild() {
            return child;
        }

        public void setChild(List<ChildBean> child) {
            this.child = child;
        }

        public static class ChildBean {
            /**
             * stc_id : 67
             * stc_name_bak : 风衣
             * stc_parent_id : 66
             * stc_state : 1
             * store_id : 32
             * stc_sort : 0
             * stc_image : null
             * language_id : 2
             * stc_name : 风衣
             */

            private String stc_id;
            private String stc_name_bak;
            private String stc_parent_id;
            private String stc_state;
            private String store_id;
            private String stc_sort;
            private Object stc_image;
            private String language_id;
            private String stc_name;

            public String getStc_id() {
                return stc_id;
            }

            public void setStc_id(String stc_id) {
                this.stc_id = stc_id;
            }

            public String getStc_name_bak() {
                return stc_name_bak;
            }

            public void setStc_name_bak(String stc_name_bak) {
                this.stc_name_bak = stc_name_bak;
            }

            public String getStc_parent_id() {
                return stc_parent_id;
            }

            public void setStc_parent_id(String stc_parent_id) {
                this.stc_parent_id = stc_parent_id;
            }

            public String getStc_state() {
                return stc_state;
            }

            public void setStc_state(String stc_state) {
                this.stc_state = stc_state;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getStc_sort() {
                return stc_sort;
            }

            public void setStc_sort(String stc_sort) {
                this.stc_sort = stc_sort;
            }

            public Object getStc_image() {
                return stc_image;
            }

            public void setStc_image(Object stc_image) {
                this.stc_image = stc_image;
            }

            public String getLanguage_id() {
                return language_id;
            }

            public void setLanguage_id(String language_id) {
                this.language_id = language_id;
            }

            public String getStc_name() {
                return stc_name;
            }

            public void setStc_name(String stc_name) {
                this.stc_name = stc_name;
            }
        }
    }

    public static class BrandListBean {
        /**
         * brand_id : 49
         * brand_name : 波司登
         * brand_initial : B
         */

        private String brand_id;
        private String brand_name;
        private String brand_initial;

        public String getBrand_id() {
            return brand_id;
        }

        public void setBrand_id(String brand_id) {
            this.brand_id = brand_id;
        }

        public String getBrand_name() {
            return brand_name;
        }

        public void setBrand_name(String brand_name) {
            this.brand_name = brand_name;
        }

        public String getBrand_initial() {
            return brand_initial;
        }

        public void setBrand_initial(String brand_initial) {
            this.brand_initial = brand_initial;
        }
    }

    public static class AttrListBean {
        /**
         * attr_id : 16
         * attr_name : 类别
         * value : [{"attr_value_id":"61","attr_value_name":"有机农药"},{"attr_value_id":"62","attr_value_name":"植物性农药"},{"attr_value_id":"63","attr_value_name":"赤霉素"}]
         */

        private int attr_id;
        private String attr_name;
        private List<ValueBean> value;

        public int getAttr_id() {
            return attr_id;
        }

        public void setAttr_id(int attr_id) {
            this.attr_id = attr_id;
        }

        public String getAttr_name() {
            return attr_name;
        }

        public void setAttr_name(String attr_name) {
            this.attr_name = attr_name;
        }

        public List<ValueBean> getValue() {
            return value;
        }

        public void setValue(List<ValueBean> value) {
            this.value = value;
        }

        public static class ValueBean {
            /**
             * attr_value_id : 61
             * attr_value_name : 有机农药
             */

            private String attr_value_id;
            private String attr_value_name;

            public String getAttr_value_id() {
                return attr_value_id;
            }

            public void setAttr_value_id(String attr_value_id) {
                this.attr_value_id = attr_value_id;
            }

            public String getAttr_value_name() {
                return attr_value_name;
            }

            public void setAttr_value_name(String attr_value_name) {
                this.attr_value_name = attr_value_name;
            }
        }
    }

    public static class SpecListBean {
        /**
         * sp_id : 1
         * sp_name : 带宽
         * sp_format : null
         * value : [{"sp_value_id":"878","sp_value_name":"12","sp_value_color":null}]
         */

        private int sp_id;
        private String sp_name;
        private Object sp_format;
        private List<ValueBeanX> value;

        public int getSp_id() {
            return sp_id;
        }

        public void setSp_id(int sp_id) {
            this.sp_id = sp_id;
        }

        public String getSp_name() {
            return sp_name;
        }

        public void setSp_name(String sp_name) {
            this.sp_name = sp_name;
        }

        public Object getSp_format() {
            return sp_format;
        }

        public void setSp_format(Object sp_format) {
            this.sp_format = sp_format;
        }

        public List<ValueBeanX> getValue() {
            return value;
        }

        public void setValue(List<ValueBeanX> value) {
            this.value = value;
        }

        public static class ValueBeanX {
            /**
             * sp_value_id : 878
             * sp_value_name : 12
             * sp_value_color : null
             */

            private String sp_value_id;
            private String sp_value_name;
            private Object sp_value_color;

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

            public Object getSp_value_color() {
                return sp_value_color;
            }

            public void setSp_value_color(Object sp_value_color) {
                this.sp_value_color = sp_value_color;
            }
        }
    }
}
