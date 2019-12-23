package com.aite.jiananseller.utils;

import com.google.gson.Gson;

/**
 * @author:TQX
 * @Date:2019/2/14
 * @description:
 */
public class RetrofitUtil {

    private Gson gson = new Gson();
    /**
     * 超时时间
     */
    private static volatile RetrofitUtil mInstance;
//    private AllApi allApi;

    /**
     * 单例封装
     *
     * @return
     */
    public static RetrofitUtil getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitUtil.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化Retrofit
     */
//    public AllApi initRetrofit() {
//        if (allApi == null) {
//            Retrofit mRetrofit = new Retrofit.Builder()
//                    .client(App.initOKHttp())
//                    // 设置请求的域名
//                    .baseUrl(ApiAddress.api)
//                    // 设置解析转换工厂，用自己定义的
//                    .addConverterFactory(LenientGsonConverterFactory.create(gson))
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .build();
//            allApi = mRetrofit.create(AllApi.class);
//        }
//        return allApi;
//    }
}
