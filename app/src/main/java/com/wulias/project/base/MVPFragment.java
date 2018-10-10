package com.wulias.project.base;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wulias.project.constacts.Constacts;
import com.wulias.project.view.IHttp;
import com.wulias.project.view.IMVPView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Fragment 基类
 * Created by Gavin
 * 2018/9/26
 */
public abstract class MVPFragment<p extends Presenter> extends Fragment implements IMVPView, IHttp, OnRefreshLoadMoreListener {
    private Unbinder unbinder;
    public View view;
    public Activity mContext;
    public p presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        initBefor();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(initLayout(), null, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }

        presenter.detattch();
    }


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        //第三方刷新加载-->加载
        refreshLayout.finishLoadMore(Constacts.REFRESHLOADMORE_TIME_OUT);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        //第三方刷新加载-->刷新
        refreshLayout.finishRefresh(Constacts.REFRESHLOADMORE_TIME_OUT);
    }


    @Override
    public void initBefor() {
        presenter = initPresenter();
        presenter.addView(this, this);
    }

    @Override
    public void onSuccess(String json) {
        //网络请求之成功
    }

    @Override
    public void onFail(Object t) {
        //网络请求之失败并结束，和onCompleted互斥
    }

    @Override
    public void onCompleted() {
        //网络请求之结束，和onFail互斥
    }

    /**
     * 权限请求
     *
     * @param permissions
     */
    public void getPermissions(String[] permissions) {
        List<String> mPermissionList = new ArrayList();
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(mContext, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                mPermissionList.add(permissions[i]);
            }
        }
        if (mPermissionList.isEmpty()) {//未授予的权限为空，表示都授予了
            Toast.makeText(mContext, "已经授权", Toast.LENGTH_LONG).show();
        } else {//请求权限方法
            String[] permis = mPermissionList.toArray(new String[mPermissionList.size()]);//将List转为数组
            ActivityCompat.requestPermissions(mContext, permis, Constacts.MY_PERMISSIONS_REQUEST_CALL_CAMERA);
        }
    }


    /**
     * 获取到状态栏的高度
     *
     * @return
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public abstract void initView();

    public abstract void initData();

    public abstract int initLayout();

    protected abstract p initPresenter();
}
