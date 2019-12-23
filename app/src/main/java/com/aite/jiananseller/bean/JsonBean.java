package com.aite.jiananseller.bean;


import com.contrarywind.interfaces.IPickerViewData;

import java.util.List;

/**
 * TODO<json数据源>
 *
 * @author: 小嵩
 * @date: 2017/3/16 15:36
 */

public class JsonBean implements IPickerViewData {


    /**
     * name : class1
     * city : [{"name":"北京市","area":["东城区","西城区","崇文区","宣武区","朝阳区"]}]
     */

    private String name;
//    private String id;
    private List<TowClassBean> city;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TowClassBean> getCityList() {
        return city;
    }

    public void setCityList(List<TowClassBean> city) {
        this.city = city;
    }

    // 实现 IPickerViewData 接口，
    // 这个用来显示在PickerView上面的字符串，
    // PickerView会通过IPickerViewData获取getPickerViewText方法显示出来。
    @Override
    public String getPickerViewText() {
        return this.name;
    }


    public static class TowClassBean {
        /**
         * name : 城市
         * area : ["东城区","西城区","崇文区","昌平区"]
         */
//        private String id;
        private String twoClass;
        private List<String> threeClass;

        public String getTwoClass() {
            return twoClass;
        }

        public void setTwoClass(String twoClass) {
            this.twoClass = twoClass;
        }

        public List<String> getThreeClass() {
            return threeClass;
        }

        public void setThreeClass(List<String> threeClass) {
            this.threeClass = threeClass;
        }

//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }



    }
}
