package com.aite.jiananseller.bean;

/**
 * @author:TQX
 * @Date: 2019/11/21
 * @description:
 */
public class BusinessBean {

    /**
     * store_id : 32
     * store_name : aiteshop
     * store_collect : 74
     * all_goods_count : 573
     * store_sales : 945
     * store_avatar : https://aitecc.com/data/upload/shop/store/06265436700768516_sm.jpg
     * store_credit_percent : 100
     * daily_sales : 2
     * today_sales : 0
     * total_money : 17078.01
     * yesterday_money : 123
     * store_customers : 85
     * turnover_rate : 71.76%
     * currency : {"id":"1","name":"美元","symbol":"$","unit":"美元","exchange_rate":"1.0000","is_currency_base":false}
     */

    private String store_id;
    private String store_name;
    private String store_collect;
    private String all_goods_count;
    private String store_sales;
    private String store_avatar;
    private int store_credit_percent;
    private String daily_sales;
    private String today_sales;
    private double total_money;
    private int yesterday_money;
    private int store_customers;
    private String turnover_rate;
    private CurrencyBean currency;

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_collect() {
        return store_collect;
    }

    public void setStore_collect(String store_collect) {
        this.store_collect = store_collect;
    }

    public String getAll_goods_count() {
        return all_goods_count;
    }

    public void setAll_goods_count(String all_goods_count) {
        this.all_goods_count = all_goods_count;
    }

    public String getStore_sales() {
        return store_sales;
    }

    public void setStore_sales(String store_sales) {
        this.store_sales = store_sales;
    }

    public String getStore_avatar() {
        return store_avatar;
    }

    public void setStore_avatar(String store_avatar) {
        this.store_avatar = store_avatar;
    }

    public int getStore_credit_percent() {
        return store_credit_percent;
    }

    public void setStore_credit_percent(int store_credit_percent) {
        this.store_credit_percent = store_credit_percent;
    }

    public String getDaily_sales() {
        return daily_sales;
    }

    public void setDaily_sales(String daily_sales) {
        this.daily_sales = daily_sales;
    }

    public String getToday_sales() {
        return today_sales;
    }

    public void setToday_sales(String today_sales) {
        this.today_sales = today_sales;
    }

    public double getTotal_money() {
        return total_money;
    }

    public void setTotal_money(double total_money) {
        this.total_money = total_money;
    }

    public int getYesterday_money() {
        return yesterday_money;
    }

    public void setYesterday_money(int yesterday_money) {
        this.yesterday_money = yesterday_money;
    }

    public int getStore_customers() {
        return store_customers;
    }

    public void setStore_customers(int store_customers) {
        this.store_customers = store_customers;
    }

    public String getTurnover_rate() {
        return turnover_rate;
    }

    public void setTurnover_rate(String turnover_rate) {
        this.turnover_rate = turnover_rate;
    }

    public CurrencyBean getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyBean currency) {
        this.currency = currency;
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
