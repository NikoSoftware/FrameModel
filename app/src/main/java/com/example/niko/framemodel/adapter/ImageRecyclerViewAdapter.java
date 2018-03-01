package com.example.niko.framemodel.adapter;

import android.content.Context;

import com.example.framelib.adapter.BaseRecyclerViewAdapter;
import com.example.framelib.adapter.BaseViewHandle;
import com.example.niko.framemodel.R;
import com.example.niko.framemodel.model.TracksBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.Map;

/**
 * Created by niko on 2017/5/3.
 */

public class ImageRecyclerViewAdapter extends BaseRecyclerViewAdapter<TracksBean> {
    public ImageRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    public void setViewMap(Map<Integer, Integer[]> map) {
        map.put( R.layout.recycler_item_view,new Integer[]{
                R.id.imageview
        });
    }

    @Override
    public void onBind(BaseViewHandle holder, int position, TracksBean model, int viewType) {
        ((SimpleDraweeView) holder.getView(R.id.imageview)).setImageURI(model.getAlbum().getBlurPicUrl());
    }

    @Override
    public int getItemViewsType(int position) {
        return R.layout.recycler_item_view;
    }
}
