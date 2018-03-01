package com.example.niko.framemodel.config;

import android.os.Environment;

import java.io.File;

/**
 * Created by niko on 2018/2/27.
 */

public class Config {


    /**
     * SD卡地址
     */
    public static final String SD_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();

    /**
     * 文件储存路径
     */
    public static final String DOC_PATH = SD_PATH+File.separator+"doc";





}
