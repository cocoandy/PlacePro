package com.wulias.project.ui.fragment;

import com.wulias.project.R;
import com.wulias.project.base.MVPActivity;
import com.wulias.project.base.MVPFragment;
import com.wulias.project.presenter.RegistPresenter;

/**
 * 注册
 * Created by 曹小贼 on 2018/10/12.
 */

public class RegistFragment extends MVPFragment<RegistPresenter> {
    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int initLayout() {
        return R.layout.fragment_regist;
    }

    @Override
    protected RegistPresenter initPresenter() {
        return new RegistPresenter();
    }
}
