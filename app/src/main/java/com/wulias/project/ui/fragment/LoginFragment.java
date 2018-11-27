package com.wulias.project.ui.fragment;

import android.view.View;
import android.widget.EditText;

import com.wulias.project.R;
import com.wulias.project.base.BaseBean;
import com.wulias.project.base.LoginBean;
import com.wulias.project.base.MVPFragment;
import com.wulias.project.bean.vo.LoginVo;
import com.wulias.project.bean.vo.UserVo;
import com.wulias.project.listener.CallBack;
import com.wulias.project.manage.ResultManage;
import com.wulias.project.presenter.LoginPresenter;
import com.wulias.project.tool.MsgTool;
import com.wulias.project.tool.Tool;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录
 * Created by 曹小贼 on 2018/10/11.
 */

public class LoginFragment extends MVPFragment<LoginPresenter> {
    @BindView(R.id.et_login_phone)
    EditText mEtPhone;
    @BindView(R.id.et_login_password)
    EditText mEtPassword;

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

    public void setLoginCallBack(CallBack.LoginCallBack loginCallBack) {
        this.loginCallBack = loginCallBack;
    }

    @Override
    public void onSuccess(BaseBean json, Object object) {
        super.onSuccess(json, object);
        if (object instanceof LoginBean){
           BaseBean<LoginBean> loginBean = (BaseBean<LoginBean>) object;
            if (loginBean.getCode()==0){
                presenter.userDetail(new UserVo(0L));
                mContext.finish();
            }
        }
    }

    @OnClick({R.id.tv_login_forget, R.id.btn_login_submit})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_submit:
                login();
                break;
            case R.id.tv_login_forget:
                if (!Tool.isEmpty(loginCallBack)) {
                    loginCallBack.changeForget();
                }
                break;
        }
    }

    /**
     * 登录
     */
    public void login() {
        String userName = mEtPhone.getText().toString().trim();
        String userPassword = mEtPassword.getText().toString().trim();

        if (Tool.isEmpty(userName)) {
            MsgTool.showShortToast("");
            return;
        }
        if (Tool.isEmpty(userPassword)) {
            MsgTool.showShortToast("");
            return;
        }
        presenter.login(new LoginVo(userName,userPassword));
    }

}
