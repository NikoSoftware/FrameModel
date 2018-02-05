package com.example.niko.framemodel.net;


import android.app.Activity;
import android.content.Context;

import java.io.InputStream;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.internal.operators.observable.ObservableCreate;

/**
 * Created by niko on 2017/11/6.
 */

public abstract class  ProgressListener {

    private Context mContext;
    public ProgressListener(Context context) {
        mContext = context;
    }

    /**
     *
     * @param progress 已经下载或上传字节数
     * @param total 总字节数
     * @param done 是否完成
     */
    public abstract void onProgress(long progress, long total, boolean done);



   public void onAsyMainProgress(final long progress, final long total, final boolean done){

       ((Activity) mContext).runOnUiThread(new Runnable() {
           @Override
           public void run() {
               onProgress(progress,total,done);
           }
       });
   }



}
