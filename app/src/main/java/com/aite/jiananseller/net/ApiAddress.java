package com.aite.jiananseller.net;

/**
 * @author:TQX
 * @Date: 2019/7/3
 * @description:
 */
public class ApiAddress {
    //    public static final String api = "https://www.aitecc.com/mobile/";
//    public static final String api = "https://piikmall.aitecc.com/mobile/";
    public static final String api = "https://daluxmall.com/mobile/";
    //获取验证码
    public static final String URL_POST_AUTHCODE = api + "index.php?act=login&op=get_mobile_vcode";
    //注册
    public static final String URL_POST_REGISTER = api + "index.php?act=login&op=register";
    //注册协议
    public static final String URL_POST_REGISTER_CONTENT = api + "index.php?act=login&op=get_agreement";
    //登录
    public static final String URL_POST_LOGIN = api + "index.php?act=login&op=loginThreeWay";
    //忘记密码
    public static final String URL_POST_UPDATE_PW = api + "index.php?act=member_secret&op=find_pass_step2";
    //登出
    public static final String URL_LOGINOUT = api + "index.php?act=logout";
    //忘记密码获取验证码
    public static final String URL_GET_AUTH_CODE = api + "index.php?act=member_secret&op=find_pass_step1";
    //商家信息
    public static final String URL_GET_SELLER_INFO = api + "index.php?act=seller_center&op=index";
    //首页 统计未读消息接口
    public static final String URL_POST_UNREADMSGNUMBER_INFO = api + "index.php?act=member_message&op=showReceivedNewNum";
    //上架商品列表
    public static final String URL_GET_GOOS_UP_LIST = api + "index.php?act=seller_goods_online&op=index";
    //上架商品列表2
    public static final String URL_GET_GOOS_UP_LIST2 = api + "index.php?act=seller_goods_offline&op=index";
    //订单列表
    public static final String URL_GET_ORDER_LIST = api + "index.php?act=seller_order&op=index";
    //卖家中心--删除商品
    public static final String URL_POST_DELETE_GOODS = api + "index.php?act=seller_goods_online&op=drop_goods";
    //卖家中心--商品下架
    public static final String URL_POST_GOODS_UNSHOW = api + "index.php?act=seller_goods_online&op=goods_unshow";
    //卖家中心--商品上架
    public static final String URL_POST_GOODS_SHOW = api + "index.php?act=seller_goods_offline&op=goods_show";
    //订单物流
    public static final String URL_POST_EXPRESS_INFO = api + "index.php?act=seller_order&op=search_deliver";
    //订单信息
    public static final String URL_POST_ORDER_SEND_INFO = api + "index.php?act=seller_order&op=send";
    //获取店铺的经营数据
    public static final String URL_POST_STORE_INFO = api + "index.php?act=seller_center&op=business_data";
    //系统站内信列表
    public static final String URL_POST_SYSTEM_MSG = api + "index.php?act=member_message&op=systemmsg";
    //站内信列表
    public static final String URL_POST_PERSONAL_MSG = api + "index.php?act=member_message&op=personalmsg";
    //订单发货操作
    public static final String URL_POST_SAVE_SEND = api + "index.php?act=seller_order&op=savesend";
    //获取物品类型
    public static final String URL_POST_GET_GOODS_CLASS = api + "index.php?act=seller_goods&op=storebindclass";
    //获取物品结构类型
    public static final String URL_POST_GET_GOODS_TYPE = api + "index.php?act=seller_goods&op=index";
    //添加商品规格值
    public static final String URL_POST_ADD_GOODS_TYPE = api + "index.php?act=seller_goods&op=add_spec";
    //获取可选择区域信息
    public static final String URL_POST_GET_AREA_BEAN = api + "index.php?act=index&op=getAreaList";
    //编辑商品(简版)
    public static final String URL_POST_EDIT_GOODS = api + "index.php?act=seller_goods_online&op=edit_save_goods_new";
    //保存商品(简版)
    public static final String URL_POST_SAVE_GOODS = api + "index.php?act=seller_goods&op=save_add_new";
    //上传图片
    public static final String URL_POST_IMAGE_UPLOAD = api + "index.php?act=seller_goods&op=image_upload";
    //获取上传图片类型
    public static final String URL_POST_GET_PHOTO_TYPE = api + "index.php?act=seller_goods&op=add_step_three";
    //获取空间照片
    public static final String URL_POST_GET_SPACE_PHOTO = api + "index.php?act=seller_goods&op=album_pic";
    //保存商品颜色图片
//    public static final String URL_POST_SAVE_COLOR_PHOTO = api + "index.php?act=seller_goods&op=save_image";
    public static final String URL_POST_SAVE_COLOR_PHOTO = api + "index.php?act=seller_goods_online&op=edit_save_image";
    //编辑商品页面
    public static final String URL_POST_EDIT_GOODS_INFO = api + "index.php?act=seller_goods_online&op=edit_goods";
    //编辑商品页面提交
    public static final String URL_POST_EDIT_GOODS_COMMIT = api + "index.php?act=seller_goods_online&op=edit_goods";
    //获取手机区号及城市名称
    public static final String URL_POST_GET_AREA_CODE = api + "index.php?act=index&op=getAreaCode";

}
