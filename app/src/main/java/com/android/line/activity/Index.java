package com.android.line.activity;

import android.app.TabActivity;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.TabHost;

import com.android.line.Fragment.Cneter;
import com.android.line.Fragment.MySetting;
import com.android.line.Fragment.Shipping;
import com.android.line.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


public class Index extends FragmentActivity {


    List<Fragment>  mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        mFragments = new ArrayList<Fragment>();
        mFragments.add(new Cneter());
        mFragments.add(new Shipping());
        mFragments.add(new MySetting());
        new TabManager(mFragments, Index.this);
    }


}
