package com.wulias.project.ui.fragment;

import android.view.View;

import com.wulias.project.R;
import com.wulias.project.base.MVPFragment;
import com.wulias.project.presenter.ForgetPresenter;

import butterknife.OnClick;

/**
 * 忘记密码
 * Created by 曹小贼 on 2018/10/12.
 */

public class ForgetFragment extends MVPFragment<ForgetPresenter>{
    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int initLayout() {
        return R.layout.fragment_forget;
    }

    @Override
    protected ForgetPresenter initPresenter() {
        return new ForgetPresenter();
    }


}
