package com.example.niko.framemodel.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.niko.framemodel.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Niko on 2016/4/27.
 */
public class RecyclerViewAdapter extends BaseRecyclerViewAdapter<String> {


    public RecyclerViewAdapter(Context context){
        super(context);

    }

    @Override
    public void setViewMap(Map<Integer, Integer[]> map) {
        map.put( R.layout.item_view,new Integer[]{
                R.id.imageview,R.id.textview
        });
    }



    @Override
    public int getItemViewsType(int position) {
        return R.layout.item_view;
    }

    @Override
    public void onBind(BaseViewHandle holder, int position, String obj, int viewType) {

        ImageView imageView = (ImageView) holder.getView(R.id.imageview);
        TextView textView  = (TextView) holder.getView(R.id.textview);
        imageView.setImageResource(R.mipmap.ic_launcher);
        textView.setText(obj);
    }



}
