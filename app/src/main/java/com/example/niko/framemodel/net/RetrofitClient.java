package com.example.niko.framemodel.net;

import android.util.Log;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by niko on 2017/4/29.
 */

public class RetrofitClient {
    private static RetrofitClient retrofitClient= null;
    private final static String hostPath = "http://music.163.com";
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


    /**
     * 文件上传下载
     * @param progresslistener
     * @return
     */
    public static ApiService getUploadOrDownloadService(final ProgressListener progresslistener){

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response originalResponse = chain.proceed(chain.request());
                        return originalResponse.newBuilder()
                                .body(new ProgressResponseBody(originalResponse.body(),
                                        progresslistener)).build();

                    }
                })
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        OkHttpClient builder = okHttpClient.build();


        Retrofit retrofit = new Retrofit.Builder().baseUrl(hostPath) // "https://timgsa.baidu.com/"
                .client(builder)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

      return   retrofit.create(ApiService.class);
    }





}
