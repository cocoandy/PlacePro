package com.wulias.project.ui.activity;

import android.arch.lifecycle.Observer;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wulias.project.R;
import com.wulias.project.base.MVPActivity;
import com.wulias.project.constacts.Constacts;
import com.wulias.project.listener.CallBack;
import com.wulias.project.presenter.LoginPresenter;
import com.wulias.project.tool.LiveDataBus;
import com.wulias.project.ui.fragment.ForgetFragment;
import com.wulias.project.ui.fragment.LoginFragment;
import com.wulias.project.ui.fragment.RegistFragment;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends MVPActivity<LoginPresenter> implements CallBack.LoginCallBack
{
    final int ACTION_TYPE_LOGIN = 1;//登录
    final int ACTION_TYPE_REGIST = 2;//注册
    final int ACTION_TYPE_FORGET = 3;//忘记密码

    @BindView(R.id.toolbar)
    Toolbar mTbTitle;
    @BindView(R.id.tv_login_action)
    TextView mTvAction;
    @BindView(R.id.tv_title)
    TextView mTvTitle;


    private LoginFragment loginFragment;
    private RegistFragment registFragment;
    private ForgetFragment forgetFragment;


    private int actionType = 0;

    @Override
    public void initView() {
        changeTodo(ACTION_TYPE_LOGIN);
        mTvTitle.setText(R.string.title_login);
        setToolbar(mTbTitle, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @OnClick({R.id.tv_login_action})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login_action:
                if (actionType == ACTION_TYPE_LOGIN) {
                    //转换成注册
                    changeTodo(ACTION_TYPE_REGIST);
                    mTvTitle.setText(R.string.title_regist);
                } else {
                    //转换成登录
                    changeTodo(ACTION_TYPE_LOGIN);
                    mTvTitle.setText(R.string.title_login);
                }

                break;
        }
    }

    /**
     * 切换界面
     *
     * @param actionType
     */
    public void changeTodo(int actionType) {

        if (this.actionType == actionType) {
            return;
        }
        this.actionType = actionType;

        switch (actionType) {
            case ACTION_TYPE_LOGIN:
                if (loginFragment == null) {
                    loginFragment = new LoginFragment();
                    loginFragment.setLoginCallBack(this);
                }
                commitFragment(loginFragment, R.id.fl_login_main);
                mTvAction.setText(getResources().getString(R.string.action_regist));
                break;
            case ACTION_TYPE_REGIST:
                if (registFragment == null) {
                    registFragment = new RegistFragment();
                }
                commitFragment(registFragment, R.id.fl_login_main);
                mTvAction.setText(getResources().getString(R.string.action_login));
                break;
            case ACTION_TYPE_FORGET:
                if (forgetFragment == null) {
                    forgetFragment = new ForgetFragment();
                }
                commitFragment(forgetFragment, R.id.fl_login_main);
                break;
        }
    }

    @Override
    public void changeForget() {
        changeTodo(ACTION_TYPE_FORGET);
    }
}
