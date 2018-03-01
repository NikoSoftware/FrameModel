package com.example.niko.framemodel.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.framelib.activtiy.BaseActivity;
import com.example.niko.framemodel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by niko on 2018/2/27.
 */

public class HomeActitvity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bt_tool_bar)
    Button btToolBar;
    @BindView(R.id.bt_ok_http)
    Button btOkHttp;
    @BindView(R.id.bt_doc_down)
    Button btDocDown;

    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @Override
    protected void setupViews() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("westar开发框架");
    }


    @OnClick({R.id.bt_tool_bar, R.id.bt_ok_http, R.id.bt_doc_down})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_tool_bar:
                skip(mContext, ToolBarActivity.class);
                break;
            case R.id.bt_ok_http:

                skip(mContext,RxjavaAndRetrofitActivity.class);

                break;
            case R.id.bt_doc_down:
                skip(mContext,MainActivity.class);
                break;
        }
    }
}
