package com.wulias.project.presenter;

import com.wulias.project.base.BaseVo;
import com.wulias.project.base.Presenter;
import com.wulias.project.model.UserModle;

/**
 * Created by 曹小贼 on 2018/10/12.
 */

public class RegistPresenter extends Presenter {
    private UserModle userModle;


    public RegistPresenter() {
        super();
        userModle = new UserModle();
    }

    public void regist(BaseVo vo) {
        userModle.regist(vo, new RxObserver());
    }
}
