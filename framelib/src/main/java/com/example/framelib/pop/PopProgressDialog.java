package com.example.framelib.pop;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;

import com.example.framelib.R;
import com.example.framelib.basepopup.BasePopupWindow;

/**
 * Created by niko on 2017/7/22.
 */

public class PopProgressDialog extends BasePopupWindow {
    private  TextView tvIntro;

    public PopProgressDialog(Activity context) {
        super(context);
        tvIntro = (TextView)findViewById(R.id.tv_intro);

    }

    @Override
    public View onCreatePopupView() {
        return createPopupById(R.layout.pop_progress_dialg);
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

    /**
     * 设置说明
     * @param msg
     */
    public void setMsg(String msg){

        tvIntro.setText(msg);
    }

}
