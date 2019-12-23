package com.aite.jiananseller.bean;

import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/27
 * @description:
 */
public class EditGoodsInfoBean {

    /**
     * goods : {"goods_commonid":"1852","goods_name_bak":"","goods_short_title_bak":"","style":"","goods_jingle_bak":"","goods_unit_bak":null,"gc_id":"645","gc_id_1":"643","gc_id_2":"644","gc_id_3":"645","gc_name_bak":"","store_id":"32","store_name_bak":"","spec_name_bak":"","spec_value_bak":null,"brand_id":"0","brand_name_bak":"","type_id":"44","goods_image":"2019/11/26/32_06281065641682478_240.jpg","goods_attr_bak":null,"goods_body_bak":null,"mobile_body_bak":null,"goods_state":"1","goods_stateremark":null,"goods_verify":"1","goods_verifyremark":null,"goods_lock":"0","goods_addtime":"1574820003","goods_selltime":"0","goods_specname":"","goods_price":"1.00","goods_marketprice":"1.00","goods_costprice":"0.00","goods_weight":"0","goods_discount":"100","goods_serial":"2","goods_storage_alarm":"2","transport_id":"0","transport_title":"","goods_commend":"0","goods_freight":"0.00","goods_vat":"0","areaid_1":"1","areaid_2":"2","goods_stcids":"","plateid_top":"0","plateid_bottom":"0","is_virtual":"0","virtual_indate":null,"virtual_limit":null,"virtual_invalid_refund":"1","is_fcode":"0","is_appoint":"0","appoint_satedate":"0","is_presell":"0","presell_deliverdate":"0","is_own_shop":"1","level_0_price":"0.00","level_1_price":"0.00","level_2_price":"0.00","level_3_price":"0.00","level_0_auth_price":"0.00","level_1_auth_price":"0.00","level_2_auth_price":"0.00","level_3_auth_price":"0.00","is_more_discount":"0","goods_type":"0","parent_commonid":"0","hotel_id":"0","is_service":"0","is_installment":"0","installment_money":"","is_vat":"1","is_index_select":"0","is_kuajing":"0","origin":null,"kj_service":null,"is_native":"1","seaport":null,"clearance":null,"clearance_sn":null,"goods_points_offset":"0","is_visit_comm":"0","is_Independent_comm":"0","is_deleted":"0","goods_labels_ids":null,"language_id":"2","goods_name":"1","goods_short_title":"","goods_jingle":"","goods_unit":null,"gc_name":"精选服饰 >女装 >棉衣","store_name":"aiteshop","brand_name":"","goods_attr":"N;","mobile_body":[{"type":"image","value":"https://aitecc.com/data/upload/shop/store/goods/32/2019/11/26/32_06281065641682478_240.jpg"}],"g_storage":"1","native_info":null,"goods_fullimage":"https://aitecc.com/data/upload/shop/store/goods/32/2019/11/26/32_06281065641682478_240.jpg"}
     * goods_class : {"gc_id":"645","type_id":"44","gc_virtual":"0","gc_id_1":"643","gc_tag_name":"精选服饰 >女装 >棉衣","gc_tag_value":"精选服饰,女装,棉衣","gc_id_2":"644","gc_id_3":"645"}
     * spec_list : [{"sp_id":1,"sp_name":"颜色分类","sp_format":null,"value":[{"sp_value_id":"487","sp_value_name":"红色","sp_value_color":"#ff0000"},{"sp_value_id":"488","sp_value_name":"绿色","sp_value_color":"#00b050"},{"sp_value_id":"489","sp_value_name":"黑色","sp_value_color":"#000000"},{"sp_value_id":"490","sp_value_name":"紫色","sp_value_color":"#7030a0"},{"sp_value_id":"616","sp_value_name":"雅致灰","sp_value_color":"#f79646"},{"sp_value_id":"617","sp_value_name":"焦糖咖","sp_value_color":""},{"sp_value_id":"638","sp_value_name":"银色","sp_value_color":""},{"sp_value_id":"666","sp_value_name":"蓝色","sp_value_color":""},{"sp_value_id":"667","sp_value_name":"米白","sp_value_color":""},{"sp_value_id":"751","sp_value_name":"tty","sp_value_color":""},{"sp_value_id":"755","sp_value_name":"ffty","sp_value_color":""},{"sp_value_id":"772","sp_value_name":"回来了","sp_value_color":""},{"sp_value_id":"773","sp_value_name":"回来了考虑考虑","sp_value_color":""},{"sp_value_id":"774","sp_value_name":"回来了考虑考虑","sp_value_color":""},{"sp_value_id":"775","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"776","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"777","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"778","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"779","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"780","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"781","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"782","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"784","sp_value_name":"阿狸","sp_value_color":""},{"sp_value_id":"785","sp_value_name":"主题","sp_value_color":""},{"sp_value_id":"786","sp_value_name":"ceshi","sp_value_color":""},{"sp_value_id":"788","sp_value_name":"ceshi","sp_value_color":""},{"sp_value_id":"810","sp_value_name":"玫瑰红","sp_value_color":""},{"sp_value_id":"851","sp_value_name":"try","sp_value_color":""},{"sp_value_id":"852","sp_value_name":"上班不","sp_value_color":""},{"sp_value_id":"853","sp_value_name":"上班不","sp_value_color":""},{"sp_value_id":"854","sp_value_name":"上班不","sp_value_color":""},{"sp_value_id":"855","sp_value_name":"222","sp_value_color":""},{"sp_value_id":"856","sp_value_name":"eeeee","sp_value_color":""},{"sp_value_id":"857","sp_value_name":"777","sp_value_color":""},{"sp_value_id":"858","sp_value_name":"3333","sp_value_color":""},{"sp_value_id":"1056","sp_value_name":"tttt","sp_value_color":null},{"sp_value_id":"1057","sp_value_name":"iiii","sp_value_color":null}]},{"sp_id":73,"sp_name":"尺码","sp_format":null,"value":[{"sp_value_id":"582","sp_value_name":"S","sp_value_color":null},{"sp_value_id":"583","sp_value_name":"L","sp_value_color":null},{"sp_value_id":"584","sp_value_name":"XL","sp_value_color":null},{"sp_value_id":"588","sp_value_name":"XXL","sp_value_color":null},{"sp_value_id":"668","sp_value_name":"M","sp_value_color":null},{"sp_value_id":"750","sp_value_name":"产品规格","sp_value_color":null},{"sp_value_id":"783","sp_value_name":"xxxxxxx","sp_value_color":null},{"sp_value_id":"791","sp_value_name":"000","sp_value_color":null},{"sp_value_id":"1022","sp_value_name":"500ml","sp_value_color":null},{"sp_value_id":"1058","sp_value_name":"eeeee","sp_value_color":null},{"sp_value_id":"1149","sp_value_name":"try","sp_value_color":null}]}]
     * attr_list : [{"attr_id":14,"attr_name":"颜色","value":[{"attr_value_id":"54","attr_value_name":"黑色，红色"},{"attr_value_id":"59","attr_value_name":"红色，灰色，卡其色，酒红色"},{"attr_value_id":"60","attr_value_name":"白色，黑色，粉色"}]},{"attr_id":15,"attr_name":"尺码","value":[{"attr_value_id":"56","attr_value_name":""},{"attr_value_id":"57","attr_value_name":""},{"attr_value_id":"58","attr_value_name":"S码，M码，L码，XL码"}]}]
     * attr_checked : []
     * spec_checked : [{"id":489,"name":"黑色"},{"id":750,"name":"产品规格"}]
     * sp_value : [{"sid":"489750","marketprice":"1.00","price":"1.00","costprice":"0.00","id":"3033","stock":"1","alarm":"1","sku":"1","level_0_price":"0.00","level_1_price":"0.00","level_2_price":"0.00","level_3_price":"0.00","level_0_auth_price":"0.00","level_1_auth_price":"0.00","level_2_auth_price":"0.00","level_3_auth_price":"0.00","goods_points_offset":"0"}]
     * store_goods_class : [{"stc_id":"66","stc_name":"女装","child":[{"stc_id":"67","stc_name_bak":"风衣","stc_parent_id":"66","stc_state":"1","store_id":"32","stc_sort":"0","stc_image":null,"language_id":"2","stc_name":"风衣"},{"stc_id":"88","stc_name_bak":"","stc_parent_id":"66","stc_state":"1","store_id":"32","stc_sort":"0","stc_image":"","language_id":"2","stc_name":"棉衣"}]},{"stc_id":"68","stc_name":"瓷砖胶","child":null},{"stc_id":"33","stc_name":"休闲","child":[{"stc_id":"34","stc_name_bak":"休闲鞋","stc_parent_id":"33","stc_state":"1","store_id":"32","stc_sort":"2","stc_image":null,"language_id":"2","stc_name":"休闲鞋"}]},{"stc_id":"41","stc_name":"女装","child":[{"stc_id":"42","stc_name_bak":"棉衣","stc_parent_id":"41","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"棉衣"}]},{"stc_id":"92","stc_name":"女装","child":[{"stc_id":"93","stc_name_bak":"","stc_parent_id":"92","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"棉衣"},{"stc_id":"94","stc_name_bak":"","stc_parent_id":"92","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"毛呢大衣"},{"stc_id":"95","stc_name_bak":"","stc_parent_id":"92","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"风衣"},{"stc_id":"96","stc_name_bak":"","stc_parent_id":"92","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"打底衫"},{"stc_id":"97","stc_name_bak":"","stc_parent_id":"92","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"情侣装"},{"stc_id":"98","stc_name_bak":"","stc_parent_id":"92","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"毛呢短裤"}]},{"stc_id":"43","stc_name":"男装","child":[{"stc_id":"89","stc_name_bak":"","stc_parent_id":"43","stc_state":"1","store_id":"32","stc_sort":"0","stc_image":"","language_id":"2","stc_name":"潮流"},{"stc_id":"44","stc_name_bak":"羽绒服","stc_parent_id":"43","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"羽绒服"},{"stc_id":"45","stc_name_bak":"卫衣","stc_parent_id":"43","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"卫衣"}]},{"stc_id":"99","stc_name":"男装","child":[{"stc_id":"100","stc_name_bak":"","stc_parent_id":"99","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"羽绒服"},{"stc_id":"101","stc_name_bak":"","stc_parent_id":"99","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"卫衣"},{"stc_id":"102","stc_name_bak":"","stc_parent_id":"99","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"长袖T恤"},{"stc_id":"103","stc_name_bak":"","stc_parent_id":"99","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"长袖衬衫"},{"stc_id":"104","stc_name_bak":"","stc_parent_id":"99","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"品质秋冬外套"}]},{"stc_id":"105","stc_name":"蜜饯果脯","child":[{"stc_id":"106","stc_name_bak":"","stc_parent_id":"105","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"芒果干"},{"stc_id":"107","stc_name_bak":"","stc_parent_id":"105","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"葡萄干"},{"stc_id":"108","stc_name_bak":"","stc_parent_id":"105","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"梅类"},{"stc_id":"109","stc_name_bak":"","stc_parent_id":"105","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"菠萝干"},{"stc_id":"110","stc_name_bak":"","stc_parent_id":"105","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"草莓干"},{"stc_id":"111","stc_name_bak":"","stc_parent_id":"105","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"香蕉干"},{"stc_id":"112","stc_name_bak":"","stc_parent_id":"105","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"玫瑰脯"},{"stc_id":"113","stc_name_bak":"","stc_parent_id":"105","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"蓝莓"}]},{"stc_id":"114","stc_name":"汽车用品","child":[{"stc_id":"115","stc_name_bak":"","stc_parent_id":"114","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"GPS导航"},{"stc_id":"116","stc_name_bak":"","stc_parent_id":"114","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"充电器"},{"stc_id":"117","stc_name_bak":"","stc_parent_id":"114","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"车载影音"},{"stc_id":"118","stc_name_bak":"","stc_parent_id":"114","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"加热保温"},{"stc_id":"119","stc_name_bak":"","stc_parent_id":"114","stc_state":"1","store_id":"32","stc_sort":"255","stc_image":null,"language_id":"2","stc_name":"座垫/座套"}]}]
     * store_class_goods : []
     * plate_list : [{"plate_id":"11","plate_name":"底部1","plate_position":"0"},{"plate_id":"22","plate_name":"footer","plate_position":"0"},{"plate_id":"23","plate_name":"顶部","plate_position":"1"},{"plate_id":"24","plate_name":"底部1","plate_position":"0"},{"plate_id":"25","plate_name":"1234567890","plate_position":"1"}]
     * fcode_array : []
     * md_rule : []
     */

    private GoodsBean goods;
    private GoodsClassBean goods_class;
    private List<SpecListBean> spec_list;
    private List<AttrListBean> attr_list;
    private List<?> attr_checked;
    private List<SpecCheckedBean> spec_checked;
    private List<SpValueBean> sp_value;
    private List<StoreGoodsClassBean> store_goods_class;
    private List<?> store_class_goods;
    private List<PlateListBean> plate_list;
    private List<?> fcode_array;
    private List<?> md_rule;

    public GoodsBean getGoods() {
        return goods;
    }

    public void setGoods(GoodsBean goods) {
        this.goods = goods;
    }

    public GoodsClassBean getGoods_class() {
        return goods_class;
    }

    public void setGoods_class(GoodsClassBean goods_class) {
        this.goods_class = goods_class;
    }

    public List<SpecListBean> getSpec_list() {
        return spec_list;
    }

    public void setSpec_list(List<SpecListBean> spec_list) {
        this.spec_list = spec_list;
    }

    public List<AttrListBean> getAttr_list() {
        return attr_list;
    }

    public void setAttr_list(List<AttrListBean> attr_list) {
        this.attr_list = attr_list;
    }

    public List<?> getAttr_checked() {
        return attr_checked;
    }

    public void setAttr_checked(List<?> attr_checked) {
        this.attr_checked = attr_checked;
    }

    public List<SpecCheckedBean> getSpec_checked() {
        return spec_checked;
    }

    public void setSpec_checked(List<SpecCheckedBean> spec_checked) {
        this.spec_checked = spec_checked;
    }

    public List<SpValueBean> getSp_value() {
        return sp_value;
    }

    public void setSp_value(List<SpValueBean> sp_value) {
        this.sp_value = sp_value;
    }

    public List<StoreGoodsClassBean> getStore_goods_class() {
        return store_goods_class;
    }

    public void setStore_goods_class(List<StoreGoodsClassBean> store_goods_class) {
        this.store_goods_class = store_goods_class;
    }

    public List<?> getStore_class_goods() {
        return store_class_goods;
    }

    public void setStore_class_goods(List<?> store_class_goods) {
        this.store_class_goods = store_class_goods;
    }

    public List<PlateListBean> getPlate_list() {
        return plate_list;
    }

    public void setPlate_list(List<PlateListBean> plate_list) {
        this.plate_list = plate_list;
    }

    public List<?> getFcode_array() {
        return fcode_array;
    }

    public void setFcode_array(List<?> fcode_array) {
        this.fcode_array = fcode_array;
    }

    public List<?> getMd_rule() {
        return md_rule;
    }

    public void setMd_rule(List<?> md_rule) {
        this.md_rule = md_rule;
    }

    public static class GoodsBean {
        /**
         * goods_commonid : 1852
         * goods_name_bak :
         * goods_short_title_bak :
         * style :
         * goods_jingle_bak :
         * goods_unit_bak : null
         * gc_id : 645
         * gc_id_1 : 643
         * gc_id_2 : 644
         * gc_id_3 : 645
         * gc_name_bak :
         * store_id : 32
         * store_name_bak :
         * spec_name_bak :
         * spec_value_bak : null
         * brand_id : 0
         * brand_name_bak :
         * type_id : 44
         * goods_image : 2019/11/26/32_06281065641682478_240.jpg
         * goods_attr_bak : null
         * goods_body_bak : null
         * mobile_body_bak : null
         * goods_state : 1
         * goods_stateremark : null
         * goods_verify : 1
         * goods_verifyremark : null
         * goods_lock : 0
         * goods_addtime : 1574820003
         * goods_selltime : 0
         * goods_specname :
         * goods_price : 1.00
         * goods_marketprice : 1.00
         * goods_costprice : 0.00
         * goods_weight : 0
         * goods_discount : 100
         * goods_serial : 2
         * goods_storage_alarm : 2
         * transport_id : 0
         * transport_title :
         * goods_commend : 0
         * goods_freight : 0.00
         * goods_vat : 0
         * areaid_1 : 1
         * areaid_2 : 2
         * goods_stcids :
         * plateid_top : 0
         * plateid_bottom : 0
         * is_virtual : 0
         * virtual_indate : null
         * virtual_limit : null
         * virtual_invalid_refund : 1
         * is_fcode : 0
         * is_appoint : 0
         * appoint_satedate : 0
         * is_presell : 0
         * presell_deliverdate : 0
         * is_own_shop : 1
         * level_0_price : 0.00
         * level_1_price : 0.00
         * level_2_price : 0.00
         * level_3_price : 0.00
         * level_0_auth_price : 0.00
         * level_1_auth_price : 0.00
         * level_2_auth_price : 0.00
         * level_3_auth_price : 0.00
         * is_more_discount : 0
         * goods_type : 0
         * parent_commonid : 0
         * hotel_id : 0
         * is_service : 0
         * is_installment : 0
         * installment_money :
         * is_vat : 1
         * is_index_select : 0
         * is_kuajing : 0
         * origin : null
         * kj_service : null
         * is_native : 1
         * seaport : null
         * clearance : null
         * clearance_sn : null
         * goods_points_offset : 0
         * is_visit_comm : 0
         * is_Independent_comm : 0
         * is_deleted : 0
         * goods_labels_ids : null
         * language_id : 2
         * goods_name : 1
         * goods_short_title :
         * goods_jingle :
         * goods_unit : null
         * gc_name : 精选服饰 >女装 >棉衣
         * store_name : aiteshop
         * brand_name :
         * goods_attr : N;
         * mobile_body : [{"type":"image","value":"https://aitecc.com/data/upload/shop/store/goods/32/2019/11/26/32_06281065641682478_240.jpg"}]
         * g_storage : 1
         * native_info : null
         * goods_fullimage : https://aitecc.com/data/upload/shop/store/goods/32/2019/11/26/32_06281065641682478_240.jpg
         */

        private String goods_commonid;
        private String goods_name_bak;
        private String goods_short_title_bak;
        private String style;
        private String goods_jingle_bak;
        private Object goods_unit_bak;
        private String gc_id;
        private String gc_id_1;
        private String gc_id_2;
        private String gc_id_3;
        private String gc_name_bak;
        private String store_id;
        private String store_name_bak;
        private String spec_name_bak;
        private Object spec_value_bak;
        private String brand_id;
        private String brand_name_bak;
        private String type_id;
        private String goods_image;
        private Object goods_attr_bak;
        private Object goods_body_bak;
        private Object mobile_body_bak;
        private String goods_state;
        private Object goods_stateremark;
        private String goods_verify;
        private Object goods_verifyremark;
        private String goods_lock;
        private String goods_addtime;
        private String goods_selltime;
        private String goods_specname;
        private String goods_price;
        private String goods_marketprice;
        private String goods_costprice;
        private String goods_weight;
        private String goods_discount;
        private String goods_serial;
        private String goods_storage_alarm;
        private String transport_id;
        private String transport_title;
        private String goods_commend;
        private String goods_freight;
        private String goods_vat;
        private String areaid_1;
        private String areaid_2;
        private String goods_stcids;
        private String plateid_top;
        private String plateid_bottom;
        private String is_virtual;
        private Object virtual_indate;
        private Object virtual_limit;
        private String virtual_invalid_refund;
        private String is_fcode;
        private String is_appoint;
        private String appoint_satedate;
        private String is_presell;
        private String presell_deliverdate;
        private String is_own_shop;
        private String level_0_price;
        private String level_1_price;
        private String level_2_price;
        private String level_3_price;
        private String level_0_auth_price;
        private String level_1_auth_price;
        private String level_2_auth_price;
        private String level_3_auth_price;
        private String is_more_discount;
        private String goods_type;
        private String parent_commonid;
        private String hotel_id;
        private String is_service;
        private String is_installment;
        private String installment_money;
        private String is_vat;
        private String is_index_select;
        private String is_kuajing;
        private Object origin;
        private Object kj_service;
        private String is_native;
        private Object seaport;
        private Object clearance;
        private Object clearance_sn;
        private String goods_points_offset;
        private String is_visit_comm;
        private String is_Independent_comm;
        private String is_deleted;
        private Object goods_labels_ids;
        private String language_id;
        private String goods_name;
        private String goods_short_title;
        private String goods_jingle;
        private Object goods_unit;
        private String gc_name;
        private String store_name;
        private String brand_name;
        private String goods_attr;
        private String g_storage;
        private Object native_info;
        private String goods_fullimage;
        private List<MobileBodyBean> mobile_body;

        public String getGoods_commonid() {
            return goods_commonid;
        }

        public void setGoods_commonid(String goods_commonid) {
            this.goods_commonid = goods_commonid;
        }

        public String getGoods_name_bak() {
            return goods_name_bak;
        }

        public void setGoods_name_bak(String goods_name_bak) {
            this.goods_name_bak = goods_name_bak;
        }

        public String getGoods_short_title_bak() {
            return goods_short_title_bak;
        }

        public void setGoods_short_title_bak(String goods_short_title_bak) {
            this.goods_short_title_bak = goods_short_title_bak;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getGoods_jingle_bak() {
            return goods_jingle_bak;
        }

        public void setGoods_jingle_bak(String goods_jingle_bak) {
            this.goods_jingle_bak = goods_jingle_bak;
        }

        public Object getGoods_unit_bak() {
            return goods_unit_bak;
        }

        public void setGoods_unit_bak(Object goods_unit_bak) {
            this.goods_unit_bak = goods_unit_bak;
        }

        public String getGc_id() {
            return gc_id;
        }

        public void setGc_id(String gc_id) {
            this.gc_id = gc_id;
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

        public String getGc_name_bak() {
            return gc_name_bak;
        }

        public void setGc_name_bak(String gc_name_bak) {
            this.gc_name_bak = gc_name_bak;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getStore_name_bak() {
            return store_name_bak;
        }

        public void setStore_name_bak(String store_name_bak) {
            this.store_name_bak = store_name_bak;
        }

        public String getSpec_name_bak() {
            return spec_name_bak;
        }

        public void setSpec_name_bak(String spec_name_bak) {
            this.spec_name_bak = spec_name_bak;
        }

        public Object getSpec_value_bak() {
            return spec_value_bak;
        }

        public void setSpec_value_bak(Object spec_value_bak) {
            this.spec_value_bak = spec_value_bak;
        }

        public String getBrand_id() {
            return brand_id;
        }

        public void setBrand_id(String brand_id) {
            this.brand_id = brand_id;
        }

        public String getBrand_name_bak() {
            return brand_name_bak;
        }

        public void setBrand_name_bak(String brand_name_bak) {
            this.brand_name_bak = brand_name_bak;
        }

        public String getType_id() {
            return type_id;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }

        public String getGoods_image() {
            return goods_image;
        }

        public void setGoods_image(String goods_image) {
            this.goods_image = goods_image;
        }

        public Object getGoods_attr_bak() {
            return goods_attr_bak;
        }

        public void setGoods_attr_bak(Object goods_attr_bak) {
            this.goods_attr_bak = goods_attr_bak;
        }

        public Object getGoods_body_bak() {
            return goods_body_bak;
        }

        public void setGoods_body_bak(Object goods_body_bak) {
            this.goods_body_bak = goods_body_bak;
        }

        public Object getMobile_body_bak() {
            return mobile_body_bak;
        }

        public void setMobile_body_bak(Object mobile_body_bak) {
            this.mobile_body_bak = mobile_body_bak;
        }

        public String getGoods_state() {
            return goods_state;
        }

        public void setGoods_state(String goods_state) {
            this.goods_state = goods_state;
        }

        public Object getGoods_stateremark() {
            return goods_stateremark;
        }

        public void setGoods_stateremark(Object goods_stateremark) {
            this.goods_stateremark = goods_stateremark;
        }

        public String getGoods_verify() {
            return goods_verify;
        }

        public void setGoods_verify(String goods_verify) {
            this.goods_verify = goods_verify;
        }

        public Object getGoods_verifyremark() {
            return goods_verifyremark;
        }

        public void setGoods_verifyremark(Object goods_verifyremark) {
            this.goods_verifyremark = goods_verifyremark;
        }

        public String getGoods_lock() {
            return goods_lock;
        }

        public void setGoods_lock(String goods_lock) {
            this.goods_lock = goods_lock;
        }

        public String getGoods_addtime() {
            return goods_addtime;
        }

        public void setGoods_addtime(String goods_addtime) {
            this.goods_addtime = goods_addtime;
        }

        public String getGoods_selltime() {
            return goods_selltime;
        }

        public void setGoods_selltime(String goods_selltime) {
            this.goods_selltime = goods_selltime;
        }

        public String getGoods_specname() {
            return goods_specname;
        }

        public void setGoods_specname(String goods_specname) {
            this.goods_specname = goods_specname;
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

        public String getGoods_weight() {
            return goods_weight;
        }

        public void setGoods_weight(String goods_weight) {
            this.goods_weight = goods_weight;
        }

        public String getGoods_discount() {
            return goods_discount;
        }

        public void setGoods_discount(String goods_discount) {
            this.goods_discount = goods_discount;
        }

        public String getGoods_serial() {
            return goods_serial;
        }

        public void setGoods_serial(String goods_serial) {
            this.goods_serial = goods_serial;
        }

        public String getGoods_storage_alarm() {
            return goods_storage_alarm;
        }

        public void setGoods_storage_alarm(String goods_storage_alarm) {
            this.goods_storage_alarm = goods_storage_alarm;
        }

        public String getTransport_id() {
            return transport_id;
        }

        public void setTransport_id(String transport_id) {
            this.transport_id = transport_id;
        }

        public String getTransport_title() {
            return transport_title;
        }

        public void setTransport_title(String transport_title) {
            this.transport_title = transport_title;
        }

        public String getGoods_commend() {
            return goods_commend;
        }

        public void setGoods_commend(String goods_commend) {
            this.goods_commend = goods_commend;
        }

        public String getGoods_freight() {
            return goods_freight;
        }

        public void setGoods_freight(String goods_freight) {
            this.goods_freight = goods_freight;
        }

        public String getGoods_vat() {
            return goods_vat;
        }

        public void setGoods_vat(String goods_vat) {
            this.goods_vat = goods_vat;
        }

        public String getAreaid_1() {
            return areaid_1;
        }

        public void setAreaid_1(String areaid_1) {
            this.areaid_1 = areaid_1;
        }

        public String getAreaid_2() {
            return areaid_2;
        }

        public void setAreaid_2(String areaid_2) {
            this.areaid_2 = areaid_2;
        }

        public String getGoods_stcids() {
            return goods_stcids;
        }

        public void setGoods_stcids(String goods_stcids) {
            this.goods_stcids = goods_stcids;
        }

        public String getPlateid_top() {
            return plateid_top;
        }

        public void setPlateid_top(String plateid_top) {
            this.plateid_top = plateid_top;
        }

        public String getPlateid_bottom() {
            return plateid_bottom;
        }

        public void setPlateid_bottom(String plateid_bottom) {
            this.plateid_bottom = plateid_bottom;
        }

        public String getIs_virtual() {
            return is_virtual;
        }

        public void setIs_virtual(String is_virtual) {
            this.is_virtual = is_virtual;
        }

        public Object getVirtual_indate() {
            return virtual_indate;
        }

        public void setVirtual_indate(Object virtual_indate) {
            this.virtual_indate = virtual_indate;
        }

        public Object getVirtual_limit() {
            return virtual_limit;
        }

        public void setVirtual_limit(Object virtual_limit) {
            this.virtual_limit = virtual_limit;
        }

        public String getVirtual_invalid_refund() {
            return virtual_invalid_refund;
        }

        public void setVirtual_invalid_refund(String virtual_invalid_refund) {
            this.virtual_invalid_refund = virtual_invalid_refund;
        }

        public String getIs_fcode() {
            return is_fcode;
        }

        public void setIs_fcode(String is_fcode) {
            this.is_fcode = is_fcode;
        }

        public String getIs_appoint() {
            return is_appoint;
        }

        public void setIs_appoint(String is_appoint) {
            this.is_appoint = is_appoint;
        }

        public String getAppoint_satedate() {
            return appoint_satedate;
        }

        public void setAppoint_satedate(String appoint_satedate) {
            this.appoint_satedate = appoint_satedate;
        }

        public String getIs_presell() {
            return is_presell;
        }

        public void setIs_presell(String is_presell) {
            this.is_presell = is_presell;
        }

        public String getPresell_deliverdate() {
            return presell_deliverdate;
        }

        public void setPresell_deliverdate(String presell_deliverdate) {
            this.presell_deliverdate = presell_deliverdate;
        }

        public String getIs_own_shop() {
            return is_own_shop;
        }

        public void setIs_own_shop(String is_own_shop) {
            this.is_own_shop = is_own_shop;
        }

        public String getLevel_0_price() {
            return level_0_price;
        }

        public void setLevel_0_price(String level_0_price) {
            this.level_0_price = level_0_price;
        }

        public String getLevel_1_price() {
            return level_1_price;
        }

        public void setLevel_1_price(String level_1_price) {
            this.level_1_price = level_1_price;
        }

        public String getLevel_2_price() {
            return level_2_price;
        }

        public void setLevel_2_price(String level_2_price) {
            this.level_2_price = level_2_price;
        }

        public String getLevel_3_price() {
            return level_3_price;
        }

        public void setLevel_3_price(String level_3_price) {
            this.level_3_price = level_3_price;
        }

        public String getLevel_0_auth_price() {
            return level_0_auth_price;
        }

        public void setLevel_0_auth_price(String level_0_auth_price) {
            this.level_0_auth_price = level_0_auth_price;
        }

        public String getLevel_1_auth_price() {
            return level_1_auth_price;
        }

        public void setLevel_1_auth_price(String level_1_auth_price) {
            this.level_1_auth_price = level_1_auth_price;
        }

        public String getLevel_2_auth_price() {
            return level_2_auth_price;
        }

        public void setLevel_2_auth_price(String level_2_auth_price) {
            this.level_2_auth_price = level_2_auth_price;
        }

        public String getLevel_3_auth_price() {
            return level_3_auth_price;
        }

        public void setLevel_3_auth_price(String level_3_auth_price) {
            this.level_3_auth_price = level_3_auth_price;
        }

        public String getIs_more_discount() {
            return is_more_discount;
        }

        public void setIs_more_discount(String is_more_discount) {
            this.is_more_discount = is_more_discount;
        }

        public String getGoods_type() {
            return goods_type;
        }

        public void setGoods_type(String goods_type) {
            this.goods_type = goods_type;
        }

        public String getParent_commonid() {
            return parent_commonid;
        }

        public void setParent_commonid(String parent_commonid) {
            this.parent_commonid = parent_commonid;
        }

        public String getHotel_id() {
            return hotel_id;
        }

        public void setHotel_id(String hotel_id) {
            this.hotel_id = hotel_id;
        }

        public String getIs_service() {
            return is_service;
        }

        public void setIs_service(String is_service) {
            this.is_service = is_service;
        }

        public String getIs_installment() {
            return is_installment;
        }

        public void setIs_installment(String is_installment) {
            this.is_installment = is_installment;
        }

        public String getInstallment_money() {
            return installment_money;
        }

        public void setInstallment_money(String installment_money) {
            this.installment_money = installment_money;
        }

        public String getIs_vat() {
            return is_vat;
        }

        public void setIs_vat(String is_vat) {
            this.is_vat = is_vat;
        }

        public String getIs_index_select() {
            return is_index_select;
        }

        public void setIs_index_select(String is_index_select) {
            this.is_index_select = is_index_select;
        }

        public String getIs_kuajing() {
            return is_kuajing;
        }

        public void setIs_kuajing(String is_kuajing) {
            this.is_kuajing = is_kuajing;
        }

        public Object getOrigin() {
            return origin;
        }

        public void setOrigin(Object origin) {
            this.origin = origin;
        }

        public Object getKj_service() {
            return kj_service;
        }

        public void setKj_service(Object kj_service) {
            this.kj_service = kj_service;
        }

        public String getIs_native() {
            return is_native;
        }

        public void setIs_native(String is_native) {
            this.is_native = is_native;
        }

        public Object getSeaport() {
            return seaport;
        }

        public void setSeaport(Object seaport) {
            this.seaport = seaport;
        }

        public Object getClearance() {
            return clearance;
        }

        public void setClearance(Object clearance) {
            this.clearance = clearance;
        }

        public Object getClearance_sn() {
            return clearance_sn;
        }

        public void setClearance_sn(Object clearance_sn) {
            this.clearance_sn = clearance_sn;
        }

        public String getGoods_points_offset() {
            return goods_points_offset;
        }

        public void setGoods_points_offset(String goods_points_offset) {
            this.goods_points_offset = goods_points_offset;
        }

        public String getIs_visit_comm() {
            return is_visit_comm;
        }

        public void setIs_visit_comm(String is_visit_comm) {
            this.is_visit_comm = is_visit_comm;
        }

        public String getIs_Independent_comm() {
            return is_Independent_comm;
        }

        public void setIs_Independent_comm(String is_Independent_comm) {
            this.is_Independent_comm = is_Independent_comm;
        }

        public String getIs_deleted() {
            return is_deleted;
        }

        public void setIs_deleted(String is_deleted) {
            this.is_deleted = is_deleted;
        }

        public Object getGoods_labels_ids() {
            return goods_labels_ids;
        }

        public void setGoods_labels_ids(Object goods_labels_ids) {
            this.goods_labels_ids = goods_labels_ids;
        }

        public String getLanguage_id() {
            return language_id;
        }

        public void setLanguage_id(String language_id) {
            this.language_id = language_id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_short_title() {
            return goods_short_title;
        }

        public void setGoods_short_title(String goods_short_title) {
            this.goods_short_title = goods_short_title;
        }

        public String getGoods_jingle() {
            return goods_jingle;
        }

        public void setGoods_jingle(String goods_jingle) {
            this.goods_jingle = goods_jingle;
        }

        public Object getGoods_unit() {
            return goods_unit;
        }

        public void setGoods_unit(Object goods_unit) {
            this.goods_unit = goods_unit;
        }

        public String getGc_name() {
            return gc_name;
        }

        public void setGc_name(String gc_name) {
            this.gc_name = gc_name;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getBrand_name() {
            return brand_name;
        }

        public void setBrand_name(String brand_name) {
            this.brand_name = brand_name;
        }

        public String getGoods_attr() {
            return goods_attr;
        }

        public void setGoods_attr(String goods_attr) {
            this.goods_attr = goods_attr;
        }

        public String getG_storage() {
            return g_storage;
        }

        public void setG_storage(String g_storage) {
            this.g_storage = g_storage;
        }

        public Object getNative_info() {
            return native_info;
        }

        public void setNative_info(Object native_info) {
            this.native_info = native_info;
        }

        public String getGoods_fullimage() {
            return goods_fullimage;
        }

        public void setGoods_fullimage(String goods_fullimage) {
            this.goods_fullimage = goods_fullimage;
        }

        public List<MobileBodyBean> getMobile_body() {
            return mobile_body;
        }

        public void setMobile_body(List<MobileBodyBean> mobile_body) {
            this.mobile_body = mobile_body;
        }

        public static class MobileBodyBean {
            /**
             * type : image
             * value : https://aitecc.com/data/upload/shop/store/goods/32/2019/11/26/32_06281065641682478_240.jpg
             */

            private String type;
            private String value;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }

    public static class GoodsClassBean {
        /**
         * gc_id : 645
         * type_id : 44
         * gc_virtual : 0
         * gc_id_1 : 643
         * gc_tag_name : 精选服饰 >女装 >棉衣
         * gc_tag_value : 精选服饰,女装,棉衣
         * gc_id_2 : 644
         * gc_id_3 : 645
         */

        private String gc_id;
        private String type_id;
        private String gc_virtual;
        private String gc_id_1;
        private String gc_tag_name;
        private String gc_tag_value;
        private String gc_id_2;
        private String gc_id_3;

        public String getGc_id() {
            return gc_id;
        }

        public void setGc_id(String gc_id) {
            this.gc_id = gc_id;
        }

        public String getType_id() {
            return type_id;
        }

        public void setType_id(String type_id) {
            this.type_id = type_id;
        }

        public String getGc_virtual() {
            return gc_virtual;
        }

        public void setGc_virtual(String gc_virtual) {
            this.gc_virtual = gc_virtual;
        }

        public String getGc_id_1() {
            return gc_id_1;
        }

        public void setGc_id_1(String gc_id_1) {
            this.gc_id_1 = gc_id_1;
        }

        public String getGc_tag_name() {
            return gc_tag_name;
        }

        public void setGc_tag_name(String gc_tag_name) {
            this.gc_tag_name = gc_tag_name;
        }

        public String getGc_tag_value() {
            return gc_tag_value;
        }

        public void setGc_tag_value(String gc_tag_value) {
            this.gc_tag_value = gc_tag_value;
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
    }

    public static class SpecListBean {
        /**
         * sp_id : 1
         * sp_name : 颜色分类
         * sp_format : null
         * value : [{"sp_value_id":"487","sp_value_name":"红色","sp_value_color":"#ff0000"},{"sp_value_id":"488","sp_value_name":"绿色","sp_value_color":"#00b050"},{"sp_value_id":"489","sp_value_name":"黑色","sp_value_color":"#000000"},{"sp_value_id":"490","sp_value_name":"紫色","sp_value_color":"#7030a0"},{"sp_value_id":"616","sp_value_name":"雅致灰","sp_value_color":"#f79646"},{"sp_value_id":"617","sp_value_name":"焦糖咖","sp_value_color":""},{"sp_value_id":"638","sp_value_name":"银色","sp_value_color":""},{"sp_value_id":"666","sp_value_name":"蓝色","sp_value_color":""},{"sp_value_id":"667","sp_value_name":"米白","sp_value_color":""},{"sp_value_id":"751","sp_value_name":"tty","sp_value_color":""},{"sp_value_id":"755","sp_value_name":"ffty","sp_value_color":""},{"sp_value_id":"772","sp_value_name":"回来了","sp_value_color":""},{"sp_value_id":"773","sp_value_name":"回来了考虑考虑","sp_value_color":""},{"sp_value_id":"774","sp_value_name":"回来了考虑考虑","sp_value_color":""},{"sp_value_id":"775","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"776","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"777","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"778","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"779","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"780","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"781","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"782","sp_value_name":"噢噢噢哦哦","sp_value_color":""},{"sp_value_id":"784","sp_value_name":"阿狸","sp_value_color":""},{"sp_value_id":"785","sp_value_name":"主题","sp_value_color":""},{"sp_value_id":"786","sp_value_name":"ceshi","sp_value_color":""},{"sp_value_id":"788","sp_value_name":"ceshi","sp_value_color":""},{"sp_value_id":"810","sp_value_name":"玫瑰红","sp_value_color":""},{"sp_value_id":"851","sp_value_name":"try","sp_value_color":""},{"sp_value_id":"852","sp_value_name":"上班不","sp_value_color":""},{"sp_value_id":"853","sp_value_name":"上班不","sp_value_color":""},{"sp_value_id":"854","sp_value_name":"上班不","sp_value_color":""},{"sp_value_id":"855","sp_value_name":"222","sp_value_color":""},{"sp_value_id":"856","sp_value_name":"eeeee","sp_value_color":""},{"sp_value_id":"857","sp_value_name":"777","sp_value_color":""},{"sp_value_id":"858","sp_value_name":"3333","sp_value_color":""},{"sp_value_id":"1056","sp_value_name":"tttt","sp_value_color":null},{"sp_value_id":"1057","sp_value_name":"iiii","sp_value_color":null}]
         */

        private int sp_id;
        private String sp_name;
        private Object sp_format;
        private List<ValueBean> value;

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

        public List<ValueBean> getValue() {
            return value;
        }

        public void setValue(List<ValueBean> value) {
            this.value = value;
        }

        public static class ValueBean {
            /**
             * sp_value_id : 487
             * sp_value_name : 红色
             * sp_value_color : #ff0000
             */

            private String sp_value_id;
            private String sp_value_name;
            private String sp_value_color;

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

            public String getSp_value_color() {
                return sp_value_color;
            }

            public void setSp_value_color(String sp_value_color) {
                this.sp_value_color = sp_value_color;
            }
        }
    }

    public static class AttrListBean {
        /**
         * attr_id : 14
         * attr_name : 颜色
         * value : [{"attr_value_id":"54","attr_value_name":"黑色，红色"},{"attr_value_id":"59","attr_value_name":"红色，灰色，卡其色，酒红色"},{"attr_value_id":"60","attr_value_name":"白色，黑色，粉色"}]
         */

        private int attr_id;
        private String attr_name;
        private List<ValueBeanX> value;

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

        public List<ValueBeanX> getValue() {
            return value;
        }

        public void setValue(List<ValueBeanX> value) {
            this.value = value;
        }

        public static class ValueBeanX {
            /**
             * attr_value_id : 54
             * attr_value_name : 黑色，红色
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

    public static class SpecCheckedBean {
        /**
         * id : 489
         * name : 黑色
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class SpValueBean {
        /**
         * sid : 489750
         * marketprice : 1.00
         * price : 1.00
         * costprice : 0.00
         * id : 3033
         * stock : 1
         * alarm : 1
         * sku : 1
         * level_0_price : 0.00
         * level_1_price : 0.00
         * level_2_price : 0.00
         * level_3_price : 0.00
         * level_0_auth_price : 0.00
         * level_1_auth_price : 0.00
         * level_2_auth_price : 0.00
         * level_3_auth_price : 0.00
         * goods_points_offset : 0
         */

        private String sid;
        private String marketprice;
        private String price;
        private String costprice;
        private String id;
        private String stock;
        private String alarm;
        private String sku;
        private String level_0_price;
        private String level_1_price;
        private String level_2_price;
        private String level_3_price;
        private String level_0_auth_price;
        private String level_1_auth_price;
        private String level_2_auth_price;
        private String level_3_auth_price;
        private String goods_points_offset;

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getMarketprice() {
            return marketprice;
        }

        public void setMarketprice(String marketprice) {
            this.marketprice = marketprice;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCostprice() {
            return costprice;
        }

        public void setCostprice(String costprice) {
            this.costprice = costprice;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
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

        public String getLevel_0_price() {
            return level_0_price;
        }

        public void setLevel_0_price(String level_0_price) {
            this.level_0_price = level_0_price;
        }

        public String getLevel_1_price() {
            return level_1_price;
        }

        public void setLevel_1_price(String level_1_price) {
            this.level_1_price = level_1_price;
        }

        public String getLevel_2_price() {
            return level_2_price;
        }

        public void setLevel_2_price(String level_2_price) {
            this.level_2_price = level_2_price;
        }

        public String getLevel_3_price() {
            return level_3_price;
        }

        public void setLevel_3_price(String level_3_price) {
            this.level_3_price = level_3_price;
        }

        public String getLevel_0_auth_price() {
            return level_0_auth_price;
        }

        public void setLevel_0_auth_price(String level_0_auth_price) {
            this.level_0_auth_price = level_0_auth_price;
        }

        public String getLevel_1_auth_price() {
            return level_1_auth_price;
        }

        public void setLevel_1_auth_price(String level_1_auth_price) {
            this.level_1_auth_price = level_1_auth_price;
        }

        public String getLevel_2_auth_price() {
            return level_2_auth_price;
        }

        public void setLevel_2_auth_price(String level_2_auth_price) {
            this.level_2_auth_price = level_2_auth_price;
        }

        public String getLevel_3_auth_price() {
            return level_3_auth_price;
        }

        public void setLevel_3_auth_price(String level_3_auth_price) {
            this.level_3_auth_price = level_3_auth_price;
        }

        public String getGoods_points_offset() {
            return goods_points_offset;
        }

        public void setGoods_points_offset(String goods_points_offset) {
            this.goods_points_offset = goods_points_offset;
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
}
