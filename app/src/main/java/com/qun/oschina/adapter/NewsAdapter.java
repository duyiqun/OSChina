package com.qun.oschina.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.qun.oschina.bean.FragmentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qun on 2017/7/25.
 */

public class NewsAdapter extends FragmentStatePagerAdapter {

    private List<FragmentInfo> mShowItems = new ArrayList<>();

    public NewsAdapter(FragmentManager fm, List<FragmentInfo> showItems) {
        super(fm);
        this.mShowItems = showItems;
    }

    //返回显示的fragment
    @Override
    public Fragment getItem(int position) {
        return mShowItems.get(position).fragment;
    }

    //fragment有多少个
    @Override
    public int getCount() {
        return mShowItems.size();
    }

    //标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mShowItems.get(position).title;
    }
}
