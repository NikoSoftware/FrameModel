package com.example.niko.framemodel.utils.permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description:
 * <p/>
 * Created by 曾辉 on 2016/11/12.
 * QQ：240336124
 * Email: 240336124@qq.com
 * Version：1.0
 */
@Target(ElementType.METHOD)// 放在什么位置  ElementType.METHOD 方法上面
@Retention(RetentionPolicy.RUNTIME)// 是编译时检测 还是 运行时检测
public @interface PermissionFail {
    public int requestCode();// 请求码
}
