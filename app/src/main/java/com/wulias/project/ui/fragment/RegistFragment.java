package com.wulias.project.ui.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.wulias.project.R;
import com.wulias.project.base.BaseBean;
import com.wulias.project.base.MVPFragment;
import com.wulias.project.bean.vo.RegistVo;
import com.wulias.project.presenter.RegistPresenter;
import com.wulias.project.util.MsgTool;
import com.wulias.project.util.Tool;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册
 * Created by 曹小贼 on 2018/10/12.
 */

public class RegistFragment extends MVPFragment<RegistPresenter> {
    @BindView(R.id.et_regist_phone)
    EditText mEtPhone;
    @BindView(R.id.et_regist_code)
    EditText mEtCode;
    @BindView(R.id.et_regist_password)
    EditText mEtPassword;
    @BindView(R.id.et_regist_nickname)
    EditText mEtNickname;
    @BindView(R.id.et_regist_repassword)
    EditText mEtRePassword;

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

    @Override
    public void onSuccess(BaseBean json, Object object) {
        super.onSuccess(json, object);
    }

    @OnClick({R.id.btn_regist_submit, R.id.btn_regist_code})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_regist_submit:
                regist();
                break;
            case R.id.btn_regist_code:
                break;
        }
    }


    /**
     * 处理填写信息并注册
     */
    public void regist() {
        String userName = mEtPhone.getText().toString().trim();
        String userNickname = mEtNickname.getText().toString().trim();
        String userPassword = mEtPassword.getText().toString().trim();

        if (Tool.isEmpty(userName)) {
            MsgTool.showShortToast("");
            return;
        }
        if (Tool.isEmpty(userNickname)) {
            MsgTool.showShortToast("");
            return;
        }
        if (Tool.isEmpty(userPassword)) {
            MsgTool.showShortToast("");
            return;
        }

        presenter.regist(new RegistVo(userName, userNickname, userPassword));
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            String userName = "";
//            String userNickname = "";
//            String userPassword = "";
//            if ()
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
