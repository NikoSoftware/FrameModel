package com.example.niko.framemodel.net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by niko on 2017/5/1.
 */

public class HttpInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Log.e("request:    ",chain.request().url().toString());
        Response response =chain.proceed(chain.request());

        Log.e("response:    ",response.body().toString());


        return response;
    }
}
