package com.dever.qiubaiwork;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by admin on 2015/12/30.
 */
public class BaseApplicaton extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
