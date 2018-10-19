package com.wulias.project.base;

import com.wulias.project.tool.Tool;
import com.wulias.project.view.IHttp;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Gavin
 * 2018/9/26
 */
public abstract class Presenter<V> {
    public V view;
    private IHttp http;


    public Presenter(){

    }
    /**
     * 加载View 建立连接
     */
    public void addView(V v, IHttp http) {
        this.view = v;
        this.http = http;

    }

    /**
     * 断开连接
     */
    public void detattch() {
        if (view != null) {
            view = null;
        }
    }

    /**
     *
     * @param <Object>
     */
    public class RxObserver<Object> implements Observer<Object> {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(Object object) {
            http.onSuccess(Tool.beanToString(object));
        }

        @Override
        public void onError(Throwable e) {
            http.onFail(e);
        }

        @Override
        public void onComplete() {
            http.onCompleted();
        }
    }
}
