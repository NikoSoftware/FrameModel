package com.example.framelib.pop;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.framelib.R;
import com.example.framelib.basepopup.BasePopupWindow;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by niko on 2017/11/7.
 */

public class PopDownLoadProgress extends BasePopupWindow {
    private SimpleDraweeView ivImage;
    private TextView tvDocName;
    private ProgressBar progressBar;

    public PopDownLoadProgress(Activity context) {
        super(context);
        init();
    }

    private void init() {

        ivImage = (SimpleDraweeView)findViewById(R.id.iv_image);
        tvDocName = (TextView)findViewById(R.id.tv_doc_name);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

    }

    /**
     * 主题
     * @param name
     * @return
     */
    public PopDownLoadProgress setTitle(String name, @DrawableRes Integer image){
        tvDocName.setText(name);
        if(image!=null) {
            ivImage.setBackgroundResource(image);
        }
        return this;
    }


    /**
     * 进度
     * @param progress
     * @param total
     * @return
     */
    public PopDownLoadProgress setProgress(long progress,long total){

        progressBar.setProgress((int) progress);
        progressBar.setMax((int) total);

        return this;
    }


    @Override
    public View onCreatePopupView() {
        return createPopupById(R.layout.pop_download_progress);
    }

    @Override
    public View initAnimaView() {
        return null;
    }

    @Override
    protected Animation initShowAnimation() {
        return null;
    }

    @Override
    public View getClickToDismissView() {
        return null;
    }
}
