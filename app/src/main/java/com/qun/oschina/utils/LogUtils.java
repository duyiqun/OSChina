package com.qun.oschina.utils;

import android.util.Log;

/**
 * 描述:工具类
 * Created by Qun on 2017/7/20.
 */

public class LogUtils {
    //定义全局的标志
    public static boolean sIsOpen = true;

    public static void info(String msg) {
        if (sIsOpen) {
            Log.i("OSChina info message:", msg);
        }
    }
}
