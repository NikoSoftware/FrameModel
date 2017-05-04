package com.example.niko.framemodel.application;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;


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
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealm.realm")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(config);
    }

}
