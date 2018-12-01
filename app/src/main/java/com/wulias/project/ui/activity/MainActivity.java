package com.wulias.project.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.Target;
import com.wulias.navigation.widget.NavigationBar;
import com.wulias.project.R;
import com.wulias.project.base.BaseBean;
import com.wulias.project.base.BaseVo;
import com.wulias.project.base.MVPActivity;
import com.wulias.project.bean.AdvertBean;
import com.wulias.project.presenter.MainPresenter;
import com.wulias.project.util.MsgTool;
import com.wulias.project.util.Tool;
import com.wulias.project.view.IMainView;

import java.io.File;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends MVPActivity<MainPresenter> implements IMainView {
    @BindView(R.id.selft_bottom_menu)
    NavigationBar mBmMenu;
    List<Fragment> mList;

    @Override
    public void initBefor() {
        super.initBefor();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //4.4以后此方法设置状态栏透明
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void initView() {
        presenter.initNavigation(getSupportFragmentManager(), mBmMenu);
        if (!Tool.isNotificationEnabled()) {
            goToSet();
        } else {

            MsgTool.showShortToast("已经开启通知");
        }

    }

    private void goToSet() {
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
        presenter.advert(new BaseVo());

    }

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onSuccess(BaseBean bean, Object object) {
        super.onSuccess(bean, object);
        if (bean.getData() instanceof AdvertBean) {
            BaseBean<AdvertBean> advertBean = (BaseBean<AdvertBean>) object;
            loadingAdvert(advertBean.getData().getCover());
        }
    }

    public void loadingAdvert(final String url) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                // 文件名
                final String fileName = url.substring(url.lastIndexOf("/") + 1);
                if (!fileName.contains(".")) {
                    return;
                }
                File imgFile = null;
                try {
                    FutureTarget<File> futureTarget = Glide.with(mContext)
                            .load(url)
                            .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);

                    imgFile = futureTarget.get();
                } catch (Exception e) {
                }

                String path = Tool.getDir();
                File file = new File(path + "/" + "124.jpg");
                if (!file.exists()) {
                    Tool.copy(imgFile, file);
                }

            }


        }.start();

    }

    @Override
    public void changePage(int position, boolean isFulllScreen) {
    }


}
