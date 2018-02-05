package com.example.framelib.utils.Tools;

import android.content.Context;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by niko on 2017/2/2.
 * 有关Rx的工具类
 */
public class RxNetUtils {
    /**
     * 生命周期绑定
     *
     * @param context Activity或者Fragment
     */
    public static <T> LifecycleTransformer<T> bindToLifecycle(Context context) {
        if (context instanceof LifecycleProvider) {
            return ((LifecycleProvider) context).bindToLifecycle();
        } else {
            throw new IllegalArgumentException("context not the LifecycleProvider type");
        }
    }

    /**
     * 线程调度器
     */
    public static ObservableTransformer schedulersTransformer() {
        return new ObservableTransformer(){

            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

//    public static <T> Observable.Transformer<BaseResponse<T>, T> exceptionTransformer() {
//
//        return new Observable.Transformer() {
//
//            @Override
//            public Object call(Object observable) {
//                return ((Observable) observable).map(new HandleFuc<T>()).onErrorResumeNext(new HttpResponseFunc<T>());
//            }
//        };
//    }
//
//    private static class HttpResponseFunc<T> implements Func1<Throwable, Observable<T>> {
//        @Override
//        public Observable<T> call(Throwable t) {
//            return Observable.error(ExceptionHandle.handleException(t));
//        }
//    }
//
//    private static class HandleFuc<T> implements Func1<BaseResponse<T>, T> {
//        @Override
//        public T call(BaseResponse<T> response) {
//            if (!response.isOk())
//                throw new RuntimeException(response.getCode() + "" + response.getMessage() != null ? response.getMessage() : "");
//            return response.getResult();
//        }
//    }

}
