package com.aite.jiananseller.bean;

import java.util.List;

/**
 * @author:TQX
 * @Date: 2019/11/24
 * @description:
 */
public class AreaBean {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * area_id : 1
         * area_name : 中国大陆
         * citylist : [{"area_id":"2","area_name":"北京"},{"area_id":"3","area_name":"天津"},{"area_id":"4","area_name":"河北"},{"area_id":"5","area_name":"山西"},{"area_id":"6","area_name":"内蒙古"},{"area_id":"7","area_name":"辽宁"},{"area_id":"8","area_name":"吉林"},{"area_id":"9","area_name":"黑龙江"},{"area_id":"10","area_name":"上海"},{"area_id":"11","area_name":"江苏"},{"area_id":"12","area_name":"浙江"},{"area_id":"13","area_name":"安徽"},{"area_id":"14","area_name":"福建"},{"area_id":"15","area_name":"江西"},{"area_id":"16","area_name":"山东"},{"area_id":"17","area_name":"河南"},{"area_id":"18","area_name":"湖北"},{"area_id":"19","area_name":"湖南"},{"area_id":"20","area_name":"广东"},{"area_id":"21","area_name":"广西"},{"area_id":"22","area_name":"海南"},{"area_id":"23","area_name":"重庆"},{"area_id":"24","area_name":"四川"},{"area_id":"25","area_name":"贵州"},{"area_id":"26","area_name":"云南"},{"area_id":"27","area_name":"西藏"},{"area_id":"28","area_name":"陕西"},{"area_id":"29","area_name":"甘肃"},{"area_id":"30","area_name":"青海"},{"area_id":"31","area_name":"宁夏"},{"area_id":"32","area_name":"新疆"}]
         */

        private String area_id;
        private String area_name;
        private List<CitylistBean> citylist;

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public List<CitylistBean> getCitylist() {
            return citylist;
        }

        public void setCitylist(List<CitylistBean> citylist) {
            this.citylist = citylist;
        }

        public static class CitylistBean {
            /**
             * area_id : 2
             * area_name : 北京
             */

            private String area_id;
            private String area_name;

            public String getArea_id() {
                return area_id;
            }

            public void setArea_id(String area_id) {
                this.area_id = area_id;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }
        }
    }
}
