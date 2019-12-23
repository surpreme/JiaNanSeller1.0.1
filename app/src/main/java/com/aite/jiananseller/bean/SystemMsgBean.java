package com.aite.jiananseller.bean;

import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/21
 * @description:
 */
public class SystemMsgBean {

    /**
     * new_num : {"newcommon":"4","newsystem":"114","newpersonal":"3","isallowsend":true}
     * message_array : [{"message_id":"5091","message_parent_id":"0","from_member_id":"0","to_member_id":"135","message_title":null,"message_body":"您的订单已经出库。","message_time":"1573610686","message_update_time":"1573610686","message_open":"0","message_state":"0","message_type":"1","read_member_id":"","del_member_id":"","message_ismore":"0","from_member_name":"系统消息","to_member_name":"","order_id":null},{"message_id":"5090","message_parent_id":"0","from_member_id":"0","to_member_id":"135","message_title":null,"message_body":"您的订单已成功提交，订单号：2000000000183601 请尽快付款哦，以免被取消订单。","message_time":"1573610636","message_update_time":"1573610636","message_open":"0","message_state":"0","message_type":"1","read_member_id":"","del_member_id":"","message_ismore":"0","from_member_name":"系统消息","to_member_name":"","order_id":null},{"message_id":"5089","message_parent_id":"0","from_member_id":"0","to_member_id":"135","message_title":null,"message_body":"你的账户于 2019-11-13 10:03 账户资金有变化，描述：predeposit_change，可用金额变化 ：-11.00元，冻结金额变化：0.00元。","message_time":"1573610635","message_update_time":"1573610635","message_open":"0","message_state":"0","message_type":"1","read_member_id":"","del_member_id":"","message_ismore":"0","from_member_name":"系统消息","to_member_name":"","order_id":null},{"message_id":"5041","message_parent_id":"0","from_member_id":"0","to_member_id":"135","message_title":null,"message_body":"您的订单已成功提交，订单号：2000000000182501 请尽快付款哦，以免被取消订单。","message_time":"1573539546","message_update_time":"1573539546","message_open":"0","message_state":"0","message_type":"1","read_member_id":"","del_member_id":"","message_ismore":"0","from_member_name":"系统消息","to_member_name":"","order_id":null},{"message_id":"5040","message_parent_id":"0","from_member_id":"0","to_member_id":"135","message_title":null,"message_body":"你的账户于 2019-11-12 14:19 账户资金有变化，描述：predeposit_change，可用金额变化 ：-120.90元，冻结金额变化：0.00元。","message_time":"1573539546","message_update_time":"1573539546","message_open":"0","message_state":"0","message_type":"1","read_member_id":"","del_member_id":"","message_ismore":"0","from_member_name":"系统消息","to_member_name":"","order_id":null},{"message_id":"5039","message_parent_id":"0","from_member_id":"0","to_member_id":"135","message_title":null,"message_body":"您的订单已成功提交，订单号：2000000000182401 请尽快付款哦，以免被取消订单。","message_time":"1573539511","message_update_time":"1573539511","message_open":"0","message_state":"0","message_type":"1","read_member_id":"","del_member_id":"","message_ismore":"0","from_member_name":"系统消息","to_member_name":"","order_id":null},{"message_id":"4574","message_parent_id":"0","from_member_id":"0","to_member_id":"135","message_title":null,"message_body":"您的订单已成功提交，订单号：2000000000161201 请尽快付款哦，以免被取消订单。","message_time":"1572722225","message_update_time":"1572722225","message_open":"0","message_state":"0","message_type":"1","read_member_id":"","del_member_id":"","message_ismore":"0","from_member_name":"系统消息","to_member_name":"","order_id":null},{"message_id":"4405","message_parent_id":"0","from_member_id":"0","to_member_id":"135","message_title":null,"message_body":"您的订单已成功提交，订单号：2000000000139101 请尽快付款哦，以免被取消订单。","message_time":"1572247534","message_update_time":"1572247534","message_open":"0","message_state":"0","message_type":"1","read_member_id":"","del_member_id":"","message_ismore":"0","from_member_name":"系统消息","to_member_name":"","order_id":null},{"message_id":"4404","message_parent_id":"0","from_member_id":"0","to_member_id":"135","message_title":null,"message_body":"你的账户于 2019-10-28 15:25:34 账户资金有变化，描述：下单，支付预存款，订单号: 2000000000139101，可用金额变化 ：-138.00元，冻结金额变化：0.00元。","message_time":"1572247534","message_update_time":"1572247534","message_open":"0","message_state":"0","message_type":"1","read_member_id":"","del_member_id":"","message_ismore":"0","from_member_name":"系统消息","to_member_name":"","order_id":null},{"message_id":"4382","message_parent_id":"0","from_member_id":"0","to_member_id":"135","message_title":null,"message_body":"关于订单：2000000000138501的款项已经收到，请留意出库通知。","message_time":"1572230463","message_update_time":"1572230463","message_open":"0","message_state":"0","message_type":"1","read_member_id":"","del_member_id":"","message_ismore":"0","from_member_name":"系统消息","to_member_name":"","order_id":null}]
     */

    private NewNumBean new_num;
    private List<MessageArrayBean> message_array;

    public NewNumBean getNew_num() {
        return new_num;
    }

    public void setNew_num(NewNumBean new_num) {
        this.new_num = new_num;
    }

    public List<MessageArrayBean> getMessage_array() {
        return message_array;
    }

    public void setMessage_array(List<MessageArrayBean> message_array) {
        this.message_array = message_array;
    }

    public static class NewNumBean {
        /**
         * newcommon : 4
         * newsystem : 114
         * newpersonal : 3
         * isallowsend : true
         */

        private String newcommon;
        private String newsystem;
        private String newpersonal;
        private boolean isallowsend;

        public String getNewcommon() {
            return newcommon;
        }

        public void setNewcommon(String newcommon) {
            this.newcommon = newcommon;
        }

        public String getNewsystem() {
            return newsystem;
        }

        public void setNewsystem(String newsystem) {
            this.newsystem = newsystem;
        }

        public String getNewpersonal() {
            return newpersonal;
        }

        public void setNewpersonal(String newpersonal) {
            this.newpersonal = newpersonal;
        }

        public boolean isIsallowsend() {
            return isallowsend;
        }

        public void setIsallowsend(boolean isallowsend) {
            this.isallowsend = isallowsend;
        }
    }

    public static class MessageArrayBean {
        /**
         * message_id : 5091
         * message_parent_id : 0
         * from_member_id : 0
         * to_member_id : 135
         * message_title : null
         * message_body : 您的订单已经出库。
         * message_time : 1573610686
         * message_update_time : 1573610686
         * message_open : 0
         * message_state : 0
         * message_type : 1
         * read_member_id :
         * del_member_id :
         * message_ismore : 0
         * from_member_name : 系统消息
         * to_member_name :
         * order_id : null
         */

        private String message_id;
        private String message_parent_id;
        private String from_member_id;
        private String to_member_id;
        private Object message_title;
        private String message_body;
        private String message_time;
        private String message_update_time;
        private String message_open;
        private String message_state;
        private String message_type;
        private String read_member_id;
        private String del_member_id;
        private String message_ismore;
        private String from_member_name;
        private String to_member_name;
        private Object order_id;

        public String getMessage_id() {
            return message_id;
        }

        public void setMessage_id(String message_id) {
            this.message_id = message_id;
        }

        public String getMessage_parent_id() {
            return message_parent_id;
        }

        public void setMessage_parent_id(String message_parent_id) {
            this.message_parent_id = message_parent_id;
        }

        public String getFrom_member_id() {
            return from_member_id;
        }

        public void setFrom_member_id(String from_member_id) {
            this.from_member_id = from_member_id;
        }

        public String getTo_member_id() {
            return to_member_id;
        }

        public void setTo_member_id(String to_member_id) {
            this.to_member_id = to_member_id;
        }

        public Object getMessage_title() {
            return message_title;
        }

        public void setMessage_title(Object message_title) {
            this.message_title = message_title;
        }

        public String getMessage_body() {
            return message_body;
        }

        public void setMessage_body(String message_body) {
            this.message_body = message_body;
        }

        public String getMessage_time() {
            return message_time;
        }

        public void setMessage_time(String message_time) {
            this.message_time = message_time;
        }

        public String getMessage_update_time() {
            return message_update_time;
        }

        public void setMessage_update_time(String message_update_time) {
            this.message_update_time = message_update_time;
        }

        public String getMessage_open() {
            return message_open;
        }

        public void setMessage_open(String message_open) {
            this.message_open = message_open;
        }

        public String getMessage_state() {
            return message_state;
        }

        public void setMessage_state(String message_state) {
            this.message_state = message_state;
        }

        public String getMessage_type() {
            return message_type;
        }

        public void setMessage_type(String message_type) {
            this.message_type = message_type;
        }

        public String getRead_member_id() {
            return read_member_id;
        }

        public void setRead_member_id(String read_member_id) {
            this.read_member_id = read_member_id;
        }

        public String getDel_member_id() {
            return del_member_id;
        }

        public void setDel_member_id(String del_member_id) {
            this.del_member_id = del_member_id;
        }

        public String getMessage_ismore() {
            return message_ismore;
        }

        public void setMessage_ismore(String message_ismore) {
            this.message_ismore = message_ismore;
        }

        public String getFrom_member_name() {
            return from_member_name;
        }

        public void setFrom_member_name(String from_member_name) {
            this.from_member_name = from_member_name;
        }

        public String getTo_member_name() {
            return to_member_name;
        }

        public void setTo_member_name(String to_member_name) {
            this.to_member_name = to_member_name;
        }

        public Object getOrder_id() {
            return order_id;
        }

        public void setOrder_id(Object order_id) {
            this.order_id = order_id;
        }
    }
}
