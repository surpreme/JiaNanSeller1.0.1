package com.aite.jiananseller.utils;


//import com.aite.Base.BaseData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * @param
 * @author chenkuidou
 * @description bean转化类
 * @date 2019/1/7 20:17
 * @return
 **/
public class BeanConvertor {

    /**
     * 方法说明：将bean转化为另一种bean实体
     *
     * @param object
     * @param entityClass
     * @return
     */
    public static <T> T convertBean(Object object, Class<T> entityClass) {
        if (null == object) {
            return null;
        }
        return JSON.parseObject(JSON.toJSONString(object), entityClass);
    }

    public static <T> T convertBean(String value, Class<T> entityClass) {
        JSONObject jsonObj = (JSONObject) JSON.parse(value);
        if (null == jsonObj) {
            return null;
        }
        return JSON.parseObject(JSON.toJSONString(jsonObj), entityClass);
    }

    /**
     * 方法说明：对象转换(List)
     *
     * @param list             原对象
     * @param target           目标对象
     * @param ignoreProperties 排除要copy的属性
     * @return
     */
    public static <T, E> List<T> convertList(List<E> list, Class<T> target, String... ignoreProperties) {
        List<T> targetList = new ArrayList<>();
        if (list.size() == 0) {
            return targetList;
        }
        for (E e : list) {
            targetList.add(convertBean(e, target));
        }
        return targetList;
    }
    /**
     * 方法说明：对象转换(List)
     *
     * @param target           目标对象
     * @param ignoreProperties 排除要copy的属性
     * @return
     */
    public static <T> List<T> convertList(Object object, Class<T> target, String... ignoreProperties) {
        if (null == object) {
            return null;
        }
        List<T> targetList =  JSON.parseArray(JSON.toJSONString(object),target);
        return targetList;
    }
    public static <T> List<T> convertList(String object, Class<T> target, String... ignoreProperties) {
        if (null == object) {
            return null;
        }
        List<T> targetList =  JSON.parseArray(object,target);
        return targetList;
    }

    /**
     * 返回的obj有分页的数据的直接获得list
     *
     * @param value
     * @param target
     * @param ignoreProperties
     * @param <T>
     * @return
     */
//    public static <T> List<T> getPageBeanList(Object value, Class<T> target, String... ignoreProperties) {
//        List<T> targetList = new ArrayList<>();
//        JSONObject data = ResponseCodeUtil.getData(value);
//        PageInfo pageInfo = BeanConvertor.convertBean(data, PageInfo.class);
//        targetList = BeanConvertor.convertList(pageInfo.getList(), target);
//        return targetList;
//    }
//
    public static <T> T getBean(String value, String key, Class<T> target, String... ignoreProperties) {
        JSONObject jsonObj = (JSONObject) JSON.parse(value);
        JSONObject data = ResponseCodeUtil.getData(jsonObj).getJSONObject(key);
        return BeanConvertor.convertBean(data, target);
    }

    public static <T> T getBean(String value, Class<T> target, String... ignoreProperties) {
        JSONObject jsonObj = (JSONObject) JSON.parse(value);
        JSONObject data = ResponseCodeUtil.getData(jsonObj);
        return BeanConvertor.convertBean(data, target);
    }

//    public static boolean isError(String value) {
//        JSONObject respons = JSON.parseObject(value);
//        BaseData data = BeanConvertor.convertBean(respons, BaseData.class);
//        if (!data.isSuccess()) {
//            return true;
//        } else {
//            return false;
//        }
//    }

//    public static <T> T getList(String value, String key, Class<T> target, String... ignoreProperties) {
//        List<T> targetList = new ArrayList<>();
//        JSONObject jsonObj = (JSONObject) JSON.parse(value);
//        JSONObject data = ResponseCodeUtil.getData(jsonObj).getJSONObject(key);
//        targetList = BeanConvertor.convertList(data, target);
//        return targetList;
//    }

}
