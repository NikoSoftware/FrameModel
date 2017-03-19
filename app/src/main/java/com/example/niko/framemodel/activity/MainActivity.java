package com.example.niko.framemodel.activity;



import android.Manifest;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.niko.framemodel.R;

import com.example.niko.framemodel.utils.permission.PermissionFail;
import com.example.niko.framemodel.utils.permission.PermissionHelper;
import com.example.niko.framemodel.utils.permission.PermissionSucceed;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends BaseActivity {

    public static final int REQUECT_CODE_SDCARD = 2;
    private static final int REQUECT_CODE_CALL_PHONE = 3;
    private Button mBtnNet;
    private SimpleDraweeView mImageView;

    @Override
    protected void setLayout() {
        Fresco.initialize(mContext);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initViews() {

        mImageView = (SimpleDraweeView)findViewById(R.id.imageview);
        mBtnNet = (Button)findViewById(R.id.btn_net);
    }


   @Override
    protected void setupViews() {
       /**
        * fresco 网络图片加载
        */
       mImageView.setImageURI(Uri.parse("http://f.hiphotos.baidu.com/image/pic/item/00e93901213fb80e0ee553d034d12f2eb9389484.jpg"));
       mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * 运行时权限
                 */
                PermissionHelper.requestPermission(MainActivity.this, REQUECT_CODE_SDCARD,
                        new String[]{Manifest.permission.CALL_PHONE},"需要申请电话权限");
            }
        });

       mBtnNet.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               skip(mContext,RxjavaAndRetrofitActivity.class);
           }
       });


    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        PermissionHelper.requestPermissionsResult(this,requestCode,permissions);
    }

    /**
     * 运行时权限成功时调用
     */
    @PermissionSucceed(requestCode = REQUECT_CODE_SDCARD)
    private void callPhone() {
        Toast.makeText(mContext,"申请权限成功",Toast.LENGTH_SHORT).show();
    }


    /**
     * 运行时权限失败时调用
     */
    @PermissionFail(requestCode = REQUECT_CODE_SDCARD)
    private void failPermission(){

        Toast.makeText(mContext,"申请权限失败",Toast.LENGTH_SHORT).show();

    }



}
