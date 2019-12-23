package com.aite.jiananseller.bean;

import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/26
 * @description:
 */
public class SpacePhotoBean {

    private List<PicListBean> pic_list;
    private List<ClassListBean> class_list;

    public List<PicListBean> getPic_list() {
        return pic_list;
    }

    public void setPic_list(List<PicListBean> pic_list) {
        this.pic_list = pic_list;
    }

    public List<ClassListBean> getClass_list() {
        return class_list;
    }

    public void setClass_list(List<ClassListBean> class_list) {
        this.class_list = class_list;
    }

    public static class PicListBean {
        /**
         * apic_id : 2966
         * apic_name : 157449504031237
         * apic_tag :
         * aclass_id : 44
         * apic_cover : 2019/11/26/32_06280776582611459.jpeg
         * apic_size : 8944
         * apic_spec : 336x336
         * store_id : 32
         * upload_time : 1574733658
         * full_path : https://aitecc.com/data/upload/shop/store/goods/32/2019/11/26/32_06280776582611459_240.jpeg
         */

        private String apic_id;
        private String apic_name;
        private String apic_tag;
        private String aclass_id;
        private String apic_cover;
        private String apic_size;
        private String apic_spec;
        private String store_id;
        private String upload_time;
        private String full_path;
        private boolean check;

        public boolean isCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        public String getApic_id() {
            return apic_id;
        }

        public void setApic_id(String apic_id) {
            this.apic_id = apic_id;
        }

        public String getApic_name() {
            return apic_name;
        }

        public void setApic_name(String apic_name) {
            this.apic_name = apic_name;
        }

        public String getApic_tag() {
            return apic_tag;
        }

        public void setApic_tag(String apic_tag) {
            this.apic_tag = apic_tag;
        }

        public String getAclass_id() {
            return aclass_id;
        }

        public void setAclass_id(String aclass_id) {
            this.aclass_id = aclass_id;
        }

        public String getApic_cover() {
            return apic_cover;
        }

        public void setApic_cover(String apic_cover) {
            this.apic_cover = apic_cover;
        }

        public String getApic_size() {
            return apic_size;
        }

        public void setApic_size(String apic_size) {
            this.apic_size = apic_size;
        }

        public String getApic_spec() {
            return apic_spec;
        }

        public void setApic_spec(String apic_spec) {
            this.apic_spec = apic_spec;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getUpload_time() {
            return upload_time;
        }

        public void setUpload_time(String upload_time) {
            this.upload_time = upload_time;
        }

        public String getFull_path() {
            return full_path;
        }

        public void setFull_path(String full_path) {
            this.full_path = full_path;
        }
    }

    public static class ClassListBean {
        /**
         * aclass_id : 11
         * aclass_name : 文件夹
         * store_id : 32
         * aclass_des : 文件夹
         * aclass_sort : 2
         * aclass_cover : 2019/01/17/32_06010519614884333.jpg
         * upload_time : 1473231502
         * is_default : 0
         * count : 11
         * full_path : https://aitecc.com/data/upload/shop/store/goods/32/2019/01/17/32_06010519614884333_240.jpg
         */

        private String aclass_id;
        private String aclass_name;
        private String store_id;
        private String aclass_des;
        private String aclass_sort;
        private String aclass_cover;
        private String upload_time;
        private String is_default;
        private String count;
        private String full_path;

        public String getAclass_id() {
            return aclass_id;
        }

        public void setAclass_id(String aclass_id) {
            this.aclass_id = aclass_id;
        }

        public String getAclass_name() {
            return aclass_name;
        }

        public void setAclass_name(String aclass_name) {
            this.aclass_name = aclass_name;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getAclass_des() {
            return aclass_des;
        }

        public void setAclass_des(String aclass_des) {
            this.aclass_des = aclass_des;
        }

        public String getAclass_sort() {
            return aclass_sort;
        }

        public void setAclass_sort(String aclass_sort) {
            this.aclass_sort = aclass_sort;
        }

        public String getAclass_cover() {
            return aclass_cover;
        }

        public void setAclass_cover(String aclass_cover) {
            this.aclass_cover = aclass_cover;
        }

        public String getUpload_time() {
            return upload_time;
        }

        public void setUpload_time(String upload_time) {
            this.upload_time = upload_time;
        }

        public String getIs_default() {
            return is_default;
        }

        public void setIs_default(String is_default) {
            this.is_default = is_default;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getFull_path() {
            return full_path;
        }

        public void setFull_path(String full_path) {
            this.full_path = full_path;
        }
    }
}
