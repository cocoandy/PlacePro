package com.wulias.project.listener;

import java.io.File;

/**
 * Created by 曹小贼 on 2018/10/12.
 */

public interface CallBack {

    /**
     * 登录的回调
     */
    interface LoginCallBack {
        void changeForget();//切换到忘记密码
    }

    /**
     * 欢迎页回调
     */
    interface GuideCallBack {
        void showAdvert(File file);//显示广告

        void onTick(long millisUntilFinished);//倒计时中

        void onFinish();//倒计时结束


    }
}
