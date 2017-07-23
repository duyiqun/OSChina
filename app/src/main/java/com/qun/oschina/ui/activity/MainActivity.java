package com.qun.oschina.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.qun.oschina.R;
import com.qun.oschina.bean.MainTabs;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_main_show_layout)
    FrameLayout mFlMainShowLayout;
    @BindView(R.id.ftab_main_bottom_layout)
    FragmentTabHost mFtabMainBottomLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        //初始化底部
        //1.跟显示的界面关联
        //2.初始化底部页签

        //关联
        mFtabMainBottomLayout.setup(this, getSupportFragmentManager(), R.id.fl_main_show_layout);
        //最大化ctrl+shift+F12
        //alt+1:打开工程窗口

        /**
         * 第一个参数 页签
         * 第二个参数 class代表fragment的class
         * 第三个参数 参数
         */

//        //文字数组
//        String[] tabs = Utils.getStringArray(R.array.tabs_arrays);
//        //图片数组
//        int[] images = {R.drawable.tab_icon_new, R.drawable.tab_icon_tweet, R.drawable.tab_icon_selector, R.drawable.tab_icon_explore, R.drawable.tab_icon_explore};
//
//        for (int i = 0; i < tabs.length; i++) {
//
//            TabHost.TabSpec tabSpec = mFtabMainBottomLayout.newTabSpec("tag" + i);//复用
//
//            //设置显示的view
//            View view = View.inflate(this, R.layout.tab_indicator, null);
//
//            //动态的设置文字
//            TextView title = (TextView) view.findViewById(R.id.tab_title);
//            title.setText(tabs[i]);
//            //动态的设置图片
//            ImageView icon = (ImageView) view.findViewById(R.id.iv_icon);
//            icon.setImageResource(images[i]);
//
//            tabSpec.setIndicator(view);
//
//            Class<?> clss = NewsFragment.class;
//            Bundle args = new Bundle();
//            args.putString("point", i + "");
//            mFtabMainBottomLayout.addTab(tabSpec, clss, args);
//        }

        MainTabs[] tabs = MainTabs.values();
        for (int i = 0; i < tabs.length; i++) {

            Bundle args = new Bundle();
            args.putString("point", i + "");
            addTab(tabs[i], args);
        }

        //去掉分隔线
        mFtabMainBottomLayout.getTabWidget().setDividerDrawable(null);
    }

    private void addTab(MainTabs tab, Bundle args) {
        TabHost.TabSpec tabSpec = mFtabMainBottomLayout.newTabSpec(tab.mTag);//复用

        //设置显示的view
        View view = View.inflate(this, R.layout.tab_indicator, null);

        //动态的设置文字
        TextView title = (TextView) view.findViewById(R.id.tab_title);
        title.setText(tab.mTitle);
        //动态的设置图片
        ImageView icon = (ImageView) view.findViewById(R.id.iv_icon);
        icon.setImageResource(tab.mImage);

        tabSpec.setIndicator(view);

        Class<?> clss = tab.mClss;
        mFtabMainBottomLayout.addTab(tabSpec, clss, args);
    }
}
