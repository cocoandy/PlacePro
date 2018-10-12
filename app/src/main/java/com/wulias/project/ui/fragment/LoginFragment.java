package com.wulias.project.ui.fragment;

import android.provider.ContactsContract;
import android.view.View;

import com.wulias.project.R;
import com.wulias.project.base.MVPFragment;
import com.wulias.project.constacts.Constacts;
import com.wulias.project.listener.CallBack;
import com.wulias.project.presenter.LoginPresenter;
import com.wulias.project.tool.LiveDataBus;

import butterknife.OnClick;

/**
 * 登录
 * Created by 曹小贼 on 2018/10/11.
 */

public class LoginFragment extends MVPFragment<LoginPresenter> {

    private CallBack.LoginCallBack loginCallBack;

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int initLayout() {
        return R.layout.fragment_login;
    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @OnClick({R.id.tv_login_forget})
    public void OnClick(View view) {
        if (loginCallBack != null) {

            loginCallBack.changeForget();
        }
    }

    public void setLoginCallBack(CallBack.LoginCallBack loginCallBack) {
        this.loginCallBack = loginCallBack;
    }
}
