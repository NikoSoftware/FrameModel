package com.example.framelib.activtiy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.framelib.pop.PopProgressDialog;

/**
 * 基类
 * Created by niko on 2017/1/11.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected String TAG;//页面名称
    protected Context mContext;
    private Bundle mBundle;
    private PopProgressDialog mProgressDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mBundle = getIntent().getExtras();
        setLayout();
        initViews();
        setupViews();
        getActivityTag();
    }



    /**
     * 为Activity添加布局文件
     */
    protected abstract void setLayout();

    /**
     * 获取activity TAG
     *
     * @return String
     */
    protected  String getActivityTag(){

        return TAG;
    }

    /**
     * 初始化控件
     */
    protected abstract void initViews();

    /**
     * 为控件填充内容
     */
    protected abstract void setupViews();





    /**
     * 跳转界面
     *
     * @param mContext 当前跳转的界面
     * @param clazz    要跳转的界面
     */
    public  void skip(Context mContext, Class clazz) {
        Intent intent = new Intent(mContext, clazz);
        mContext.startActivity(intent);
    }

    /**
     * 跳转界面 bundle
     * @param mContext 当前跳转的界面
     * @param clazz 要跳转的界面
     * @param bundle 传值
     */
    public void skip(Context mContext, Class clazz, Bundle bundle) {
        Intent intent = new Intent(mContext, clazz);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    /**
     * 跳转界面带回调函数
     * @param mContext
     * @param clazz
     * @param bundle
     */
    public void skipForResult(Context mContext, Class clazz, Bundle bundle, int requestCode){
        Intent intent = new Intent(mContext, clazz);
        if(bundle!=null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent,requestCode);
    }




    /**
     * 点击任意位置关闭软键盘
     * 在指派Touch事件时拦截，由于安卓的Touch事件是自顶而下的，所以Activity是第一响应者
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // 类型为Down才处理，还有Move/Up之类的
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            // 当前拥有焦点的View
            if (this.getCurrentFocus() != null) {
                closeSoftInput(getCurrentFocus());
            }
        }
        // 继续指派Touch事件，如果这里不执行基类的dispatchTouchEvent，事件将不会继续往下传递
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 关闭软键盘
     *
     * @param view View
     */
    protected void closeSoftInput(View view) {
        if (view != null) {
            if (view.getWindowToken() != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            } else {

            }
        }
    }

    /**
     * 按键监听
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /**
         * 回退键监听
         */
        if(keyCode == KeyEvent.KEYCODE_BACK ){

        }
        return super.onKeyDown(keyCode,event);
    }

    /**
     * 回退键点击时监听
     */
    public void onKeyBack(){


    }



    /**
     * 网络进度条启动
     */
    public void showProgressDialog(){
        showProgressDialog("加载中");
    }



    /**
     * 网络进度条启动
     * @param msg
     */
    public void showProgressDialog(String msg){
        if(mProgressDialog==null) {
            mProgressDialog = new PopProgressDialog((Activity) mContext);
            mProgressDialog.setBackPressEnable(false);
            mProgressDialog.setPopupWindowFullScreen(true);
            this.findViewById(android.R.id.content).post(new Runnable() {
                @Override
                public void run() {
                    mProgressDialog.showPopupWindow();
                }
            });

        }else{
            mProgressDialog.showPopupWindow();
        }
    }


    /**
     * 网络进度条关闭
     */
    public void dismissProgressDialog(){
        /**
         * 注意要等待视图加载完成
         */
        this.findViewById(android.R.id.content).post(new Runnable() {
            @Override
            public void run() {
                if(mProgressDialog!=null){
                    mProgressDialog.dismiss();
                }
            }
        });
    }



    /**
     * 显示Toast信息
     * @param msg  String
     */
    public void showSnackbar(String msg) {

        View view = this.getWindow().getDecorView();
        if (view != null && msg != null && !"".equals(msg) && !"null".equals(msg)) {
            Snackbar.make(view, msg, Snackbar.LENGTH_SHORT)
                    .setAction("取消", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // nothing
                        }
                    })
                    .show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }
}
