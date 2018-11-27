package com.wulias.project.view;

import com.wulias.project.base.BaseBean;

/**
 * Created by Gavin
 * 2018/9/26
 */
public interface IHttp {

    /**
     * 请求成功
     * @param bean 返回值
     */
    void onSuccess(BaseBean bean, Object object);

    /**
     * 请求失败
     * @param t
     */
    void onFail(Object t);

    /**
     * 请求结束
     */
    void onCompleted();
}
