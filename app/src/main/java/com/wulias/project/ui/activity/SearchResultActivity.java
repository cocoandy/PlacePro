package com.wulias.project.ui.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.wulias.project.R;
import com.wulias.project.base.MVPActivity;
import com.wulias.project.constacts.Constacts;
import com.wulias.project.presenter.SearchResultPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchResultActivity extends MVPActivity<SearchResultPresenter> {
    @BindView(R.id.toolbar)
    Toolbar mTbTitle;
    @BindView(R.id.tv_search)
    TextView mTvSearch;

    @Override
    public void initView() {
        setToolbar(mTbTitle, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        mTvSearch.setText(intent.getStringExtra(Constacts.Key.KEY_SEARCH_VALUE));
    }

    @Override
    public int initLayout() {
        return R.layout.activity_search_result;
    }

    @Override
    protected SearchResultPresenter initPresenter() {
        return new SearchResultPresenter();
    }

    @OnClick({})
    public void onClick(View view){
        switch (view.getId()){
        }
    }
}
