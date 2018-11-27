package com.wulias.project.presenter;

import android.os.CountDownTimer;

import com.wulias.project.base.Presenter;
import com.wulias.project.listener.CallBack;
import com.wulias.project.tool.Tool;

import java.io.File;

/**
 * Created by 曹小贼 on 2018/10/26.
 */

public class GuidePresenter extends Presenter<CallBack.GuideCallBack> {

    private CountDownTimer timer;

    /**
     * 是否显示广告
     *
     * @param name 图片的名称
     */
    public void showAdvert(String name) {

        if (name == null) {
            finishDelate();
            return;
        }
        String path = Tool.getDir();
        File file = new File(path, name);
        if (file.exists()) {
            view.showAdvert(file);
            startTimer(6000,1000);
        }else {
            finishDelate();
        }
    }


    /**
     * 没显示广告页的时候
     */
    private void finishDelate(){
        CountDownTimer timer = new CountDownTimer(1000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                finishGuild();
            }
        };
        timer.start();
    }

    /**
     * 开始倒计时
     *
     * @param totalTime    总时间
     * @param intervalTime 间隔时间
     */
    private void startTimer(long totalTime, long intervalTime) {
        cancleTimer();
        timer = new CountDownTimer(totalTime, intervalTime) {

            @Override
            public void onTick(long millisUntilFinished) {
                view.onTick(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                view.onFinish();
            }
        };
        timer.start();
    }

    /**
     * 结束欢迎页进入主页(包含手动跳过广告)
     */
    public void finishGuild() {
        cancleTimer();
        view.onFinish();
    }

    /**
     * 取消倒计时
     */
    public void cancleTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

}
