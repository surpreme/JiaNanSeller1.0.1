package com.aite.jiananseller.bean;

/**
 * @author:TQX
 * @Date: 2019/11/13
 * @description:
 */
public class OrderListBean<T> {
    public T getOrder_list() {
        return order_list;
    }

    public void setOrder_list(T order_list) {
        this.order_list = order_list;
    }

    private  T order_list;
}
