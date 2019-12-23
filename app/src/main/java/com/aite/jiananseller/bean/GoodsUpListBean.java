package com.aite.jiananseller.bean;

import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/13
 * @description:
 */
public class GoodsUpListBean {



    private List<GoodsListBean> goods_list;
    /**
     * currency : {"id":"1","name":"美元","symbol":"$","unit":"美元","exchange_rate":"1.0000","is_currency_base":false}
     */

    private CurrencyBean currency;

    public List<GoodsListBean> getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(List<GoodsListBean> goods_list) {
        this.goods_list = goods_list;
    }

    public CurrencyBean getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyBean currency) {
        this.currency = currency;
    }

    public static class GoodsListBean {
        /**
         * commonid : 1626
         * goods_name : 袜子1333
         * gc_id_1 : 643
         * gc_id_2 : 644
         * gc_id_3 : 645
         * goods_image : https://aitecc.com/data/upload/shop/store/goods/32/2019/11/11/32_06268093130597479_240.jpg
         * goods_price : 5.00
         * goods_marketprice : 5.00
         * goods_costprice : 1.00
         * goods_discount : 100
         * goods_storage : 2
         * province_id : 0
         * city_id : 0
         * goods_freight : 0.00
         */

        private String commonid;
        private String goods_name;
        private String gc_id_1;
        private String gc_id_2;
        private String gc_id_3;
        private String goods_image;
        private String goods_price;
        private String goods_marketprice;
        private String goods_costprice;
        private String goods_discount;
        private int goods_storage;
        private int province_id;
        private int city_id;
        private String goods_freight;

        public String getCommonid() {
            return commonid;
        }

        public void setCommonid(String commonid) {
            this.commonid = commonid;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGc_id_1() {
            return gc_id_1;
        }

        public void setGc_id_1(String gc_id_1) {
            this.gc_id_1 = gc_id_1;
        }

        public String getGc_id_2() {
            return gc_id_2;
        }

        public void setGc_id_2(String gc_id_2) {
            this.gc_id_2 = gc_id_2;
        }

        public String getGc_id_3() {
            return gc_id_3;
        }

        public void setGc_id_3(String gc_id_3) {
            this.gc_id_3 = gc_id_3;
        }

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getGoods_marketprice() {
            return goods_marketprice;
        }

        public void setGoods_marketprice(String goods_marketprice) {
            this.goods_marketprice = goods_marketprice;
        }

        public String getGoods_costprice() {
            return goods_costprice;
        }

        public void setGoods_costprice(String goods_costprice) {
            this.goods_costprice = goods_costprice;
        }

        public String getGoods_discount() {
            return goods_discount;
        }

        public void setGoods_discount(String goods_discount) {
            this.goods_discount = goods_discount;
        }

        public int getGoods_storage() {
            return goods_storage;
        }

        public void setGoods_storage(int goods_storage) {
            this.goods_storage = goods_storage;
        }

        public int getProvince_id() {
            return province_id;
        }

        public void setProvince_id(int province_id) {
            this.province_id = province_id;
        }

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public String getGoods_freight() {
            return goods_freight;
        }

        public void setGoods_freight(String goods_freight) {
            this.goods_freight = goods_freight;
        }
    }

    public static class CurrencyBean {
        /**
         * id : 1
         * name : 美元
         * symbol : $
         * unit : 美元
         * exchange_rate : 1.0000
         * is_currency_base : false
         */

        private String id;
        private String name;
        private String symbol;
        private String unit;
        private String exchange_rate;
        private boolean is_currency_base;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getExchange_rate() {
            return exchange_rate;
        }

        public void setExchange_rate(String exchange_rate) {
            this.exchange_rate = exchange_rate;
        }

        public boolean isIs_currency_base() {
            return is_currency_base;
        }

        public void setIs_currency_base(boolean is_currency_base) {
            this.is_currency_base = is_currency_base;
        }
    }
}
