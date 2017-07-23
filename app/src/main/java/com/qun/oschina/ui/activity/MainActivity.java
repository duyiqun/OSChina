package com.qun.oschina.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TabHost;

import com.qun.oschina.R;
import com.qun.oschina.ui.fragment.NewsFragment;

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
        for (int i = 0; i < 5; i++) {
            TabHost.TabSpec tabSpec = mFtabMainBottomLayout.newTabSpec("tag" + i);//复用

            //设置显示的view
            View view = View.inflate(this, R.layout.tab_indicator, null);
            tabSpec.setIndicator(view);

            Class<?> clss = NewsFragment.class;
            Bundle args = new Bundle();
            args.putString("point", i + "");
            mFtabMainBottomLayout.addTab(tabSpec, clss, args);
        }

        //去掉分隔线
        mFtabMainBottomLayout.getTabWidget().setDividerDrawable(null);
    }
}
