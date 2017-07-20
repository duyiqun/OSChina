package com.qun.oschina.utils;

import android.widget.Toast;

import com.qun.oschina.glob.OSChina;

public class ToastUtil {

    private static Toast sToast;

    /**
     * 强大的吐司，能够连续弹的吐司
     *
     * @param text
     */
    public static void showToast(final String text) {
        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                if (sToast == null) {
                    sToast = Toast.makeText(OSChina.sContext, text, Toast.LENGTH_SHORT);
                } else {
                    sToast.setText(text);//如果不为空，则直接改变当前toast的文本
                }
                sToast.show();
            }
        });
    }
}
