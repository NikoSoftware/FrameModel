package com.example.framelib.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.framelib.pop.PopProgressDialog;
import com.trello.rxlifecycle2.components.support.RxFragment;


/**
 * Created by niko on 2017/1/11.
 */

public abstract class BaseFragment extends RxFragment {

    public Context mContext;
    protected View mView;
    public Bundle mBundle=null;
    private PopProgressDialog mProgressDialog;

    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mBundle = getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        /**
         * 缓存Fragment view
         */
        if (mView == null) {
            mView = setLayout(inflater, container);
        }
        /**
         * 缓存的view需要判断是否已被加过parent，
         * 如果有，则需要从parent删除，
         * 否则，会报错：view已有parent
         */
        ViewGroup parent = (ViewGroup) mView.getParent();
        if (parent != null) {
            parent.removeView(mView);
        }
        setupViews();
        return mView;
    }


    /**
     * 加载布局文件
     *
     * @param inflater  LayoutInflater
     * @param container ViewGroup
     * @return View
     */
    protected abstract View setLayout(LayoutInflater inflater, ViewGroup container);

    /**
     * 给view赋值
     */
    protected abstract void setupViews();


    /**
     * 获得View
     * @param id
     * @param <V>
     * @return
     */
    protected <V> V findViewById(int id) {
        //noinspection unchecked
        if(mView!=null){
            return (V) mView.findViewById(id);
        }
        try {
            throw new Exception("请初始化fragment Layout");
        } catch (Exception e) {
            Log.e("TAG==>", "Exception: 主动抛出异常", e);
        }
        return null;
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
            mProgressDialog.setPopupWindowFullScreen(true);
            mView.post(new Runnable(){
                @Override
                public void run() {
                    mProgressDialog.showPopupWindow();
                }
            });

        }
    }


    /**
     * 网络进度条关闭
     */
    public void dismissProgressDialog(){
        if(mProgressDialog!=null){
            mProgressDialog.dismiss();
        }
    }



    /**
     * 跳转界面 bundle
     * @param mContext 当前跳转的界面
     * @param clazz 要跳转的界面
     * @param bundle 传值
     */
    public void skip(Context mContext, Class clazz, Bundle bundle) {
        Intent intent = new Intent(mContext, clazz);
        if(bundle!=null) {
            intent.putExtras(bundle);
        }
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


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
