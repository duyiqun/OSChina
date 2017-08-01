package com.qun.oschina.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qun.oschina.ui.view.LoaderPager;

/**
 * Created by Qun on 2017/8/1.
 */

public abstract class BaseFragment extends Fragment {

    private LoaderPager mLoaderPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mLoaderPager == null) {
            mLoaderPager = new LoaderPager(getContext()) {
                @Override
                protected Object getNetData() {
                    return getURLData();
                }

                @Override
                protected View createSuccessView() {
                    return createShowView();
                }
            };
        }
        return mLoaderPager;
    }

    //返回一个view
    protected abstract View createShowView();

    //子类返回请求的数据
    public abstract Object getURLData();
}
