package com.wulias.project.model;

import com.wulias.project.base.BaseVo;
import com.wulias.project.base.Presenter;
import com.wulias.project.retrofit.RetrofitManager;
import com.wulias.project.util.Tool;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 广告页
 * Created by 曹小贼 on 2018/10/26.
 */

public class AdvertModel {
    /**
     * 获取广告下载地址
     * @param observer
     */
    public void advert(BaseVo vo, Presenter.RxObserver observer){

        RetrofitManager
                .getSingleton()
                .RetrofitService()
                .advert(Tool.toApiMap(vo))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
