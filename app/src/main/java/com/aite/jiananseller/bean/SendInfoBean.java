package com.aite.jiananseller.bean;

import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/20
 * @description:
 */
public class SendInfoBean {

    /**
     * order_info : {"order_id":"1823","order_sn":"2000000000191301","pay_sn":"810627208937720921","store_id":"32","store_name":"aiteshop","buyer_id":"1921","buyer_name":"ning66","buyer_email":"3609531445@qq.com","add_time":"1573864937","payment_code":"predeposit","payment_time":"1573864937","finnshed_time":"0","goods_amount":"0.01","order_amount":"0.01","order_costamount":"0.00","rcb_amount":"0.00","pd_amount":"0.01","shipping_fee":"0.00","evaluation_state":"0","order_state":"20","refund_state":"0","lock_state":"0","delete_state":"0","refund_amount":"0.00","refund_points":"0","delay_time":"0","order_from":"2","shipping_code":"","hotel_checked":"0","picktype":"0","pay_voucher_img":"","order_type":"1","phy_store_id":"0","store_points_offset":"0","store_points_offset_amount":"0.00","platform_points_offset":"0","platform_points_offset_amount":"0.00","first_comm":"0.00","second_comm":"0.00","three_comm":"0.00","transfer_remark":null,"confirm_address":"0","exchange_rate":"30.0000","delivery_fee":"0.00","warehouse_id_t":"","warehouse_id_j":"","number_days":"0","state_desc":"待发货","payment_name":"站内余额支付","extend_order_common":{"order_id":"1823","store_id":"32","shipping_time":"0","shipping_express_id":"0","evaluation_time":"0","evalseller_state":"0","evalseller_time":"0","order_message":null,"order_pointscount":"0","has_refund_points":"0","voucher_price":null,"voucher_code":null,"platform_voucher_price":null,"platform_voucher_code":null,"deliver_explain":null,"daddress_id":"45","reciver_name":"非金边","reciver_info":{"phone":"15213200000,15213203075","mob_phone":"15213200000","tel_phone":"15213203075","address":"柬埔寨白马省白马 ក្រុងកែប","area":"柬埔寨白马省白马","street":"ក្រុងកែប","points":"104.319142,10.543246"},"reciver_province_id":"86136","reciver_city_id":"86138","invoice_info":[],"promotion_info":"","dlyo_pickup_code":null,"reciver_area_id":"0","citysend_info":" ","reciver_country_id":"85917","evalseller_country_id":"0","reciver_points":""},"extend_order_goods":[{"rec_id":"1979","order_id":"1823","goods_id":"1510","goods_commonid":"933","goods_name":"长袖t恤男士圆领修身男装春秋打底衫学生韩版保暖衣服卫衣男潮流","goods_price":"0.01","goods_costprice":"0.00","goods_num":"1","goods_image":"https://aitecc.com/data/upload/shop/store/goods/32/2018/01/25/32_05702050010574768_60.jpg","goods_pay_price":"0.01","store_id":"32","buyer_id":"1921","goods_type":"1","promotions_id":"0","commis_rate":"0","gc_id":"660","start_time":"0","end_time":"0","dates":null,"days":"0","price_items":null,"hotel_msg":null,"store_points_offset":"0","store_points_offset_amount":"0.00","platform_points_offset":"0","platform_points_offset_amount":"0.00","is_visit_comm":"0","is_Independent_comm":"0","comm_rule":null,"exchange_rate":"30.0000"}]}
     * daddress_info : {"address_id":"45","store_id":"32","seller_name":"柬埔寨商家","area_id":"0","city_id":"85932","area_info":"柬埔寨磅湛省特本克蒙县","address":"柬埔寨非金边地址","telphone":"146791546784","company":"家南项目","is_default":"1","country_id":"85917","province_id":"85931","points":""}
     * my_express_list : [{"id":"1","e_name":"安信达","e_state":"1","e_code":"anxindakuaixi","e_letter":"A","e_order":"1","e_url":"http://www.anxinda.com","e_zt_state":"1"},{"id":"48","e_name":"艾特物流","e_state":"1","e_code":"aite20150626","e_letter":"A","e_order":"1","e_url":"","e_zt_state":"1"},{"id":"2","e_name":"包裹平邮","e_state":"1","e_code":"youzhengguonei","e_letter":"B","e_order":"1","e_url":"http://yjcx.chinapost.com.cn","e_zt_state":"1"},{"id":"8","e_name":"EMS","e_state":"1","e_code":"ems","e_letter":"E","e_order":"1","e_url":"http://www.ems.com.cn","e_zt_state":"1"},{"id":"16","e_name":"汇通快递","e_state":"1","e_code":"huitongkuaidi","e_letter":"H","e_order":"1","e_url":"http://www.htky365.com","e_zt_state":"1"},{"id":"49","e_name":"快捷","e_state":"1","e_code":"1321321454","e_letter":"K","e_order":"1","e_url":"","e_zt_state":"1"},{"id":"28","e_name":"申通快递","e_state":"1","e_code":"shentong","e_letter":"S","e_order":"1","e_url":"http://www.sto.cn","e_zt_state":"1"},{"id":"29","e_name":"顺丰快递","e_state":"1","e_code":"shunfeng","e_letter":"S","e_order":"1","e_url":"http://www.sf-express.com","e_zt_state":"1"},{"id":"32","e_name":"天天快递","e_state":"1","e_code":"tiantian","e_letter":"T","e_order":"1","e_url":"http://www.ttkdex.com","e_zt_state":"1"},{"id":"41","e_name":"韵达快递","e_state":"1","e_code":"yunda","e_letter":"Y","e_order":"1","e_url":"http://www.yundaex.com","e_zt_state":"1"},{"id":"42","e_name":"邮政包裹","e_state":"1","e_code":"youzhengguonei","e_letter":"Y","e_order":"1","e_url":"http://yjcx.chinapost.com.cn","e_zt_state":"1"},{"id":"40","e_name":"圆通快递","e_state":"1","e_code":"yuantong","e_letter":"Y","e_order":"1","e_url":"http://www.yto.net.cn","e_zt_state":"1"},{"id":"44","e_name":"中通快递","e_state":"1","e_code":"zhongtong","e_letter":"Z","e_order":"1","e_url":"http://www.zto.cn","e_zt_state":"1"},{"id":"46","e_name":"宅急送","e_state":"1","e_code":"zhaijisong","e_letter":"Z","e_order":"1","e_url":"http://www.zjs.com.cn","e_zt_state":"0"},{"id":"47","e_name":"中邮物流","e_state":"1","e_code":"zhongyouwuliu","e_letter":"Z","e_order":"2","e_url":"http://www.cnpl.com.cn","e_zt_state":"0"}]
     */

    private OrderInfoBean order_info;
    private DaddressInfoBean daddress_info;
    private List<MyExpressListBean> my_express_list;

    public OrderInfoBean getOrder_info() {
        return order_info;
    }

    public void setOrder_info(OrderInfoBean order_info) {
        this.order_info = order_info;
    }

    public DaddressInfoBean getDaddress_info() {
        return daddress_info;
    }

    public void setDaddress_info(DaddressInfoBean daddress_info) {
        this.daddress_info = daddress_info;
    }

    public List<MyExpressListBean> getMy_express_list() {
        return my_express_list;
    }

    public void setMy_express_list(List<MyExpressListBean> my_express_list) {
        this.my_express_list = my_express_list;
    }

    public static class OrderInfoBean {
        /**
         * order_id : 1823
         * order_sn : 2000000000191301
         * pay_sn : 810627208937720921
         * store_id : 32
         * store_name : aiteshop
         * buyer_id : 1921
         * buyer_name : ning66
         * buyer_email : 3609531445@qq.com
         * add_time : 1573864937
         * payment_code : predeposit
         * payment_time : 1573864937
         * finnshed_time : 0
         * goods_amount : 0.01
         * order_amount : 0.01
         * order_costamount : 0.00
         * rcb_amount : 0.00
         * pd_amount : 0.01
         * shipping_fee : 0.00
         * evaluation_state : 0
         * order_state : 20
         * refund_state : 0
         * lock_state : 0
         * delete_state : 0
         * refund_amount : 0.00
         * refund_points : 0
         * delay_time : 0
         * order_from : 2
         * shipping_code :
         * hotel_checked : 0
         * picktype : 0
         * pay_voucher_img :
         * order_type : 1
         * phy_store_id : 0
         * store_points_offset : 0
         * store_points_offset_amount : 0.00
         * platform_points_offset : 0
         * platform_points_offset_amount : 0.00
         * first_comm : 0.00
         * second_comm : 0.00
         * three_comm : 0.00
         * transfer_remark : null
         * confirm_address : 0
         * exchange_rate : 30.0000
         * delivery_fee : 0.00
         * warehouse_id_t :
         * warehouse_id_j :
         * number_days : 0
         * state_desc : 待发货
         * payment_name : 站内余额支付
         * extend_order_common : {"order_id":"1823","store_id":"32","shipping_time":"0","shipping_express_id":"0","evaluation_time":"0","evalseller_state":"0","evalseller_time":"0","order_message":null,"order_pointscount":"0","has_refund_points":"0","voucher_price":null,"voucher_code":null,"platform_voucher_price":null,"platform_voucher_code":null,"deliver_explain":null,"daddress_id":"45","reciver_name":"非金边","reciver_info":{"phone":"15213200000,15213203075","mob_phone":"15213200000","tel_phone":"15213203075","address":"柬埔寨白马省白马 ក្រុងកែប","area":"柬埔寨白马省白马","street":"ក្រុងកែប","points":"104.319142,10.543246"},"reciver_province_id":"86136","reciver_city_id":"86138","invoice_info":[],"promotion_info":"","dlyo_pickup_code":null,"reciver_area_id":"0","citysend_info":" ","reciver_country_id":"85917","evalseller_country_id":"0","reciver_points":""}
         * extend_order_goods : [{"rec_id":"1979","order_id":"1823","goods_id":"1510","goods_commonid":"933","goods_name":"长袖t恤男士圆领修身男装春秋打底衫学生韩版保暖衣服卫衣男潮流","goods_price":"0.01","goods_costprice":"0.00","goods_num":"1","goods_image":"https://aitecc.com/data/upload/shop/store/goods/32/2018/01/25/32_05702050010574768_60.jpg","goods_pay_price":"0.01","store_id":"32","buyer_id":"1921","goods_type":"1","promotions_id":"0","commis_rate":"0","gc_id":"660","start_time":"0","end_time":"0","dates":null,"days":"0","price_items":null,"hotel_msg":null,"store_points_offset":"0","store_points_offset_amount":"0.00","platform_points_offset":"0","platform_points_offset_amount":"0.00","is_visit_comm":"0","is_Independent_comm":"0","comm_rule":null,"exchange_rate":"30.0000"}]
         */

        private String order_id;
        private String order_sn;
        private String pay_sn;
        private String store_id;
        private String store_name;
        private String buyer_id;
        private String buyer_name;
        private String buyer_email;
        private String add_time;
        private String payment_code;
        private String payment_time;
        private String finnshed_time;
        private String goods_amount;
        private String order_amount;
        private String order_costamount;
        private String rcb_amount;
        private String pd_amount;
        private String shipping_fee;
        private String evaluation_state;
        private String order_state;
        private String refund_state;
        private String lock_state;
        private String delete_state;
        private String refund_amount;
        private String refund_points;
        private String delay_time;
        private String order_from;
        private String shipping_code;
        private String hotel_checked;
        private String picktype;
        private String pay_voucher_img;
        private String order_type;
        private String phy_store_id;
        private String store_points_offset;
        private String store_points_offset_amount;
        private String platform_points_offset;
        private String platform_points_offset_amount;
        private String first_comm;
        private String second_comm;
        private String three_comm;
        private Object transfer_remark;
        private String confirm_address;
        private String exchange_rate;
        private String delivery_fee;
        private String warehouse_id_t;
        private String warehouse_id_j;
        private String number_days;
        private String state_desc;
        private String payment_name;
        private ExtendOrderCommonBean extend_order_common;
        private List<ExtendOrderGoodsBean> extend_order_goods;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public String getPay_sn() {
            return pay_sn;
        }

        public void setPay_sn(String pay_sn) {
            this.pay_sn = pay_sn;
        }

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

        public String getBuyer_id() {
            return buyer_id;
        }

        public void setBuyer_id(String buyer_id) {
            this.buyer_id = buyer_id;
        }

        public String getBuyer_name() {
            return buyer_name;
        }

        public void setBuyer_name(String buyer_name) {
            this.buyer_name = buyer_name;
        }

        public String getBuyer_email() {
            return buyer_email;
        }

        public void setBuyer_email(String buyer_email) {
            this.buyer_email = buyer_email;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getPayment_code() {
            return payment_code;
        }

        public void setPayment_code(String payment_code) {
            this.payment_code = payment_code;
        }

        public String getPayment_time() {
            return payment_time;
        }

        public void setPayment_time(String payment_time) {
            this.payment_time = payment_time;
        }

        public String getFinnshed_time() {
            return finnshed_time;
        }

        public void setFinnshed_time(String finnshed_time) {
            this.finnshed_time = finnshed_time;
        }

        public String getGoods_amount() {
            return goods_amount;
        }

        public void setGoods_amount(String goods_amount) {
            this.goods_amount = goods_amount;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

        public String getOrder_costamount() {
            return order_costamount;
        }

        public void setOrder_costamount(String order_costamount) {
            this.order_costamount = order_costamount;
        }

        public String getRcb_amount() {
            return rcb_amount;
        }

        public void setRcb_amount(String rcb_amount) {
            this.rcb_amount = rcb_amount;
        }

        public String getPd_amount() {
            return pd_amount;
        }

        public void setPd_amount(String pd_amount) {
            this.pd_amount = pd_amount;
        }

        public String getShipping_fee() {
            return shipping_fee;
        }

        public void setShipping_fee(String shipping_fee) {
            this.shipping_fee = shipping_fee;
        }

        public String getEvaluation_state() {
            return evaluation_state;
        }

        public void setEvaluation_state(String evaluation_state) {
            this.evaluation_state = evaluation_state;
        }

        public String getOrder_state() {
            return order_state;
        }

        public void setOrder_state(String order_state) {
            this.order_state = order_state;
        }

        public String getRefund_state() {
            return refund_state;
        }

        public void setRefund_state(String refund_state) {
            this.refund_state = refund_state;
        }

        public String getLock_state() {
            return lock_state;
        }

        public void setLock_state(String lock_state) {
            this.lock_state = lock_state;
        }

        public String getDelete_state() {
            return delete_state;
        }

        public void setDelete_state(String delete_state) {
            this.delete_state = delete_state;
        }

        public String getRefund_amount() {
            return refund_amount;
        }

        public void setRefund_amount(String refund_amount) {
            this.refund_amount = refund_amount;
        }

        public String getRefund_points() {
            return refund_points;
        }

        public void setRefund_points(String refund_points) {
            this.refund_points = refund_points;
        }

        public String getDelay_time() {
            return delay_time;
        }

        public void setDelay_time(String delay_time) {
            this.delay_time = delay_time;
        }

        public String getOrder_from() {
            return order_from;
        }

        public void setOrder_from(String order_from) {
            this.order_from = order_from;
        }

        public String getShipping_code() {
            return shipping_code;
        }

        public void setShipping_code(String shipping_code) {
            this.shipping_code = shipping_code;
        }

        public String getHotel_checked() {
            return hotel_checked;
        }

        public void setHotel_checked(String hotel_checked) {
            this.hotel_checked = hotel_checked;
        }

        public String getPicktype() {
            return picktype;
        }

        public void setPicktype(String picktype) {
            this.picktype = picktype;
        }

        public String getPay_voucher_img() {
            return pay_voucher_img;
        }

        public void setPay_voucher_img(String pay_voucher_img) {
            this.pay_voucher_img = pay_voucher_img;
        }

        public String getOrder_type() {
            return order_type;
        }

        public void setOrder_type(String order_type) {
            this.order_type = order_type;
        }

        public String getPhy_store_id() {
            return phy_store_id;
        }

        public void setPhy_store_id(String phy_store_id) {
            this.phy_store_id = phy_store_id;
        }

        public String getStore_points_offset() {
            return store_points_offset;
        }

        public void setStore_points_offset(String store_points_offset) {
            this.store_points_offset = store_points_offset;
        }

        public String getStore_points_offset_amount() {
            return store_points_offset_amount;
        }

        public void setStore_points_offset_amount(String store_points_offset_amount) {
            this.store_points_offset_amount = store_points_offset_amount;
        }

        public String getPlatform_points_offset() {
            return platform_points_offset;
        }

        public void setPlatform_points_offset(String platform_points_offset) {
            this.platform_points_offset = platform_points_offset;
        }

        public String getPlatform_points_offset_amount() {
            return platform_points_offset_amount;
        }

        public void setPlatform_points_offset_amount(String platform_points_offset_amount) {
            this.platform_points_offset_amount = platform_points_offset_amount;
        }

        public String getFirst_comm() {
            return first_comm;
        }

        public void setFirst_comm(String first_comm) {
            this.first_comm = first_comm;
        }

        public String getSecond_comm() {
            return second_comm;
        }

        public void setSecond_comm(String second_comm) {
            this.second_comm = second_comm;
        }

        public String getThree_comm() {
            return three_comm;
        }

        public void setThree_comm(String three_comm) {
            this.three_comm = three_comm;
        }

        public Object getTransfer_remark() {
            return transfer_remark;
        }

        public void setTransfer_remark(Object transfer_remark) {
            this.transfer_remark = transfer_remark;
        }

        public String getConfirm_address() {
            return confirm_address;
        }

        public void setConfirm_address(String confirm_address) {
            this.confirm_address = confirm_address;
        }

        public String getExchange_rate() {
            return exchange_rate;
        }

        public void setExchange_rate(String exchange_rate) {
            this.exchange_rate = exchange_rate;
        }

        public String getDelivery_fee() {
            return delivery_fee;
        }

        public void setDelivery_fee(String delivery_fee) {
            this.delivery_fee = delivery_fee;
        }

        public String getWarehouse_id_t() {
            return warehouse_id_t;
        }

        public void setWarehouse_id_t(String warehouse_id_t) {
            this.warehouse_id_t = warehouse_id_t;
        }

        public String getWarehouse_id_j() {
            return warehouse_id_j;
        }

        public void setWarehouse_id_j(String warehouse_id_j) {
            this.warehouse_id_j = warehouse_id_j;
        }

        public String getNumber_days() {
            return number_days;
        }

        public void setNumber_days(String number_days) {
            this.number_days = number_days;
        }

        public String getState_desc() {
            return state_desc;
        }

        public void setState_desc(String state_desc) {
            this.state_desc = state_desc;
        }

        public String getPayment_name() {
            return payment_name;
        }

        public void setPayment_name(String payment_name) {
            this.payment_name = payment_name;
        }

        public ExtendOrderCommonBean getExtend_order_common() {
            return extend_order_common;
        }

        public void setExtend_order_common(ExtendOrderCommonBean extend_order_common) {
            this.extend_order_common = extend_order_common;
        }

        public List<ExtendOrderGoodsBean> getExtend_order_goods() {
            return extend_order_goods;
        }

        public void setExtend_order_goods(List<ExtendOrderGoodsBean> extend_order_goods) {
            this.extend_order_goods = extend_order_goods;
        }

        public static class ExtendOrderCommonBean {
            /**
             * order_id : 1823
             * store_id : 32
             * shipping_time : 0
             * shipping_express_id : 0
             * evaluation_time : 0
             * evalseller_state : 0
             * evalseller_time : 0
             * order_message : null
             * order_pointscount : 0
             * has_refund_points : 0
             * voucher_price : null
             * voucher_code : null
             * platform_voucher_price : null
             * platform_voucher_code : null
             * deliver_explain : null
             * daddress_id : 45
             * reciver_name : 非金边
             * reciver_info : {"phone":"15213200000,15213203075","mob_phone":"15213200000","tel_phone":"15213203075","address":"柬埔寨白马省白马 ក្រុងកែប","area":"柬埔寨白马省白马","street":"ក្រុងកែប","points":"104.319142,10.543246"}
             * reciver_province_id : 86136
             * reciver_city_id : 86138
             * invoice_info : []
             * promotion_info :
             * dlyo_pickup_code : null
             * reciver_area_id : 0
             * citysend_info :
             * reciver_country_id : 85917
             * evalseller_country_id : 0
             * reciver_points :
             */

            private String order_id;
            private String store_id;
            private String shipping_time;
            private String shipping_express_id;
            private String evaluation_time;
            private String evalseller_state;
            private String evalseller_time;
            private Object order_message;
            private String order_pointscount;
            private String has_refund_points;
            private Object voucher_price;
            private Object voucher_code;
            private Object platform_voucher_price;
            private Object platform_voucher_code;
            private Object deliver_explain;
            private String daddress_id;
            private String reciver_name;
            private ReciverInfoBean reciver_info;
            private String reciver_province_id;
            private String reciver_city_id;
            private String promotion_info;
            private Object dlyo_pickup_code;
            private String reciver_area_id;
            private String citysend_info;
            private String reciver_country_id;
            private String evalseller_country_id;
            private String reciver_points;
            private List<?> invoice_info;

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getShipping_time() {
                return shipping_time;
            }

            public void setShipping_time(String shipping_time) {
                this.shipping_time = shipping_time;
            }

            public String getShipping_express_id() {
                return shipping_express_id;
            }

            public void setShipping_express_id(String shipping_express_id) {
                this.shipping_express_id = shipping_express_id;
            }

            public String getEvaluation_time() {
                return evaluation_time;
            }

            public void setEvaluation_time(String evaluation_time) {
                this.evaluation_time = evaluation_time;
            }

            public String getEvalseller_state() {
                return evalseller_state;
            }

            public void setEvalseller_state(String evalseller_state) {
                this.evalseller_state = evalseller_state;
            }

            public String getEvalseller_time() {
                return evalseller_time;
            }

            public void setEvalseller_time(String evalseller_time) {
                this.evalseller_time = evalseller_time;
            }

            public Object getOrder_message() {
                return order_message;
            }

            public void setOrder_message(Object order_message) {
                this.order_message = order_message;
            }

            public String getOrder_pointscount() {
                return order_pointscount;
            }

            public void setOrder_pointscount(String order_pointscount) {
                this.order_pointscount = order_pointscount;
            }

            public String getHas_refund_points() {
                return has_refund_points;
            }

            public void setHas_refund_points(String has_refund_points) {
                this.has_refund_points = has_refund_points;
            }

            public Object getVoucher_price() {
                return voucher_price;
            }

            public void setVoucher_price(Object voucher_price) {
                this.voucher_price = voucher_price;
            }

            public Object getVoucher_code() {
                return voucher_code;
            }

            public void setVoucher_code(Object voucher_code) {
                this.voucher_code = voucher_code;
            }

            public Object getPlatform_voucher_price() {
                return platform_voucher_price;
            }

            public void setPlatform_voucher_price(Object platform_voucher_price) {
                this.platform_voucher_price = platform_voucher_price;
            }

            public Object getPlatform_voucher_code() {
                return platform_voucher_code;
            }

            public void setPlatform_voucher_code(Object platform_voucher_code) {
                this.platform_voucher_code = platform_voucher_code;
            }

            public Object getDeliver_explain() {
                return deliver_explain;
            }

            public void setDeliver_explain(Object deliver_explain) {
                this.deliver_explain = deliver_explain;
            }

            public String getDaddress_id() {
                return daddress_id;
            }

            public void setDaddress_id(String daddress_id) {
                this.daddress_id = daddress_id;
            }

            public String getReciver_name() {
                return reciver_name;
            }

            public void setReciver_name(String reciver_name) {
                this.reciver_name = reciver_name;
            }

            public ReciverInfoBean getReciver_info() {
                return reciver_info;
            }

            public void setReciver_info(ReciverInfoBean reciver_info) {
                this.reciver_info = reciver_info;
            }

            public String getReciver_province_id() {
                return reciver_province_id;
            }

            public void setReciver_province_id(String reciver_province_id) {
                this.reciver_province_id = reciver_province_id;
            }

            public String getReciver_city_id() {
                return reciver_city_id;
            }

            public void setReciver_city_id(String reciver_city_id) {
                this.reciver_city_id = reciver_city_id;
            }

            public String getPromotion_info() {
                return promotion_info;
            }

            public void setPromotion_info(String promotion_info) {
                this.promotion_info = promotion_info;
            }

            public Object getDlyo_pickup_code() {
                return dlyo_pickup_code;
            }

            public void setDlyo_pickup_code(Object dlyo_pickup_code) {
                this.dlyo_pickup_code = dlyo_pickup_code;
            }

            public String getReciver_area_id() {
                return reciver_area_id;
            }

            public void setReciver_area_id(String reciver_area_id) {
                this.reciver_area_id = reciver_area_id;
            }

            public String getCitysend_info() {
                return citysend_info;
            }

            public void setCitysend_info(String citysend_info) {
                this.citysend_info = citysend_info;
            }

            public String getReciver_country_id() {
                return reciver_country_id;
            }

            public void setReciver_country_id(String reciver_country_id) {
                this.reciver_country_id = reciver_country_id;
            }

            public String getEvalseller_country_id() {
                return evalseller_country_id;
            }

            public void setEvalseller_country_id(String evalseller_country_id) {
                this.evalseller_country_id = evalseller_country_id;
            }

            public String getReciver_points() {
                return reciver_points;
            }

            public void setReciver_points(String reciver_points) {
                this.reciver_points = reciver_points;
            }

            public List<?> getInvoice_info() {
                return invoice_info;
            }

            public void setInvoice_info(List<?> invoice_info) {
                this.invoice_info = invoice_info;
            }

            public static class ReciverInfoBean {
                /**
                 * phone : 15213200000,15213203075
                 * mob_phone : 15213200000
                 * tel_phone : 15213203075
                 * address : 柬埔寨白马省白马 ក្រុងកែប
                 * area : 柬埔寨白马省白马
                 * street : ក្រុងកែប
                 * points : 104.319142,10.543246
                 */

                private String phone;
                private String mob_phone;
                private String tel_phone;
                private String address;
                private String area;
                private String street;
                private String points;

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getMob_phone() {
                    return mob_phone;
                }

                public void setMob_phone(String mob_phone) {
                    this.mob_phone = mob_phone;
                }

                public String getTel_phone() {
                    return tel_phone;
                }

                public void setTel_phone(String tel_phone) {
                    this.tel_phone = tel_phone;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }

                public String getStreet() {
                    return street;
                }

                public void setStreet(String street) {
                    this.street = street;
                }

                public String getPoints() {
                    return points;
                }

                public void setPoints(String points) {
                    this.points = points;
                }
            }
        }

        public static class ExtendOrderGoodsBean {
            /**
             * rec_id : 1979
             * order_id : 1823
             * goods_id : 1510
             * goods_commonid : 933
             * goods_name : 长袖t恤男士圆领修身男装春秋打底衫学生韩版保暖衣服卫衣男潮流
             * goods_price : 0.01
             * goods_costprice : 0.00
             * goods_num : 1
             * goods_image : https://aitecc.com/data/upload/shop/store/goods/32/2018/01/25/32_05702050010574768_60.jpg
             * goods_pay_price : 0.01
             * store_id : 32
             * buyer_id : 1921
             * goods_type : 1
             * promotions_id : 0
             * commis_rate : 0
             * gc_id : 660
             * start_time : 0
             * end_time : 0
             * dates : null
             * days : 0
             * price_items : null
             * hotel_msg : null
             * store_points_offset : 0
             * store_points_offset_amount : 0.00
             * platform_points_offset : 0
             * platform_points_offset_amount : 0.00
             * is_visit_comm : 0
             * is_Independent_comm : 0
             * comm_rule : null
             * exchange_rate : 30.0000
             */

            private String rec_id;
            private String order_id;
            private String goods_id;
            private String goods_commonid;
            private String goods_name;
            private String goods_price;
            private String goods_costprice;
            private String goods_num;
            private String goods_image;
            private String goods_pay_price;
            private String store_id;
            private String buyer_id;
            private String goods_type;
            private String promotions_id;
            private String commis_rate;
            private String gc_id;
            private String start_time;
            private String end_time;
            private Object dates;
            private String days;
            private Object price_items;
            private Object hotel_msg;
            private String store_points_offset;
            private String store_points_offset_amount;
            private String platform_points_offset;
            private String platform_points_offset_amount;
            private String is_visit_comm;
            private String is_Independent_comm;
            private Object comm_rule;
            private String exchange_rate;

            public String getRec_id() {
                return rec_id;
            }

            public void setRec_id(String rec_id) {
                this.rec_id = rec_id;
            }

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_commonid() {
                return goods_commonid;
            }

            public void setGoods_commonid(String goods_commonid) {
                this.goods_commonid = goods_commonid;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getGoods_costprice() {
                return goods_costprice;
            }

            public void setGoods_costprice(String goods_costprice) {
                this.goods_costprice = goods_costprice;
            }

            public String getGoods_num() {
                return goods_num;
            }

            public void setGoods_num(String goods_num) {
                this.goods_num = goods_num;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getGoods_pay_price() {
                return goods_pay_price;
            }

            public void setGoods_pay_price(String goods_pay_price) {
                this.goods_pay_price = goods_pay_price;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getBuyer_id() {
                return buyer_id;
            }

            public void setBuyer_id(String buyer_id) {
                this.buyer_id = buyer_id;
            }

            public String getGoods_type() {
                return goods_type;
            }

            public void setGoods_type(String goods_type) {
                this.goods_type = goods_type;
            }

            public String getPromotions_id() {
                return promotions_id;
            }

            public void setPromotions_id(String promotions_id) {
                this.promotions_id = promotions_id;
            }

            public String getCommis_rate() {
                return commis_rate;
            }

            public void setCommis_rate(String commis_rate) {
                this.commis_rate = commis_rate;
            }

            public String getGc_id() {
                return gc_id;
            }

            public void setGc_id(String gc_id) {
                this.gc_id = gc_id;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public Object getDates() {
                return dates;
            }

            public void setDates(Object dates) {
                this.dates = dates;
            }

            public String getDays() {
                return days;
            }

            public void setDays(String days) {
                this.days = days;
            }

            public Object getPrice_items() {
                return price_items;
            }

            public void setPrice_items(Object price_items) {
                this.price_items = price_items;
            }

            public Object getHotel_msg() {
                return hotel_msg;
            }

            public void setHotel_msg(Object hotel_msg) {
                this.hotel_msg = hotel_msg;
            }

            public String getStore_points_offset() {
                return store_points_offset;
            }

            public void setStore_points_offset(String store_points_offset) {
                this.store_points_offset = store_points_offset;
            }

            public String getStore_points_offset_amount() {
                return store_points_offset_amount;
            }

            public void setStore_points_offset_amount(String store_points_offset_amount) {
                this.store_points_offset_amount = store_points_offset_amount;
            }

            public String getPlatform_points_offset() {
                return platform_points_offset;
            }

            public void setPlatform_points_offset(String platform_points_offset) {
                this.platform_points_offset = platform_points_offset;
            }

            public String getPlatform_points_offset_amount() {
                return platform_points_offset_amount;
            }

            public void setPlatform_points_offset_amount(String platform_points_offset_amount) {
                this.platform_points_offset_amount = platform_points_offset_amount;
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

            public Object getComm_rule() {
                return comm_rule;
            }

            public void setComm_rule(Object comm_rule) {
                this.comm_rule = comm_rule;
            }

            public String getExchange_rate() {
                return exchange_rate;
            }

            public void setExchange_rate(String exchange_rate) {
                this.exchange_rate = exchange_rate;
            }
        }
    }

    public static class DaddressInfoBean {
        /**
         * address_id : 45
         * store_id : 32
         * seller_name : 柬埔寨商家
         * area_id : 0
         * city_id : 85932
         * area_info : 柬埔寨磅湛省特本克蒙县
         * address : 柬埔寨非金边地址
         * telphone : 146791546784
         * company : 家南项目
         * is_default : 1
         * country_id : 85917
         * province_id : 85931
         * points :
         */

        private String address_id;
        private String store_id;
        private String seller_name;
        private String area_id;
        private String city_id;
        private String area_info;
        private String address;
        private String telphone;
        private String company;
        private String is_default;
        private String country_id;
        private String province_id;
        private String points;

        public String getAddress_id() {
            return address_id;
        }

        public void setAddress_id(String address_id) {
            this.address_id = address_id;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getSeller_name() {
            return seller_name;
        }

        public void setSeller_name(String seller_name) {
            this.seller_name = seller_name;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getArea_info() {
            return area_info;
        }

        public void setArea_info(String area_info) {
            this.area_info = area_info;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTelphone() {
            return telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getIs_default() {
            return is_default;
        }

        public void setIs_default(String is_default) {
            this.is_default = is_default;
        }

        public String getCountry_id() {
            return country_id;
        }

        public void setCountry_id(String country_id) {
            this.country_id = country_id;
        }

        public String getProvince_id() {
            return province_id;
        }

        public void setProvince_id(String province_id) {
            this.province_id = province_id;
        }

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }
    }

    public static class MyExpressListBean {
        /**
         * id : 1
         * e_name : 安信达
         * e_state : 1
         * e_code : anxindakuaixi
         * e_letter : A
         * e_order : 1
         * e_url : http://www.anxinda.com
         * e_zt_state : 1
         */

        private String id;
        private String e_name;
        private String e_state;
        private String e_code;
        private String e_letter;
        private String e_order;
        private String e_url;
        private String e_zt_state;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getE_name() {
            return e_name;
        }

        public void setE_name(String e_name) {
            this.e_name = e_name;
        }

        public String getE_state() {
            return e_state;
        }

        public void setE_state(String e_state) {
            this.e_state = e_state;
        }

        public String getE_code() {
            return e_code;
        }

        public void setE_code(String e_code) {
            this.e_code = e_code;
        }

        public String getE_letter() {
            return e_letter;
        }

        public void setE_letter(String e_letter) {
            this.e_letter = e_letter;
        }

        public String getE_order() {
            return e_order;
        }

        public void setE_order(String e_order) {
            this.e_order = e_order;
        }

        public String getE_url() {
            return e_url;
        }

        public void setE_url(String e_url) {
            this.e_url = e_url;
        }

        public String getE_zt_state() {
            return e_zt_state;
        }

        public void setE_zt_state(String e_zt_state) {
            this.e_zt_state = e_zt_state;
        }
    }
}
