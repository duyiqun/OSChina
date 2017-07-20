package com.qun.oschina.glob;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Qun on 2017/7/20.
 */

public class OSChina extends Application {

    public static Handler sMainHandler;
    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sMainHandler = new Handler();
        sContext = this;
    }
}
