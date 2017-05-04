package com.example.niko.framemodel.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by niko on 2017/4/29.
 */

public class RetrofitClient {
    private static RetrofitClient retrofitClient= null;
    private final String hostPath = "http://music.163.com";
    private static ApiService apiService=null;


    private RetrofitClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpInterceptor())
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        /**
         * Retrofit 初始化
         */
        Retrofit retrofit = new Retrofit.Builder().baseUrl(hostPath)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
         apiService = retrofit.create(ApiService.class);
    }

     /**
     * 获得请求接口服务
     * @return
     */
    public static ApiService getApiService(){
        if(apiService==null){
            retrofitClient = new RetrofitClient();
        }
        return  apiService;
    }




}
