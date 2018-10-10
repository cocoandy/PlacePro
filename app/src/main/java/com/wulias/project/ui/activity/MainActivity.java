package com.wulias.project.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.wulias.navigation.widget.NavigationBar;
import com.wulias.project.R;
import com.wulias.project.base.MVPActivity;
import com.wulias.project.bean.UserInfo;
import com.wulias.project.presenter.TestPresenter;
import com.wulias.project.tool.MsgTool;
import com.wulias.project.tool.Tool;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends MVPActivity<TestPresenter> {
    @BindView(R.id.selft_bottom_menu)
    NavigationBar mBmMenu;
    List<Fragment> mList;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4以后此方法设置状态栏透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        presenter.initNavigation(getSupportFragmentManager(), mBmMenu);
        if (!Tool.isNotificationEnabled()){
            goToSet();
        }else {
            MsgTool.showShortToast("已经开启通知");
        }
    }
    private void goToSet(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.BASE) {
            // 进入设置系统应用权限界面
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
            return;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {// 运行系统在5.x环境使用
            // 进入设置系统应用权限界面
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
            return;
        }
    }
    @Override
    public void initData() {
//        showProgress();
//        presenter.loadingAll();
    }

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected TestPresenter initPresener() {
        return new TestPresenter();
    }



}
