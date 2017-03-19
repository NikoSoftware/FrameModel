package com.example.niko.framemodel.netinterface;


import com.example.niko.framemodel.model.MusicModel;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by niko on 2017/3/18.
 */

public interface NetInterface {


    //58451795

    @GET("/api/playlist/detail")
    public Observable<Response<MusicModel>> getMusic(@Query("id") String id);

}
