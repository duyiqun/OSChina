package com.qun.oschina.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qun.oschina.R;
import com.qun.oschina.adapter.NewsAdapter;
import com.qun.oschina.bean.FragmentInfo;
import com.qun.oschina.ui.fragment.news.NewFragment;
import com.qun.oschina.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Qun on 2017/7/23.
 */

public class NewsFragment extends Fragment {

    @BindView(R.id.tab_news_titles_layout)
    TabLayout mTabNewsTitlesLayout;
    @BindView(R.id.vp_news_show_layout)
    ViewPager mVpNewsShowLayout;
    Unbinder unbinder;

    private List<FragmentInfo> mShowItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //获取参数
//        Bundle arguments = getArguments();
//        String point = arguments.getString("point");
//
//        TextView textView = new TextView(getContext());
//        textView.setText("我是子界面" + point);

        View view = View.inflate(getContext(), R.layout.fragment_news, null);
        unbinder = ButterKnife.bind(this, view);

        init();

        return view;
    }

    private void init() {

        //标题
        String[] titles = Utils.getStringArray(R.array.general_viewpage_arrays);
        //显示的fragment
        Class[] clss = {NewFragment.class, NewFragment.class, NewFragment.class, NewFragment.class};

        //通过循环初始化
        for (int i = 0; i < titles.length; i++) {
            try {
//                FragmentInfo info = new FragmentInfo();
//                info.fragment = (Fragment) clss[i].newInstance();
//                info.title = titles[i];
//                mShowItems.add(info);

                mShowItems.add(new FragmentInfo((Fragment) clss[i].newInstance(), titles[i]));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        //初始化viewpager
        mVpNewsShowLayout.setAdapter(new NewsAdapter(getChildFragmentManager(), mShowItems));

        //页签与viewpager绑定
        mTabNewsTitlesLayout.setupWithViewPager(mVpNewsShowLayout);

        //设置tablayout的颜色
        int normalColor = Color.parseColor("#AFAFAF");
        int selectedColor = Color.parseColor("#1EA238");
        mTabNewsTitlesLayout.setTabTextColors(normalColor, selectedColor);

        //设置tablayout底部导航的颜色
        mTabNewsTitlesLayout.setSelectedTabIndicatorColor(selectedColor);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }
}
