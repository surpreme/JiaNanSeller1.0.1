package com.aite.jiananseller.bean;

import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/24
 * @description:
 */
public class SpecBean {

    public SpecBean() {
    }



    /**
     * sp_value_color : 487
     * value : [{"sp_value_id":"487","sp_value_name":"红色"},{"sp_value_id":"582","sp_value_name":"S"}]
     * alarm : 1
     * sku : 1
     * price : 1
     * stock : 1
     */

    private String sp_value_color;
    private String alarm;
    private String sku;
    private String price;
    private String stock;
    private List<ValueBean> value;

    public String getSp_value_color() {
        return sp_value_color;
    }

    public void setSp_value_color(String sp_value_color) {
        this.sp_value_color = sp_value_color;
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public List<ValueBean> getValue() {
        return value;
    }

    public void setValue(List<ValueBean> value) {
        this.value = value;
    }

    public static class ValueBean {
        public ValueBean() {
        }

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

        @Override
        public String toString() {
            return "ValueBean{" +
                    "sp_value_id='" + sp_value_id + '\'' +
                    ", sp_value_name='" + sp_value_name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "SpecBean{" +
                "sp_value_color='" + sp_value_color + '\'' +
                ", alarm='" + alarm + '\'' +
                ", sku='" + sku + '\'' +
                ", price='" + price + '\'' +
                ", stock='" + stock + '\'' +
                ", value=" + value +
                '}';
    }
}
