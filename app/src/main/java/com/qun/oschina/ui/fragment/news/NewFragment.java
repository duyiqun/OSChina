package com.qun.oschina.ui.fragment.news;

import android.view.View;

import com.qun.oschina.R;
import com.qun.oschina.ui.fragment.BaseFragment;

/**
 * 资讯
 * Created by Qun on 2017/7/25.
 */

public class NewFragment extends BaseFragment {

    //返回一个view
    @Override
    protected View createShowView() {
        View view = View.inflate(getContext(), R.layout.fragment_new, null);
        return view;
    }

    //返回一个数据
    @Override
    public Object getURLData() {
        return "";
    }
}
