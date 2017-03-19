package com.example.niko.framemodel.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Niko on 2016/4/27.
 */
public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseViewHandle> {
    protected Context context;
    protected  int size;
    protected List<T> list;
    protected Map<Integer,Integer[]> map = new HashMap<Integer,Integer[]>();

    public BaseRecyclerViewAdapter(Context context){
        this.context= context;
        setViewMap(map);
    }


    /**
     * 设置数据
     * @param list
     */
    public void setData(List<T> list){
        this.list =list;
        if(list==null){
            size= 0;
        }else {
            size = list.size();
        }
        notifyDataSetChanged();
    }


    /**
     * 设置hashmap 布局
     * @param map
     */
    public abstract void setViewMap(Map<Integer,Integer[]> map);



    @Override
    public BaseViewHandle onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(viewType,parent,false);

        return new BaseViewHandle(view,map.get(viewType));
    }

    @Override
    public void onBindViewHolder(BaseViewHandle holder, int position) {

        onBind(holder,position,list.get(position),getItemViewType(position));
    }

    public abstract void onBind(BaseViewHandle holder, int position,T obj,int viewType);

    @Override
    public int getItemCount() {
        return size;
    }

    @Override
    public int getItemViewType(int position) {
        return getItemViewsType(position);
    }

    public abstract int getItemViewsType(int position);

}
