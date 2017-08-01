package com.qun.oschina.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.qun.oschina.R;
import com.qun.oschina.viewholder.NewViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 资讯的显示列表
 * Created by Qun on 2017/8/1.
 */

public class NewListAdapter extends RecyclerView.Adapter {

    private List<Object> mShowItems = new ArrayList<>();

    public NewListAdapter(List<Object> showItems) {
        mShowItems = showItems;
    }

    //返回一个viewholder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_new, null);
        return new NewViewHolder(view);
    }

    //绑定更新数据
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int viewType) {

    }

    //条目
    @Override
    public int getItemCount() {
        return mShowItems.size();
    }
}
