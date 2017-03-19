package com.example.niko.framemodel.activity;

import android.util.Log;
import android.widget.TextView;

import com.example.niko.framemodel.R;
import com.example.niko.framemodel.model.MusicModel;
import com.example.niko.framemodel.netinterface.NetInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by niko on 2017/3/17.
 */

public class RxjavaAndRetrofitActivity extends BaseActivity {

    private String url ="http://music.163.com";
    private TextView mTvContext;

    @Override
    protected void setLayout() {
        setContentView(R.layout.ok_http_activity);
    }

    @Override
    protected void initViews() {

        mTvContext = (TextView)findViewById(R.id.tv_context);

        /**
         * Retrofit 初始化
         */
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        NetInterface netInterface = retrofit.create(NetInterface.class);

        /**
         * Retrofit 网络请求级Rxjava线程切换
         */
        netInterface.getMusic("58451795")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<MusicModel>>(){
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("TAG","onSubscribe");
                    }

                    @Override
                    public void onNext(Response<MusicModel> value) {

                        mTvContext.setText(value.body().getResult().toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG","onComplete");
                    }
                });






    }

    @Override
    protected void setupViews() {


    }



}
