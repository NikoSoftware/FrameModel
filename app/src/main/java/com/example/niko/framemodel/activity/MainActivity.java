package com.example.niko.framemodel.activity;


import android.Manifest;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.framelib.activtiy.BaseActivity;
import com.example.framelib.utils.permission.PermissionFail;
import com.example.framelib.utils.permission.PermissionHelper;
import com.example.framelib.utils.permission.PermissionSucceed;
import com.example.niko.framemodel.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity {

    public static final int REQUECT_CODE_SDCARD = 2;
    private static final int REQUECT_CODE_CALL_PHONE = 3;
    @BindView(R.id.imageview)
    SimpleDraweeView mImageView;
    @BindView(R.id.btn_net)
    Button mBtnNet;

    @Override
    protected void setLayout() {
        Fresco.initialize(mContext);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
    }


    @Override
    protected void setupViews() {
        /**
         * fresco 网络图片加载
         */
        Log.e("mImageView",(mImageView==null)+"");
        mImageView.setImageURI(Uri.parse("http://f.hiphotos.baidu.com/image/pic/item/00e93901213fb80e0ee553d034d12f2eb9389484.jpg"));
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * 运行时权限
                 */
                PermissionHelper.requestPermission(MainActivity.this, REQUECT_CODE_SDCARD,
                        new String[]{Manifest.permission.CALL_PHONE}, "需要申请电话权限");
            }
        });

        RxView.clicks(mBtnNet)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        skip(mContext, RxjavaAndRetrofitActivity.class);
                    }
                });


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        PermissionHelper.requestPermissionsResult(this, requestCode, permissions);
    }

    /**
     * 运行时权限成功时调用
     */
    @PermissionSucceed(requestCode = REQUECT_CODE_SDCARD)
    private void callPhone() {
        Toast.makeText(mContext, "申请权限成功", Toast.LENGTH_SHORT).show();
    }


    /**
     * 运行时权限失败时调用
     */
    @PermissionFail(requestCode = REQUECT_CODE_SDCARD)
    private void failPermission() {

        Toast.makeText(mContext, "申请权限失败", Toast.LENGTH_SHORT).show();

    }

}
