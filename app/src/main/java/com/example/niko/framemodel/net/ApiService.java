package com.example.niko.framemodel.net;


import com.example.niko.framemodel.model.MusicModel;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by niko on 2017/3/18.
 */

public interface ApiService {


    /**
     * 获取链接信息
     * @param id
     * @return
     */
    //58451795
    @Headers("Cache-Control: max-age=640000")
    @GET("/api/playlist/detail")
    public Observable<Response<MusicModel>> getMusic(@Query("id") String id);


    /**
     * 获取音乐数据
     * @param id
     * @return
     */
    @Headers("Cache-Control: max-age=640000")
    @GET("/api/playlist/detail")
    public Call<MusicModel> getCallMusic(@Query("id") String id);


    /**
     * 文件下载
     * @param url 文件下载地址
     * @return
     */
    @Streaming
    @GET
    Call<ResponseBody> downloadFile(@Url String url);


}
