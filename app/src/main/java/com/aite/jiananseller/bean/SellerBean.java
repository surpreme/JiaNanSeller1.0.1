package com.aite.jiananseller.bean;

import java.util.List;

/**
 * @author:lzy
 * @Date: 2019/12/20
 * @description:
 */
public class SellerBean {


    /**
     * store_info : {"store_id":"2","store_name":"泰国精品直销店","grade_id":"1","member_id":"2","member_name":"tg001","seller_name":"tg001","sc_id":"1","store_company_name":"","province_id":"85764","area_info":"泰国曼谷直辖市拍那空县","store_address":"Lam Luk Ka, Lam Luk Ka District, Pathum Thani 1215","store_zip":"","store_state":"1","store_close_info":null,"store_sort":"0","store_time":"1575876443","store_end_time":"1639151999","store_label":"https://piikmall.aitecc.com/data/upload/shop/common/default_store_logo.gif","store_banner":"https://piikmall.aitecc.com/data/upload/shop/common/default_store_mb_banner.gif","store_avatar":"https://piikmall.aitecc.com/data/upload/shop/store/06298927072560248_sm.jpg","store_keywords":"","store_description":"","store_qq":null,"store_ww":null,"store_phone":null,"store_zy":"","store_domain":null,"store_domain_times":"0","store_recommend":"0","store_theme":"default","store_credit":{"store_desccredit":{"text":"描述相符","credit":5,"percent":"----","percent_class":"equal","percent_text":"持平"},"store_servicecredit":{"text":"服务态度","credit":5,"percent":"----","percent_class":"equal","percent_text":"持平"},"store_deliverycredit":{"text":"发货速度","credit":5,"percent":"----","percent_class":"equal","percent_text":"持平"}},"store_desccredit":"0","store_servicecredit":"0","store_deliverycredit":"0","store_collect":"2","store_slide":null,"store_slide_url":null,"store_stamp":null,"store_printdesc":null,"store_sales":"0","store_presales":null,"store_aftersales":null,"store_workingtime":null,"store_free_price":"0.00","store_decoration_switch":"0","store_decoration_only":"0","store_decoration_image_count":"0","live_store_name":null,"live_store_address":"泰国曼谷直辖市拍那空县","live_store_tel":null,"live_store_bus":null,"is_own_shop":"0","bind_all_gc":"0","store_vrcode_prefix":null,"store_baozh":"0","store_baozhopen":"0","store_baozhrmb":"零","store_qtian":"0","store_zhping":"0","store_erxiaoshi":"0","store_tuihuo":"0","store_shiyong":"0","store_shiti":"0","store_xiaoxie":"0","store_huodaofk":"0","store_points":"100.77456640000003,13.9443098","city_id":"85765","area_id":"0","store_type":"0","store_agent_level":null,"store_agent_area_id":"0","rm_id":"0","agent_comm":"0","agent_top":"0","agent_top_top":"0","agent_top_top_top":"0","addrole":"0","store_mb_slide":null,"store_mb_slide_url":null,"store_mb_ad1":null,"store_mb_ad2":null,"store_mb_ad1_url":null,"store_mb_ad2_url":null,"store_mb_banner":null,"store_anli_count":"0","visit_number":"0","introduce":"","store_is_weike":"1","task_price_number":"0","store_bank_info":"","store_industry":"0","store_open_rush":"0","goods_page_show_nav":"1","store_info_remark":null,"country_id":"85763","currency_id":"2","concern_num":"0","goods_count":"7","store_credit_average":5,"store_credit_percent":100,"seller_id":"2","store_end_time_text":"2021-12-10","grade_name":"金牌店铺","grade_goodslimit":"1000","grade_albumlimit":"1000","country_name":"泰国"}
     * daily_sales : 2
     * today_sales : 0
     * monthly_sales : 42
     * phone_array : ["+855978899755","+85511711911"]
     * sold_out : 0
     * all_shop_count : 18
     * onsell : 7
     * total_money : 0
     * Yesterday_total : 50002
     * website_logo : https://piikmall.aitecc.com/data/upload/shop/common/
     * currency : {"id":"2","name":"泰铢","symbol":"฿","unit":"泰铢","exchange_rate":"20.0000","is_currency_base":false}
     * no_delivery : 10
     */

    private StoreInfoBean store_info;
    private String daily_sales;
    private String today_sales;
    private String monthly_sales;
    private String sold_out;
    private String all_shop_count;
    private String onsell;
    private int total_money;
    private int Yesterday_total;
    private String website_logo;
    private CurrencyBean currency;
    private String no_delivery;
    private List<String> phone_array;

    public StoreInfoBean getStore_info() {
        return store_info;
    }

    public void setStore_info(StoreInfoBean store_info) {
        this.store_info = store_info;
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

    public String getMonthly_sales() {
        return monthly_sales;
    }

    public void setMonthly_sales(String monthly_sales) {
        this.monthly_sales = monthly_sales;
    }

    public String getSold_out() {
        return sold_out;
    }

    public void setSold_out(String sold_out) {
        this.sold_out = sold_out;
    }

    public String getAll_shop_count() {
        return all_shop_count;
    }

    public void setAll_shop_count(String all_shop_count) {
        this.all_shop_count = all_shop_count;
    }

    public String getOnsell() {
        return onsell;
    }

    public void setOnsell(String onsell) {
        this.onsell = onsell;
    }

    public int getTotal_money() {
        return total_money;
    }

    public void setTotal_money(int total_money) {
        this.total_money = total_money;
    }

    public int getYesterday_total() {
        return Yesterday_total;
    }

    public void setYesterday_total(int Yesterday_total) {
        this.Yesterday_total = Yesterday_total;
    }

    public String getWebsite_logo() {
        return website_logo;
    }

    public void setWebsite_logo(String website_logo) {
        this.website_logo = website_logo;
    }

    public CurrencyBean getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyBean currency) {
        this.currency = currency;
    }

    public String getNo_delivery() {
        return no_delivery;
    }

    public void setNo_delivery(String no_delivery) {
        this.no_delivery = no_delivery;
    }

    public List<String> getPhone_array() {
        return phone_array;
    }

    public void setPhone_array(List<String> phone_array) {
        this.phone_array = phone_array;
    }

    public static class StoreInfoBean {
        /**
         * store_id : 2
         * store_name : 泰国精品直销店
         * grade_id : 1
         * member_id : 2
         * member_name : tg001
         * seller_name : tg001
         * sc_id : 1
         * store_company_name :
         * province_id : 85764
         * area_info : 泰国曼谷直辖市拍那空县
         * store_address : Lam Luk Ka, Lam Luk Ka District, Pathum Thani 1215
         * store_zip :
         * store_state : 1
         * store_close_info : null
         * store_sort : 0
         * store_time : 1575876443
         * store_end_time : 1639151999
         * store_label : https://piikmall.aitecc.com/data/upload/shop/common/default_store_logo.gif
         * store_banner : https://piikmall.aitecc.com/data/upload/shop/common/default_store_mb_banner.gif
         * store_avatar : https://piikmall.aitecc.com/data/upload/shop/store/06298927072560248_sm.jpg
         * store_keywords :
         * store_description :
         * store_qq : null
         * store_ww : null
         * store_phone : null
         * store_zy :
         * store_domain : null
         * store_domain_times : 0
         * store_recommend : 0
         * store_theme : default
         * store_credit : {"store_desccredit":{"text":"描述相符","credit":5,"percent":"----","percent_class":"equal","percent_text":"持平"},"store_servicecredit":{"text":"服务态度","credit":5,"percent":"----","percent_class":"equal","percent_text":"持平"},"store_deliverycredit":{"text":"发货速度","credit":5,"percent":"----","percent_class":"equal","percent_text":"持平"}}
         * store_desccredit : 0
         * store_servicecredit : 0
         * store_deliverycredit : 0
         * store_collect : 2
         * store_slide : null
         * store_slide_url : null
         * store_stamp : null
         * store_printdesc : null
         * store_sales : 0
         * store_presales : null
         * store_aftersales : null
         * store_workingtime : null
         * store_free_price : 0.00
         * store_decoration_switch : 0
         * store_decoration_only : 0
         * store_decoration_image_count : 0
         * live_store_name : null
         * live_store_address : 泰国曼谷直辖市拍那空县
         * live_store_tel : null
         * live_store_bus : null
         * is_own_shop : 0
         * bind_all_gc : 0
         * store_vrcode_prefix : null
         * store_baozh : 0
         * store_baozhopen : 0
         * store_baozhrmb : 零
         * store_qtian : 0
         * store_zhping : 0
         * store_erxiaoshi : 0
         * store_tuihuo : 0
         * store_shiyong : 0
         * store_shiti : 0
         * store_xiaoxie : 0
         * store_huodaofk : 0
         * store_points : 100.77456640000003,13.9443098
         * city_id : 85765
         * area_id : 0
         * store_type : 0
         * store_agent_level : null
         * store_agent_area_id : 0
         * rm_id : 0
         * agent_comm : 0
         * agent_top : 0
         * agent_top_top : 0
         * agent_top_top_top : 0
         * addrole : 0
         * store_mb_slide : null
         * store_mb_slide_url : null
         * store_mb_ad1 : null
         * store_mb_ad2 : null
         * store_mb_ad1_url : null
         * store_mb_ad2_url : null
         * store_mb_banner : null
         * store_anli_count : 0
         * visit_number : 0
         * introduce :
         * store_is_weike : 1
         * task_price_number : 0
         * store_bank_info :
         * store_industry : 0
         * store_open_rush : 0
         * goods_page_show_nav : 1
         * store_info_remark : null
         * country_id : 85763
         * currency_id : 2
         * concern_num : 0
         * goods_count : 7
         * store_credit_average : 5
         * store_credit_percent : 100
         * seller_id : 2
         * store_end_time_text : 2021-12-10
         * grade_name : 金牌店铺
         * grade_goodslimit : 1000
         * grade_albumlimit : 1000
         * country_name : 泰国
         */

        private String store_id;
        private String store_name;
        private String grade_id;
        private String member_id;
        private String member_name;
        private String seller_name;
        private String sc_id;
        private String store_company_name;
        private String province_id;
        private String area_info;
        private String store_address;
        private String store_zip;
        private String store_state;
        private Object store_close_info;
        private String store_sort;
        private String store_time;
        private String store_end_time;
        private String store_label;
        private String store_banner;
        private String store_avatar;
        private String store_keywords;
        private String store_description;
        private Object store_qq;
        private Object store_ww;
        private Object store_phone;
        private String store_zy;
        private Object store_domain;
        private String store_domain_times;
        private String store_recommend;
        private String store_theme;
        private StoreCreditBean store_credit;
        private String store_desccredit;
        private String store_servicecredit;
        private String store_deliverycredit;
        private String store_collect;
        private Object store_slide;
        private Object store_slide_url;
        private Object store_stamp;
        private Object store_printdesc;
        private String store_sales;
        private Object store_presales;
        private Object store_aftersales;
        private Object store_workingtime;
        private String store_free_price;
        private String store_decoration_switch;
        private String store_decoration_only;
        private String store_decoration_image_count;
        private Object live_store_name;
        private String live_store_address;
        private Object live_store_tel;
        private Object live_store_bus;
        private String is_own_shop;
        private String bind_all_gc;
        private Object store_vrcode_prefix;
        private String store_baozh;
        private String store_baozhopen;
        private String store_baozhrmb;
        private String store_qtian;
        private String store_zhping;
        private String store_erxiaoshi;
        private String store_tuihuo;
        private String store_shiyong;
        private String store_shiti;
        private String store_xiaoxie;
        private String store_huodaofk;
        private String store_points;
        private String city_id;
        private String area_id;
        private String store_type;
        private Object store_agent_level;
        private String store_agent_area_id;
        private String rm_id;
        private String agent_comm;
        private String agent_top;
        private String agent_top_top;
        private String agent_top_top_top;
        private String addrole;
        private Object store_mb_slide;
        private Object store_mb_slide_url;
        private Object store_mb_ad1;
        private Object store_mb_ad2;
        private Object store_mb_ad1_url;
        private Object store_mb_ad2_url;
        private Object store_mb_banner;
        private String store_anli_count;
        private String visit_number;
        private String introduce;
        private String store_is_weike;
        private String task_price_number;
        private String store_bank_info;
        private String store_industry;
        private String store_open_rush;
        private String goods_page_show_nav;
        private Object store_info_remark;
        private String country_id;
        private String currency_id;
        private String concern_num;
        private String goods_count;
        private int store_credit_average;
        private int store_credit_percent;
        private String seller_id;
        private String store_end_time_text;
        private String grade_name;
        private String grade_goodslimit;
        private String grade_albumlimit;
        private String country_name;

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

        public String getGrade_id() {
            return grade_id;
        }

        public void setGrade_id(String grade_id) {
            this.grade_id = grade_id;
        }

        public String getMember_id() {
            return member_id;
        }

        public void setMember_id(String member_id) {
            this.member_id = member_id;
        }

        public String getMember_name() {
            return member_name;
        }

        public void setMember_name(String member_name) {
            this.member_name = member_name;
        }

        public String getSeller_name() {
            return seller_name;
        }

        public void setSeller_name(String seller_name) {
            this.seller_name = seller_name;
        }

        public String getSc_id() {
            return sc_id;
        }

        public void setSc_id(String sc_id) {
            this.sc_id = sc_id;
        }

        public String getStore_company_name() {
            return store_company_name;
        }

        public void setStore_company_name(String store_company_name) {
            this.store_company_name = store_company_name;
        }

        public String getProvince_id() {
            return province_id;
        }

        public void setProvince_id(String province_id) {
            this.province_id = province_id;
        }

        public String getArea_info() {
            return area_info;
        }

        public void setArea_info(String area_info) {
            this.area_info = area_info;
        }

        public String getStore_address() {
            return store_address;
        }

        public void setStore_address(String store_address) {
            this.store_address = store_address;
        }

        public String getStore_zip() {
            return store_zip;
        }

        public void setStore_zip(String store_zip) {
            this.store_zip = store_zip;
        }

        public String getStore_state() {
            return store_state;
        }

        public void setStore_state(String store_state) {
            this.store_state = store_state;
        }

        public Object getStore_close_info() {
            return store_close_info;
        }

        public void setStore_close_info(Object store_close_info) {
            this.store_close_info = store_close_info;
        }

        public String getStore_sort() {
            return store_sort;
        }

        public void setStore_sort(String store_sort) {
            this.store_sort = store_sort;
        }

        public String getStore_time() {
            return store_time;
        }

        public void setStore_time(String store_time) {
            this.store_time = store_time;
        }

        public String getStore_end_time() {
            return store_end_time;
        }

        public void setStore_end_time(String store_end_time) {
            this.store_end_time = store_end_time;
        }

        public String getStore_label() {
            return store_label;
        }

        public void setStore_label(String store_label) {
            this.store_label = store_label;
        }

        public String getStore_banner() {
            return store_banner;
        }

        public void setStore_banner(String store_banner) {
            this.store_banner = store_banner;
        }

        public String getStore_avatar() {
            return store_avatar;
        }

        public void setStore_avatar(String store_avatar) {
            this.store_avatar = store_avatar;
        }

        public String getStore_keywords() {
            return store_keywords;
        }

        public void setStore_keywords(String store_keywords) {
            this.store_keywords = store_keywords;
        }

        public String getStore_description() {
            return store_description;
        }

        public void setStore_description(String store_description) {
            this.store_description = store_description;
        }

        public Object getStore_qq() {
            return store_qq;
        }

        public void setStore_qq(Object store_qq) {
            this.store_qq = store_qq;
        }

        public Object getStore_ww() {
            return store_ww;
        }

        public void setStore_ww(Object store_ww) {
            this.store_ww = store_ww;
        }

        public Object getStore_phone() {
            return store_phone;
        }

        public void setStore_phone(Object store_phone) {
            this.store_phone = store_phone;
        }

        public String getStore_zy() {
            return store_zy;
        }

        public void setStore_zy(String store_zy) {
            this.store_zy = store_zy;
        }

        public Object getStore_domain() {
            return store_domain;
        }

        public void setStore_domain(Object store_domain) {
            this.store_domain = store_domain;
        }

        public String getStore_domain_times() {
            return store_domain_times;
        }

        public void setStore_domain_times(String store_domain_times) {
            this.store_domain_times = store_domain_times;
        }

        public String getStore_recommend() {
            return store_recommend;
        }

        public void setStore_recommend(String store_recommend) {
            this.store_recommend = store_recommend;
        }

        public String getStore_theme() {
            return store_theme;
        }

        public void setStore_theme(String store_theme) {
            this.store_theme = store_theme;
        }

        public StoreCreditBean getStore_credit() {
            return store_credit;
        }

        public void setStore_credit(StoreCreditBean store_credit) {
            this.store_credit = store_credit;
        }

        public String getStore_desccredit() {
            return store_desccredit;
        }

        public void setStore_desccredit(String store_desccredit) {
            this.store_desccredit = store_desccredit;
        }

        public String getStore_servicecredit() {
            return store_servicecredit;
        }

        public void setStore_servicecredit(String store_servicecredit) {
            this.store_servicecredit = store_servicecredit;
        }

        public String getStore_deliverycredit() {
            return store_deliverycredit;
        }

        public void setStore_deliverycredit(String store_deliverycredit) {
            this.store_deliverycredit = store_deliverycredit;
        }

        public String getStore_collect() {
            return store_collect;
        }

        public void setStore_collect(String store_collect) {
            this.store_collect = store_collect;
        }

        public Object getStore_slide() {
            return store_slide;
        }

        public void setStore_slide(Object store_slide) {
            this.store_slide = store_slide;
        }

        public Object getStore_slide_url() {
            return store_slide_url;
        }

        public void setStore_slide_url(Object store_slide_url) {
            this.store_slide_url = store_slide_url;
        }

        public Object getStore_stamp() {
            return store_stamp;
        }

        public void setStore_stamp(Object store_stamp) {
            this.store_stamp = store_stamp;
        }

        public Object getStore_printdesc() {
            return store_printdesc;
        }

        public void setStore_printdesc(Object store_printdesc) {
            this.store_printdesc = store_printdesc;
        }

        public String getStore_sales() {
            return store_sales;
        }

        public void setStore_sales(String store_sales) {
            this.store_sales = store_sales;
        }

        public Object getStore_presales() {
            return store_presales;
        }

        public void setStore_presales(Object store_presales) {
            this.store_presales = store_presales;
        }

        public Object getStore_aftersales() {
            return store_aftersales;
        }

        public void setStore_aftersales(Object store_aftersales) {
            this.store_aftersales = store_aftersales;
        }

        public Object getStore_workingtime() {
            return store_workingtime;
        }

        public void setStore_workingtime(Object store_workingtime) {
            this.store_workingtime = store_workingtime;
        }

        public String getStore_free_price() {
            return store_free_price;
        }

        public void setStore_free_price(String store_free_price) {
            this.store_free_price = store_free_price;
        }

        public String getStore_decoration_switch() {
            return store_decoration_switch;
        }

        public void setStore_decoration_switch(String store_decoration_switch) {
            this.store_decoration_switch = store_decoration_switch;
        }

        public String getStore_decoration_only() {
            return store_decoration_only;
        }

        public void setStore_decoration_only(String store_decoration_only) {
            this.store_decoration_only = store_decoration_only;
        }

        public String getStore_decoration_image_count() {
            return store_decoration_image_count;
        }

        public void setStore_decoration_image_count(String store_decoration_image_count) {
            this.store_decoration_image_count = store_decoration_image_count;
        }

        public Object getLive_store_name() {
            return live_store_name;
        }

        public void setLive_store_name(Object live_store_name) {
            this.live_store_name = live_store_name;
        }

        public String getLive_store_address() {
            return live_store_address;
        }

        public void setLive_store_address(String live_store_address) {
            this.live_store_address = live_store_address;
        }

        public Object getLive_store_tel() {
            return live_store_tel;
        }

        public void setLive_store_tel(Object live_store_tel) {
            this.live_store_tel = live_store_tel;
        }

        public Object getLive_store_bus() {
            return live_store_bus;
        }

        public void setLive_store_bus(Object live_store_bus) {
            this.live_store_bus = live_store_bus;
        }

        public String getIs_own_shop() {
            return is_own_shop;
        }

        public void setIs_own_shop(String is_own_shop) {
            this.is_own_shop = is_own_shop;
        }

        public String getBind_all_gc() {
            return bind_all_gc;
        }

        public void setBind_all_gc(String bind_all_gc) {
            this.bind_all_gc = bind_all_gc;
        }

        public Object getStore_vrcode_prefix() {
            return store_vrcode_prefix;
        }

        public void setStore_vrcode_prefix(Object store_vrcode_prefix) {
            this.store_vrcode_prefix = store_vrcode_prefix;
        }

        public String getStore_baozh() {
            return store_baozh;
        }

        public void setStore_baozh(String store_baozh) {
            this.store_baozh = store_baozh;
        }

        public String getStore_baozhopen() {
            return store_baozhopen;
        }

        public void setStore_baozhopen(String store_baozhopen) {
            this.store_baozhopen = store_baozhopen;
        }

        public String getStore_baozhrmb() {
            return store_baozhrmb;
        }

        public void setStore_baozhrmb(String store_baozhrmb) {
            this.store_baozhrmb = store_baozhrmb;
        }

        public String getStore_qtian() {
            return store_qtian;
        }

        public void setStore_qtian(String store_qtian) {
            this.store_qtian = store_qtian;
        }

        public String getStore_zhping() {
            return store_zhping;
        }

        public void setStore_zhping(String store_zhping) {
            this.store_zhping = store_zhping;
        }

        public String getStore_erxiaoshi() {
            return store_erxiaoshi;
        }

        public void setStore_erxiaoshi(String store_erxiaoshi) {
            this.store_erxiaoshi = store_erxiaoshi;
        }

        public String getStore_tuihuo() {
            return store_tuihuo;
        }

        public void setStore_tuihuo(String store_tuihuo) {
            this.store_tuihuo = store_tuihuo;
        }

        public String getStore_shiyong() {
            return store_shiyong;
        }

        public void setStore_shiyong(String store_shiyong) {
            this.store_shiyong = store_shiyong;
        }

        public String getStore_shiti() {
            return store_shiti;
        }

        public void setStore_shiti(String store_shiti) {
            this.store_shiti = store_shiti;
        }

        public String getStore_xiaoxie() {
            return store_xiaoxie;
        }

        public void setStore_xiaoxie(String store_xiaoxie) {
            this.store_xiaoxie = store_xiaoxie;
        }

        public String getStore_huodaofk() {
            return store_huodaofk;
        }

        public void setStore_huodaofk(String store_huodaofk) {
            this.store_huodaofk = store_huodaofk;
        }

        public String getStore_points() {
            return store_points;
        }

        public void setStore_points(String store_points) {
            this.store_points = store_points;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getStore_type() {
            return store_type;
        }

        public void setStore_type(String store_type) {
            this.store_type = store_type;
        }

        public Object getStore_agent_level() {
            return store_agent_level;
        }

        public void setStore_agent_level(Object store_agent_level) {
            this.store_agent_level = store_agent_level;
        }

        public String getStore_agent_area_id() {
            return store_agent_area_id;
        }

        public void setStore_agent_area_id(String store_agent_area_id) {
            this.store_agent_area_id = store_agent_area_id;
        }

        public String getRm_id() {
            return rm_id;
        }

        public void setRm_id(String rm_id) {
            this.rm_id = rm_id;
        }

        public String getAgent_comm() {
            return agent_comm;
        }

        public void setAgent_comm(String agent_comm) {
            this.agent_comm = agent_comm;
        }

        public String getAgent_top() {
            return agent_top;
        }

        public void setAgent_top(String agent_top) {
            this.agent_top = agent_top;
        }

        public String getAgent_top_top() {
            return agent_top_top;
        }

        public void setAgent_top_top(String agent_top_top) {
            this.agent_top_top = agent_top_top;
        }

        public String getAgent_top_top_top() {
            return agent_top_top_top;
        }

        public void setAgent_top_top_top(String agent_top_top_top) {
            this.agent_top_top_top = agent_top_top_top;
        }

        public String getAddrole() {
            return addrole;
        }

        public void setAddrole(String addrole) {
            this.addrole = addrole;
        }

        public Object getStore_mb_slide() {
            return store_mb_slide;
        }

        public void setStore_mb_slide(Object store_mb_slide) {
            this.store_mb_slide = store_mb_slide;
        }

        public Object getStore_mb_slide_url() {
            return store_mb_slide_url;
        }

        public void setStore_mb_slide_url(Object store_mb_slide_url) {
            this.store_mb_slide_url = store_mb_slide_url;
        }

        public Object getStore_mb_ad1() {
            return store_mb_ad1;
        }

        public void setStore_mb_ad1(Object store_mb_ad1) {
            this.store_mb_ad1 = store_mb_ad1;
        }

        public Object getStore_mb_ad2() {
            return store_mb_ad2;
        }

        public void setStore_mb_ad2(Object store_mb_ad2) {
            this.store_mb_ad2 = store_mb_ad2;
        }

        public Object getStore_mb_ad1_url() {
            return store_mb_ad1_url;
        }

        public void setStore_mb_ad1_url(Object store_mb_ad1_url) {
            this.store_mb_ad1_url = store_mb_ad1_url;
        }

        public Object getStore_mb_ad2_url() {
            return store_mb_ad2_url;
        }

        public void setStore_mb_ad2_url(Object store_mb_ad2_url) {
            this.store_mb_ad2_url = store_mb_ad2_url;
        }

        public Object getStore_mb_banner() {
            return store_mb_banner;
        }

        public void setStore_mb_banner(Object store_mb_banner) {
            this.store_mb_banner = store_mb_banner;
        }

        public String getStore_anli_count() {
            return store_anli_count;
        }

        public void setStore_anli_count(String store_anli_count) {
            this.store_anli_count = store_anli_count;
        }

        public String getVisit_number() {
            return visit_number;
        }

        public void setVisit_number(String visit_number) {
            this.visit_number = visit_number;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getStore_is_weike() {
            return store_is_weike;
        }

        public void setStore_is_weike(String store_is_weike) {
            this.store_is_weike = store_is_weike;
        }

        public String getTask_price_number() {
            return task_price_number;
        }

        public void setTask_price_number(String task_price_number) {
            this.task_price_number = task_price_number;
        }

        public String getStore_bank_info() {
            return store_bank_info;
        }

        public void setStore_bank_info(String store_bank_info) {
            this.store_bank_info = store_bank_info;
        }

        public String getStore_industry() {
            return store_industry;
        }

        public void setStore_industry(String store_industry) {
            this.store_industry = store_industry;
        }

        public String getStore_open_rush() {
            return store_open_rush;
        }

        public void setStore_open_rush(String store_open_rush) {
            this.store_open_rush = store_open_rush;
        }

        public String getGoods_page_show_nav() {
            return goods_page_show_nav;
        }

        public void setGoods_page_show_nav(String goods_page_show_nav) {
            this.goods_page_show_nav = goods_page_show_nav;
        }

        public Object getStore_info_remark() {
            return store_info_remark;
        }

        public void setStore_info_remark(Object store_info_remark) {
            this.store_info_remark = store_info_remark;
        }

        public String getCountry_id() {
            return country_id;
        }

        public void setCountry_id(String country_id) {
            this.country_id = country_id;
        }

        public String getCurrency_id() {
            return currency_id;
        }

        public void setCurrency_id(String currency_id) {
            this.currency_id = currency_id;
        }

        public String getConcern_num() {
            return concern_num;
        }

        public void setConcern_num(String concern_num) {
            this.concern_num = concern_num;
        }

        public String getGoods_count() {
            return goods_count;
        }

        public void setGoods_count(String goods_count) {
            this.goods_count = goods_count;
        }

        public int getStore_credit_average() {
            return store_credit_average;
        }

        public void setStore_credit_average(int store_credit_average) {
            this.store_credit_average = store_credit_average;
        }

        public int getStore_credit_percent() {
            return store_credit_percent;
        }

        public void setStore_credit_percent(int store_credit_percent) {
            this.store_credit_percent = store_credit_percent;
        }

        public String getSeller_id() {
            return seller_id;
        }

        public void setSeller_id(String seller_id) {
            this.seller_id = seller_id;
        }

        public String getStore_end_time_text() {
            return store_end_time_text;
        }

        public void setStore_end_time_text(String store_end_time_text) {
            this.store_end_time_text = store_end_time_text;
        }

        public String getGrade_name() {
            return grade_name;
        }

        public void setGrade_name(String grade_name) {
            this.grade_name = grade_name;
        }

        public String getGrade_goodslimit() {
            return grade_goodslimit;
        }

        public void setGrade_goodslimit(String grade_goodslimit) {
            this.grade_goodslimit = grade_goodslimit;
        }

        public String getGrade_albumlimit() {
            return grade_albumlimit;
        }

        public void setGrade_albumlimit(String grade_albumlimit) {
            this.grade_albumlimit = grade_albumlimit;
        }

        public String getCountry_name() {
            return country_name;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
        }

        public static class StoreCreditBean {
            /**
             * store_desccredit : {"text":"描述相符","credit":5,"percent":"----","percent_class":"equal","percent_text":"持平"}
             * store_servicecredit : {"text":"服务态度","credit":5,"percent":"----","percent_class":"equal","percent_text":"持平"}
             * store_deliverycredit : {"text":"发货速度","credit":5,"percent":"----","percent_class":"equal","percent_text":"持平"}
             */

            private StoreDesccreditBean store_desccredit;
            private StoreServicecreditBean store_servicecredit;
            private StoreDeliverycreditBean store_deliverycredit;

            public StoreDesccreditBean getStore_desccredit() {
                return store_desccredit;
            }

            public void setStore_desccredit(StoreDesccreditBean store_desccredit) {
                this.store_desccredit = store_desccredit;
            }

            public StoreServicecreditBean getStore_servicecredit() {
                return store_servicecredit;
            }

            public void setStore_servicecredit(StoreServicecreditBean store_servicecredit) {
                this.store_servicecredit = store_servicecredit;
            }

            public StoreDeliverycreditBean getStore_deliverycredit() {
                return store_deliverycredit;
            }

            public void setStore_deliverycredit(StoreDeliverycreditBean store_deliverycredit) {
                this.store_deliverycredit = store_deliverycredit;
            }

            public static class StoreDesccreditBean {
                /**
                 * text : 描述相符
                 * credit : 5
                 * percent : ----
                 * percent_class : equal
                 * percent_text : 持平
                 */

                private String text;
                private int credit;
                private String percent;
                private String percent_class;
                private String percent_text;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getCredit() {
                    return credit;
                }

                public void setCredit(int credit) {
                    this.credit = credit;
                }

                public String getPercent() {
                    return percent;
                }

                public void setPercent(String percent) {
                    this.percent = percent;
                }

                public String getPercent_class() {
                    return percent_class;
                }

                public void setPercent_class(String percent_class) {
                    this.percent_class = percent_class;
                }

                public String getPercent_text() {
                    return percent_text;
                }

                public void setPercent_text(String percent_text) {
                    this.percent_text = percent_text;
                }
            }

            public static class StoreServicecreditBean {
                /**
                 * text : 服务态度
                 * credit : 5
                 * percent : ----
                 * percent_class : equal
                 * percent_text : 持平
                 */

                private String text;
                private int credit;
                private String percent;
                private String percent_class;
                private String percent_text;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getCredit() {
                    return credit;
                }

                public void setCredit(int credit) {
                    this.credit = credit;
                }

                public String getPercent() {
                    return percent;
                }

                public void setPercent(String percent) {
                    this.percent = percent;
                }

                public String getPercent_class() {
                    return percent_class;
                }

                public void setPercent_class(String percent_class) {
                    this.percent_class = percent_class;
                }

                public String getPercent_text() {
                    return percent_text;
                }

                public void setPercent_text(String percent_text) {
                    this.percent_text = percent_text;
                }
            }

            public static class StoreDeliverycreditBean {
                /**
                 * text : 发货速度
                 * credit : 5
                 * percent : ----
                 * percent_class : equal
                 * percent_text : 持平
                 */

                private String text;
                private int credit;
                private String percent;
                private String percent_class;
                private String percent_text;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public int getCredit() {
                    return credit;
                }

                public void setCredit(int credit) {
                    this.credit = credit;
                }

                public String getPercent() {
                    return percent;
                }

                public void setPercent(String percent) {
                    this.percent = percent;
                }

                public String getPercent_class() {
                    return percent_class;
                }

                public void setPercent_class(String percent_class) {
                    this.percent_class = percent_class;
                }

                public String getPercent_text() {
                    return percent_text;
                }

                public void setPercent_text(String percent_text) {
                    this.percent_text = percent_text;
                }
            }
        }
    }

    public static class CurrencyBean {
        /**
         * id : 2
         * name : 泰铢
         * symbol : ฿
         * unit : 泰铢
         * exchange_rate : 20.0000
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
