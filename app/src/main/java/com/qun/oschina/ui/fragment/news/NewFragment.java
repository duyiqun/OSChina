package com.qun.oschina.ui.fragment.news;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qun.oschina.R;
import com.qun.oschina.adapter.NewListAdapter;
import com.qun.oschina.ui.fragment.BaseFragment;
import com.qun.oschina.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 资讯
 * Created by Qun on 2017/7/25.
 */

public class NewFragment extends BaseFragment {

    @BindView(R.id.rv_new_list_layout)
    RecyclerView mRvNewListLayout;
    Unbinder unbinder;

    private List<Object> mShowItems = new ArrayList<>();
    private NewListAdapter mNewListAdapter;

    //返回一个view
    @Override
    protected View createShowView() {
        View view = View.inflate(getContext(), R.layout.fragment_new, null);
        unbinder = ButterKnife.bind(this, view);

        init();
        return view;
    }

    private void init() {
        //1.给个布局管理器
        //2.设置adapter
        mRvNewListLayout.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        mNewListAdapter = new NewListAdapter(mShowItems);
        mRvNewListLayout.setAdapter(mNewListAdapter);
    }

    //返回一个数据
    @Override
    public Object getURLData() {

        for (int i = 0; i < 100; i++) {
            mShowItems.add(i);
        }

        //模拟的去请求数据
        Utils.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                mNewListAdapter.notifyDataSetChanged();
            }
        });

        return "";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
