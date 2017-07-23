package com.qun.oschina.bean;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.qun.oschina.R;
import com.qun.oschina.ui.fragment.NewsFragment;

/**
 * 枚举类封装数据
 * Created by Qun on 2017/7/23.
 */

public enum MainTabs {

    New("NEWS", "综合", R.drawable.tab_icon_new, NewsFragment.class, null),
    TWEET("TWEET", "动态", R.drawable.tab_icon_tweet, NewsFragment.class, null),
    SELECTOR("SELECTOR", "弹一弹", R.drawable.tab_icon_selector, NewsFragment.class, null),
    EXPLORE("EXPLORE", "发现", R.drawable.tab_icon_explore, NewsFragment.class, null),
    ME("ME", "我的", R.drawable.tab_icon_me, NewsFragment.class, null);

    public String mTag;
    public String mTitle;
    public int mImage;
    public Class<? extends Fragment> mClss;
    public Bundle mBundle;

    MainTabs(String tag, String title, int image, Class<? extends Fragment> clss, Bundle bundle) {
        this.mTag = tag;
        this.mTitle = title;
        this.mImage = image;
        this.mClss = clss;
        this.mBundle = bundle;
    }
}
