package com.wulias.project.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wulias.project.R;
import com.wulias.project.base.MVPActivity;
import com.wulias.project.listener.CallBack;
import com.wulias.project.presenter.GuidePresenter;

import java.io.File;

import butterknife.BindView;

public class GuideActivity extends MVPActivity<GuidePresenter> implements CallBack.GuideCallBack {

    @BindView(R.id.guide_cover)
    ImageView mImgCover;

    Handler handler = new Handler();
    private boolean agreeAllPermissions;

    @Override
    public void initBefor() {
        super.initBefor();
        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void initView() {
        agreeAllPermissions = getPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE});
    }

    @Override
    public void initData() {
        presenter.showAdvert("124.jpg");
    }

    @Override
    public int initLayout() {
        return R.layout.activity_guide;
    }

    @Override
    protected GuidePresenter initPresenter() {
        return new GuidePresenter();
    }

    @Override
    public void showAdvert(File file) {
        //显示广告
        Glide.with(mContext).load(file).into(mImgCover);

    }

    @Override
    public void onTick(long millisUntilFinished) {

    }

    @Override
    public void onFinish() {
        Intent intent = new Intent();
        intent.setClass(mContext, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
