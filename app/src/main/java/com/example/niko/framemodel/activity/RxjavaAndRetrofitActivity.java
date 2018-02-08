package com.example.niko.framemodel.activity;

import android.graphics.drawable.Drawable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.framelib.activtiy.BaseActivity;
import com.example.framelib.utils.Tools.StatusBarUtils;
import com.example.niko.framemodel.R;
import com.example.niko.framemodel.adapter.ImageRecyclerViewAdapter;
import com.example.niko.framemodel.model.MusicModel;
import com.example.niko.framemodel.model.TracksBean;
import com.example.niko.framemodel.net.RetrofitClient;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import retrofit2.Response;

/**
 * Created by niko on 2017/3/17.
 */

public class RxjavaAndRetrofitActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.recyclerview)
    XRecyclerView mRecyclerView;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;
    private ImageRecyclerViewAdapter adapter;

    @Override
    protected void setLayout() {
        setContentView(R.layout.ok_http_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void setupViews() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager( 2,
                StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        mRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                requestData();
            }

            @Override
            public void onLoadMore() {

            }
        });
         adapter = new ImageRecyclerViewAdapter(mContext);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.refresh();
    }


    public void requestData(){

        /**
         * Retrofit 网络请求Rxjava线程切换
         */
        RetrofitClient.getApiService().getMusic("58451795")
                .throttleFirst(500, TimeUnit.MILLISECONDS)//500毫秒内同样请求丢弃
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<Response<MusicModel>>bindToLifecycle())
                .subscribe(new Observer<Response<MusicModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("TAG", "onSubscribe");

                    }

                    @Override
                    public void onNext(final Response<MusicModel> value) {

      /*           Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                realm.insert(value.body());

                            }
                        });
                        RealmResults<MusicModel> musicModels = Realm.getDefaultInstance().where(MusicModel.class).findAll();
                        List<TracksBean> resultBean = musicModels.get(3).getResult().getTracks();
                        */
                    final Long startTime =System.currentTimeMillis();
/*
                        Observable.just(value.body())
                                .map(new Function<MusicModel, RealmResults<TracksBean>>() {
                                    @Override
                                    public RealmResults<TracksBean> apply(final MusicModel musicModel) throws Exception {
                                        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                                            @Override
                                            public void execute(Realm realm) {
                                                realm.copyToRealmOrUpdate(musicModel.getResult().getTracks());
                                            }
                                        });
                                        return Realm.getDefaultInstance().where(TracksBean.class).findAll();
                                    }
                                })
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<RealmResults<TracksBean>>() {
                                    @Override
                                    public void accept(RealmResults<TracksBean> tracksBeens) throws Exception {
                                        Long endTime =System.currentTimeMillis();

                                        adapter.setData(tracksBeens);
                                    }
                                });
                        */
                        /**
                         * 数据库存取代码
                         */
                        Realm.getDefaultInstance().executeTransactionAsync(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                realm.copyToRealmOrUpdate(value.body().getResult().getTracks());
                            }
                        });


                        final Long endTime =System.currentTimeMillis();

                        RealmResults<TracksBean>  tracksBeans=Realm.getDefaultInstance().where(TracksBean.class).findAllAsync();
                        tracksBeans.addChangeListener(new RealmChangeListener<RealmResults<TracksBean>>() {
                            @Override
                            public void onChange(RealmResults<TracksBean> element) {
                                adapter.setData(element);
                                Log.e("xendTime", String.valueOf(startTime-endTime));
                            }
                        });
                        adapter.setData(tracksBeans);
                        Log.e("endTime", String.valueOf(startTime-endTime));

                    }

                    @Override
                    public void onError(Throwable e) {
                        mRecyclerView.refreshComplete();
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        mRecyclerView.refreshComplete();
                        Log.e("TAG", "onComplete");
                    }
                });




    }



    @Override
    public void setStatusBar() {
        StatusBarUtils.with(this)
                .init();
    }
}
