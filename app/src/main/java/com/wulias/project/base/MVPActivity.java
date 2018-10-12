package com.wulias.project.base;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.wulias.project.constacts.Constacts;
import com.wulias.project.tool.Tool;
import com.wulias.project.view.IHttp;
import com.wulias.project.view.IMVPView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity 基类
 * Created by Gavin
 * 2018/9/26
 */
public abstract class MVPActivity<p extends Presenter> extends AppCompatActivity implements IMVPView, IHttp,OnRefreshLoadMoreListener {
    public Activity mContext;
    private Unbinder unbinder;
    public p presenter;


    //当前显示的界面
    private Fragment currFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBefor();
        setContentView(initLayout());
        mContext = this;
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {//解绑
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
        Log.e("onSuccess>>>>>>>" + "TAG_OO", json);
    }

    @Override
    public void onFail(Object t) {
        Log.e("TAG_OO", "onFail>>>>>>>" + Tool.beanToString(t));
    }

    public void onCompleted() {
        Log.e("TAG_OO", "OVER>>>>>>>");
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
     * 设置Toolbar左侧返回箭头
     * @param toolbar
     * @param onClickListener
     */
    public void setToolbar(Toolbar toolbar, View.OnClickListener onClickListener) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(onClickListener);
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


    /**
     * 跳转到fragment
     *
     * @param fragmentTo   Fragment
     */
    public void commitFragment(Fragment fragmentTo,int fragmentId) {
        FragmentManager manager = getSupportFragmentManager();
        if (fragmentId == 0 || fragmentTo == null) return;

        FragmentTransaction ft = manager.beginTransaction();
        if (currFragment == null) {
            ft.remove(fragmentTo).commit();
            ft = manager.beginTransaction();
            ft.add(fragmentId, fragmentTo, fragmentTo.getClass().getName());
            ft.commit();
        }else if (fragmentTo.isAdded()) {
            ft.hide(currFragment).show(fragmentTo).commit();
            manager.executePendingTransactions();
        } else {
            ft.remove(fragmentTo).commit();
            ft = manager.beginTransaction();
            ft.hide(currFragment).add(fragmentId, fragmentTo, fragmentTo.getClass().getName());
            ft.commit();
        }
        currFragment = fragmentTo;
    }


    public abstract void initView();

    public abstract void initData();

    public abstract int initLayout();

    protected abstract p initPresenter();
}
