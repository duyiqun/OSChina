package com.qun.oschina.bean;

import android.support.v4.app.Fragment;

/**
 * Created by Qun on 2017/7/25.
 */

public class FragmentInfo {

    public Fragment fragment;
    //标题
    public String title;

    public FragmentInfo(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }
}
