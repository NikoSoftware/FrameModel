package com.example.niko.framemodel.net;


import com.example.niko.framemodel.model.MusicModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by niko on 2017/3/18.
 */

public interface ApiService {

    //58451795
    @Headers("Cache-Control: max-age=640000")
    @GET("/api/playlist/detail")
    public Observable<Response<MusicModel>> getMusic(@Query("id") String id);

    @Headers("Cache-Control: max-age=640000")
    @GET("/api/playlist/detail")
    public Call<MusicModel> getCallMusic(@Query("id") String id);



}
