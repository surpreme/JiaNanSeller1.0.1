package com.aite.jiananseller.bean;

import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/24
 * @description:
 */
public class SpecValBean {


    /**
     * value : [{"sp_value_id":"487","sp_value_name":"红色"},{"sp_value_id":"1057","sp_value_name":"iiii"}]
     * spec_id : 1
     */

    private String spec_id;
    private List<ValueBean> value;

    public String getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(String spec_id) {
        this.spec_id = spec_id;
    }

    public List<ValueBean> getValue() {
        return value;
    }

    public void setValue(List<ValueBean> value) {
        this.value = value;
    }

    public static class ValueBean {
        public ValueBean(String sp_value_id, String sp_value_name) {
            this.sp_value_id = sp_value_id;
            this.sp_value_name = sp_value_name;
        }

        /**
         * sp_value_id : 487
         * sp_value_name : 红色
         */

        private String sp_value_id;
        private String sp_value_name;

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

    @Override
    public String toString() {
        return "SpecValBean{" +
                "spec_id='" + spec_id + '\'' +
                ", value=" + value +
                '}';
    }
}
