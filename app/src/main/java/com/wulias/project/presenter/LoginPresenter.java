package com.wulias.project.presenter;

import com.wulias.project.base.BaseVo;
import com.wulias.project.base.Presenter;
import com.wulias.project.model.UserModle;

/**
 * Created by 曹小贼 on 2018/10/11.
 */

public class LoginPresenter extends Presenter {

    private UserModle userModle;


    public LoginPresenter() {
        super();
        userModle = new UserModle();
    }

    public void login(BaseVo vo) {
        userModle.login(vo, new RxObserver());
    }


}
