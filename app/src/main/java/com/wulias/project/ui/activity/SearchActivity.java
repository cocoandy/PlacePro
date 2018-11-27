package com.wulias.project.ui.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.wulias.project.R;
import com.wulias.project.base.MVPActivity;
import com.wulias.project.constacts.Constacts;
import com.wulias.project.listener.OnTagClickListener;
import com.wulias.project.presenter.SearchPresenter;
import com.wulias.project.ui.adapter.TagAdapter;
import com.wulias.project.weight.FlowTagLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 输入查询条件界面
 */
public class SearchActivity extends MVPActivity<SearchPresenter> {

    @BindView(R.id.toolbar)
    Toolbar mTbTitle;
    @BindView(R.id.et_scaner)
    EditText mEtSearch;
    @BindView(R.id.color_flow_layout)
    FlowTagLayout mColorFlowTagLayout;

    private TagAdapter<String> mColorTagAdapter;
    private int mPage; //1.首页 2.场地   (首页跳转下个界面，场地跳转回自己)

    @Override
    public void initView() {
        setToolbar(mTbTitle, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //颜色
        mColorTagAdapter = new TagAdapter<>(this);
        mColorFlowTagLayout.setAdapter(mColorTagAdapter);
        mColorFlowTagLayout.setOnTagClickListener(new OnTagClickListener() {
            @Override
            public void onItemClick(FlowTagLayout parent, View view, int position) {
                toSearch(parent.getAdapter().getItem(position)+"");
            }
        });
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        mPage = intent.getIntExtra(Constacts.INTENT.KEY_PAGE_TYPE,1);
        initColorData();
    }

    @Override
    public int initLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected SearchPresenter initPresenter() {
        return new SearchPresenter();
    }

    @OnClick({R.id.et_scaner, R.id.bnt_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_scaner:
                break;
            case R.id.bnt_search:
                toSearch(mEtSearch.getText().toString().trim());
                break;
        }
    }

    /**
     * 获取查询的值，跳转到相应的结果界面
     * @param value
     */
    public void toSearch(String value) {
        Intent intent = new Intent();
        intent.putExtra(Constacts.Key.KEY_SEARCH_VALUE, value);
        if (mPage==1){
            intent.setClass(mContext, SearchResultActivity.class);
            startActivity(intent);
        }else {
            setResult(Constacts.RESULTCODE.CODE_SEARCH_VALUE,intent);
            finish();
        }

    }

    private void initColorData() {
        List<String> dataSource = new ArrayList<>();
        dataSource.add("红色");
        dataSource.add("黑色");
        dataSource.add("花边色");
        dataSource.add("深蓝色");
        dataSource.add("白色");
        dataSource.add("玫瑰红色");
        dataSource.add("紫黑紫兰色");
        dataSource.add("葡萄红色");
        dataSource.add("屎黄色");
        dataSource.add("绿色");
        dataSource.add("彩虹色");
        dataSource.add("牡丹色");
        mColorTagAdapter.onlyAddAll(dataSource);
    }
}
