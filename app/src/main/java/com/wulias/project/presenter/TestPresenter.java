package com.wulias.project.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.wulias.project.R;
import com.wulias.project.ui.fragment.CarFragment;
import com.wulias.project.ui.fragment.GroundFragment;
import com.wulias.project.ui.fragment.HomeFragment;
import com.wulias.project.ui.fragment.SelfFragment;
import com.wulias.navigation.bean.ItemBean;
import com.wulias.navigation.listener.OnFragmentInitialization;
import com.wulias.navigation.widget.NavigationBar;
import com.wulias.project.base.Presenter;
import com.wulias.project.view.IMainView;

import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/7/2.
 */

public class TestPresenter extends Presenter<IMainView> implements OnFragmentInitialization {

    public TestPresenter() {

    }

    public void initNavigation(FragmentManager manager, NavigationBar mBmMenu){
        mBmMenu.setFragmentManager(manager, R.id.main_fragment);//设置管理  R.id.main_fragment是fragment要显示的地方
        // 字体颜色
        mBmMenu.setSelectTextColor(R.color.colorPrimary);
        mBmMenu.setNormalTextColor(R.color.bottom_textcolor);
        //给导航添加item
        mBmMenu.addItem("首页", R.mipmap.ic_main_home, R.mipmap.ic_main_home_select);
        mBmMenu.addItem("订场地", R.mipmap.ic_main_ground, R.mipmap.ic_main_ground_select);
        mBmMenu.addItem("购物车", R.mipmap.ic_main_car, R.mipmap.ic_main_car_select);
        mBmMenu.addItem("我的", R.mipmap.ic_main_self, R.mipmap.ic_main_self_select);
        mBmMenu.addOnInitialization(this);//初始化回调，一定要设置，非Viewpage
        mBmMenu.selectCurrentItem(0);
    }

    private HomeFragment mHomeFragment;//首页
    private GroundFragment mGroundFragment;//场地
    private CarFragment mCarFragment;//购物车
    private SelfFragment mSelfFragment;//我的


    @Override
    public Fragment onInitialization(int position, ItemBean bean) {
        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
                return mHomeFragment;
            case 1:
                if (mGroundFragment == null) {
                    mGroundFragment = new GroundFragment();
                }
                return mGroundFragment;
            case 2:
                if (mCarFragment == null) {
                    mCarFragment = new CarFragment();
                }
                return mCarFragment;
            case 3:
                if (mSelfFragment == null) {
                    mSelfFragment = new SelfFragment();
                }
                return mSelfFragment;
        }
        return null;
    }
}
