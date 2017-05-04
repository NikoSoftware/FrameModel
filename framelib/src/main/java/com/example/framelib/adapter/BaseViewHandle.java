package com.example.framelib.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by Niko on 2016/4/27.
 */
public class BaseViewHandle extends RecyclerView.ViewHolder {

    private SparseArray<View> views = new SparseArray<View>();
    public BaseViewHandle(View itemView,Integer[] widgetIds) {
        super(itemView);
        for(Integer widgetId : widgetIds){

           views.put(widgetId, itemView.findViewById(widgetId));
        }
    }

    public View getView(Integer id){
        return views.get(id);
    }


}
