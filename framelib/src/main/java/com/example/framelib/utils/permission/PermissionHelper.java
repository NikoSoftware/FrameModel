package com.example.framelib.utils.permission;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

import java.util.List;

/**
 * Created by Niko on 2016/4/27.
 */
public class PermissionHelper {
    // 1. 传什么参数
    // 1.1. Object Fragment or Activity  1.2. int 请求码   1.3.需要请求的权限  string[]
    private Object mObject;
    private int mRequestCode;
    private String[] mRequestPermission;
    private String mHint=null;

    private PermissionHelper(Object object){
        this.mObject = object;
    }

    // 2.已什么的方式传参数
    // 2.1 直接传参数
    public static void  requestPermission(Activity activity, int requestCode, String[] permissions, String hint){
            PermissionHelper.with(activity).requestCode(requestCode).
                    requestPermission(permissions).setHint(hint).request();
    }

    public static void  requestPermission(Fragment fragment, int requestCode, String[] permissions, String hint){
        PermissionHelper.with(fragment).requestCode(requestCode).
                requestPermission(permissions).setHint(hint).request();
    }

    // 2.2 链式的方式传
    // 传Activity
    public static PermissionHelper with(Activity activity){
        return new PermissionHelper(activity);
    }

    // 传Fragment
    public static PermissionHelper with(Fragment fragment){
        return new PermissionHelper(fragment);
    }

    // 添加一个请求码
    public PermissionHelper requestCode(int requestCode){
        this.mRequestCode = requestCode;
        return this;
    }

    // 添加请求的权限数组
    public PermissionHelper requestPermission(String... permissions){
        this.mRequestPermission = permissions;
        return this;
    }
    //设置提示信息
    private PermissionHelper setHint(String hint){

        this.mHint = hint;
        return this;
    }

    /**
     * 3.1 真正判断和发起请求权限
     */
    public void request() {
        // 3.2 首先判断当前的版本是不是6.0 及以上
        if(!PermissionUtils.isOverMarshmallow()){
            // 3.3 如果不是6.0以上  那么直接执行方法   反射获取执行方法
            // 执行什么方法并不确定 那么我们只能采用注解的方式给方法打一个标记，
            // 然后通过反射去执行。  注解 + 反射  执行Activity里面的callPhone
            PermissionUtils.executeSucceedMethod(mObject,mRequestCode);
            return;
        }

        // 3.3 如果是6.0以上  那么首先需要判断权限是否授予
        // 需要申请的权限中 获取没有授予过得权限
        List<String> deniedPermissions = PermissionUtils.getDeniedPermissions(mObject,mRequestPermission);

        // 3.3.1 如果授予了 那么我们直接执行方法   反射获取执行方法
        if(deniedPermissions.size() == 0){
            // 全部都是授予过的
            PermissionUtils.executeSucceedMethod(mObject,mRequestCode);
        }else {
            warnHint(deniedPermissions);
        }
    }


    /**
     *  如果没有授予 那么我们就申请权限  申请权限
     */
    private void requestPermissions(List<String> deniedPermissions){
        ActivityCompat.requestPermissions(PermissionUtils.getActivity(mObject),
                deniedPermissions.toArray(new String[deniedPermissions.size()]),
                mRequestCode);
    }

    /**
     * 警告提示
     */
    public void warnHint(final List<String> deniedPermissions){

        if(mHint==null){
            requestPermissions(deniedPermissions);
            return ;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(PermissionUtils.getActivity(mObject));
        builder.setTitle("权限提示");
        builder.setMessage(mHint);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                requestPermissions(deniedPermissions);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create();
        builder.show();
    }


    /**
     * 处理申请权限的回调
    */
    public static void requestPermissionsResult(Object object, int requestCode,
                                                String[] permissions) {
        // 再次获取没有授予的权限
        List<String> deniedPermissions = PermissionUtils.getDeniedPermissions(object,permissions);

        if(deniedPermissions.size() == 0){
            // 权限用户都同意授予了
            PermissionUtils.executeSucceedMethod(object,requestCode);
        }else{
            // 你申请的权限中 有用户不同意的
            PermissionUtils.executeFailMethod(object,requestCode);
        }
    }
}
