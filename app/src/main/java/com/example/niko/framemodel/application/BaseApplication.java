package com.example.niko.framemodel.application;

import android.app.Application;
import android.content.Context;


/**

 * Created by niko on 2017/1/11.
 */

public class BaseApplication extends Application {

    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    /**
     * 初始化数据
     */
    private void init() {



    }

}
