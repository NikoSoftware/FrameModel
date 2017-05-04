package com.example.niko.framemodel.model;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by niko on 2017/3/18.
 */

public class MusicModel extends RealmObject {


    /**
     * result : {"subscribers":[],"subscribed":false,"creator":{},"artists":null,"tracks":[],"ordered":true,"tags":[],"adType":0,"trackNumberUpdateTime":1426573494520,"cloudTrackCount":0,"status":10,"privacy":0,"newImported":false,"subscribedCount":413,"specialType":0,"anonimous":false,"description":"丹特","userId":18608696,"coverImgId":7868105208878634,"totalDuration":0,"highQuality":false,"updateTime":1426577277886,"commentThreadId":"A_PL_0_58451795","trackCount":30,"createTime":1426343880849,"playCount":157036,"trackUpdateTime":1483695939310,"coverImgUrl":"http://p1.music.126.net/5FyIC3n9K7LTbChuxraFuQ==/7868105208878634.jpg","name":"2015 春天","id":58451795,"shareCount":17,"commentCount":27}
     * code : 200
     */


    private ResultBean result;
    private int code;


    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }



    @Override
    public String toString() {
        return "MusicModel{" +
                "result=" + result +
                ", code=" + code +
                '}';
    }
}
