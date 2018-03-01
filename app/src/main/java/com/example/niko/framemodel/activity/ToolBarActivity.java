package com.example.niko.framemodel.activity;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.framelib.activtiy.BaseActivity;
import com.example.niko.framemodel.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by niko on 2018/2/27.
 */

public class ToolBarActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private SearchView searchView;

    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_toolbar);
        ButterKnife.bind(this);
    }

    @Override
    protected void setupViews() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ToolBar 特性");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_toolbar, menu);

        MenuItem menuItem = menu.findItem(R.id.ad_search);//在菜单中找到对应控件的item
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                showSnackbar(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:

                finish();
                break;
        }
        return true;
    }


}
