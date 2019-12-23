package com.aite.jiananseller.net;

import android.util.Log;

import com.aite.jiananseller.app.App;
import com.aite.jiananseller.base.BaseData;
import com.aite.jiananseller.base.BaseData2;
import com.aite.jiananseller.base.BaseData3;
import com.aite.jiananseller.base.BaseObserver;
import com.aite.jiananseller.base.BaseObserver2;
import com.aite.jiananseller.base.BaseObserver3;
import com.aite.jiananseller.utils.BeanConvertor;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;


import io.reactivex.Observable;

/**
 * @author:TQX
 * @Date: 2019/8/6
 * @description:
 */
public class OkGoUtil {


    /**
     * post请求 数据结构一
     *
     * @param url
     * @param params
     * @param baseObserver
     * @param <T>
     */
    public static <T> void postRequest(String url, HttpParams params, BaseObserver<T> baseObserver) {
        OkGo.<Observable<BaseData<T>>>post(url)
                .tag(App.app)
                .params(params)
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new AbsCallback<Observable<BaseData<T>>>() {
                    @Override
                    public void onSuccess(Response<Observable<BaseData<T>>> response) {
                        response.body().subscribe(baseObserver);
                    }

                    @Override
                    public Observable<BaseData<T>> convertResponse(okhttp3.Response response) {
                        return Observable.create(emitter -> {
                            String body = response.body().string();
                            Log.e("m_tag", "convertResponse: " + body);
                            BaseData baseData = BeanConvertor.convertBean(body, BaseData.class);
                            emitter.onNext(baseData);
                        });
                    }
                });
    }

    /**
     * post请求 数据结构二
     *
     * @param url
     * @param params
     * @param baseObserver
     * @param <T>
     */
    public static <T> void postRequest(String url, HttpParams params, BaseObserver2<T> baseObserver) {
        OkGo.<Observable<BaseData2<T>>>post(url)
                .tag(App.app)
                .params(params)
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new AbsCallback<Observable<BaseData2<T>>>() {
                    @Override
                    public void onSuccess(Response<Observable<BaseData2<T>>> response) {
                        response.body().subscribe(baseObserver);
                    }

                    @Override
                    public Observable<BaseData2<T>> convertResponse(okhttp3.Response response) {
                        return Observable.create(emitter -> {
                            String body = response.body().string();
                            Log.e("m_tag", "convertResponse: " + body);
                            BaseData2 baseData = BeanConvertor.convertBean(body, BaseData2.class);
                            emitter.onNext(baseData);
                        });
                    }
                });
    }

    /**
     * post请求 数据结构三 分页列表加载
     *
     * @param url
     * @param params
     * @param baseObserver
     * @param <T>
     */
    public static <T> void postRequest(String url, HttpParams params, BaseObserver3<T> baseObserver) {
        OkGo.<Observable<BaseData3<T>>>post(url)
                .tag(App.app)
                .params(params)
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new AbsCallback<Observable<BaseData3<T>>>() {
                    @Override
                    public void onSuccess(Response<Observable<BaseData3<T>>> response) {
                        response.body().subscribe(baseObserver);
                    }

                    @Override
                    public Observable<BaseData3<T>> convertResponse(okhttp3.Response response) {
                        return Observable.create(emitter -> {
                            String body = response.body().string();
                            Log.e("m_tag", "convertResponse: " + body);
                            BaseData3 baseData = BeanConvertor.convertBean(body, BaseData3.class);
                            emitter.onNext(baseData);
                        });
                    }
                });
    }


    public static <T> void getRequest(String url, HttpParams params, BaseObserver<T> baseObserver) {
        OkGo.<Observable<BaseData<T>>>get(url)
                .tag(App.app)
                .params(params)
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new AbsCallback<Observable<BaseData<T>>>() {
                    @Override
                    public void onSuccess(Response<Observable<BaseData<T>>> response) {
                        response.body().subscribe(baseObserver);
                    }

                    @Override
                    public Observable<BaseData<T>> convertResponse(okhttp3.Response response) {
                        return Observable.create(emitter -> {
                            String body = response.body().string();
                            Log.e("m_tag", "convertResponse: " + body);
                            BaseData baseData = BeanConvertor.convertBean(body, BaseData.class);
                            emitter.onNext(baseData);
                        });
                    }
                });
    }

    public static <T> void getRequest(String url, HttpParams params, BaseObserver2<T> baseObserver) {
        OkGo.<Observable<BaseData2<T>>>get(url)
                .tag(App.app)
                .params(params)
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new AbsCallback<Observable<BaseData2<T>>>() {
                    @Override
                    public void onSuccess(Response<Observable<BaseData2<T>>> response) {
                        response.body().subscribe(baseObserver);
                    }

                    @Override
                    public Observable<BaseData2<T>> convertResponse(okhttp3.Response response) {
                        return Observable.create(emitter -> {
                            String body = response.body().string();
                            Log.e("m_tag", "convertResponse: " + body);
                            BaseData2 baseData = BeanConvertor.convertBean(body, BaseData2.class);
                            emitter.onNext(baseData);
                        });
                    }
                });
    }

    public static <T> void getRequest(String url, HttpParams params, BaseObserver3<T> baseObserver) {
        OkGo.<Observable<BaseData3<T>>>get(url)
                .tag(App.app)
                .params(params)
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new AbsCallback<Observable<BaseData3<T>>>() {
                    @Override
                    public void onSuccess(Response<Observable<BaseData3<T>>> response) {
                        response.body().subscribe(baseObserver);
                    }

                    @Override
                    public Observable<BaseData3<T>> convertResponse(okhttp3.Response response) {
                        return Observable.create(emitter -> {
                            String body = response.body().string();
                            Log.e("m_tag", "convertResponse: " + body);
                            BaseData3 baseData = BeanConvertor.convertBean(body, BaseData3.class);
                            emitter.onNext(baseData);
                        });
                    }
                });
    }


}
