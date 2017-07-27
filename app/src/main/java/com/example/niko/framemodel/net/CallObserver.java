package com.example.niko.framemodel.net;

import android.util.Log;

import com.example.niko.framemodel.model.ResultModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

/**
 * 网络请求回调方法
 * Created by niko on 2017/7/14.
 */

public abstract class CallObserver<T> implements Observer<Response<ResultModel<T>>> {


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Response<ResultModel<T>> value) {

        if(value!=null&&value.body()!=null) {
            Log.e("TAG==>",value.body().toString() + "");
        }else{
            Log.e("TAG==>",value + "");
        }

        /**
         * code 由项目后台协定，暂时默认0为网络请求正确
         */
        if(value.body().getCode()==0){
            onSuccess(value.body().getData());
        }else{
            onFailure(value.body().getMsg());
        }
    }


    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onFailure("网络异常");
    }

    @Override
    public void onComplete() {

    }

    /**
     * 网络请求成功
     * @param t
     */
    public abstract void onSuccess(T t);

    /**
     * 网络请求失败
     * @param msg
     */
    public abstract void onFailure(String msg);

}
