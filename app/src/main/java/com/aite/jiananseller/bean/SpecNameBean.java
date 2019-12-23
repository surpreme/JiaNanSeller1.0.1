package com.aite.jiananseller.bean;

/**
 * @author:TQX
 * @Date: 2019/11/24
 * @description:
 */
public class SpecNameBean {

    /**
     * spec_id : 1
     * spec_name : 颜色分类
     */

    private int spec_id;
    private String spec_name;

    public SpecNameBean(int spec_id, String spec_name) {
        this.spec_id = spec_id;
        this.spec_name = spec_name;
    }

    public int getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(int spec_id) {
        this.spec_id = spec_id;
    }

    public String getSpec_name() {
        return spec_name;
    }

    public void setSpec_name(String spec_name) {
        this.spec_name = spec_name;
    }

    @Override
    public String toString() {
        return "SpecNameBean{" +
                "spec_id=" + spec_id +
                ", spec_name='" + spec_name + '\'' +
                '}';
    }
}
