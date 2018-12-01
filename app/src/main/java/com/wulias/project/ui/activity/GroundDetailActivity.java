package com.wulias.project.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wulias.project.R;
import com.wulias.project.base.MVPActivity;
import com.wulias.project.bean.entity.GroundBean;
import com.wulias.project.bean.entity.GroundItemBean;
import com.wulias.project.presenter.GroundDetailPresenter;
import com.wulias.project.ui.adapter.GroundAdapter;
import com.wulias.project.ui.adapter.GroundDetailAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GroundDetailActivity extends MVPActivity<GroundDetailPresenter> {
    @BindView(R.id.recycle)
    RecyclerView recycle;

    private List mDatas;

    GroundDetailAdapter adapter;

    @Override
    public void initView() {
        initRecycle();
    }

    @Override
    public void initData() {
        mDatas.add(new GroundBean("123","123"));
        mDatas.add(new GroundItemBean("123","123"));
        mDatas.add(new GroundItemBean("123","123"));
        mDatas.add(new GroundItemBean("123","123"));
        adapter.notifyDataSetChanged();
    }

    @Override
    public int initLayout() {
        return R.layout.activity_ground_info;
    }

    @Override
    protected GroundDetailPresenter initPresenter() {
        return new GroundDetailPresenter();
    }

    private void initRecycle() {
        mDatas  = new ArrayList();
        adapter = new GroundDetailAdapter(mContext, mDatas);
        recycle.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        recycle.setLayoutManager(new LinearLayoutManager(mContext));
        recycle.setAdapter(adapter);
    }
}
