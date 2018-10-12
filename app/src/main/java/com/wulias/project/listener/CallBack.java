package com.wulias.project.listener;

/**
 * Created by 曹小贼 on 2018/10/12.
 */

public interface CallBack {

    /**
     * 登录的回调
     */
    public interface LoginCallBack {
        public void changeForget();//切换到忘记密码
    }
}
