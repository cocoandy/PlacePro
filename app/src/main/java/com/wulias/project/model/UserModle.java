package com.wulias.project.model;

import com.wulias.project.base.BaseVo;
import com.wulias.project.base.Presenter;
import com.wulias.project.retrofit.RetrofitManager;
import com.wulias.project.tool.Tool;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 关于用户的逻辑层
 * Created by 曹小贼 on 2018/10/16.
 */

public class UserModle {

    /**
     * 登录
     * @param observer
     */
    public void login(BaseVo vo, Presenter.RxObserver observer){
        RetrofitManager
                .getSingleton()
                .RetrofitService()
                .loginLogin(Tool.toApiMap(vo))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * 注册
     * @param observer
     */
    public void regist(BaseVo vo, Presenter.RxObserver observer){
        RetrofitManager
                .getSingleton()
                .RetrofitService()
                .loginRegister(Tool.toApiMap(vo))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
