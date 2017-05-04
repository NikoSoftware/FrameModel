package com.example.niko.framemodel.net;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/**
 * 转换 null 为 ""  或者 “” 为 null
 * Created by niko on 2017/5/1.
 */

public class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<T> rawType = (Class<T>) type.getRawType();
        Log.e("TAG==>",rawType.toString());
        if (rawType != String.class) {
            return null;
        }
        return (TypeAdapter<T>) new StringNullAdapter();
    }
}
