package com.aite.jiananseller.bean;

/**
 * @author:TQX
 * @Date: 2019/11/25
 * @description:
 */
public class UploadBean {

    /**
     * code : 0
     * datas : {"thumb_name":"请上传图片","img_path":""}
     */

    private String thumb_name;
    private String img_path;

    public String getThumb_name() {
        return thumb_name;
    }

    public void setThumb_name(String thumb_name) {
        this.thumb_name = thumb_name;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }
}
